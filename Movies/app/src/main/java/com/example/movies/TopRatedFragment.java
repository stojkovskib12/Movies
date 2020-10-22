package com.example.movies;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TopRatedFragment extends Fragment implements TopAdapter.TopClickListener {

    RecyclerView recyclerView;
    List<TopClass> topList;
    TopAdapter topAdapter;
    Dialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_toprated, container, false);


        recyclerView=v.findViewById(R.id.recyclerViewTop);
        topAdapter=new TopAdapter(topList,getContext(),this);
        recyclerView.setAdapter(topAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        topList=new ArrayList<>();
        topList.add(new TopClass(R.drawable.avengers,"Avengers","1","20"));
        topList.add(new TopClass(R.drawable.joker,"Joker","2","20"));
        topList.add(new TopClass(R.drawable.roma,"Roma","1","35"));
        topList.add(new TopClass(R.drawable.thefault,"The Fault in Our Stars","1","55"));
        topList.add(new TopClass(R.drawable.crazy,"Crazy Rich Asians ","1","48"));
        topList.add(new TopClass(R.drawable.mebefore,"Me Before You","1","39"));
        topList.add(new TopClass(R.drawable.titanic,"Titanic","2","35"));
        topList.add(new TopClass(R.drawable.lovesimon,"Love, Simon","1","24"));
        topList.add(new TopClass(R.drawable.first,"The First Time","1","33"));
        topList.add(new TopClass(R.drawable.boys,"To All the Boys I've Loved Before ","1","54"));
    }

    @Override
    public void onCustomClick(int position) {
        Toast.makeText(getActivity(), "Movie "+topList.get(position).getText(), Toast.LENGTH_SHORT).show();
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.popup);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView tv;
        ImageView iv;

        tv=dialog.findViewById(R.id.tV);
        iv=dialog.findViewById(R.id.iV);

        tv.setText(topList.get(position).getText());
        iv.setImageResource(topList.get(position).getImg());

        dialog.show();

    }
}
