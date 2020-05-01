package main.java.leetcode.Design;

import java.util.*;

public class ReorderLogFiles {
    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                StringTokenizer firstStr = new StringTokenizer(first);
                StringTokenizer secondStr = new StringTokenizer(second);
                String firstIdentifier = firstStr.nextToken();
                String secondIdentifier = secondStr.nextToken();
                int identifierComparison =
                    firstIdentifier.compareTo(secondIdentifier);
                String pendingFirst = first.substring(firstIdentifier.length() + 2);
                String pendingSecond = second.substring(secondIdentifier.length() + 2);
                int pendingComparison = pendingFirst.compareTo(pendingSecond);
                if (identifierComparison == 0) {
                    return pendingComparison;
                } else {
                    return identifierComparison;
                }
            }
        });
        return logs;
    }

    public static String[] reorder(String[] logs) {
        ArrayList<String> let = new ArrayList<>();
        ArrayList<String> dig = new ArrayList<>();
        for (String log : logs) {
            if (log.charAt(0) == 'l') {
                let.add(log);
            } else {
                dig.add(log);
            }
        }
        Collections.sort(let);
        Collections.sort(dig);
        int counter = 0;
        for (String s : let) {
            logs[counter++] = s;
        }
        for (String s : dig) {
            logs[counter++] = s;
        }
        return logs;
    }

    public static void main(String[] args) {
        String[] input = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.toString(reorder(input)));
    }
}
