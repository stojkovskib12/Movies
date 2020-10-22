package com.example.movies;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.facebook.login.LoginManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class ProfileFragment extends Fragment {

    TextView txtUser, txtEmail;
    ImageView slika;
    Button floatingActionButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_profile,container,false);

        txtUser =v.findViewById(R.id.useroT);
        txtEmail =v.findViewById(R.id.emailoT);
        slika=v.findViewById(R.id.slikatA);
        floatingActionButton=v.findViewById(R.id.btnLogout);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity()).setIcon(android.R.drawable.alert_light_frame)
                        .setTitle("Logout Alert").setMessage("Are you sure you want to log out?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                FirebaseAuth.getInstance().signOut();
                                Intent intent=new Intent(getContext(), MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                LoginManager.getInstance().logOut();
                            }
                        }).setNegativeButton("NO",null).show();
            }
        });

        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();


        String name = user.getDisplayName();
        String email=user.getEmail();
        txtEmail.setText(email);
        this.txtUser.setText(name);

        if(user.getPhotoUrl()!=null){
            String url=user.getPhotoUrl().toString();
            url=url+"?type=large";
            Picasso.get().load(url).into(slika);
        }

        return v;
    }

}
