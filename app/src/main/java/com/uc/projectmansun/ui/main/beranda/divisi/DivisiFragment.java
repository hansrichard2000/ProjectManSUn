package com.uc.projectmansun.ui.main.beranda.divisi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.uc.projectmansun.R;
import com.uc.projectmansun.model.local.Divisi;
import com.uc.projectmansun.model.local.Proker;
import com.uc.projectmansun.ui.MainActivity;
import com.uc.projectmansun.util.SharedPreferenceHelper;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DivisiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DivisiFragment extends Fragment {

    @BindView(R.id.rv_divisi)
    RecyclerView rv_divisi;

    @BindView(R.id.progressBarDivisi)
    ProgressBar loading;

    private Proker proker;
    private DivisiViewModel divisiViewModel;
    private DivisiAdapter divisiAdapter;
    private SharedPreferenceHelper helper;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DivisiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DivisiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DivisiFragment newInstance(String param1, String param2) {
        DivisiFragment fragment = new DivisiFragment();
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
        return inflater.inflate(R.layout.fragment_divisi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        showLoading(true);
        Objects.requireNonNull(((MainActivity) requireActivity()).getSupportActionBar()).setTitle("List Divisi");

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        divisiViewModel = ViewModelProviders.of(requireActivity()).get(DivisiViewModel.class);
        divisiViewModel.init(helper.getAccessToken());
//        divisiViewModel.getDivisi().observe(requireActivity());

        rv_divisi.setLayoutManager(new LinearLayoutManager(getActivity()));
        divisiAdapter = new DivisiAdapter(getActivity());
    }

    private Observer<List<Divisi>> observer = new Observer<List<Divisi>>() {
        @Override
        public void onChanged(List<Divisi> divisis) {
            if (divisis != null){
                divisiAdapter.setDivisiList(divisis);
                divisiAdapter.notifyDataSetChanged();
                rv_divisi.setAdapter(divisiAdapter);
                showLoading(false);
            }
        }
    };

    private void showLoading(Boolean state) {
        if (state){
            rv_divisi.setVisibility(View.GONE);
            loading.setVisibility(View.VISIBLE);
        }
        else {
            rv_divisi.setVisibility(View.VISIBLE);
            loading.setVisibility(View.GONE);
        }
    }
}