package com.example.quixoteinternshiptask;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
   static List<Notetype> listView;
    private FloatingActionButton actionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ListView notelist = (ListView) findViewById(R.id.list);
        actionButton = findViewById(R.id.add);
        listView = new ArrayList<Notetype>();

        listView.add(new Notetype(R.drawable.facebook,"Facebook","Owner-Mark Zuckerberg","Facebook is a website which allows users, who sign-up for free profiles, to connect with friends, work colleagues or people they don't know, online. It allows users to share pictures, music, videos, and articles, as well as their own thoughts and opinions with however many people they like.",R.drawable.f1,R.drawable.f2));
        listView.add(new Notetype(R.drawable.whatsapp,"Whatsapp","Owner-Brain Acton","WhatsApp is a messaging app that lets users text, chat, and share media, including voice messages and video, with individuals or groups. How does WhatsApp work? WhatsApp relies on data to send messages, like iMessage or BBM, so it doesn't cut into your monthly text allotment",R.drawable.whatsapp,R.drawable.w2));
        listView.add(new Notetype(R.drawable.twitter,"Twitter","Owner- Jack Dorsey","Twitter is a 'microblogging' system that allows you to send and receive short posts called tweets. Tweets can be up to 140 characters long and can include links to relevant websites and resources. Twitter users follow other users. If you follow someone you can see their tweets in your twitter 'timeline'",R.drawable.t1,R.drawable.t2));
        listView.add(new Notetype(R.drawable.instagram,"Instagram","Owner- Kevin Systrom","Instagram is an online photo sharing service. It allows you to apply different types of photo filters to your pictures with a single click, then share them with others. ... The website allows you to upload images, manage your photos, apply filters, and share them with your friends.",R.drawable.i1,R.drawable.i2));
        listView.add(new Notetype(R.drawable.youtube,"Youtube","Owner- Google","YouTube is a video sharing service that allows users to watch videos posted by other users and upload videos of their own. The service was started as an independent website in 2005 and was acquired by Google in 2006.",R.drawable.y1,R.drawable.y2));
        NoteAdapter adapter = new NoteAdapter(getApplicationContext(),listView);
        notelist.setAdapter(adapter);

        notelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),DeatailsActivity.class);
                intent.putExtra("key",position);
                startActivity(intent);
            }
        });
    actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent displayScreen = new Intent(Login.this, addnote.class);
                startActivity(displayScreen);
            }
        });


    }

}