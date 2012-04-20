package br.com.appCar.model;

import java.io.Serializable;

public class Vehicle implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String brand;
    private String model;
    private String plate;
    private int currentKm;
    private int currentVolume;

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

    public int getCurrentKm() {
	return currentKm;
    }

    public void setCurrentKm(int currentKm) {
	this.currentKm = currentKm;
    }

    public int getCurrentVolume() {
	return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
	this.currentVolume = currentVolume;
    }

    public String getPlate() {
	return plate;
    }

    public void setPlate(String plate) {
	this.plate = plate;
    }
}
