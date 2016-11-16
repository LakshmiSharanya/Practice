package com.hackerrank.stacks.maximumelement;

import java.io.*;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws IOException {
        Stack mainStack = new Stack();
        Stack maxStack = new Stack();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        String[] split = line.split(" ");
        int N = Integer.parseInt(split[0]);
        for (int i = 0; i < N; i++) {
            line = bufferedReader.readLine();
            split = line.split(" ");
            int x = Integer.parseInt(split[0]);

            if (x == 1) {
                int y = Integer.parseInt(split[1]);
                mainStack.push(y);
                if (maxStack.isEmpty() || (Integer) maxStack.peek() < y) {
                    maxStack.push(y);
                } else
                    maxStack.push(maxStack.peek());

            } else if (x == 2) {

                mainStack.pop();
                maxStack.pop();

            } else {
                System.out.println(maxStack.peek());
            }
        }
    }
}
