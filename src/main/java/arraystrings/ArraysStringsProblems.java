package arraystrings;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ArraysStringsProblems {

    // Problem: Replace all spaces in a string with "%20"
    // Assume: String has sufficient space at the end to add the new characters and is given the true length of the string
    public static String urlifyv1(String str, int length) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < length; i++) {
            if(chars[i] == ' ') {
                // move characters 2 times
                for(int t = 0; t < 2; t++) {
                    for (int j = length - 1; j > i; j--) {
                        chars[j] = chars[j - 1];
                    }
                }
                chars[i] = '%';
                chars[i + 1] = '2';
                chars[i + 2] = '0';
            }
        }
        return Arrays.toString(chars);
    }

    public static String urlifyv2(String str, int length) {
        char[] chars = str.toCharArray();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                s.append("%20");
            } else {
                s.append(chars[i]);
            }
            if(s.length() == length) {
                break;
            }
        }
        return s.toString();
    }

    // Problem: Given a string, write a function to check if it is a permutation of a palindrome
    // Assume: Palindrome does not need to be limited to just dictionary words
    public static boolean palindromePermutation(String str) {
    // if length of str is even, then every character must appear an even number of times
    // if length of str is odd, then exactly one character can appear an odd number of times (center of the palindrome)
    // and all other characters must appear an even number of times
        boolean isEven = str.length() % 2 == 0;
        Map<Character, Integer> charMap = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(!charMap.containsKey(c)) {
                charMap.put(c, 1);
            } else {
                charMap.put(c, charMap.get(c) + 1);
            }
        }
        if(isEven && isEvenMap(charMap)) {
            return true;
        }
        if(!isEven && !isEvenMap(charMap)) {
            return true;
        }
        return false;
    }

    private static boolean isEvenMap(Map<Character, Integer> charMap) {
        AtomicInteger countOdds = new AtomicInteger();
        charMap.forEach((c, count) -> {
            if(count % 2 != 0){
                countOdds.addAndGet(count);
            }
        });
        return countOdds.get() % 2 == 0;
    }

    //Problem: Implement a method to perform basic string compression using the counts of repeated characters
    public static String stringCompression(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); ) {
            int count = 1;
            for(int j = i + 1; j < str.length(); ) {
                if(str.charAt(i) == str.charAt(j)) {
                    count++;
                    j++;
                } else {
                    sb.append(str.charAt(i));
                    sb.append(count);
                    i += count;
                    break;
                }
                if(j == str.length()) {
                    sb.append(str.charAt(i));
                    sb.append(count);
                    i += count;
                }
            }
        }
        return sb.toString();
    }
}
