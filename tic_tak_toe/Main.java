package tic_tak_toe;
import java.util.*;

public class Main {

    private static final String TYPE_OF_GAME = "Выберите тип игры: 1 - player vs. player, 2 - player vs. computer";
    private static boolean statusYesNo = true;

    public static void main (String[] args){
        System.out.println("Game Tic Tak Toe.");
        checkTypeGame();
        do {
            System.out.println("Хотите начать новую игру? 1 - yes, 2 - no:");
            Scanner scannerNewGame = new Scanner(System.in);
            int resultYesNo = scannerNewGame.nextInt();
            if (resultYesNo == 1){
                checkTypeGame();
            } else if (resultYesNo == 2){
                statusYesNo = false;
            } else {
                System.out.println("Ошибка ввода. Повторите попытку.");
            }
        } while(statusYesNo);
        System.out.println("Конец игры!");

    }

    private static void checkTypeGame(){
        GameType newGame = new GameType();
        System.out.println(TYPE_OF_GAME);
        Scanner scannerTypeGame = new Scanner(System.in);
        newGame.setTypeGame(scannerTypeGame.nextInt());
    }
}
