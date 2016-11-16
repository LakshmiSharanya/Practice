package com.hackerrank.dynamicarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        String[] split = line.split(" ");
        int N = Integer.parseInt(split[0]);
        int Q = Integer.parseInt(split[1]);

        // Initial Values
        int lastAns = 0;
        List[] seqList = new List[N];
        for (int i = 0; i < N; i++) {
            seqList[i] = new ArrayList<>();
        }

        for (int i = 0; i < Q; i++) {
            line = bufferedReader.readLine();
            split = line.split(" ");
            int x = Integer.parseInt(split[1]);
            int y = Integer.parseInt(split[2]);

            int temp = (x ^ lastAns) % N;

            // Type 1 Query
            if (split[0].equals("1")) {
                List seq = seqList[temp];
                seq.add(y);
            } else {
                int size = seqList[temp].size();
                lastAns = (Integer) seqList[temp].get(y % size);
                System.out.println(lastAns);
            }
        }
    }
}
