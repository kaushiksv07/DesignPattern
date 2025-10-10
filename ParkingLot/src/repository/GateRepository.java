package repository;

import model.Gate;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {

    private int gateCounter = 1;
    private TreeMap<Integer, Gate> gates;
    public GateRepository() {
         gates = new TreeMap<Integer, Gate>();
    }

    public void insertGate(Gate gate) {
        gate.setId(gateCounter);
        gates.put(gateCounter, gate);
        gateCounter++;
    }
    public Optional<Gate> getGate(int id) {
        return Optional.ofNullable(gates.get(id));
    }
}
