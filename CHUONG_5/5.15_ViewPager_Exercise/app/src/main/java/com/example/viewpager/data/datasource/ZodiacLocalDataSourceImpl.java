package com.example.viewpager.data.datasource;

import com.example.viewpager.R;
import com.example.viewpager.data.model.Zodiac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZodiacLocalDataSourceImpl implements ZodiacLocalDataSource{
    private final List<Zodiac> mZodiacs = new ArrayList<>();

    public ZodiacLocalDataSourceImpl(){
        mZodiacs.add(new Zodiac("Tý", R.drawable.mouse));
        mZodiacs.add(new Zodiac("Sửu", R.drawable.buffalo));
        mZodiacs.add(new Zodiac("Dần", R.drawable.tiger));
        mZodiacs.add(new Zodiac("Mão", R.drawable.rabbit));
        mZodiacs.add(new Zodiac("Thìn", R.drawable.dragon));
        mZodiacs.add(new Zodiac("Tỵ", R.drawable.snake));
        mZodiacs.add(new Zodiac("Ngọ", R.drawable.horse));
        mZodiacs.add(new Zodiac("Mùi", R.drawable.sheep));
        mZodiacs.add(new Zodiac("Thân", R.drawable.monkey));
        mZodiacs.add(new Zodiac("Dậu", R.drawable.cock));
        mZodiacs.add(new Zodiac("Tuất", R.drawable.dog));
        mZodiacs.add(new Zodiac("Hợi", R.drawable.pig));
    }

    @Override
    public List<Zodiac> getZodiacs() {
        return mZodiacs;
    }
}
