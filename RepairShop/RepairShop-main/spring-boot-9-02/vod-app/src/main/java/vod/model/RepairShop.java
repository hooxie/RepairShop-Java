package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class RepairShop {

    private int id;
    @NotNull
    @Size(min=2,max=20)
    private String name;
    private String address; // odpowiednik 'logo' - adres warsztatu

    @JsonIgnore
    private List<Car> cars = new ArrayList<>(); // struktura kolekcyjna związana z serwisowanymi autami, uproszczone relacja wiele do wiele

    public RepairShop(int id, String name, String address) { // konstruktor
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public RepairShop() { // bezparametrowy
    }

    // settery, gettery i toString - później będziemy korzystać z wynalazku Lombok
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car c) {
        this.cars.add(c);
    }

    @Override
    public String toString() {
        return "RepairShop{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}