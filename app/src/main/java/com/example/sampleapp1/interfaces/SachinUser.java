package com.example.sampleapp1.interfaces;

public class SachinUser {

    public static void main(String[] args) {
        SwitchBoard switchBoard = new PhilipsAppliance();
        //new GEAppliances();
        switchBoard.switchOne();//ac will be on
        switchBoard.switchTwo();
        switchBoard.switchThree();
        switchBoard.switchFour();
    }
}