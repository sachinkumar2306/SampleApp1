package com.example.sampleapp1.interfaces;

public class PhilipsAppliance implements SwitchBoard {

    @Override
    public void switchOne() {
        System.out.println("Philips ac appliance is running");

    }

    @Override
    public void switchTwo() {
        System.out.println("Philips fan appliance is running");

    }

    @Override
    public void switchThree() {
        System.out.println("Philips light appliance is running");

    }

    @Override
    public void switchFour() {
        System.out.println("Philips heater appliance is running");

    }
}