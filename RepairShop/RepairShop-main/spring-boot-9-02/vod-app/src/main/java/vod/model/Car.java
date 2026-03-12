package vod.model;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private int id;

    private String brand;
    private String model;

    // Relacja wiele do jednego z mechanikiem (odpowiednik reżysera)
    private Mechanic mechanic;

    // Relacja wiele do wielu z warsztatami (odpowiednik kin)
    private List<RepairShop> repairShops = new ArrayList<>();

    public Car(int id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public List<RepairShop> getRepairShops() {
        return repairShops;
    }

    public void setRepairShops(List<RepairShop> repairShops) {
        this.repairShops = repairShops;
    }

    public void addRepairShop(RepairShop shop) {
        this.repairShops.add(shop);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", mechanic=" + (mechanic != null ? mechanic.getLastName() : "brak") +
                '}';
    }
}