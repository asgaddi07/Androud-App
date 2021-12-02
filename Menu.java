package com.example.foodapponline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void addToast(View v){
        Toast.makeText(Menu.this, "Item Ordered", Toast.LENGTH_SHORT).show();
    }
}