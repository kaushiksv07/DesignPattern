package repository;

import model.Slots;

import java.util.Optional;
import java.util.TreeMap;

public class SlotRepository {
    private int slotCounter = 1;
    private TreeMap<Integer, Slots> slots;
    public SlotRepository() {
        slots = new TreeMap<>();
    }
    public void intializeSlots(Slots slot) {
        slot.setId(slotCounter);
        slots.put(slotCounter, slot);
        slotCounter++;
    }
    public Optional<Slots> getSlot(int id) {
        return Optional.ofNullable(slots.get(id));
    }
}
