package stratergy;

import model.Board;
import model.Move;
import model.Player;

public interface BotStrategy {
    Move makeMove(Board board, Player player);
}
