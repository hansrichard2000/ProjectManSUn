package com.uc.projectmansun.ui.main.beranda.tugas.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.uc.projectmansun.R;
import com.uc.projectmansun.model.local.Divisi;
import com.uc.projectmansun.model.local.Task;
import com.uc.projectmansun.ui.MainActivity;
import com.uc.projectmansun.ui.main.beranda.proker.detail.DetailProkerFragment;
import com.uc.projectmansun.util.SharedPreferenceHelper;

import org.w3c.dom.Text;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailTugasFragment extends Fragment {

    @BindView(R.id.judul_tugas)
    TextView judul_tugas;

    @BindView(R.id.isi_tugas)
    TextView deskripsi_tugas;

    @BindView(R.id.tanggal_akhir)
    TextView tanggal_akhir;

    @BindView(R.id.link)
    TextView link_hasil_kerja;

    @BindView(R.id.status_task)
    TextView status_task;

    private Task task;
    private DetailTugasViewModel detailTugasViewModel;
    private SharedPreferenceHelper helper;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailTugasFragment() {
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
    public static DetailTugasFragment newInstance(String param1, String param2) {
        DetailTugasFragment fragment = new DetailTugasFragment();
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
        return inflater.inflate(R.layout.fragment_detail_tugas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        detailTugasViewModel = ViewModelProviders.of(requireActivity()).get(DetailTugasViewModel.class);
        detailTugasViewModel.init(helper.getAccessToken());

        if (getArguments() != null){
            task = DetailTugasFragmentArgs.fromBundle(getArguments()).getDetailTask();
            initDetailTugas(task);
        }
    }

    private void initDetailTugas(Task task) {
        Objects.requireNonNull((MainActivity) requireActivity()).getSupportActionBar().setTitle("Detail Tugas");
        judul_tugas.setText(task.getJudul());
        deskripsi_tugas.setText(task.getDeskripsi());
        tanggal_akhir.setText(task.getDeadline());
        link_hasil_kerja.setText(task.getLink_hasil_kerja());
        status_task.setText(task.getStatus_task_id());
    }

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
