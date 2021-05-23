package com.example.madt1116;

import android.os.AsyncTask;

import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class DataLoader extends AsyncTask<String, Void, List<String>> {

    protected List<String> doInBackground(String... params) {
        //InputStream stream = downloadUrl(Constants.ECB_URL);
        try {
            return DataManager.getRateFromECB();
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));


            List<String> datalist = new ArrayList<>(List.of(sw.toString() ));


            return datalist;
        }
    }
}