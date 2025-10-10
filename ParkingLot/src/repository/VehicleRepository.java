package repository;

import model.Vehicles;

import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {
    private int vehicleId = 1;
    private TreeMap<String, Vehicles> vehicles;
    public VehicleRepository() {
        vehicles = new TreeMap<>();
    }

    public Optional<Vehicles> findByLicenseId(String id) {
        return Optional.ofNullable(vehicles.get(id));
    }

    public Vehicles saveVehicles(Vehicles vehicle) {
        Vehicles newVehicle = new Vehicles();
        newVehicle.setId(vehicleId);
        vehicleId++;
        newVehicle.setLicensePlate(vehicle.getLicensePlate());
        newVehicle.setVehicleType(vehicle.getVehicleType());
        vehicles.put(vehicle.getLicensePlate(), newVehicle);
        return newVehicle;
    }
}
