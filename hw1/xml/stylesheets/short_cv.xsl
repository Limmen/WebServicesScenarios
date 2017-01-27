<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:cv="http://www.limmen.kth.se.id2208.hw1.short_cv"
                xmlns="http://www.limmen.kth.se.id2208.hw1.application_profile">
    <xsl:output method="xml" indent="yes" encoding="UTF-8"/>

    <xsl:template match="*">
        <xsl:element name="{local-name()}">
            <xsl:apply-templates select="node()|@*"/>
        </xsl:element>
    </xsl:template>

    <xsl:template match="@*">
        <xsl:attribute name="{local-name()}">
            <xsl:value-of select="."/>
            <xsl:apply-templates select="/cv:ShortCV"/>
        </xsl:attribute>
    </xsl:template>

    <xsl:template match="/cv:ShortCV">
        <xsl:element name="PersonalInformation">
            <xsl:element name="Person">
                <xsl:element name="FirstName">
                    <xsl:value-of select="cv:PersonalInformation/cv:FirstName"/>
                </xsl:element>
                <xsl:element name="LastName">
                    <xsl:value-of select="cv:PersonalInformation/cv:LastName"/>
                </xsl:element>
                <xsl:element name="CivicRegistrationNumber">
                    <xsl:value-of select="cv:PersonalInformation/cv:CivicRegistrationNumber"/>
                </xsl:element>
            </xsl:element>
            <xsl:element name="Preferences">
                <xsl:element name="JobInterest">
                    <xsl:value-of select="cv:Preferences/cv:JobInterest"/>
                </xsl:element>
                <xsl:element name="JobType">
                    <xsl:value-of select="cv:Preferences/cv:JobType"/>
                </xsl:element>
                <xsl:element name="Locations">
                    <xsl:for-each select="cv:Preferences/cv:Locations/cv:Location">
                        <xsl:element name="Location">
                            <xsl:value-of select="."/>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
            </xsl:element>
            <xsl:element name="MotivationLetter">
                <xsl:value-of select="cv:MotivationLetter"/>
            </xsl:element>
        </xsl:element>
    </xsl:template>

</xsl:stylesheet>