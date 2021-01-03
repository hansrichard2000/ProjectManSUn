package com.uc.projectmansun.ui.main.beranda.proker.detail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.uc.projectmansun.R;
import com.uc.projectmansun.model.local.Periode;
import com.uc.projectmansun.model.local.Proker;
import com.uc.projectmansun.ui.MainActivity;
import com.uc.projectmansun.ui.main.beranda.proker.ProkerFragment;
import com.uc.projectmansun.util.SharedPreferenceHelper;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailProkerFragment extends Fragment {

    @BindView(R.id.judul_proker)
    TextView judul_proker;

    @BindView(R.id.deskripsi_proker)
    TextView deskripsi_proker;

    @BindView(R.id.tanggal_proker)
    TextView tanggal_proker;

    @BindView(R.id.pemasukan_proker)
    TextView pemasukan_proker;

    @BindView(R.id.pengeluaran_proker)
    TextView pengeluaran_proker;

    @BindView(R.id.rekapitulasi_proker)
    TextView rekapitulasi_proker;

    @BindView(R.id.button_list_divisi)
    Button button_list_divisi;

    private Periode periode;
    private Proker proker;
    private DetailProkerViewModel detailProkerViewModel;
    private SharedPreferenceHelper helper;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailProkerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProkerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailProkerFragment newInstance(String param1, String param2) {
        DetailProkerFragment fragment = new DetailProkerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_proker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        detailProkerViewModel = ViewModelProviders.of(requireActivity()).get(DetailProkerViewModel.class);
        detailProkerViewModel.init(helper.getAccessToken());

        if (getArguments() != null){
            proker = DetailProkerFragmentArgs.fromBundle(getArguments()).getDetailProker();
            initDetailProker(proker);
        }
    }

    @SuppressLint("SetTextI18n")
    private void initDetailProker(Proker proker) {
        Objects.requireNonNull((MainActivity) requireActivity()).getSupportActionBar().setTitle("Detail Proker");
        judul_proker.setText(proker.getNama_proker());
        deskripsi_proker.setText(proker.getDeskripsi_proker());
        tanggal_proker.setText(proker.getTanggal_mulai()+" - "+proker.getTanggal_akhir());
        pemasukan_proker.setText(String.valueOf(proker.getPemasukan()));
        pengeluaran_proker.setText(String.valueOf(proker.getPengeluaran()));
        rekapitulasi_proker.setText(String.valueOf(proker.getPemasukan() - proker.getPengeluaran()));
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        ((MainActivity)getActivity()).getSupportActionBar().show();
//    }
//
    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().getViewModelStore().clear();
    }
}
