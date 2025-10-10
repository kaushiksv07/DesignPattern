package repository;

import model.Operator;

import java.util.Optional;
import java.util.TreeMap;

public class OperatorRepository {
    private int opratorCounter = 1;
    private TreeMap<Integer, Operator> operators;
    public OperatorRepository() {
        operators = new TreeMap<>();
    }
    public void insertOperator(Operator operator) {
        operator.setId(opratorCounter++);
        operators.put(operator.getId(), operator);
    }
    public Optional<Operator> getOperator(int id) {
        return Optional.ofNullable(operators.get(id));
    }
}
