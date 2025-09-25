package model;

import stratergy.BotStrategy;

public abstract class Bot extends Player{
    private BotStrategy strategy;

    public Bot(String name, Symbol symbol, BotStrategy  strategy) {
        super(name, symbol);
        this.strategy = strategy;
    }
}
