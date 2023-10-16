package com.example.ead_mobile_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ead_mobile_app.Model.Train;

import java.util.List;

public class TrainListAdapter extends BaseAdapter {

    private Context context;
    private List<Train> trainList;

    public TrainListAdapter(Context context, List<Train> trainList) {
        this.context = context;
        this.trainList = trainList;
    }

    @Override
    public int getCount() {
        return trainList.size();
    }

    @Override
    public Object getItem(int id) {
        return trainList.get(id);
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

        TextView trainNameTextView = view.findViewById(R.id.trainNameTextView);
        TextView trainCapacityTextView = view.findViewById(R.id.trainCapacityTextView);
        TextView trainTypeTextView = view.findViewById(R.id.trainTypeTextView);

        Train train = trainList.get(id);

        trainNameTextView.setText("Train Name: " + train.getTrainName());
        trainCapacityTextView.setText("Capacity: " + train.getCapacity());
        trainTypeTextView.setText("Type: " + train.getTrainTypeId());

        return view;
    }

    public void addAll(List<Train> trains) {
        trainList.addAll(trains);
        notifyDataSetChanged();
    }
}