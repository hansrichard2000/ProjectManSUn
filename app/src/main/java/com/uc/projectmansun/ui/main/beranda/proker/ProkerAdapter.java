package com.uc.projectmansun.ui.main.beranda.proker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.uc.projectmansun.R;
import com.uc.projectmansun.model.local.Proker;

import java.util.List;

public class ProkerAdapter extends RecyclerView.Adapter<ProkerAdapter.CardViewViewHolder> {
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
        Glide.with(context).load(proker.getGambar_proker()).centerCrop().into(holder.foto_proker);
        holder.nama_proker.setText(proker.getNama_proker());
        if (proker.getStatus_proker_id() == 1) {
            holder.label.setImageResource(R.drawable.proker_label_blue);
            //kalau gak berhasil, artinya pake setBackgroundResource()
        } else if (proker.getStatus_proker_id() == 2) {
            holder.label.setImageResource(R.drawable.proker_label_green);
        } else if (proker.getStatus_proker_id() == 3) {
            holder.label.setImageResource(R.drawable.proker_label_red);
        }



        holder.itemView.setOnClickListener(view -> {
            ProkerFragmentDirections.ActionProkerFragmentToDetailProkerFragment action = ProkerFragmentDirections.actionProkerFragmentToDetailProkerFragment(proker);
            Navigation.findNavController(view).navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return prokerList.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        private TextView nama_proker;
        private ImageView label, foto_proker;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_proker = itemView.findViewById(R.id.cv_judul_proker);
            label = itemView.findViewById(R.id.cv_label_proker);
            foto_proker = itemView.findViewById(R.id.cv_foto_proker);
        }
    }
}
