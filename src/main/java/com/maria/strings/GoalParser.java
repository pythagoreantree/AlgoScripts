package com.maria.strings;

public class GoalParser {

    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == 'G') {
                sb.append('G');
            } else if (c == '(') {
                char c2 = command.charAt(i + 1);
                if (c2 == ')') {
                    sb.append('o');
                } else if (c2 == 'a') {
                    sb.append('a').append('l');
                }
            }
        }
        return sb.toString();
    }

    public String interpret2(String command) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < command.length()) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
                i++;
            }
            if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                sb.append('o');
                i += 2;
            }
            if (command.charAt(i) == '(' && command.charAt(i + 1) == 'a') {
                sb.append('a').append('l');
                i += 4;
            }
        }
        return sb.toString();
    }
}
