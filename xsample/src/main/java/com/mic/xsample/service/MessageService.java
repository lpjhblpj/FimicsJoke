package com.mic.xsample.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.mic.xsample.UserAidl;

public class MessageService extends Service {




    public MessageService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }


    private final UserAidl.Stub mBinder = new UserAidl.Stub() {
        @Override
        public String getUserName() throws RemoteException {
            return "aaa";
        }

        @Override
        public String getPassword() throws RemoteException {
            return "bbb";
        }
    };
}
