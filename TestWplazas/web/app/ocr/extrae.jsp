<%-- 
    Document   : extrae
    Created on : 04-nov-2020, 21:38:58
    Author     : willi
--%>

<%@page import="net.sourceforge.tess4j.TesseractException"%>
<%@page import="java.io.File"%>
<%@page import="net.sourceforge.tess4j.Tesseract"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            Tesseract tesseract = new Tesseract(); 
        try { 
  
            tesseract.setDatapath("/Users/willi/desktop/captura_texto/"); 
  
            // the path of your tess data folder 
            // inside the extracted file 
            String text 
                = tesseract.doOCR(new File("/Users/willi/desktop/captura_texto/tratado/image.jpg")); 
  
            // path of your image file 
            System.out.print(text); 
        } 
        catch (TesseractException e) { 
            e.printStackTrace(); 
        } 
            
            %>
    </body>
</html>
