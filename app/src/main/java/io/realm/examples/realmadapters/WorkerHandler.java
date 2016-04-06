package io.realm.examples.realmadapters;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import io.realm.Realm;
import io.realm.examples.realmadapters.models.TimeStamp;

public class WorkerHandler extends Handler {

    public static final int ADD_TIMESTAMP = 1;
    public static final int REMOVE_TIMESTAMP = 2;

    public static final String ACTION = "action";
    public static final String TIMESTAMP = "timestamp";

    private Realm realm;

    public WorkerHandler(Realm realm) {
        this.realm = realm;
    }

    @Override
    public void handleMessage(Message msg) {
        final Bundle bundle = msg.getData();

        final int action = bundle.getInt(ACTION);
        final String timestamp = bundle.getString(TIMESTAMP);

        switch (action) {
            case ADD_TIMESTAMP:
                realm.beginTransaction();
                realm.createObject(TimeStamp.class).setTimeStamp(timestamp);
                realm.commitTransaction();
                break;
            case REMOVE_TIMESTAMP:
                realm.beginTransaction();
                realm.where(TimeStamp.class).equalTo("timeStamp", timestamp).findAll().clear();
                realm.commitTransaction();
                break;
        }
    }
}
