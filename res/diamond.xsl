<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes" encoding="UTF-8"/>
    <xsl:key name="gemsByColor" match="Gem" use="VisualParameters/Color"/>
    <xsl:template match="/Gems">
        <GroupedGems>
            <xsl:for-each select="Gem[generate-id() = generate-id(key('gemsByColor', VisualParameters/Color)[1])]">
                <ColorGroup color="{VisualParameters/Color}">
                    <xsl:for-each select="key('gemsByColor', VisualParameters/Color)">
                        <Gem>
                            <Name><xsl:value-of select="Name"/></Name>
                            <Origin><xsl:value-of select="Origin"/></Origin>
                            <VisualParameters>
                                <Color><xsl:value-of select="VisualParameters/Color"/></Color>
                                <Transparency><xsl:value-of select="VisualParameters/Transparency"/></Transparency>
                                <Cut><xsl:value-of select="VisualParameters/Cut"/></Cut>
                            </VisualParameters>
                            <Value><xsl:value-of select="Value"/></Value>
                        </Gem>
                    </xsl:for-each>
                </ColorGroup>
            </xsl:for-each>
        </GroupedGems>
    </xsl:template>
</xsl:stylesheet>
