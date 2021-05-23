package com.example.madt1116;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> currList;
    private ArrayAdapter Adapter;
    private ListView lvCurr;


    TextView tvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvContent = findViewById(R.id.tvContent);
    }

    public void onBtnDownloadClick(View view) {
        this.tvContent.setText("Loading...");
        new DataLoader(){
            @Override
            public void onPostExecute(List<String> result)
            {
                //tvContent.setText(result);
                //lvCurrencies = findViewById(R.id.lvCurrencies);
                currList = new ArrayList<String>(result);
                Adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, currList);
                lvCurr.setAdapter(Adapter);
            }
        }.execute();
    }
}