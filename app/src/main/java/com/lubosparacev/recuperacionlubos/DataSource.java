package com.lubosparacev.recuperacionlubos;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class DataSource {
    private Context mContext;

    public DataSource(Context context) {
        mContext = context;
    }

    public List<Item> getItems() {
        String json = loadJSONFromAsset();
        Type type = new TypeToken<List<Item>>() {}.getType();
        return new Gson().fromJson(json, type);
    }

    private String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = mContext.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
