<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <xsl:apply-templates select="biblioteca/libro">
            <xsl:sort select="pubblicazione" data-type="number"/>
        </xsl:apply-templates>
    </xsl:template>

    <xsl:template match="biblioteca/libro">

------- Nuovo libro:
------- Pubblicazione     <xsl:value-of select="pubblicazione"/>
------- Titolo            <xsl:value-of select="titolo"/>
        <xsl:if test="titolo/@bestof[. = 'si']"> (BEST OF)</xsl:if><xsl:if test="pubblicazione[. = 2015]"> (NUOVO)</xsl:if>
        <xsl:if test="serie">
------- Serie             <xsl:value-of select="serie"/>
        </xsl:if>
------- ISBN              <xsl:value-of select="@isbn"/>
------- Autori            <xsl:for-each select="autori/autore">
            <xsl:value-of select="."/>
            <xsl:if test="position() != last()"> - </xsl:if>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>