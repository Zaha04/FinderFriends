package com.example.sportsbuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ConcurrentModificationException;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private List<Event> eventList;
    private Context mContext;
    public EventAdapter(List<Event> eventList){this.eventList=eventList;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from ( mContext ).inflate ( R.layout.evet_layout ,parent,false);

        return new EventAdapter.ViewHolder ( view );
    }

    @Override
    public void onBindViewHolder (@NonNull EventAdapter.ViewHolder holder, int position) {

    }

   

    @Override
    public int getItemCount () {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{



        public ViewHolder(View itemView){
            super(itemView);

        }

    }
}
