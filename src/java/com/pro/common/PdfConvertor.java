/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro.common;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
// http://www.allcolor.org/YaHPConverter/
import org.allcolor.yahp.converter.CYaHPConverter;
import org.allcolor.yahp.converter.IHtmlToPdfTransformer;

/**
 *
 * @author zoondia
 */
public class PdfConvertor extends ActionSupport {
    public String execute() throws FileNotFoundException, IHtmlToPdfTransformer.CConvertException, IOException{
        try{
            String root = "d:/codes/paypal_api/";
    String input = "file_1659686.html";  // need to be charset utf-8
    htmlToPdfFile(new File(root, input),
                  new File(root, input + "2.pdf"));
    System.out.println("Done");
        }catch(Exception e){
            e.printStackTrace();
        }
           /* String str ="";
             CYaHPConverter converter = new CYaHPConverter();
    File fout = new File("d:/codes/paypal_api/test.txt");
    FileOutputStream out = new FileOutputStream(fout);
    Map properties = new HashMap();
    List headerFooterList = new ArrayList();

     str = "<HTML><HEAD></HEAD><BODY><H1>Testing</H1><FORM>" +
                 "check : <INPUT TYPE='checkbox' checked=checked/><br/>"   +
                 "</FORM></BODY></HTML>";

    properties.put(IHtmlToPdfTransformer.PDF_RENDERER_CLASS,
                   IHtmlToPdfTransformer.FLYINGSAUCER_PDF_RENDERER);
    //properties.put(IHtmlToPdfTransformer.FOP_TTF_FONT_PATH, fontPath);
    
    converter.convertToPdf(str,
          IHtmlToPdfTransformer.A4P,
          headerFooterList,
          "file:///temp/", // root for relative external CSS and IMAGE
          out,
          properties);
    out.flush();
    out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        */
            return SUCCESS;
    }
    
    
    public static void htmlToPdfFile(File htmlIn, File pdfOut) throws Exception {
        try{
             Scanner scanner =   new Scanner(htmlIn).useDelimiter(">");
             
    String htmlContents = scanner.next();

    CYaHPConverter converter = new CYaHPConverter();
    FileOutputStream out = new FileOutputStream(pdfOut);
    Map properties = new HashMap();
    List headerFooterList = new ArrayList();

    properties.put(IHtmlToPdfTransformer.PDF_RENDERER_CLASS,
                   IHtmlToPdfTransformer.FLYINGSAUCER_PDF_RENDERER);
    //properties.put(IHtmlToPdfTransformer.FOP_TTF_FONT_PATH, fontPath);
    converter.convertToPdf(htmlContents,
                IHtmlToPdfTransformer.A4P,
                headerFooterList,
                "file:///temp/html/",
                out,
                properties);
    out.flush();
    out.close();
        }catch(Exception e){
              e.printStackTrace();
        }
   
  }
}
