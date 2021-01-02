package com.uc.projectmansun.ui.main.beranda.tugas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uc.projectmansun.R;
import com.uc.projectmansun.model.local.Proker;
import com.uc.projectmansun.model.local.Task;
import com.uc.projectmansun.ui.main.beranda.proker.ProkerAdapter;

import java.util.List;

public class TugasAdapter extends RecyclerView.Adapter<TugasAdapter.CardViewViewHolder>  {
    private Context context;
    private List<Task> tugasList;

    public TugasAdapter(Context context) {
        this.context = context;
    }

    public void setProkerList(List<Task> tugasList) {
        this.tugasList = tugasList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TugasAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LAYOUT NYA MASIH KE CV DIVISI
        View view = LayoutInflater.from(context).inflate(R.layout.cv_divisi, parent, false);
        return new TugasAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TugasAdapter.CardViewViewHolder holder, int position) {
        Task tugas = tugasList.get(position);
        holder.nama_proker.setText(tugas.getJudul());
    }

    @Override
    public int getItemCount() {
        return tugasList.size();
    }

    //BELUM DIPUPDATE
    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        private TextView nama_proker;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_proker = itemView.findViewById(R.id.cv_judul_proker);
        }
    }
}
