package com.example.foodapponline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonLogIn=findViewById(R.id.buttonLogIn);
        buttonLogIn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,LogIn.class);
            startActivity(intent);
        });
        Button button3SignUp=findViewById(R.id.button3SignUp);
        button3SignUp.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,Register.class);
            startActivity(intent);
        });

    }
}