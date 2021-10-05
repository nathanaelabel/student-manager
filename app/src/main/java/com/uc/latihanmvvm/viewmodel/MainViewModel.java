package com.uc.latihanmvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.uc.latihanmvvm.model.Mahasiswa;
import com.uc.latihanmvvm.repositories.MainRepository;

import java.util.ArrayList;

public class MainViewModel extends AndroidViewModel {

    private MainRepository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = MainRepository.getInstance();
    }

    // Begin of MVVM addMahasiswa
    private MutableLiveData<ArrayList<Mahasiswa>> resultAddMahasiswa = new MutableLiveData<>();
    // request
    public void addMahasiswa(String name, String nim) {
        resultAddMahasiswa = repository.addMahasiswa(name, nim);
    }
    // response
    public LiveData<ArrayList<Mahasiswa>> getResultAddMahasiswa() {
        return resultAddMahasiswa;
    }
    // End of MVVM addMahasiswa

    // Begin of MVVM getMahasiswa
    private MutableLiveData<ArrayList<Mahasiswa>> resultGetMahasiswa = new MutableLiveData<>();
    // request
    public void getMahasiswa() {
        resultGetMahasiswa = repository.getMahasiswa();
    }
    // response
    public LiveData<ArrayList<Mahasiswa>> getResultGetMahasiswa() {
        return resultGetMahasiswa;
    }
    // End of MVVM getMahasiswa
}
