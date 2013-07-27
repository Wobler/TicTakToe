package tic_tak_toe.gamePlayerVsPlater;

import tic_tak_toe.Field.Field;
import tic_tak_toe.human.Human;

import java.util.Scanner;

public class GamePlayerVsPlayer {

    private static final char DEFAULT_SYMBOL_PLAYER1 = 'X';
    private static final char DEFAULT_SYMBOL_PLAYER2 = 'O';

    private boolean gameOn = true;
    private boolean player1Win = false;
    private boolean player2Win = false;
    private boolean statusInputError = true;
    private boolean putStatus = true;

    private int resultScan;
    private int numberStep = 0;

    public  void  startGame(){

        Human player1 = new Human();
        Human player2 = new Human();
        Field fieldGame = new Field();

        System.out.println("Введите имя игрока 1:");
        Scanner setNamePlayer1 = new Scanner(System.in);
        player1.setName(setNamePlayer1.next());
        System.out.println("Игрок"+ player1.getName()+" играет симолом "+DEFAULT_SYMBOL_PLAYER1);

        System.out.println("Введите имя игрока 2:");
        Scanner setNamePlayer2 = new Scanner(System.in);
        player2.setName(setNamePlayer2.next());
        System.out.println("Игрок "+player2.getName()+"  играет симолом "+DEFAULT_SYMBOL_PLAYER2);

        fieldGame.eraseField();
        fieldGame.showField();


        while (gameOn){
            numberStep++;

            System.out.println("Ход номер "+ numberStep);
            System.out.println("Ходит  "+ player1.getName());

            while (putStatus){
                System.out.print("Введите номер строки:  ");
                while (statusInputError){
                    Scanner scannerLinePlayer1 = new Scanner(System.in);
                    resultScan = scannerLinePlayer1.nextInt();
                    statusInputError = fieldGame.checkInputOk(resultScan);
                    messageError();
                }
                player1.setNumberRow(resultScan);
                statusInputError = true;

                System.out.print("Введите номер стобца:  ");
                while (statusInputError){
                    Scanner scannerColumnPlayer1 = new Scanner(System.in);
                    resultScan = scannerColumnPlayer1.nextInt();
                    statusInputError = fieldGame.checkInputOk(resultScan);
                    messageError();
                }
                player1.setNumberColumn(resultScan);
                statusInputError = true;

                fieldGame.putSymbol(player1.getNumberColumn(),player1.getNumberRow(), DEFAULT_SYMBOL_PLAYER1);
                if (Field.symbolCheck){
                    putStatus = false;
                } else {
                    putStatus = true;
                }
            }
            fieldGame.showField();
            putStatus = true;

            if (numberStep >= fieldGame.fieldSize){
                if (fieldGame.checkWin()){
                    gameOn = false;
                    player1Win = true;
                    break;
                }
            }

            if (numberStep >= fieldGame.fieldSize*fieldGame.fieldSize) {
                break;
            }

            numberStep++;
            System.out.println("Ход номер "+ numberStep);
            System.out.println("Ходит  "+ player2.getName());

            while (putStatus){
                System.out.print("Введите номер строки:  ");
                while (statusInputError){
                    Scanner scannerLinePlayer2 = new Scanner(System.in);
                    resultScan = scannerLinePlayer2.nextInt();
                    statusInputError = fieldGame.checkInputOk(resultScan);
                    messageError();
                }
                player2.setNumberRow(resultScan);
                statusInputError = true;

                System.out.print("Введите номер стобца:  ");
                while (statusInputError){
                    Scanner scannerColumnPlayer2 = new Scanner(System.in);
                    resultScan = scannerColumnPlayer2.nextInt();
                    statusInputError=fieldGame.checkInputOk(resultScan);
                    messageError();
                }
                player2.setNumberColumn(resultScan);
                statusInputError = true;

                fieldGame.putSymbol(player2.getNumberColumn(),player2.getNumberRow(), DEFAULT_SYMBOL_PLAYER2);
                if (Field.symbolCheck){
                    putStatus = false;
                } else {
                    putStatus = true;
                }
            }
            fieldGame.showField();
            putStatus = true;

            if (numberStep >= fieldGame.fieldSize){
                if (fieldGame.checkWin()){
                    gameOn = false;
                    player2Win = true;
                    break;
                }
            }

            if (numberStep >= fieldGame.fieldSize*fieldGame.fieldSize) {
                break;
            }
        }

        if (player1Win){
            System.out.println("Выйгра игрок "+ player1.getName());
        } else if (player2Win){
                System.out.println("Выйгра игрок "+ player2.getName());
        } else {
                System.out.println("Ничья!");
        }
    }

    private void messageError(){
        if (statusInputError){
            System.out.print("Ошибка ввода. Введите новое число: ");
        }
    }
}