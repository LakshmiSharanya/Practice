package com.arrays.problems;

public class CharCount {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String line = "sattas";
        // Output:  a4b5c6t7d1
        printCounts(line);
    }

    private static void printCounts(final String line) {
        char[] charArray = line.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            int count = 1;

            if (ch == '@')
                continue;

            for (int j = i + 1; j < charArray.length; j++) {
                if (ch == charArray[j]) {
                    count++;
                    charArray[j] = '@';
                }
            }

            System.out.println(ch + ": " + count);
        }
    }
}

