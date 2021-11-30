<?xml version = "1.0" encoding = "UTF-8"?> 
<xsl:stylesheet version = "1.0" 
   xmlns:xsl = "http://www.w3.org/1999/XSL/Transform">   
   <xsl:template match = "/"> 
      <html> 
         <body> 
            <h2>Szalmás Balázs apple-template</h2> 
            <xsl:apply-templates select = "class/student" /> 
         </body> 
      </html> 
   </xsl:template>  

   <xsl:template match = "class/student"> 
      <xsl:apply-templates select = "@id" /> 
      <xsl:apply-templates select = "firstname" /> 
      <xsl:apply-templates select = "lastname" /> 
      <xsl:apply-templates select = "nickname" /> 
      <xsl:apply-templates select = "age" />
      <xsl:apply-templates select = "salary" />  
      <br /> 
   </xsl:template>  

   <xsl:template match = "@id"> 
      ID: <span style = "font-size = 30px;"> 
         <xsl:value-of select = "." /> 
      </span> 
      <br /> 
   </xsl:template>  

   <xsl:template match = "firstname"> 
      Keresztnev: <span style = "color:darkred;"> 
         <xsl:value-of select = "." /> 
      </span> 
      <br /> 
   </xsl:template>  

    <xsl:template match = "lastname"> 
      Vezeteknev: <span style = "color:green;"> 
         <xsl:value-of select = "." /> 
      </span> 
      <br /> 
   </xsl:template> 

   <xsl:template match = "nickname"> 
      <span style = "color:black;"> 
         <xsl:value-of select = "." /> 
      </span> 
       
   </xsl:template>  

   <xsl:template match = "age"> 
      kor: <span style = "color:blue;"> 
         <xsl:value-of select = "." /> 
      </span> 
      <br /> 
   </xsl:template> 
   
   <xsl:template match = "salary"> 
      Fizetes: <span style = "color:red;"> 
         <xsl:value-of select = "." /> 
      </span> 
      <br /> 
   </xsl:template> 
	
</xsl:stylesheet>