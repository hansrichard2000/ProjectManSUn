package com.uc.projectmansun.ui.main.beranda.divisi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uc.projectmansun.R;
import com.uc.projectmansun.model.local.Divisi;
import com.uc.projectmansun.model.local.Proker;
import com.uc.projectmansun.ui.main.beranda.proker.ProkerAdapter;

import java.util.List;

public class DivisiAdapter extends RecyclerView.Adapter<DivisiAdapter.CardViewViewHolder>  {
    private Context context;
    private List<Divisi> divisiList;

    public DivisiAdapter(Context context) {
        this.context = context;
    }

    public void setDivisiList(List<Divisi> divisiList) {
        this.divisiList = divisiList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DivisiAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cv_divisi, parent, false);
        return new DivisiAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DivisiAdapter.CardViewViewHolder holder, int position) {
        Divisi divisi = divisiList.get(position);
        holder.nama_divisi.setText(divisi.getNama_divisi());
        holder.itemView.setOnClickListener(view -> {

        });
    }

    @Override
    public int getItemCount() {
        return divisiList.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        private TextView nama_divisi;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_divisi = itemView.findViewById(R.id.cv_judul_divisi);
        }
    }
}
