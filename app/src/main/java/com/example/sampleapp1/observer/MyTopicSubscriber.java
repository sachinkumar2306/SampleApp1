package com.example.sampleapp1.observer;

import android.util.Log;

public class MyTopicSubscriber implements Observer {
    public static final String TAG = MyTopicSubscriber.class.getSimpleName();
    private final String name;
    private PostOffice topic;

    public MyTopicSubscriber(String nm){
        this.name=nm;
    }
    @Override
    public void update() {
        String msg = (String) topic.getUpdate();
        if(msg == null){
            System.out.println(name+":: No new message");
            Log.i(TAG,name+":: No new message");
        }else
            System.out.println(name+":: Consuming message::"+msg);
        Log.i(TAG,name+":: Consuming message::"+msg);

    }

    @Override
    public void setSubject(PostOffice sub) {
        this.topic=sub;
    }

}