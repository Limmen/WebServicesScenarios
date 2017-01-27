<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:tscp="http://www.limmen.kth.se.id2208.hw1.transcript"
                xmlns="http://www.limmen.kth.se.id2208.hw1.application_profile">
    <xsl:output method="xml" indent="yes" encoding="UTF-8"/>
    <xsl:template match="/tscp:Transcript">
        <xsl:element name="Degrees">
            <xsl:for-each select="tscp:Degrees/tscp:Degree">
                <xsl:element name="Degree">
                    <xsl:element name="Name">
                        <xsl:value-of select="tscp:Name"/>
                    </xsl:element>
                    <xsl:element name="StartDate">
                        <xsl:value-of select="tscp:StartDate"/>
                    </xsl:element>
                    <xsl:element name="DateOfCompletion">
                        <xsl:value-of select="tscp:DateOfCompletion"/>
                    </xsl:element>
                    <xsl:element name="Credits">
                        <xsl:value-of select="tscp:Credits"/>
                    </xsl:element>
                    <xsl:variable name="degreeId" select="@degreeId"/>
                    <xsl:variable name="courses" select="../../tscp:Courses/tscp:Course[@degree=$degreeId]"/>
                    <xsl:variable name="credits" select="sum($courses/tscp:Credits)"/>
                    <xsl:variable name="points" select="sum($courses/(tscp:Credits*tscp:Grade))"/>
                    <xsl:element name="GPA">
                        <xsl:if test="$credits > 0 ">
                            <xsl:value-of select="$points div $credits"/>
                        </xsl:if>
                        <xsl:if test="$credits = 0">
                            <xsl:value-of select="0"/>
                        </xsl:if>
                    </xsl:element>
                </xsl:element>
            </xsl:for-each>
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>