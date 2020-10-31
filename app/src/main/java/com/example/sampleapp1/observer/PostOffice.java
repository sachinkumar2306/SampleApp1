package com.example.sampleapp1.observer;

public interface PostOffice {

    //methods to register and unregister observers
    void register(Observer obj);
    void unregister(Observer obj);

    //method to notify observers of change
    void notifyObservers();

    //method to get updates from subject
    Object getUpdate();

}