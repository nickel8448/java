package main.java.LeetCode.Design;

import java.util.HashMap;
import java.util.HashSet;

public class Logger {

    private HashMap<String, Integer> logMap;

    public Logger() {
        logMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(logMap.containsKey(message)) {
            if (timestamp - logMap.get(message) < 10) {
                return false;
            }
        }
        logMap.put(message, timestamp);
        return true;
    }

    public static void main(String []args) {
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(3, "foo"));
        System.out.println(logger.shouldPrintMessage(10, "foo"));
        System.out.println(logger.shouldPrintMessage(11, "foo"));
        System.out.println(logger.shouldPrintMessage(2, "bar"));
        System.out.println(logger.shouldPrintMessage(8, "bar"));
    }
}
