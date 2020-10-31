package com.example.sampleapp1.observer;

public class MysoreCityPostOfficeObserverTest {

    public static void main(String[] args) {
        //create subject
        MyPostOffice postOffice = new MyPostOffice();

        //create observers
        Observer person1 = new MyTopicSubscriber("parthiban");
        Observer person2 = new MyTopicSubscriber("sohel");
        Observer person3 = new MyTopicSubscriber("shikar");

        //register observers to the subject
        postOffice.register(person1);
        postOffice.register(person2);
        postOffice.register(person3);

        //attach observer to subject
        person1.setSubject(postOffice);
        person2.setSubject(postOffice);
        person3.setSubject(postOffice);

        //check if any update is available
        person1.update();

        //now send message to subject
        postOffice.postMessage("New passport has arrived");
    }

}