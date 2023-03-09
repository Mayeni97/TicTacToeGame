package TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {

        char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' } };

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your play via 1-9: ");
            int playerPos = scan.nextInt();
            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
            System.out.println("Postion Taken, Try Anothe Number");
            playerPos = scan.nextInt();
            
        }

            placePiece(gameBoard, playerPos, "Player 1");

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                System.out.println("Postion Taken, Try Anothe Number");
                cpuPos = rand.nextInt(9) + 1;
            placePiece(gameBoard, cpuPos, "CPU");

            printGameBoard(gameBoard);
        }
    }

    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();

        }
    }

    public static void placePiece(char[][] gameBoard, int playerPos, String user) {

        char symbol = ' ';

        if (user.equals("Player 1")) {
            symbol = 'X';
        } else if (user.equals("CPU")) {
            symbol = 'O';
        }

        switch (playerPos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }

    }

    public static String checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List leftColumn = Arrays.asList(1, 4, 7);
        List middleColumn = Arrays.asList(2, 5, 8);
        List rightColumn = Arrays.asList(3, 6, 9);
        List diagonal1 = Arrays.asList(1, 5, 9);
        List diagonal2 = Arrays.asList(3, 5, 7);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(middleRow);
        winning.add(bottomRow);
        winning.add(leftColumn);
        winning.add(middleColumn);
        winning.add(rightColumn);
        winning.add(diagonal1);
        winning.add(diagonal2);

        for (List l : winning) {
            if (playerPositions.contains(l)) {
                return "Player 1 Wins";
            } else if (cpuPositions.contains(l)) {
                return "CPU Wins";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "Draw";
            }
        }
        return null;
    }

}