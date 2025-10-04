package com.example.gridview.data.source.local;

import android.content.Context;

import com.example.gridview.R;
import com.example.gridview.data.model.Country;
import com.example.gridview.data.source.CountryDataSource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LocalDataSource implements CountryDataSource {
    private final Context mContext;

    public LocalDataSource(Context context){
        mContext = context;
    }
    @Override
    public List<Country> loadData() {
        String jsonString = getJsonString();
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonString, new TypeReference<List<Country>>() {});
        } catch (JsonProcessingException ex){
            return new ArrayList<>();
        }
    }

    private String getJsonString(){
        StringWriter writer = new StringWriter();
        char[] buffer = new char[1024];
        try (InputStream inputStream = mContext.getResources()
                .openRawResource(R.raw.country)) {
            Reader reader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8)
            );
            int size;
            while ((size = reader.read(buffer)) != -1){
                writer.write(buffer, 0, size);
            }
        } catch (IOException ignored) {

        }
        return writer.toString();
    }
}
