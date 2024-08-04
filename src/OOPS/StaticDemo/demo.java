package OOPS.StaticDemo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class demo {
    public static void main(String[] args) {
          String outputPath="C:\\ZR\\FINAL_ZRDS\\ZRDS\\release\\output\\regular_items\\15905.xml";

        //String filePath = "C:\\ZR\\Files\\15606_oldRecords\\15606_oldRecords\\regular\\15606.xml";
      // generateTagReports(Path.of(filePath));

        try (FileInputStream fis = new FileInputStream(outputPath)) {
           isValidAsciiSequence(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //generateTagReports(Paths.get(outputPath));
        //generateReports(Paths.get(outputPath));


      /* String caddress="Tula Reg Exotarium, Oktyabrskaya St,D 26, Tula, 300002,";
        System.out.println(caddress.substring(0,caddress.length()-1));*/
//       StringBuilder stringBuilder=new StringBuilder();
//        Pattern pattern=Pattern.compile("(?<=\\s)&(?=\\s)|(?<!\\s)&(?!\\s) |(?<!\\s)&(?=\\s)|(?<=\\s)&([^A-Za-z])");
//        Matcher matcher= pattern.matcher(str);
//        while (matcher.find()){
//            String replacement = "&amp;" + matcher.group(1);
//            matcher.appendReplacement(stringBuilder, replacement);
//        }
//        matcher.appendTail(stringBuilder);
      //  System.out.println(convertAmp(str));


       // System.out.println(c);
//        for(Integer it:lst){
//             System.out.println("hello");
//         }
//        String write='"' +"Tag Name" +"\",\""+"Count"+"\"\n";
//        System.out.println(write);
          //deliverToPath(outputPath);
//        try{
//             devide();
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }

    }

    public static boolean isValidAsciiSequence(FileInputStream fis) throws IOException {
        int byteRead;
        while ((byteRead = fis.read()) != -1) {
            if (byteRead < 0 || byteRead > 127) {
                // Print the invalid character and its position if needed
                printInvalidCharacter(byteRead,fis.getChannel().position() - 1);
                return false; // Invalid ASCII byte
            }
            System.out.println(byteRead);
        }
        return true; // All bytes are valid ASCII characters
    }

    private static void printInvalidCharacter(int invalidByte, long position) {
        System.out.printf("Invalid ASCII character 0x%X at position %d%n", invalidByte, position);
    }



    private static boolean isValidUtf8Sequence(FileInputStream fis, int firstByte, long position) throws IOException {

        int expectedBytes = -1;
        if ((firstByte & 0xE0) == 0xC0) expectedBytes = 1;
        else if ((firstByte & 0xF0) == 0xE0) expectedBytes = 2;
        else if ((firstByte & 0xF8) == 0xF0) expectedBytes = 3;
        else {
            printInvalidCharacter(firstByte, position);
            return false; // Invalid leading byte
        }

        for (int i = 0; i < expectedBytes; i++) {
            int nextByte = fis.read();
            if (nextByte == -1 || (nextByte & 0xC0) != 0x80) return false;
        }
        return true;
    }



    public static String convertAmp(String text) {
        // Match "&" surrounded by spaces and no space within any word
//       String pattern =  "(?<!\\s)&(?!\\s)";
//
//       text=text.replaceAll(pattern," &amp; ");
       String pattern2= "&([^#])";


        return text.replaceAll(pattern2, "&amp;$1");
    }



    public static void generateReports(Path filePath){
        try {
            // Create a SAX parser factory
            SAXParserFactory factory = SAXParserFactory.newInstance();

            // Create a SAX parser
            SAXParser saxParser = factory.newSAXParser();


            // Now, when you parse the XML file using this parser, it will ignore entity references
            saxParser.parse(filePath.toFile(), new CustomHandler());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static class CustomEntityResolver implements EntityResolver {
        @Override
        public InputSource resolveEntity(String publicId, String systemId) {
            // Provide a dummy InputSource for the "sum" entity
            if ("sum".equals(publicId)) {
                return new InputSource(new StringReader(""));
            }
            // Return null to let the parser handle other entities normally
            return null;
        }
    }

    static class CustomHandler extends DefaultHandler {
        @Override
        public InputSource resolveEntity(String publicId, String systemId) throws IOException, SAXException {
            // Provide the definition of the entity when it's referenced
            if ("sum".equals(systemId)) {
                return new InputSource(new StringReader("<!-- Entity 'sum' declaration -->"));
            }
            // For other entities, return null to let the parser handle them
            return null;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Your handling of start elements
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Your handling of end elements
        }
    }

    static class TagHandler extends DefaultHandler {
        private Map<String, Integer> tagCounts = new HashMap<>();
        private String currentTag;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Record the start tag
            currentTag = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Increment count for the end tag
            tagCounts.put(qName, tagCounts.getOrDefault(qName, 0) + 1);
        }

        public Map<String, Integer> getTagCounts() {
            return tagCounts;
        }
    }
    public static void generateTagReports(Path filePath){
        String parent= String.valueOf(filePath.getParent().getFileName());
        if(parent.equals("regular")){
            DocumentBuilderFactory documentBuilderFactory;
            HashMap<String,Integer> tagCountMap;
            try {
                documentBuilderFactory = DocumentBuilderFactory.newInstance();
                //documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
               // documentBuilder.setEntityResolver(new CustomEntityResolver());
              //  Document doc = documentBuilder.parse(new InputSource("file.xml"));
                Document document = documentBuilder.parse(new InputSource(String.valueOf(filePath.toFile())));
                document.getDocumentElement().normalize();
                Element root = document.getDocumentElement();
                NodeList childNodes = root.getChildNodes();
                tagCountMap = new HashMap<>();
                tagCountMap = countTags(childNodes, tagCountMap);
                Integer count = 0;
                Path tagfilePath = Paths.get(filePath.getParent().toFile().getPath(), "TagReport.csv");
                try (FileWriter fileWriter = new FileWriter(tagfilePath.toFile())) {
                    String write = '"' + "Tag Name" + "\",\"" + "Count" + "\"\n";
                    fileWriter.append(write);
                    for (String tagName : tagCountMap.keySet()) {
                        count += tagCountMap.get(tagName);
                        write = '"' + tagName + "\",\"" + tagCountMap.get(tagName) + "\"\n";
                        fileWriter.append(write);
                    }
                }

                System.out.println("Total tagCount is " + count);

            }
            catch (Exception e){
                System.out.println("Error occurred while generating tag reports "+e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static HashMap<String, Integer> countTags(NodeList nodeList, HashMap<String,Integer> tagCountMap){
        for (int i=0;i<nodeList.getLength();i++){
            Node node=nodeList.item(i);
            if(node.getNodeType()==Node.ELEMENT_NODE){
                String tagName=node.getNodeName();
                tagCountMap.put(tagName,tagCountMap.getOrDefault(tagName,0)+1);
                if (node.hasChildNodes()){
                    countTags(node.getChildNodes(),tagCountMap);
                }
            }
        }
        return tagCountMap;
    }

    private static void devide() {
       int x=1/0;
    }


    public static void deliverToPath(String path){
        String deliveryPath = "C:\\ZR\\deliveryLocation";
        System.out.println("Delivering file to the delivery path " + deliveryPath);
        File fileToZip = new File(path);
        String filePath = deliveryPath + "\\" + fileToZip.getName() + ".zip";
        Path toPath = Paths.get(filePath);
        try (FileOutputStream fos = new FileOutputStream(toPath.toFile())) {
            try (ZipOutputStream zipOut = new ZipOutputStream(fos)) {
                zipFile1(fileToZip, zipOut, "");
                System.out.println("File zipped successfully to: " + filePath);
                zipOut.closeEntry();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while zipping the files: " + e.getMessage());
        }
    }

    private static void zipFile(File fileToZip, ZipOutputStream zipOut, String parentDirectoryName) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }

        String entryName = parentDirectoryName + fileToZip.getName();
        if (fileToZip.isDirectory()) {
            if (!entryName.endsWith("/")) {
                entryName += "/";
            }
            zipOut.putNextEntry(new ZipEntry(entryName));
            File[] files = fileToZip.listFiles();
            for (File childFile : files) {
                zipFile(childFile, zipOut, entryName);
            }
        } else {
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(entryName);
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
    }
    private static void zipFile1(File fileToZip, ZipOutputStream zipOut,String parent ) throws IOException {

        if(fileToZip.isHidden()){
            return;
        }
        String entryName=parent+fileToZip.getName();
        if(fileToZip.isDirectory()){
            if(!entryName.endsWith("/")){
                entryName+="/";
            }
            zipOut.putNextEntry(new ZipEntry(entryName));
            File[] files= fileToZip.listFiles();
            for(File childFile:files){
                zipFile1(childFile,zipOut,entryName);
                System.out.println("File zipped successfully to: " + childFile.getPath());
            }
        }
        else{
            FileInputStream fis=new FileInputStream(fileToZip);
            ZipEntry zipEntry=new ZipEntry(entryName);
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                System.out.println("Zipping the file"+fileToZip.getName());
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
    }

}
