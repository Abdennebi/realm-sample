package io.realm.examples.realmadapters;

import android.os.Handler;
import android.os.Looper;

import io.realm.Realm;

public class WorkerThread extends Thread {

    public Handler workerHandler;

    @Override
    public void run() {
        Realm realm = null;
        try {
            Looper.prepare();
            realm = Realm.getDefaultInstance();
            workerHandler = new WorkerHandler(realm);
            Looper.loop();
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }
}
