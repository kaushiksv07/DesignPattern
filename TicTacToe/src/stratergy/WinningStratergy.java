package stratergy;

import model.Board;
import model.Game;
import model.Move;
import model.enums.GameStatus;

public interface WinningStratergy {
    GameStatus getGameStatus(Board board, Move move);
}
