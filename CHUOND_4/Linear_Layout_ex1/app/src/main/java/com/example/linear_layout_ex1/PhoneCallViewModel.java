package com.example.linear_layout_ex1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PhoneCallViewModel extends ViewModel {
    private MutableLiveData<String> currentNumber;
    private StringBuilder phoneNumberBuilder;
    public LiveData<String> getCurrentNumber(){
        if (currentNumber == null){
            currentNumber = new MutableLiveData<>();
            phoneNumberBuilder = new StringBuilder();
        }
        return currentNumber;
    }

    public void appendNumber(String number){
        phoneNumberBuilder.append(number);
        currentNumber.setValue(phoneNumberBuilder.toString());
    }

    public void removeANumber() {
        if (phoneNumberBuilder.length() > 0) {
            phoneNumberBuilder.delete(phoneNumberBuilder.length() - 1,
                    phoneNumberBuilder.length());
            currentNumber.setValue(phoneNumberBuilder.toString());
        }
    }
}
