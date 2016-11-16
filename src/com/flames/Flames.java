package com.flames;

import java.util.Scanner;

public class Flames {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First name");
        String firstName = sc.nextLine();

        System.out.println("Enter Second name");
        String secondName = sc.nextLine();

        System.out.println(firstName + " : " + secondName);

        System.out.println(commonCharacters(firstName, secondName));
        System.out.println(playGame(commonCharacters(firstName, secondName)));
    }

    private static int commonCharacters(String firstName, String secondName) {
        char[] firstArray = toCharArray(firstName);
        char[] secondArray = toCharArray(secondName);
        int i = 0, j = 0, jindex = 0, count = 0;
        while (i < firstArray.length) {
            if (j != secondArray.length) {
                if (firstArray[i] == secondArray[j]) {
                    count += 2;
                    i++;
                    j++;
                    jindex = i;
                } else {
                    j++;
                }
            } else {
                i++;
                j = jindex;
            }
        }
        return count;
    }

    private static int commonCharacters1(String firstName, String secondName) {
        char[] firstArray = toCharArray(firstName);
        char[] secondArray = toCharArray(secondName);
        int count = 0;
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] == ' ')
                continue;
            for (int j = 0; j < secondArray.length; j++) {
                if (firstArray[i] == secondArray[j]) {
                    count += 2;
                    secondArray[j] = '-';
                    break;
                }
            }
        }
        return count;
    }

    private static char playGame(int count) {
        char[] gameArray = toCharArray("flames");
        int numberOfChars = 6;
        int i = 0;
        int curCount = 0;
        while (numberOfChars != 1) {

            if (gameArray[i] == ' ') {
                i =  (i + 1) % 6;
                continue;
            }

            if (++curCount == count) {
                System.out.println("Striking off : " + gameArray[i]);
                gameArray[i] = ' ';
                numberOfChars--;
                curCount = 0;            
            }
            
            i =  (i + 1) % 6;
        }

        char desiredChar = 'A';
        for (char cur : gameArray) {
            if (cur != ' ') {
                desiredChar = cur;
                break;
            }
        }

        return desiredChar;
    }

    private static char[] toCharArray(String name) {
        char[] characters = new char[name.length()];
        for (int i = 0; i < name.length(); i++) {
            characters[i] = name.charAt(i);
        }
        return characters;
    }

}
