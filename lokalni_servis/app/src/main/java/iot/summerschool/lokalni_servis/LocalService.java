package iot.summerschool.lokalni_servis;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Button;

public class LocalService extends Service {

    private ThreadExample mThread1;

    public LocalService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mThread1 = new ThreadExample();
        mThread1.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mThread1.exit();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // Getters
    public ThreadExample getThread1(){
        return mThread1;
    }

    private class ThreadExample extends Thread{
        Button btn;

        private boolean mRun = true;

        @Override
        public synchronized void start() {
            super.start();
            mRun = true;
        }

        public synchronized void exit(){
            mRun = false;
        }

        @Override
        public void run() {
            while(mRun) {
                Log.d("LocalService", "Hello");
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

}

