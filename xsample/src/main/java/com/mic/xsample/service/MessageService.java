package com.mic.xsample.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MessageService extends Service {

    public MessageService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    private class UserBinder{

    }
}
