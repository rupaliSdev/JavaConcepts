//package FileHandling;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import com.google.gson.*;
//
//public class demo {
//
//    static int getCountries(String s, int p) {
//        int count = 0;
//        try {
//            int page = 1;
//            int totalPages = 1;
//            Gson gson = new Gson();
//
//            while (page <= totalPages) {
//                // Build URL
//                String urlStr = "https://jsonmock.hackerrank.com/api/countries/search?name="
//                        + s + "&page=" + page;
//                URL url = new URL(urlStr);
//
//                // Open connection
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                conn.setRequestMethod("GET");
//
//                // Read response
//                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                StringBuilder sb = new StringBuilder();
//                String line;
//                while ((line = br.readLine()) != null) {
//                    sb.append(line);
//                }
//                br.close();
//
//                // Parse JSON
//                JsonObject jsonObj = gson.fromJson(sb.toString(), JsonObject.class);
//                totalPages = jsonObj.get("total_pages").getAsInt();
//                JsonArray data = jsonObj.getAsJsonArray("data");
//
//                // Loop over countries
//                for (JsonElement e : data) {
//                    JsonObject country = e.getAsJsonObject();
//                    int population = country.get("population").getAsInt();
//                    if (population > p) {
//                        count++;
//                    }
//                }
//                page++;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return count;
//    }
//
//    // For local testing
//    public static void main(String[] args) {
//        String s = "un";
//        int p = 100000;
//        System.out.println(getCountries(s, p)); // Expected output: 8
//    }
//}
