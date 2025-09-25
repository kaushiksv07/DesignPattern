package stratergy;

import model.Board;
import model.Cell;
import model.Move;
import model.Symbol;
import model.enums.GameStatus;

import java.util.HashMap;

public class RowWinningStratergy implements WinningStratergy{
    HashMap<Integer, HashMap<Symbol, Integer>> rowWinningMap;
    int boardSize;
    public RowWinningStratergy(int size) {
        this.boardSize = size;
        for(int row=0;row<size;row++){
            rowWinningMap.put(row, new HashMap<>());
        }
    }
    @Override
    public GameStatus getGameStatus(Board board, Move move) {
         Cell cell = move.getCell();
         int row = cell.getRow();
         int col = cell.getColumn();
         String symbol =  move.getPlayer().getSymbol().getCharecter();
         HashMap<Symbol, Integer> hm = rowWinningMap.get(row);
         if(hm.isEmpty()){



         }else{

         }
    }
}
