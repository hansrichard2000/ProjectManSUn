package com.uc.projectmansun.ui.main.profil.role;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.uc.projectmansun.R;
import com.uc.projectmansun.model.local.DivisiRoleUser;
import com.uc.projectmansun.model.local.Periode;
import com.uc.projectmansun.model.local.Proker;
import com.uc.projectmansun.ui.main.beranda.BerandaAdapter;
import com.uc.projectmansun.ui.main.beranda.BerandaFragmentDirections;
import com.uc.projectmansun.ui.main.beranda.proker.ProkerFragmentDirections;

import java.util.List;

public class RoleAdapter extends RecyclerView.Adapter<RoleAdapter.CardViewViewHolder> {
    private Context context;
    private List<DivisiRoleUser> DRUList;

    public RoleAdapter(Context context) {
        this.context = context;
    }

    public List<DivisiRoleUser> getDRUList() {
        return DRUList;
    }

    public void setDRUList(List<DivisiRoleUser> DRUList) {
        this.DRUList = DRUList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RoleAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lv_role, parent, false);
        return new RoleAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoleAdapter.CardViewViewHolder holder, int position) {
        DivisiRoleUser DRU = DRUList.get(position);
        holder.judul.setText(DRU.getNama_proker());
        holder.nama.setText(DRU.getNama_role() + " " + DRU.getNama_divisi());
    }

    @Override
    public int getItemCount() {
        return DRUList.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {

        private TextView judul, nama;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.judul_role);
            nama = itemView.findViewById(R.id.nama_role);
        }
    }
}