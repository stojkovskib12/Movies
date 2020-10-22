package com.example.movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.MyViewHolder> {

    List<TopClass> list;
    Context context;
    TopClickListener tcl;

    public TopAdapter(List<TopClass> list, Context context, TopClickListener tcl){
        this.list = list;
        this.context = context;
        this.tcl=tcl;
    }

    @NonNull
    @Override
    public TopAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View v=inflater.inflate(R.layout.toprecycleritem,parent,false);
        return new MyViewHolder(v,tcl);
    }

    @Override
    public void onBindViewHolder(@NonNull TopAdapter.MyViewHolder holder, int position) {

        holder.imageView.setImageResource(list.get(position).getImg());
        holder.nameTxt.setText(list.get(position).getText());
        holder.h.setText(list.get(position).getHours());
        holder.m.setText(list.get(position).getMinute());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameTxt,h,m;
        ImageView imageView;
        TopClickListener ccl;
        public MyViewHolder(@NonNull View itemView, TopClickListener x) {
            super(itemView);
            nameTxt=itemView.findViewById(R.id.texttop);
            imageView=itemView.findViewById(R.id.imagetop);
            h=itemView.findViewById(R.id.hour);
            m=itemView.findViewById(R.id.minute);
            ccl=x;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ccl.onCustomClick(getAdapterPosition());
        }
    }

    public interface TopClickListener{
        void onCustomClick(int position);
    }
}
