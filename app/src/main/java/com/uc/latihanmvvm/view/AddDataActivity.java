package com.uc.latihanmvvm.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.uc.latihanmvvm.R;
import com.uc.latihanmvvm.model.Mahasiswa;
import com.uc.latihanmvvm.viewmodel.MainViewModel;

import java.util.ArrayList;

public class AddDataActivity extends AppCompatActivity {

    private Toolbar toolbar_addData;
    private TextInputLayout til_name_addData, til_nim_addData;
    private Button btn_submit_addData;
    private String name = "", nim = "";
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        initView();
        setListener();
    }

    private void setListener() {
        btn_submit_addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = til_name_addData.getEditText().getText().toString().trim();
                nim = til_nim_addData.getEditText().getText().toString().trim();

                if (name.isEmpty()) {
                    til_name_addData.setError(getString(R.string.cannot_null));
                } else {
                    if (nim.isEmpty()) {
                        til_nim_addData.setError(getString(R.string.cannot_null));
                    } else {
                        // request
                        viewModel.addMahasiswa(name, nim);
                        // response
                        viewModel.getResultAddMahasiswa().observe(AddDataActivity.this, showResult);
                    }
                }
            }
        });
    }

    private Observer<ArrayList<Mahasiswa>> showResult = new Observer<ArrayList<Mahasiswa>>() {
        @Override
        public void onChanged(ArrayList<Mahasiswa> result) {
//            for (int i = 0; i < result.size(); i++) {
//                Log.e("Mhs ke-" + (i + 1), result.get(i).getName());
//            }
            finish();
        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void initView() {
        toolbar_addData = findViewById(R.id.toolbar_addData);
        setSupportActionBar(toolbar_addData);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        til_name_addData = findViewById(R.id.til_name_addData);
        til_nim_addData = findViewById(R.id.til_nim_addData);
        btn_submit_addData = findViewById(R.id.btn_submit_addData);
    }

}