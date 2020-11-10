package com.simon.myversetoday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> arrayAdapter;
    SwipeFlingAdapterView flingAdapterView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flingAdapterView = (SwipeFlingAdapterView) findViewById(R.id.frame);
        String []  verses  = getResources().getStringArray(R.array.All_Verses);
        arrayList = new ArrayList<>(Arrays.asList(verses));
        arrayAdapter = new ArrayAdapter<>(this,R.layout.item, R.id.frameTxt,arrayList);
        flingAdapterView.setAdapter(arrayAdapter);
        flingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                arrayList.remove(0);


                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {

            }

            @Override
            public void onRightCardExit(Object o) {

            }

            @Override
            public void onAdapterAboutToEmpty(int i) {
          // arrayList = new ArrayList<String>(Arrays.<String>asList(String.valueOf(R.array.All_Verses)));
            }

            @Override
            public void onScroll(float v) {

            }
        });
        flingAdapterView.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int i, Object o) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                String item = arrayList.get(i);
                intent.putExtra("verse", item);
                startActivity(intent);
            }
        });

    }
}