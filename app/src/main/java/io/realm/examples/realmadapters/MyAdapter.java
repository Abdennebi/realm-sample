package io.realm.examples.realmadapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;
import io.realm.examples.realmadapters.models.TimeStamp;

public class MyAdapter extends RealmBaseAdapter<TimeStamp> implements ListAdapter {

    private static class ViewHolder {
        TextView timestamp;
    }

    public MyAdapter(Context context, int resId, RealmResults<TimeStamp> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.timestamp = (TextView) convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        TimeStamp item = realmResults.get(position);
        viewHolder.timestamp.setText(item.getTimeStamp());
        return convertView;
    }

    public RealmResults<TimeStamp> getRealmResults() {
        return realmResults;
    }
}
