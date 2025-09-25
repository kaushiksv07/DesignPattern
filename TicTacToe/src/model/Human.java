package model;

import java.util.Scanner;

public class Human extends Player{
    private int coins;
    Scanner sc = new Scanner(System.in);

    public Human(String name, Symbol symbol) {
        super(name, symbol);
    }

    @Override
    public Move move() {
        System.out.println("Hi "+ this.getName() +" Please enter your row  for your " + this.getSymbol().getCharecter());
        int row = sc.nextInt();
        System.out.println("Please enter the columns");
        int col = sc.nextInt();
        return new Move(this, new Cell(row,col));
    }
}
