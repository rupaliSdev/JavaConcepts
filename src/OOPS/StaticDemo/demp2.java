package OOPS.StaticDemo;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demp2 {
    private static final int CONTEXT_RANGE = 50; // Number of characters to show before and after the invalid character

    public static void main(String[] args) {

       String text="-<hekki<hell-o>-";

        text=text
                .replaceFirst("^-", "")
//                .replace("&amp;&amp;", "&&").replaceAll("")
//                 <>=3
                .replaceAll("<<(\\D.*?)>>", "$1")
                .replaceAll("<(\\D.*?)>", "$1").replaceAll("([a-zA-Z]+)\\|([a-zA-Z]+)", "$1$2");
               text=text.replaceAll("<(\\D.*?)|(\\D.*?)(<)|(>)(\\D.*?)|(\\D.*?)(>)","$2$4")
                .replaceAll("(?<!\\d)\\^(?![\\d<>]|<>)", "").replaceAll("(?<!\\d)-(?![\\d<>]|<>)", "");
        System.out.println(text);

        String input = "ca<sup>2+</sup>";
        String output = input.replaceAll("<sup>(.*?)</sup>", "|$1");
        /*String filePath = "C:/ZR/Files/1591282/1591282/regular/15912.xml";
        System.out.println(" I review how birds\u0082 have adapted their singing ".replace("\u0082",""));
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] fileBytes = fis.readAllBytes();
            int position = 0;

            while (position < fileBytes.length) {
                int byteRead = fileBytes[position] & 0xFF; // Get unsigned byte value

                if ((byteRead & 0x80) != 0) { // Check if the byte is non-ASCII
                    if (!isValidUtf8Sequence(fileBytes, position)) {
                        printContext(fileBytes, position);
                        break;
                    }
                }
                position++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    private static boolean isValidUtf8Sequence(byte[] fileBytes, int position) {
        int firstByte = fileBytes[position] & 0xFF;
        int expectedBytes = -1;
        if ((firstByte & 0xE0) == 0xC0) expectedBytes = 1;
        else if ((firstByte & 0xF0) == 0xE0) expectedBytes = 2;
        else if ((firstByte & 0xF8) == 0xF0) expectedBytes = 3;
        else return false; // Invalid leading byte

        for (int i = 1; i <= expectedBytes; i++) {
            if (position + i >= fileBytes.length) return false;
            int nextByte = fileBytes[position + i] & 0xFF;
            if ((nextByte & 0xC0) != 0x80) return false;
        }
        return true;
    }

    private static void printContext(byte[] fileBytes, int position) {
        int start = Math.max(0, position - CONTEXT_RANGE);
        int end = Math.min(fileBytes.length, position + CONTEXT_RANGE);

        String context = new String(fileBytes, start, end - start, StandardCharsets.UTF_8);
        String invalidChar = new String(fileBytes, position, 1, StandardCharsets.UTF_8);
        System.out.printf("Invalid UTF-8 sequence detected at position %d: '%s'%n", position, invalidChar);
        System.out.printf("Context around invalid character: %s%n", context);
    }
}
