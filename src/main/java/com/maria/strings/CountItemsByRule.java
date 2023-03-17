package com.maria.strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountItemsByRule {

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = -1;
        switch(ruleKey) {
            case "type":
                index = 0;
                break;
            case "color":
                index = 1;
                break;
            case "name":
                index = 2;
                break;
            default:
                break;
        }

        int cnt = 0;
        for (int i = 0; i < items.size(); i++) {
            if (ruleValue.equals(items.get(i).get(index)))
                cnt++;
        }
        return cnt;
    }
}
