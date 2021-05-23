package com.example.madt1116;

import android.os.AsyncTask;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class DataLoader extends AsyncTask<String, Void, String> {

    protected String doInBackground(String... params) {
        try {
            return DataManager.getRateFromECB()
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));


            List<String> datalist = new ArrayList<>(List.of(sw.toString() ));


            return datalist;
        }
    }
}