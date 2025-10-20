package com.example.fragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RandomNumberViewModel extends ViewModel {
    private long seed = new Date().getTime();
    private final List<Long> numbers = new ArrayList<>();
    private final MutableLiveData<List<Long>> randomNumbers = new MutableLiveData<>();

    public long generateRandomNumber() {
        return (long) (Math.random() * seed);
    }

    public long stringToNumber(String numberStr, long randomNumber) {
        if (numberStr.trim().length() > 0) {
            return Long.parseLong(numberStr);
        } else {
            return randomNumber;
        }
    }

    public void setSeed() {
        seed = new Date().getTime();
    }

    public void addNumberToList(long number) {
        numbers.add(number);
        randomNumbers.setValue(numbers);
    }
}
