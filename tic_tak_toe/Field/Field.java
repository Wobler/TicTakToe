package tic_tak_toe.Field;

import java.util.Scanner;

public class Field {

    private static final int DEFAULT_FIELD_SIZE = 3;
    private static final char DEFAULT_CELL_NUMBER= ' ';

    public  final int fieldSize;
    public  final char[][] field;
    public static boolean symbolCheck = true;
    private boolean statusWin = false;
    private int counter;


    public Field(){
        this (DEFAULT_FIELD_SIZE);
    }

    public Field(int size){
        fieldSize = size;
        field = new char[fieldSize][fieldSize];
    }

    public void eraseField(){
        for (int i = 0; i < fieldSize; i++){
            eraseLine(i);
        }
    }

    private void eraseLine(int lineNumber){
        for (int i = 0; i < fieldSize; i++){
            field[i][lineNumber]= DEFAULT_CELL_NUMBER;
        }
    }

    public void showField(){
        System.out.println();
        for (int i = 0; i < fieldSize; i++){
            showLine(i);
            System.out.println();
        }
        System.out.println();
    }

    private void showLine (int lineNumber){
        for (int i = 0; i < fieldSize; i++){
            showCell(i, lineNumber);
        }
    }

    private void showCell (int x, int y){
        System.out.print("[" + field[x][y] + "]");
    }

    public void putSymbol(int x, int y, char symbol){
        if (field[x][y] == DEFAULT_CELL_NUMBER){
            field[x][y]= symbol;
            symbolCheck = true;
        }else {
            System.out.println("Поле занято. Выберите другое поле.");
            symbolCheck = false;
        }
    }

    public boolean checkWin (){
        checkLine();
        if (statusWin){
            return statusWin;
        } else {
            checkColumn();
            if (statusWin){
                return statusWin;
            } else {
                checkDiagonalBasic();
                if (statusWin){
                    return statusWin;
                } else {
                    checkDiagonalSide();
                    return  statusWin;
                }
            }
        }
    }

    private void checkLine (){
        for (int i=0; i < fieldSize; i++){
            checkOneLine(i);
            if (statusWin){
                break;
            }
        }
    }

    private void checkOneLine(int numberLine){
        counter =0;
        for (int i=0; i< (fieldSize-1); i++){
            if (field[i][numberLine] != DEFAULT_CELL_NUMBER){
                if (field[i][numberLine] == field[i+1][numberLine]){
                    counter++;
                    if (counter == fieldSize -1){
                        statusWin = true;
                    } else {
                        statusWin = false;
                    }
                }else {
                    statusWin = false;
                    break;
                }
            }
        }
    }

    private void checkColumn(){
        for (int i=0; i< fieldSize; i++){
            checkOneColumn(i);
            if (statusWin){
                break;
            }
        }
    }

    private void checkOneColumn (int numberColumn){
        counter = 0;
        for (int i=0; i < (fieldSize-1); i++){
            if (field[numberColumn][i] != DEFAULT_CELL_NUMBER){
                if (field [numberColumn][i] == field [numberColumn][i+1]){
                    counter++;
                    if (counter == fieldSize-1){
                        statusWin = true;
                    } else {
                        statusWin = false;
                    }
                }else {
                    statusWin = false;
                    break;
                }
            }
        }
    }

    private void  checkDiagonalBasic(){
        counter = 0;
        for (int i=0; i < (fieldSize-1); i++){
            if (field[i][i] == field[i+1][i+1] && field[i][i] != DEFAULT_CELL_NUMBER){
                counter++;
                if (counter == fieldSize -1){
                    statusWin = true;
                }else {
                    statusWin = false;
                }
            } else {
                statusWin = false;
                break;
            }
        }
    }

    private void checkDiagonalSide(){
        counter =0;
        for (int i=(fieldSize-1); i > 0 ; i--){
            if (field[(fieldSize-1)-i][i] == field[fieldSize-i][i-1] && field[(fieldSize-1)-i][i] != DEFAULT_CELL_NUMBER){
                counter++;
                if (counter == fieldSize - 1){
                    statusWin = true;
                } else {
                    statusWin = false;
                }
            } else {
                statusWin = false;
                break;
            }
        }
    }

    public boolean checkInputOk (int newResultScan){
        int resultScan = newResultScan;
        if (resultScan >= 0 && resultScan < fieldSize) {
            return false;
        } else {
            return true;
        }
    }
}
