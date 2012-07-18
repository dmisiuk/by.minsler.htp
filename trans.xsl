<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

	<xsl:template match="/pointlist">
		<table border="1"> <xsl:apply-templates /></table>
	</xsl:template>
	
	<xsl:template match="/pointlist/point">
		<tr><xsl:apply-templates select="@*|*"/></tr>
	</xsl:template>
	
	<xsl:template match="@unit">
		<td><xsl:value-of select="." /></td>
	</xsl:template>
	
	<xsl:template match="x">
		<td><xsl:value-of select="text()" /></td>
	</xsl:template>
	
	<xsl:template match="y">
		<td>
		<xsl:value-of select="text()"/>
		</td>
	</xsl:template>
</xsl:stylesheet>