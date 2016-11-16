package com.cards;

import java.util.Arrays;
import java.util.Random;

public class PlayCardsArrays {

    private static final int TOTAL_CARDS = 3;
    private static final Random random = new Random();

    public static void main(String args[]) {
        for (int i = 0; i < 3; i++) {
            playGameOnce();
        }

    }

    private static void playGameOnce() {
        System.out.println("Playing Cards started");

        int[] A = generateCards();
        int[] B = generateCards();
        System.out.println(playGame(A, B, TOTAL_CARDS));
    }

    private static int[] generateCards() {
        int A[] = new int[TOTAL_CARDS / 2];
        for (int i = 0; i < TOTAL_CARDS / 2; i++) {
            int generatedInt = random.nextInt() % TOTAL_CARDS;
            int rem = Math.floorMod(generatedInt, TOTAL_CARDS);
            A[i] = generatedInt + 1;
        }
        return A;
    }

    private static String playGame(int[] A, int B[], int totalcards) {
        int playerCards[][] = new int[2][TOTAL_CARDS];
        int numberOfCards[] = new int[2];
        int playerIndexes[][] = new int[2][2];
        int pile[] = new int[TOTAL_CARDS];
        int top = 0;

        // Copy Arrays
        copyArray(A, playerCards[0]);
        copyArray(B, playerCards[1]);

        numberOfCards[0] = A.length;
        numberOfCards[1] = B.length;

        playerIndexes[0][0] = playerIndexes[1][0] = 0;
        playerIndexes[0][1] = A.length;
        playerIndexes[1][1] = B.length;

        printArray(playerCards[0]);
        printArray(playerCards[1]);

        // Use Random to decide who starts the play.
        int currentPlayer = random.nextInt(2);
        System.out.println("Player : " + currentPlayer + " started game");

        // Play the game till both the player has some cards
        while (numberOfCards[0] != 0 && numberOfCards[1] != 0) {
            boolean switchPlayer = true;
            // Current Player should drop a card.
            int currentPlayerCard = playerCards[currentPlayer][playerIndexes[currentPlayer][0]];
            playerCards[currentPlayer][playerIndexes[currentPlayer][0]] = 0;
            // increment index.
            playerIndexes[currentPlayer][0] = (playerIndexes[currentPlayer][0] + 1) % TOTAL_CARDS;
            pile[top++] = currentPlayerCard;
            numberOfCards[currentPlayer]--;

            // Should Current Player take Cards?
            if (top == 1) {
                continue;
            }

            // Condition for currentPlayer takes cards
            if (pile[top - 2] == pile[top - 1]) {
                // Take the cards from pile and put into the current playercards.
                for (int k = 0; k < top; k++) {
                    int currentPilecard = pile[k];
                    playerCards[currentPlayer][playerIndexes[currentPlayer][1]] = currentPilecard;
                    // increment index.
                    playerIndexes[currentPlayer][1] =
                            (playerIndexes[currentPlayer][1] + 1) % TOTAL_CARDS;
                    numberOfCards[currentPlayer]++;
                }

                // End of Pile Copying
                // Reset top
                top = 0;
                switchPlayer = false;
            }

            // Switch the player.
            if (switchPlayer)
                currentPlayer = switchPlayer(currentPlayer);
        }

        if (numberOfCards[0] == 0 && numberOfCards[1] == 0) {
            return "DRAW";
        } else if (numberOfCards[0] == 0) {
            return "B";
        } else
            return "A";
    }

    private static int switchPlayer(int currentPlayer) {
        if (currentPlayer == 0)
            return 1;
        else
            return 0;
    }

    private static void printArray(int[] newA) {
        System.out.println(Arrays.toString(newA));
    }

    private static void copyArray(int[] source, int[] target) {
        for (int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }
    }
}
