package com.maria.strings;

import org.apache.commons.lang3.StringUtils;

public class MaxNumOfWordsInSentences {

    public int mostWordsFound(String[] sentences) {
        int maxnum = 0;

        for (String sentence: sentences) {
            int mxn = (int) (sentence.chars().filter(ch -> ch == ' ').count() + 1);
            if (mxn > maxnum) {
                maxnum = mxn;
            }
        }

        return maxnum;
    }

    public int mostWordsFoundV2(String[] sentences) {
        int maxnum = 0;

        for (String sentence: sentences) {
            int maxNumForSentence = StringUtils.countMatches(sentence, " ");
            if (maxNumForSentence > maxnum) {
                maxnum = maxNumForSentence;
            }
        }

        return maxnum;
    }


    public int mostWordsFoundV3(String[] sentences) {
        int maxnum = 0;

        for (String sentence: sentences) {
            int mxn = 1;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ')
                    mxn++;

            }
//            String[] words = sentence.split(" ");
//            int mxn = words.length;
            if (mxn > maxnum) {
                maxnum = mxn;
            }
        }

        return maxnum;
    }

    public int mostWordsFoundV4(String[] sentences) {
        long count = 0;
        for (String sentence : sentences) {
            count = Math.max(sentence.chars().filter(c -> c == ' ').count() + 1, count);
        }
//        System.gc();
        return (int) count;
    }
}
