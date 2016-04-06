package io.realm.examples.realmadapters.models;

import io.realm.RealmObject;

public class TimeStamp extends RealmObject {
    private String timeStamp;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
