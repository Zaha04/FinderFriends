package com.example.sportsbuddy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private Context mContext;
    private List<User> mUsers;
    public UserAdapter(Context mContext,List<User> mUsers){
        this.mUsers=mUsers;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from ( mContext ).inflate ( R.layout.users_template ,parent,false);

        return new UserAdapter.ViewHolder ( view );
    }

    @Override
    public void onBindViewHolder (@NonNull ViewHolder holder, int position) {
final User user=mUsers.get ( position );
holder.username.setText ( user.getFirstName () );
holder.itemView.setOnClickListener ( new View.OnClickListener () {
    @Override
    public void onClick (View view) {
        Intent intent =new Intent ( mContext,MessageActivity.class );
        intent.putExtra ( "FirstName",user.getFirstName () );
        intent.putExtra ( "userid",user.getUid () );
        mContext.startActivity (intent  );

    }
} );

    }

    @Override
    public int getItemCount () {
        return mUsers.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView username;

        public ViewHolder(View itemView){
            super(itemView);
            username=itemView.findViewById ( R.id.username1 );
        }

    }
}
