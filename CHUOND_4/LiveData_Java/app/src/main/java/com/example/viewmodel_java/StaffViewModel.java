package com.example.viewmodel_java;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class StaffViewModel extends ViewModel {
    private List<Staff> listStaff;
    private MutableLiveData<List<Staff>> staffs;
    public LiveData<List<Staff>> getStaffs(){
        if (staffs == null){
            staffs = new MutableLiveData<>();
            listStaff = new ArrayList<>();
            staffs.setValue(listStaff);
        }
        return staffs;
    }

    public void addStaff(String id, String fullName, String birthDate, Long salary){
        if (birthDate.length() == 0){
            birthDate = "01/01/2000";
        }
        Staff staff = new Staff(id, fullName, birthDate, salary);
        listStaff.add(staff);
        staffs.setValue(listStaff);
    }
}
