package com.uc.projectmansun.ui.main.beranda.proker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uc.projectmansun.R;
import com.uc.projectmansun.model.local.Proker;

import java.util.List;

public class ProkerAdapter extends RecyclerView.Adapter<ProkerAdapter.CardViewViewHolder>  {
    private Context context;
    private List<Proker> prokerList;

    public ProkerAdapter(Context context) {
        this.context = context;
    }

    public void setProkerList(List<Proker> prokerList) {
        this.prokerList = prokerList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProkerAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cv_proker, parent, false);
        return new ProkerAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProkerAdapter.CardViewViewHolder holder, int position) {
        Proker proker = prokerList.get(position);
        holder.nama_proker.setText(proker.getNama_proker());
    }

    @Override
    public int getItemCount() {
        return prokerList.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        private TextView nama_proker;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_proker = itemView.findViewById(R.id.cv_judul_proker);
        }
    }
}
