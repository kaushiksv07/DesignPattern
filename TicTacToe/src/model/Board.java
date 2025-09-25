package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private Cell cell;
    private List<List<Cell>> grid;
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public Board(int size) {
        this.size = size;
        this.grid = new ArrayList<>();
        for(int i=0;i<size;i++){
            List<Cell> row = new ArrayList<Cell>();
            for (int j = 0; j < size; j++) {
                row.add(new Cell(i, j));
            }
            grid.add(row);
        }
    }
    public void displayBoard(){
        for(int i=0;i<size;i++){
            for (int j = 0; j < size; j++) {
                Cell currentCell = grid.get(i).get(j);
                currentCell.displayCell();
            }
            System.out.println();
        }
    }

    public Cell getCell(int row, int col) {
        return grid.get(row).get(col);
    }
}
