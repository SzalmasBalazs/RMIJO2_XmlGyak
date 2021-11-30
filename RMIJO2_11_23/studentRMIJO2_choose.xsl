<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h1>Fokozat</h1>
                <table border="1">
                    <tr bgcolor="#f7ff08">
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Nick Name</th>
                        <th>Salary</th>
                        <th>Position</th>
                    </tr>
                    <xsl:for-each select="class/student">
                        <tr>
                            <td>
                                <xsl:value-of select="@rollno" />
                            </td>
                            <td>
                                <xsl:value-of select="firstname" />
                            </td>
                            <td>
                                <xsl:value-of select="lastname" />
                            </td>
                            <td>
                                <xsl:value-of select="nickname" />
                            </td>
                            <td>
                                <xsl:value-of select="salary" />
                            </td>
                            <td>
                                <xsl:value-of select="position" />
                            </td>

                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>

    </xsl:template>


</xsl:stylesheet>