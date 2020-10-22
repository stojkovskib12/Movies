package com.example.movies;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;



public class MyMoviesFragment extends Fragment implements CustomAdapter.customClickListener{
    DataBaseHelper mDatabaseHelper;
    SQLiteDatabase mDatabase;
    RecyclerView nov;
    ArrayList<String> lista;
    CustomAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_movies,container,false);
        mDatabaseHelper=new DataBaseHelper(getContext());
        mDatabase=mDatabaseHelper.getWritableDatabase();

        Cursor mCursor = mDatabase.rawQuery("SELECT * FROM tabela", null);
        if(mCursor.getCount() == 0)
            createList();

        nov=v.findViewById(R.id.recyclerview);
        nov.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter=new CustomAdapter(getActivity(),mDatabase.query("tabela",null,null,null,null,null,null),this);
        nov.setAdapter(mAdapter);


        return v;
    }

    @Override
    public void onCustomClick(int position) {
        Cursor cursor=mDatabase.rawQuery("select * from tabela",null);
        if(cursor.getCount()==0){}
        else{
            cursor.moveToPosition(position);
            String name=cursor.getString(1);
            lista=new ArrayList<>();
            lista.add(cursor.getString(2));
            lista.add(cursor.getString(3));
            lista.add(cursor.getString(4));
            lista.add(cursor.getString(5));
            lista.add(cursor.getString(6));
            lista.add(null);
            byte[] image=cursor.getBlob(7);
            String storyline=cursor.getString(8);
            Intent intentStart=new Intent(getContext(), DetailsActivity.class);
            intentStart.putExtra("title",name);
            intentStart.putExtra("list",lista);
            intentStart.putExtra("img",image);
            intentStart.putExtra("storyline",storyline);
            startActivity(intentStart);
        }
    }



    private void createList() {
        Resources res=getResources();

        ByteArrayOutputStream stream= new ByteArrayOutputStream();
        Drawable d=res.getDrawable(R.drawable.boy);
        Bitmap bitmap=((BitmapDrawable)d).getBitmap();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
        byte[] eden = stream.toByteArray();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "The boys");
        contentValues.put("country", " USA");
        contentValues.put("language","English" );
        contentValues.put("year", "2019");
        contentValues.put("filming_location", "Hamilton, Ontario, Canada");
        contentValues.put("runtime","60 min");
        contentValues.put("img",eden);
        contentValues.put("storyline","The Boys is set in a universe where superpowered people are recognized as heroes by the general public and owned by powerful corporation Vought International, which ensures that they are aggressively marketed and monetized. Outside of their heroic personas, most are arrogant and corrupt. The series primarily focuses on two groups: the titular Boys, vigilantes looking to keep the corrupted heroes under control, and the Seven, Vought International's premier superhero team. The Boys are led by Billy Butcher, who despises all superpowered people, and the Seven are led by the egotistical and unstable Homelander. As a conflict ensues between the two groups, the series also follows the new members of each team: Hugh \"Hughie\" Campbell of the Boys, who joins the vigilantes after his girlfriend is killed in a high speed collision by the Seven's A-Train, and Annie January / Starlight of the Seven, a young and hopeful heroine forced to face the truth about the heroes she admires.");
        mDatabase.insert("tabela", null, contentValues);

        ByteArrayOutputStream stream1= new ByteArrayOutputStream();
        d=res.getDrawable(R.drawable.war);
        bitmap=((BitmapDrawable)d).getBitmap();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream1);
        byte[] dva = stream1.toByteArray();

        contentValues.put("name", "The War with Grandpa");
        contentValues.put("country", " USA");
        contentValues.put("language","English" );
        contentValues.put("year", "2020");
        contentValues.put("filming_location", "Atlanta, Georgia");
        contentValues.put("runtime","94 min");
        contentValues.put("img",dva);
        contentValues.put("storyline","Peter is thrilled that Grandpa is coming to live with his family. That is, until Grandpa moves into Peter's room, forcing him upstairs into the creepy attic. And though he loves his grandpa he wants his room back - so he has no choice but to declare war. With the help of his friends, Peter devises outrageous plans to make Grandpa surrender the room. But Grandpa is tougher than he looks. Rather than give in, Grandpa plans to get even.");
        mDatabase.insert("tabela", null, contentValues);

        ByteArrayOutputStream stream2= new ByteArrayOutputStream();
        d=res.getDrawable(R.drawable.tenet);
        bitmap=((BitmapDrawable)d).getBitmap();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream2);
        byte[] tri = stream2.toByteArray();

        contentValues.put("name", "Tenet");
        contentValues.put("country", "  UK | USA");
        contentValues.put("language","English | Russian | Ukrainian | Estonian" );
        contentValues.put("year", "2020");
        contentValues.put("filming_location", "Atlanta, Georgia");
        contentValues.put("runtime","150  min");
        contentValues.put("img",tri);
        contentValues.put("storyline","In a twilight world of international espionage, an unnamed CIA operative, known as The Protagonist, is recruited by a mysterious organization called Tenet to participate in a global assignment that unfolds beyond real time. The mission: prevent Andrei Sator, a renegade Russian oligarch with precognition abilities, from starting World War III. The Protagonist will soon master the art of \"time inversion\" as a way of countering the threat that is to come.");
        mDatabase.insert("tabela", null, contentValues);

        ByteArrayOutputStream stream3= new ByteArrayOutputStream();
        d=res.getDrawable(R.drawable.interstellar);
        bitmap=((BitmapDrawable)d).getBitmap();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream3);
        byte[] cetiri = stream3.toByteArray();

        contentValues.put("name", "Interstellar");
        contentValues.put("country", " USA | UK | Canada");
        contentValues.put("language","English" );
        contentValues.put("year", "2014 ");
        contentValues.put("filming_location", " Okotoks, Alberta, Canada");
        contentValues.put("runtime","169  min");
        contentValues.put("img",cetiri);
        contentValues.put("storyline","Earth's future has been riddled by disasters, famines, and droughts. There is only one way to ensure mankind's survival: Interstellar travel. A newly discovered wormhole in the far reaches of our solar system allows a team of astronauts to go where no man has gone before, a planet that may have the right environment to sustain human life. ");
        mDatabase.insert("tabela", null, contentValues);


        ByteArrayOutputStream stream4= new ByteArrayOutputStream();
        d=res.getDrawable(R.drawable.dark_knight);
        bitmap=((BitmapDrawable)d).getBitmap();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream4);
        byte[] pet = stream4.toByteArray();

        contentValues.put("name", "The Dark Knight ");
        contentValues.put("country", " USA | UK");
        contentValues.put("language","English | Mandarin" );
        contentValues.put("year", "2008 ");
        contentValues.put("filming_location", "Times Square, Causeway Bay, Hong Kong");
        contentValues.put("runtime","152  min");
        contentValues.put("img",pet);
        contentValues.put("storyline","Set within a year after the events of Batman Begins (2005), Batman, Lieutenant James Gordon, and new District Attorney Harvey Dent successfully begin to round up the criminals that plague Gotham City, until a mysterious and sadistic criminal mastermind known only as \"The Joker\" appears in Gotham, creating a new wave of chaos. Batman's struggle against The Joker becomes deeply personal, forcing him to \"confront everything he believes\" and improve his technology to stop him. A love triangle develops between Bruce Wayne, Dent, and Rachel Dawes.");
        mDatabase.insert("tabela", null, contentValues);


        ByteArrayOutputStream stream5= new ByteArrayOutputStream();
        d=res.getDrawable(R.drawable.bp);
        bitmap=((BitmapDrawable)d).getBitmap();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream5);
        byte[] sest = stream5.toByteArray();

        contentValues.put("name", "Black Panther");
        contentValues.put("country", " USA");
        contentValues.put("language"," English | Swahili | Nama | Xhosa | Korean" );
        contentValues.put("year", "2018 ");
        contentValues.put("filming_location", "Pinewood Atlanta Studios - 461 Sandy Creek Road, Fayetteville, Georgia, USA");
        contentValues.put("runtime","134  min");
        contentValues.put("img",sest);
        contentValues.put("storyline","After the events of Captain America: Civil War, Prince T'Challa returns home to the reclusive, technologically advanced African nation of Wakanda to serve as his country's new king. However, T'Challa soon finds that he is challenged for the throne from factions within his own country. When two foes conspire to destroy Wakanda, the hero known as Black Panther must team up with C.I.A. agent Everett K. Ross and members of the Dora Milaje, Wakandan special forces, to prevent Wakanda from being dragged into a world war. ");
        mDatabase.insert("tabela", null, contentValues);
    }


}
