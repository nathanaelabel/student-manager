package com.uc.latihanmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uc.latihanmvvm.R;
import com.uc.latihanmvvm.adapter.MahasiswaAdapter;
import com.uc.latihanmvvm.model.Mahasiswa;
import com.uc.latihanmvvm.viewmodel.MainViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_main;
    private FloatingActionButton fab_main;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }

    private void setListener() {
        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddDataActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        rv_main = findViewById(R.id.rv_main);
        fab_main = findViewById(R.id.fab_main);
        viewModel = new ViewModelProvider(MainActivity.this).get(MainViewModel.class);
        viewModel.getMahasiswa();
        viewModel.getResultGetMahasiswa().observe(MainActivity.this, showResult);
    }

    private Observer<ArrayList<Mahasiswa>> showResult = new Observer<ArrayList<Mahasiswa>>() {
        @Override
        public void onChanged(ArrayList<Mahasiswa> result) {
            rv_main.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            MahasiswaAdapter adapter = new MahasiswaAdapter(MainActivity.this);
            adapter.setListMahasiswa(result);
            rv_main.setAdapter(adapter);
        }
    };
}