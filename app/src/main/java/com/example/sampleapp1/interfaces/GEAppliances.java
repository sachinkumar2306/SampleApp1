package com.example.sampleapp1.interfaces;

public class GEAppliances implements  SwitchBoard {


    @Override
    public void switchOne() {
        System.out.println("Ge ac appliance is running");

    }

    @Override
    public void switchTwo() {
        System.out.println("Ge fan appliance is running");


    }

    @Override
    public void switchThree() {
        System.out.println("Ge light appliance is running");

    }

    @Override
    public void switchFour() {
        System.out.println("Ge heater appliance is running");

    }
}