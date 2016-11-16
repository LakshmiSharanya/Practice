package com.hackerrank.stacks.balancedparanthesis;

import java.io.*;
import java.util.*;

public class Solution {

    private static final String BALANCED = "YES";
    private static final String NOT_BALANCED = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        String[] split = line.split(" ");
        int N = Integer.parseInt(split[0]);

        for (int i = 0; i < N; i++) {
            line = bufferedReader.readLine();
            System.out.println(isBalanced(line));
        }
    }

    private static String isBalanced(String line) {
        int i = 0;
        Stack stack = new Stack();
        for (i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty())
                    return NOT_BALANCED;
                char c = (Character) stack.pop();
                switch (ch) {
                case ')':
                    if (c != '(')
                        return NOT_BALANCED;
                    break;
                case '}':
                    if (c != '{')
                        return NOT_BALANCED;
                    break;
                case ']':
                    if (c != '[')
                        return NOT_BALANCED;
                    break;
                }

            }

        }
        if (stack.isEmpty())
            return BALANCED;

        return NOT_BALANCED;
    }
}
