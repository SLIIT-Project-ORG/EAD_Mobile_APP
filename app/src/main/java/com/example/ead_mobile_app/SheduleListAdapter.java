package com.example.ead_mobile_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ead_mobile_app.Model.Shedule;


import java.util.List;

public class SheduleListAdapter extends BaseAdapter {

    private Context context;
    private List<Shedule> sheduleList;

    public SheduleListAdapter(Context context, List<Shedule> sheduleList) {
        this.context = context;
        this.sheduleList = sheduleList;
    }

    @Override
    public int getCount() {
        return sheduleList.size();
    }

    @Override
    public Object getItem(int id) {
        return sheduleList.get(id);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int id, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.train_list_item, viewGroup, false);
        }

        TextView trainNameTextView = view.findViewById(R.id.sheduleDetailsTrainName);
        TextView timeTextView = view.findViewById(R.id.sheduleDetailsTrainTime);
        TextView stationTextView = view.findViewById(R.id.sheduleDetailsDate);

        Shedule shedule = sheduleList.get(id);

        trainNameTextView.setText("Train Name: " + shedule.getTrainName());
        timeTextView.setText("Time: " + shedule.getDepartureTime());
        stationTextView.setText("Date: " + shedule.getDepartureStation());

        return view;
    }

    public void addAll(List<Shedule> shedules) {
        sheduleList.addAll(shedules);
        notifyDataSetChanged();
    }
}