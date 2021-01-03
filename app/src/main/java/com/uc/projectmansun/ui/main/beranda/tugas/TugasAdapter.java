package com.uc.projectmansun.ui.main.beranda.tugas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
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
        View view = LayoutInflater.from(context).inflate(R.layout.cv_task, parent, false);
        return new TugasAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TugasAdapter.CardViewViewHolder holder, int position) {
        Task tugas = tugasList.get(position);
        holder.judul_task.setText(tugas.getJudul());
        holder.penanggung_jawab.setText(tugas.getPenanggung_jawab());
        holder.itemView.setOnClickListener(view -> {
            TugasFragmentDirections.ActionTugasFragmentToDetailTugasFragment actions = TugasFragmentDirections.actionTugasFragmentToDetailTugasFragment(tugas);
            Navigation.findNavController(view).navigate(actions);
        });
    }

    @Override
    public int getItemCount() {
        return tugasList.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        private TextView judul_task, penanggung_jawab;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            judul_task = itemView.findViewById(R.id.judul_task);
            penanggung_jawab = itemView.findViewById(R.id.penanggung_jawab);
        }
    }
}
