package com.uc.latihanmvvm.repositories;

import androidx.lifecycle.MutableLiveData;

import com.uc.latihanmvvm.model.Mahasiswa;

import java.util.ArrayList;

public class MainRepository {

    private static MainRepository repository;

    private MainRepository(){}

    public static MainRepository getInstance() {
        if (repository == null) {
            repository = new MainRepository();
        }
        return repository;
    }

    ArrayList<Mahasiswa> listMhs = new ArrayList<>();

    // disesuaikan dengan class MainViewModel, terutama pada nilai ArrayList-nya
    public MutableLiveData<ArrayList<Mahasiswa>> addMahasiswa(String name, String nim) {
        final MutableLiveData<ArrayList<Mahasiswa>> result = new MutableLiveData<>();
        Mahasiswa mhs = new Mahasiswa(name, nim);
        listMhs.add(mhs);
        result.setValue(listMhs);
        return result;
    }

    public MutableLiveData<ArrayList<Mahasiswa>> getMahasiswa() {
        final MutableLiveData<ArrayList<Mahasiswa>> result = new MutableLiveData<>();
        result.setValue(listMhs);
        return result;
    }
}
