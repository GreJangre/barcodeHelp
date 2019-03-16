package com.example.jangre.barcodehelp.Activity;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.jangre.barcodehelp.Datas;
import com.example.jangre.barcodehelp.DeserializeModel;
import com.example.jangre.barcodehelp.R;
import com.example.jangre.barcodehelp.RecyclerAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  RecyclerView mRecyclerView;
  Toolbar mToolbar;
  RecyclerView.LayoutManager layoutManager;
  List<DeserializeModel> mDatas;
  String strings = "[ { \"position\":\"냉동\", \"foodName\":[ { \"food\":\"소고기 뒷다리살\", \"date\":\"2019.05.03\" }, { \"food\":\"바나나\", \"date\":\"2018.12.31\" }, { \"food\":\"양고기\", \"date\":\"2020.11.24\" } ] }, { \"position\":\"냉장\", \"foodName\":[ { \"food\":\"새우튀김\", \"date\":\"2021.01.33\" }, { \"food\":\"비타플러스\", \"date\":\"2019.04.30\" }, { \"food\":\"머스타드\", \"date\":\"2020.04.11\" }, { \"food\":\"양배추\", \"date\":\"2018.11.29\" }, { \"food\":\"얼린 청포도\", \"date\":\"2040.11.24\" } ] } ]";

  @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      deserialize();

      mRecyclerView = findViewById(R.id.recyclerView);
      mToolbar = findViewById(R.id.toolbar);

      setSupportActionBar(mToolbar);
      getSupportActionBar().setTitle(R.string.app_name);

      RecyclerAdapter adapter = new RecyclerAdapter(Datas.getData(mDatas));
      layoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);

      mRecyclerView.setLayoutManager(layoutManager);
      mRecyclerView.setItemAnimator(new DefaultItemAnimator());
      mRecyclerView.setAdapter(adapter);

      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
      fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
          startActivityForResult(intent,10);
        }
      });
    }
    private void deserialize() {
    Type mTypeList = new TypeToken<ArrayList<DeserializeModel>>() {}.getType();
    mDatas = new Gson().fromJson(strings, mTypeList);
    }
}
