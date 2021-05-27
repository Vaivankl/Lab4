package com.example.madt1116;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public static ArrayList<String> getRateFromECB() throws IOException {
        ArrayList<String> rateslist = new ArrayList<String>();
        InputStream stream = downloadUrl(Constants.ECB_URL);
        try {
            rateslist = XmlParser.getAllRatesFromECB(stream);
        }
        finally {
            if (stream != null) {
                stream.close();
            }
        }
        return rateslist;
    }

    private static InputStream downloadUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
        return conn.getInputStream();
    }
}
