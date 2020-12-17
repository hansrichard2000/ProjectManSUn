package com.uc.projectmansun.ui.main.beranda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uc.projectmansun.R;
import com.uc.projectmansun.model.local.Periode;

import java.util.List;

public class BerandaAdapter extends RecyclerView.Adapter<BerandaAdapter.CardViewViewHolder> {
    private Context context;
    private List<Periode> periodeList;

    public BerandaAdapter(Context context) {
        this.context = context;
    }

    public void setPeriodeList(List<Periode> periodeList) {
        this.periodeList = periodeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BerandaAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cv_periode, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BerandaAdapter.CardViewViewHolder holder, int position) {
        Periode periode = periodeList.get(position);
        holder.tahun_periode.setText(periode.getTahun_periode());
    }

    @Override
    public int getItemCount() {
        return periodeList.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        private TextView tahun_periode;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            tahun_periode = itemView.findViewById(R.id.cv_judul_periode);
        }
    }
}
