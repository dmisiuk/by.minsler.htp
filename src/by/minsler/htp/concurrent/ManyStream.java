package by.minsler.htp.concurrent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ManyStream {

	public static void main(String[] args) throws IOException {

		Integer l[] = { 1, 1, 1, 1, 1, 1 };
		Integer m[] = { 2, 2, 2, 2, 2, 2 };
		Integer k[] = { 234, 234, 234, 23, 5, 234, 23, 4, 23, 5, 235, 23, 52,
				35, 23, 52, 53, 3 };
		List<Integer> listOne = new ArrayList<Integer>(Arrays.asList(l));
		List<Integer> listTwo = new ArrayList<Integer>(Arrays.asList(m));
		List<Integer> listThree = new ArrayList<Integer>(Arrays.asList(k));

		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(
					"/Users/minsler/testmanystreams.txt"));
			MySync sync = new MySync(bw);

			Runner r1 = new Runner(listOne, sync);
			Thread t1 = new Thread(r1, "Thread t0:");

			Runner r2 = new Runner(listTwo, sync);
			Thread t2 = new Thread(r2, "Thread t1:");

			Runner r3 = new Runner(listThree, sync);
			Thread t3 = new Thread(r3, "Thread t3:");

			t2.start();
			t3.start();
			t1.start();
			t2.join();
			t3.join();
			t1.join();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				bw.close();
			}
		}

	}

	static class MySync {

		private LinkedList<Integer> ll;
		private ListIterator<Integer> it;
		private int currentId;
		private BufferedWriter bw;

		public MySync(BufferedWriter bw) {
			this.bw = bw;
			ll = new LinkedList<Integer>();
		}

		public void add(int id) {
			ll.add(id);
			it = ll.listIterator();
			currentId = it.next();
		}

		public int size() {
			return ll.size();
		}

		public int getCurrentId() {
			return currentId;
		}

		public void next() {
			if (ll.size() == 0) {
				return;
			}
			if (!it.hasNext()) {
				it = ll.listIterator();
			}
			currentId = it.next();
			return;

		}

		public void remove() {
			it.remove();
		}
	}

	static class Runner implements Runnable {
		private static int nextId;

		private List<Integer> list;
		private MySync sync;
		private int id;

		public Runner(List<Integer> list, MySync sync) {
			this.list = list;
			this.sync = sync;
			id = nextId++;
			if (list.size() != 0) {
				sync.add(id);
			}
		}

		@Override
		public void run() {

			String name = Thread.currentThread().getName();
			Iterator<Integer> it = list.iterator();

			while (it.hasNext()) {
				synchronized (sync) {

					while (sync.size() > 1 && sync.getCurrentId() != id) {
						try {
							sync.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					String str = name + " : " + it.next() + "\n\r";
					try {
						sync.bw.write(str);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (!it.hasNext()) {
						sync.remove();
					}

					sync.next();

					sync.notify();

				}
			}
		}
	}
}