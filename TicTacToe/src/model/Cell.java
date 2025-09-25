package model;

import model.enums.CellType;

public class Cell {
    private Player player;
    private CellType cellType;
    private int row;
    private int column;

    public Cell(int row, int column) {
        this.player = null;
        this.row = row;
        this.column = column;
        cellType =  CellType.EMPTY;
    }
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }
    public CellType getCellType() {
        return cellType;
    }
    public void displayCell() {
        if(cellType == CellType.EMPTY) {
            System.out.print("| - |");
        }else if(cellType == CellType.FILLED){
            System.out.print("| " + player.getSymbol().getCharecter() + " |");
        }

    }
}
