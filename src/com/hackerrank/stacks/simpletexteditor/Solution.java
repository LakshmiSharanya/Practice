package com.hackerrank.stacks.simpletexteditor;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        String[] split = line.split(" ");
        int N = Integer.parseInt(split[0]);
        Stack stack = new Stack();
        String s = "";

        for (int i = 0; i < N; i++) {
            line = bufferedReader.readLine();
            split = line.split(" ");
            int x = Integer.parseInt(split[0]);

            
            if (x == 1) {
                stack.push(s);
                s = s + split[1];
            } else if (x == 2) {
                int k = Integer.parseInt(split[1]);
                stack.push(s);
                s = s.substring(0, s.length() - k);
            }

            else if (x == 3) {
                int k = Integer.parseInt(split[1]);
                
                System.out.println(s.charAt(k - 1));

            } else {
                s = (String) stack.pop();
            }

        }
    }
}
