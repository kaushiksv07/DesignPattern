package stratergy;

import models.Board;
import models.Move;

public interface WinningStratergy {
    boolean checkWinningStratergy(Board board, Move move);
}
