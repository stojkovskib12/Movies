package com.example.movies;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    ImageView iv;
    TextView tv, tv1, tv2, tv3, tv4, tv5, tv6, tv7;
    ArrayList<String> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        iv=findViewById(R.id.IV);
        tv =findViewById(R.id.TV);
        tv1 =findViewById(R.id.TV2);
        tv2 =findViewById(R.id.TV3);
        tv3 =findViewById(R.id.TV4);
        tv4 =findViewById(R.id.TV5);
        tv5 =findViewById(R.id.TV6);
        tv6 =findViewById(R.id.TV7);
        tv7 =findViewById(R.id.storyline);


        Bundle bundle=getIntent().getExtras();
        if(getIntent().hasExtra("image")) {
            int src = bundle.getInt("image");
            iv.setImageResource(src);
        }
        if(getIntent().hasExtra("img")) {
            byte[] src=bundle.getByteArray("img");
            Bitmap bmp= BitmapFactory.decodeByteArray(src,0,src.length);
            iv.setImageBitmap(bmp);
        }
        if(getIntent().hasExtra("title")) {
            String title = bundle.getString("title");
            tv.setText(title);
        }
        if(getIntent().hasExtra("list")) {
            lista = bundle.getStringArrayList("list");
            if (lista.get(0) != null)
                tv1.setText(lista.get(0));
            if (lista.get(1) != null)
                tv2.setText(lista.get(1));
            if (lista.get(2) != null)
                tv3.setText(lista.get(2));
            if (lista.get(3) != null)
                tv4.setText(lista.get(3));
            if (lista.get(4) != null)
                tv5.setText(lista.get(4));

            if (lista.get(5) != null)
                tv6.setText(lista.get(5));
        }

        if(getIntent().hasExtra("storyline")) {
            String storyline = bundle.getString("storyline");
            tv7.setText(storyline);
        }



    }

}
