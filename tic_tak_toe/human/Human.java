package tic_tak_toe.human;

public class Human {

    private String name;
    private int numberRow;
    private int numberColumn;

    public void setName(String newName){
        name = newName;
    }

    public String getName(){
        return name;
    }

    public void setNumberRow(int newNumberRow){
        numberRow = newNumberRow;
    }
    public void setNumberColumn (int newNumberColumn){
        numberColumn = newNumberColumn;
    }

    public int getNumberRow(){
        return numberRow;
    }

    public int getNumberColumn(){
        return numberColumn;
    }

}
