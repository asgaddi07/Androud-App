package com.example.foodapponline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button button2Home = findViewById(R.id.button2Home);
        button2Home.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this,Home.class);
            startActivity(intent);
        });

        Button buttonCart = findViewById(R.id.buttonCart);
        buttonCart.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this,Order.class);
            startActivity(intent);
        });

        Button button3Profile = findViewById(R.id.button3Profile);
        button3Profile.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this,Profile.class);
            startActivity(intent);
        });

        TextView textView3res = findViewById(R.id.textView3res);
        textView3res.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this,Menu.class);
            startActivity(intent);
        });

        TextView textView2res = findViewById(R.id.textView2res);
        textView2res.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this,Menu.class);
            startActivity(intent);
        });
        TextView textView4res = findViewById(R.id.textView4res);
        textView4res.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this,Menu.class);
            startActivity(intent);
        });
        TextView textView5res = findViewById(R.id.textView5res);
        textView5res.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this,Menu.class);
            startActivity(intent);
        });
    }

    }
