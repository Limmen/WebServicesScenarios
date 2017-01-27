<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns="http://www.limmen.kth.se.id2208.hw1.application_profile"
                xmlns:ap="http://www.limmen.kth.se.id2208.hw1.application_profile"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://www.limmen.kth.se.id2208.hw1.application_profile   ./../schemas/application_profile.xsd">

    <xsl:output method="xml" indent="yes" encoding="UTF-8"/>
    <xsl:variable name="shortCVReduced" select="document('../documents/reduced_short_cv.xml')"/>
    <xsl:variable name="employmentReduced" select="document('../documents/reduced_employment_record_company.xml')"/>
    <xsl:template match="/">
        <xsl:element name="ApplicationProfile">
            <xsl:copy-of select="document('')/*/@xsi:schemaLocation"/>
            <xsl:copy-of select="$shortCVReduced"/>
            <xsl:copy-of select="ap:Degrees"/>
            <xsl:copy-of select="$employmentReduced"/>
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>