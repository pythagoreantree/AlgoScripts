package com.maria.strings;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jwls = new HashSet<>();
        for (Character jwl: jewels.toCharArray()) {
            jwls.add(jwl);
        }

        int counter = 0;
        for (char c: stones.toCharArray()) {
            if (jwls.contains(c))
                counter++;
        }

        return counter;
    }
}
