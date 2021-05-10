package com.example.quixoteinternshiptask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.quixoteinternshiptask.Login.listView;

public class DeatailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatails);
        int position = getIntent().getExtras().getInt("key");
        TextView title = (TextView) findViewById(R.id.title1);
        TextView description = (TextView) findViewById(R.id.description1);
        ImageView imageView1 = (ImageView) findViewById(R.id.imageView);
        ImageView imageView2 = (ImageView)findViewById(R.id.imageView2);
        imageView1.setImageResource(listView.get(position).getmImg1());
        imageView2.setImageResource(listView.get(position).getmImg2());
        title.setText(listView.get(position).getNtitle());
        description.setText(listView.get(position).getNinfo());
    }
}