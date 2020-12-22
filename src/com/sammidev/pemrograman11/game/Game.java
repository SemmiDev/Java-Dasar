package com.sammidev.pemrograman11.game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Game {
    public static void main(String[] args) {

        int dessertLength = 10;
        char sand ='~';
        char tank ='t';
        char hit ='x';
        char miss='0';
        int tankTotal = 3;


        char[][] dessert = createDessert(dessertLength, sand, tank, tankTotal);
        printDessert(dessert, sand, tank);

        int unknownTankDetected = 1;

        while(unknownTankDetected > 0) {
            int[] guessCoordinates = getUserCoordinates(dessertLength);
            char locationViewUpdate = verifyGuessAndTarget(guessCoordinates, dessert, tank, sand, hit, miss);
            if(locationViewUpdate == hit)
            {
                unknownTankDetected--;
            }
            dessert = updateDessert(dessert, guessCoordinates, locationViewUpdate);
            printDessert(dessert, sand, tank);
        }
        System.out.println("Game Over");
    }
    private static char[][] updateDessert(char[][]dessert,int[]guessCoordinates,char locationViewUpdate) {
        int row = guessCoordinates[0];
        int coloumn = guessCoordinates[1];
        dessert[row][coloumn] = locationViewUpdate;
        return dessert;
    }
    private static char verifyGuessAndTarget(int []guessCoordinates,char[][]dessert,char tank,char sand,char hit,char miss) {
        String message;
        int row = guessCoordinates[0];
        int coloumn = guessCoordinates[1];
        char target = dessert[row][coloumn];
        if(target == tank)
        {
            message = "Boom!";
            target = hit;
        }else if(target == sand)
        {
            message = "....";
            target = miss;
        }else
        {
            message = "Sudah Hancur";
        }
        System.out.println(message);
        return target;
    }
    private static int[] getUserCoordinates(int dessertLength) {
        int row;
        int coloumn;

        do{
            System.out.print("Pilih Baris : ");
            row = new Scanner(System.in).nextInt();
        }while(row < 0 || row > dessertLength +1);

        do{
            System.out.print("Pilih Kolom : ");
            coloumn = new Scanner(System.in).nextInt();
        }while(coloumn < 0 || coloumn > dessertLength + 1);

        return new int[]{row - 1, coloumn - 1};
    }
    private static void printDessert(char[][]dessert, char sand, char tank) {
        int dessertLength = dessert.length;

        for (int i = 0; i < dessertLength; i++){
            System.out.print ( i + 1 + " ");
        }
        System.out.println();

        for (int row = 0; row < dessertLength; row++){
            System.out.print(row + 1 + " ");
            for(int coloumn = 0; coloumn < dessertLength; coloumn++)
            {
                char position = dessert[row][coloumn];
                if(position == tank)
                {
                    System.out.print(sand + " ");
                }else
                {
                    System.out.print(position + " ");
                }
            }
            System.out.println();
        }
    }
    private static char[][] createDessert(int dessertLength, char sand, char tank, int tankTotal) {
        char[][] dessert = new char[dessertLength][dessertLength];
        for(char[] row : dessert)
        {
            Arrays.fill(row, sand);
        }

        return placeTanks(dessert, tankTotal, sand, tank);
    }
    private static char[][] placeTanks(char[][] dessert, int tankTotal, char sand, char tank) {
        int placedTanks = 0;
        int dessertLength = dessert.length;

        while(placedTanks < tankTotal)
        {
            int[] location = generateTankCoordinate(dessertLength);
            char positionOk = dessert[location[0]][location[1]];

            if(positionOk == sand)
            {
                dessert[location[0]][location[1]] = tank;
                placedTanks++;
            }
        }
        return dessert;
    }
    private static int[] generateTankCoordinate(int dessertLength) {
        int[] coordinates = new int[2];
        for(int i = 0;i<coordinates.length;i++)
        {
            coordinates[i] = new Random().nextInt(dessertLength);
        }
        return coordinates;
    }

}