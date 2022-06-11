package com.maria.strings;

public class StringSuffixPrefix {

    public static String s1 = "abbabba";
    public static String s2 = "codility";

    public static int getIntersectionLen(String S){
        int longestStringLen = 0;

        for (int i = 1; i < S.length(); i++){
            String left = S.substring(0, i);
            String right = S.substring(S.length() - i);
//            System.out.println("left: " + left + ", right=" + right);

            if (left != null && left.equals(right)){
                if (left.length() > longestStringLen){
                    longestStringLen = left.length();
                }
            }
        }

        return longestStringLen;
    }


    public static String decodeString(String inputString){

        int fp = 0;
        int fstart = 0;
        int fend = 0;

        StringBuilder sb = new StringBuilder();
        while (fp < inputString.length()){

            char elem = inputString.charAt(fp);
            if(Character.isDigit(elem)){
                fstart = fp;
                fend = fp;
                while(fend < inputString.length() && Character.isDigit(inputString.charAt(fend))){
                    fend++;
                }
                int fnum = fend - fstart -1;
                int resultNum = 0;
                for (int i = fstart; i < fend; i++){
                    resultNum += Character.getNumericValue(inputString.charAt(i))*Double.valueOf(Math.pow(10,fnum)).intValue();
                    fnum--;
                }
                for(int j=0; j<resultNum; j++){
                    sb.append('*');
                }
                fp = fend;

            } else {
                sb.append(elem);
                fp++;
            }
        }

        return sb.toString();
    }

    public static boolean checkStrings(String S, String T) {
        // write your code in Java SE 8

        String newS = decodeString(S);
        String newT = decodeString(T);

        if (newS.length() != newT.length())
            return false;

        for (int i=0; i<newS.length(); i++){
            char schar = newS.charAt(i);
            char tchar = newT.charAt(i);
            if (schar != '*' && tchar != '*' && schar != tchar){
                return false;
            }
        }
        return true;
    }
//
//    public static String decodeString(String inputString){
//        int l = inputString.length();
//
//        boolean startDigit = false;
//        int startDigitPos = 0;
//        for (int i =0; i<inputString.length(); i++){
//            if (!Character.isDigit(inputString.charAt(i)) && startDigit){
//                l += Integer.parseInt(inputString.substring(startDigitPos, i));
//                startDigit = false;
//            }
//            if (Character.isDigit(inputString.charAt(i)) && !startDigit){
//                startDigit = true;
//                startDigitPos = i;
////                System.out.println();
////                l += Character.getNumericValue(inputString.charAt(i));
//            }
//        }
//        if(startDigit){
//            l += Integer.parseInt(inputString.substring(startDigitPos));
//        }
//        char[] sequence = new char[l];
//        int pointer = 0;
//        for (int j=0; j<inputString.length(); j++){
//            if (!Character.isDigit(inputString.charAt(j))){
//                sequence[pointer] = inputString.charAt(j);
//                pointer++;
//            } else {
//                int n = Character.getNumericValue(inputString.charAt(j));
//                while (n > 0) {
//                    sequence[pointer] = '*';
//                    pointer++;
//                    n--;
//                }
//            }
//        }
//        return new String(sequence);
//    }
}
