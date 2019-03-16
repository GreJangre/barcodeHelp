package com.example.jangre.barcodehelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jangre.barcodehelp.Activity.MainActivity;

public class Finish extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_finish);
        TextView nameText = findViewById(R.id.nameText);
        TextView foodText = findViewById(R.id.foodText);
        TextView dateText = findViewById(R.id.dateText);

        Button btnHome = findViewById(R.id.btnHome);
        ImageView food = findViewById(R.id.food);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Finish.this,MainActivity.class);
                startActivity(intent);
            }
        });

//        Intent intent = getIntent();
//        nameText.setText(intent.getStringExtra("nameText"));
//        foodText.setText(intent.getStringExtra("foodText"));
//        dateText.setText(intent.getStringExtra("dateText"));


        if (foodText.getText().equals("해산물류")){
            food.setVisibility(View.VISIBLE);
            food.setImageResource(R.drawable.fish);
        }
        else if (foodText.getText().equals("신선식품")){
            food.setVisibility(View.VISIBLE);
            food.setImageResource(R.drawable.fresh);
        }
        else if(foodText.getText().equals("냉동식품")){
            food.setVisibility(View.VISIBLE);
            food.setImageResource(R.drawable.ice);
        }
        else {
            food.setVisibility(View.VISIBLE);
        }

    }
}
