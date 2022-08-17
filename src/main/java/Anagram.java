import java.util.Arrays;

public class Anagram {

    public static void main (String args[]){
        String s = "anagram";
        String t = "nagram";
        System.out.println("isAnagram = " + isAnagram(s,t));
    }
    public static boolean isAnagram(String s, String t) {
        char [] sCharArray = s.toCharArray();
        char [] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        return Arrays.equals(sCharArray, tCharArray);

    }
}
