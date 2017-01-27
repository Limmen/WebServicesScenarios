<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:cmpi="http://www.limmen.kth.se.id2208.hw1.company_info"
                xmlns:emplr="http://www.limmen.kth.se.id2208.hw1.employment_record"
                xmlns="http://www.limmen.kth.se.id2208.hw1.application_profile">

    <xsl:output method="xml" indent="yes" encoding="UTF-8"/>
    <xsl:variable name="companyInfo" select="document('../documents/company_info.xml')/cmpi:CompaniesInfo"/>
    <xsl:template match="/emplr:EmploymentRecord">
        <xsl:element name="WorkingExperience">
            <xsl:for-each select="emplr:EmploymentHistory/emplr:Employment">
                <xsl:element name="Employment">
                    <xsl:element name="StartDate">
                        <xsl:value-of select="emplr:StartDate"/>
                    </xsl:element>
                    <xsl:element name="EndDate">
                        <xsl:value-of select="emplr:EndDate"/>
                    </xsl:element>
                    <xsl:element name="Company">
                        <xsl:variable name="companyName" select="emplr:Company"/>
                        <xsl:variable name="company" select="$companyInfo/cmpi:Company[cmpi:Name = $companyName]"/>
                        <xsl:element name="Name">
                            <xsl:value-of select="$company/cmpi:Name"/>
                        </xsl:element>
                        <xsl:element name="About">
                            <xsl:value-of select="$company/cmpi:About"/>
                        </xsl:element>
                        <xsl:element name="Website">
                            <xsl:value-of select="$company/cmpi:Website"/>
                        </xsl:element>
                    </xsl:element>
                    <xsl:element name="Title">
                        <xsl:value-of select="emplr:Title"/>
                    </xsl:element>
                </xsl:element>
            </xsl:for-each>
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>