package com.maria.strings;

public class ReformatDate {

    public static String reformatDate1(String date) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] dateArr = date.split(" ");

        StringBuilder sb = new StringBuilder(dateArr[2]);
        sb.append("-");
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(dateArr[1])) {
                if (i < 9) {
                    sb.append("0");
                }
                sb.append(i + 1);
            }
        }
        sb.append("-");
        if (Character.isDigit(dateArr[0].charAt(0))) {
            if (Character.isDigit(dateArr[0].charAt(1))) {
                sb.append(dateArr[0].charAt(0)).append(dateArr[0].charAt(1));
            } else {
                sb.append("0").append(dateArr[0].charAt(0));
            }
        }

        return sb.toString();
    }
}
