package com.example.myapplication.data;

import android.content.res.Resources;

import com.example.myapplication.R;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

// Read country.json, convert JSON to Object Java:
public class LocalDataSource {
    private final Resources mResources;

    public LocalDataSource(Resources resources){
        mResources = resources;
    }

    public List<Country> loadCountries(){
        String jsonData = readJsonFile();
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonData, new TypeReference<List<Country>>() {});
        } catch (Exception exception) {
            return new ArrayList<>();
        }
    }
    private String readJsonFile(){
        StringWriter writer = new StringWriter();
        char[] buffer = new char[1024];
        try (InputStream inputStream = mResources.openRawResource(R.raw.country)) {
            Reader reader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8)
            );
            int size;
            while ((size = reader.read(buffer)) != -1){
                writer.write(buffer, 0, size);
            }
        } catch (Exception ex) {

        }
        return writer.toString();
    }
}
