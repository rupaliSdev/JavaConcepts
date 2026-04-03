package DSA;

public class testr {

    public static void main(String[] args){

//        Anagram string finding ?
//                listen and silent


        System.out.print(isAnagramString("lislten@","@silent"));
    }

    private static boolean isAnagramString(String s1, String s2) {
        String x= findHashValue(s1);
        String y = findHashValue(s2);

        return x.equals(y);
    }

    private static String findHashValue(String s) {
        int[] chars = new int[256];
        for(char c : s.toCharArray()){
            chars[c]++;
        }
        String hash ="";
        for(int i =0;i<chars.length; i++){
            if(chars[i]>0){
                hash += (char)(i);
                hash +="#";
                hash+=chars[i];
                hash+="#";
            }
        }

        System.out.println(hash);
        return hash;
    }
}
