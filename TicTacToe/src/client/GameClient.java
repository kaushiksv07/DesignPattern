package client;

public class GameClient {
    public static void main(String[] args) {
        GameFactory gameFactory = new GameFactory();
        gameFactory.startGameFactory();

        gameFactory.prceedWithGame();
    }
}
