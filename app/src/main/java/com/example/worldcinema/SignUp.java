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
import java.security.Key;
import java.util.ArrayList;
import java.util.List;



public class SignUp extends AppCompatActivity {

    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> lastNames = new ArrayList<String>();
    ArrayList<String> emails = new ArrayList<String>();
    ArrayList<String> passwords = new ArrayList<String>();
    ArrayList<String> repeatedPasswords = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button createAccount = findViewById(R.id.si);
        Button onEnter = findViewById(R.id.sii);
        EditText name = findViewById(R.id.name);
        EditText lastName = findViewById(R.id.last_name);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        EditText repeatPassword = findViewById(R.id.repeat_password);

        String strName = "", strLastName = "", strEmail = "", strPassword = "", strRepeatPassword = "";

        name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    String strName = name.getText().toString();
                    return true;
                }
                Toast.makeText(SignUp.this, "Поле имени должно быть заполнено!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        lastName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    String strLastName = lastName.getText().toString();
                    return true;
                }
                Toast.makeText(SignUp.this, "Поле фамилии должно быть заполнено!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        email.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    String strEmail = email.getText().toString();
                    return true;
                }
                Toast.makeText(SignUp.this, "Поле почтового адреса должно быть заполнено!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(SignUp.this, "Поле пароля должно быть заполнено!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        repeatPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    String strRepeatPassword = repeatPassword.getText().toString();
                    return true;
                }
                Toast.makeText(SignUp.this, "Поле повторения пароля должно быть заполнено!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (strName.length() == 0 || strLastName.length() == 0 || strEmail.length() == 0 || strPassword.length() == 0 || strRepeatPassword.length() == 0)
                {
                    Toast.makeText(SignUp.this, "Пожалуйста, заполните все поля!", Toast.LENGTH_SHORT).show();
                    createAccount.setOnClickListener(null);
                }
                if (strPassword != strRepeatPassword)
                {
                    Toast.makeText(SignUp.this, "Введённые пароли не совпадают!", Toast.LENGTH_SHORT).show();
                }

                names.add(strName);
                lastNames.add(strLastName);
                emails.add(strEmail);
                passwords.add(strPassword);
                repeatedPasswords.add(strRepeatPassword);

                Toast.makeText(SignUp.this, "Учётная запись успешно создана!", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(SignUp.this, SignIn.class);
                SignUp.this.startActivity(a);

            }
        });

        onEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent(SignUp.this, SignIn.class);
                SignUp.this.startActivity(s);
            }
        });

        ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cm.getActiveNetworkInfo();
        boolean connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
        if(connected == false){
            Toast.makeText(SignUp.this, "Отсутствует подключение к сети!", Toast.LENGTH_SHORT).show();
        }
    }
}