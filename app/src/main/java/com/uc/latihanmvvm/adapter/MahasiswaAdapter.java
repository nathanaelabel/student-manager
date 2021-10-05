package com.uc.latihanmvvm.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uc.latihanmvvm.R;
import com.uc.latihanmvvm.model.Mahasiswa;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.CardViewViewHolder> {

    private Context context;
    private ArrayList<Mahasiswa> listMahasiswa;
    private ArrayList<Mahasiswa> getListMahasiswa(){ return listMahasiswa; }
    public void setListMahasiswa(ArrayList<Mahasiswa> listMahasiswa) {
        this.listMahasiswa = listMahasiswa;
    }

    public MahasiswaAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_mahasiswa, parent, false);
        return new MahasiswaAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder holder, int position) {
        final Mahasiswa m = getListMahasiswa().get(position);
        holder.textView_name_adapterMahasiswa.setText(m.getName());
        holder.textView_nim_adapterMahasiswa.setText(m.getNim());
    }

    @Override
    public int getItemCount() {
        return getListMahasiswa().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        TextView textView_name_adapterMahasiswa, textView_nim_adapterMahasiswa;

        CardViewViewHolder(View item) {
            super(item);
            textView_name_adapterMahasiswa = item.findViewById(R.id.textView_name_adapterMahasiswa);
            textView_nim_adapterMahasiswa = item.findViewById(R.id.textView_nim_adapterMahasiswa);
        }
    }
}