package com.example.touristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userName, pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.etUserName);
        pass = findViewById(R.id.etPass);
        login = findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentName = userName.getText().toString();
                String currentPass = pass.getText().toString();

                if (currentName.equals("user1") && currentPass.equals("password1"))
                {
                    Intent intent=new Intent(MainActivity.this,TourActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getBaseContext(),"Username or Password wrong!",Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}