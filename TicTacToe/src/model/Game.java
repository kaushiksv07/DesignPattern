package model;

import model.enums.CellType;
import model.enums.GameStatus;
import stratergy.WinningStratergy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> players;
    private int currentPlayerIndex;
    private List<Move> listMoves;
    private WinningStratergy winningStratergy;
    private int playersCount;
    private GameStatus gameStatus;
    Scanner sc = new Scanner(System.in);

    public Game() {
        this.board = null;
        players = new ArrayList<Player>();
        currentPlayerIndex = 0;
        listMoves = new ArrayList<>();
        winningStratergy = null;
        gameStatus = GameStatus.INPROGRESS;
    }
    public GameStatus getGameStatus() {
        return gameStatus;
    }
    public void getAndSetSize(){
        System.out.println("Please enter the size of the board");
        int size = sc.nextInt();
        this.board  = new Board(size);
    }
    public void getDetailsOfPlayer(){
        System.out.println("Please enter the player name");
        String playerName = sc.next();
        System.out.println("Please enter the player symbol");
        Symbol symbol = new Symbol(sc.next());
        Player player = new Human(playerName, symbol);
        players.add(player);
    }
    public void startGame() {
        //1. Ask for the size
        getAndSetSize();
        //2. ask for details of players;
        for(int i=0;i<board.getSize()-1;i++){
            getDetailsOfPlayer();
        }
        //3. Display cell
        board.displayBoard();

    }
    public GameStatus checkGameStatus(Board board, Player player) {
        return null;
    }
    public void isValidMove(int row, int col){
        if(row<0 || row > board.getSize()-1 || col<0 || col > board.getSize()-1){
            throw new IllegalArgumentException("Invalid row or column");
        }
        if(board.getCell(row, col).getCellType() == CellType.FILLED){
            throw new IllegalArgumentException("Invalid cell type !! Please try again");
        }
    }
    public void makeMove(){
        Player currentPlayer =  players.get(currentPlayerIndex);
        Move currentMove = currentPlayer.move();
        try{
            isValidMove(currentMove.getCell().getRow(), currentMove.getCell().getColumn());
        }catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
        updateCell(currentMove.getCell().getRow(), currentMove.getCell().getColumn());
        currentPlayerIndex = currentPlayerIndex + 1;
        currentPlayerIndex = currentPlayerIndex % players.size();
    }
    public void updateCell(int row, int col){
        Cell updateCell = board.getCell(row, col);
        Player currentPlayer =  players.get(currentPlayerIndex);
        updateCell.setPlayer(currentPlayer);
        updateCell.setCellType(CellType.FILLED);
    }
    public Board getBoard() {
        return board;
    }
}
