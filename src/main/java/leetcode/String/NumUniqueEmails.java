package main.java.leetcode.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NumUniqueEmails {
    /**
     * Problem: https://leetcode.com/problems/unique-email-addresses/
     * 26/03/2020
     * @param emails
     * @return
     */
    public static int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for(String str: emails) {
            String name = str.substring(0, str.indexOf('@'));
            name = name.replaceAll("\\.", "");
            int plusIndex = name.indexOf("+");
            if(plusIndex != -1)
                name = name.substring(0, plusIndex);
            String newEmail = name + str.substring(str.indexOf('@'));
            emailSet.add(newEmail);
        }
        return emailSet.size();
    }

    public static void main(String[] args) {
        String[] emails = {
                "testemail@leetcode.com",
                "testemail1@leetcode.com",
                "testemail+david@lee.tcode.com"
        };
        System.out.println(numUniqueEmails(emails));
    }
}
