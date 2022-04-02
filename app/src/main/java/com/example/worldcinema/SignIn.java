package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;


public class SignIn extends AppCompatActivity {

    ArrayList<String> passwords;
    ArrayList<String> emails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Button reg = findViewById(R.id.reg_btn);
        Button enter = findViewById(R.id.enter_btn);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);

        String strPassword = "", strEmail = "";


        email.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    String strName = email.getText().toString();
                    return true;
                }
                Toast.makeText(SignIn.this, "Поле имени должно быть заполнено!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    String strPassword = password.getText().toString();
                    return true;
                }
                Toast.makeText(SignIn.this, "Поле пароля должно быть заполнено!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (strPassword.length() == 0 || strEmail.length() == 0)
                {
                    Toast.makeText(SignIn.this, "Пожалуйста, заполните все поля!", Toast.LENGTH_SHORT).show();
                    enter.setOnClickListener(null);
                }
                if ((passwords.contains(strPassword) || emails.contains(strEmail)) == false)
                {
                    Toast.makeText(SignIn.this, "Данной учётной записи не существует!", Toast.LENGTH_SHORT).show();
                    enter.setOnClickListener(null);
                }
                if (passwords.indexOf(strPassword) != emails.indexOf(strEmail))
                {
                    Toast.makeText(SignIn.this, "Ошибка ввода почтового адреса или пароля!", Toast.LENGTH_SHORT).show();
                    enter.setOnClickListener(null);
                }
                Intent v = new Intent (SignIn.this, MainScreen.class);
                SignIn.this.startActivity(v);
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(SignIn.this, SignUp.class);
                SignIn.this.startActivity(a);
            }
        });

        ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cm.getActiveNetworkInfo();
        boolean connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
        if(connected == false){
            Toast.makeText(SignIn.this, "Отсутствует подключение к сети!", Toast.LENGTH_SHORT).show();
        }
    }
}