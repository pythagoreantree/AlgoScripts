package com.maria.strings;

public class DefangingIPAddress {

    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            sb.append(address.charAt(i) == '.'? "[.]":address.charAt(i));
        }
        return sb.toString();
    }
}
