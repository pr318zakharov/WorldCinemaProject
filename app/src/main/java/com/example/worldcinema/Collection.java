package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;


public class Collection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        LinearLayout button = findViewById(R.id.pr);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Collection.this, Profile.class);
                Collection.this.startActivity(c);
            }
        });

        LinearLayout button1 = findViewById(R.id.gl);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Collection.this, MainScreen.class);
                Collection.this.startActivity(a);
            }
        });

        LinearLayout button2 = findViewById(R.id.ac);
        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(Collection.this, CreateCollection.class);
                Collection.this.startActivity(b);
            }
        });

        ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cm.getActiveNetworkInfo();
        boolean connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
        if(connected == false){
            Toast.makeText(Collection.this, "Отсутствует подключение к сети!", Toast.LENGTH_SHORT).show();
        }
    }
}