package com.example.sampleapp1.observer;

import java.util.ArrayList;
import java.util.List;

public class MyPostOffice implements PostOffice {

    private final List<Observer> observers;
    private String passportMail;
    private boolean hasArrived;
    private final Object MUTEX= new Object();

    public MyPostOffice(){
        this.observers=new ArrayList<>();
    }
    @Override
    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if(!observers.contains(obj)) observers.add(obj);
        }
    }

    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX) {
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!hasArrived)
                return;
            observersLocal = new ArrayList<>(this.observers);
            this.hasArrived =false;
        }
        for (Observer obj : observersLocal) {
            obj.update();
        }

    }

    @Override
    public Object getUpdate() {
        return this.passportMail;
    }

    //method to post message to the topic
    public void postMessage(String msg){
        System.out.println("Message Posted to Topic:"+msg);
        this.passportMail =msg;
        this.hasArrived =true;
        notifyObservers();
    }

}