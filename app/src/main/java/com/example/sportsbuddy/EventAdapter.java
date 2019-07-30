package com.example.sportsbuddy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private List<Event> eventList;
    private Context mContext;


    public EventAdapter (ArrayList<Event> events) {
        this.eventList=events;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from ( parent.getContext () );
        View view= layoutInflater.inflate ( R.layout.evet_layout,parent,false );
        ViewHolder viewHolder=new ViewHolder ( view );

        return viewHolder;
    }

    @Override
    public void onBindViewHolder (@NonNull EventAdapter.ViewHolder holder, int position) {
final Event event=eventList.get ( position );
holder.title.setText ( event.getTitle () );
holder.people.setText ( event.getContPeople () );
holder.author.setText ( event.getAuthor () );

    }

   

    @Override
    public int getItemCount () {
        return eventList.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
public TextView title;
public TextView people;
public TextView author;


        public ViewHolder(final View itemView){
            super(itemView);

author=itemView.findViewById ( R.id.event_author );

title=itemView.findViewById ( R.id.event_title );
people=itemView.findViewById ( R.id.event_people );
itemView.setOnClickListener ( new View.OnClickListener () {
    @Override
    public void onClick (View view) {
        Intent intent=new Intent ( author.getContext (),EventDetails.class );

        intent.putExtra ( "Author",author.getText ().toString () );
        intent.putExtra ( "Title", title.getText ().toString ());
        intent.putExtra ( "Number of people",people.getText ().toString () );

       title.getContext ().startActivity ( intent );
    }
} );
        }

    }
}
