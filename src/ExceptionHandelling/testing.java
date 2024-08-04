package ExceptionHandelling;


import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class testing {



    public static void main(String[] args) {
        File file = new File("C:\\Users\\U6071845\\Downloads\\15906_11.xml");

        String result="<<apo>> should be converted to apo and <<20>> should be <<20>> only. 2^3 to be 2<^>3 and su^we should be suwe ";
        result = result.replaceAll("<<([^\\d].*?)>>", "$1");
        result = result.replaceAll("(?<!\\d)\\^(?![\\d<>]|<>)", "");
        // Replace su|we with suwe (any | where both sides are alphabetic)
        result = result.replaceAll("([a-zA-Z]+)\\|([a-zA-Z]+)", "$1$2");
        System.out.println(result);

/*        try {
            // Load the XML document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            // Get the encoding specified in the XML declaration
            String encoding = doc.getXmlEncoding();
            if (encoding != null) {
                System.out.println("Encoding specified in XML declaration: " + encoding);
            } else {
                System.out.println("No encoding specified in XML declaration.");
                // You may need to perform further analysis here to infer the encoding
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }


}
