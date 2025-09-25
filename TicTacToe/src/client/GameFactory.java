package client;

import model.Board;
import model.Game;
import model.enums.GameStatus;

public class GameFactory {
    static Game game = new Game();
    public static void startGameFactory(){
        game.startGame();
    }

    public  void prceedWithGame(){
        while(game.getGameStatus() == GameStatus.INPROGRESS){
            game.makeMove();
            game.getBoard().displayBoard();
        }
    }

}
