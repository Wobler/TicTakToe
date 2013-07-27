package tic_tak_toe;

import tic_tak_toe.gamePlayerVsPlater.GamePlayerVsPlayer;

public class GameType {
    private static final int TYPE_PLAYER_VS_PLAYER = 1;
    private static final int TYPE_PLAYER_VS_COMPUTER = 2;


    public void setTypeGame(int inputTypeGame){
        if (inputTypeGame == TYPE_PLAYER_VS_PLAYER){
            GamePlayerVsPlayer newGamePlayerVsPlayer = new GamePlayerVsPlayer();
            newGamePlayerVsPlayer.startGame();
        } else if (inputTypeGame == TYPE_PLAYER_VS_COMPUTER){
            System.out.println("Раздел находится в разработке.");
        } else {
            System.out.println("Такого типа игры нет! Выбирете другой.");
        }

    }
}
