package com.uc.projectmansun.ui.main.beranda.proker;

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
import com.uc.projectmansun.model.local.Periode;
import com.uc.projectmansun.model.local.Proker;
import com.uc.projectmansun.ui.MainActivity;
import com.uc.projectmansun.util.SharedPreferenceHelper;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProkerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProkerFragment extends Fragment {
    @BindView(R.id.progressBarProker)
    ProgressBar loading_bar;

    @BindView(R.id.rv_proker)
    RecyclerView rv_proker;

    private ProkerViewModel prokerViewModel;
    private ProkerAdapter prokerAdapter;
    private SharedPreferenceHelper helper;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProkerFragment() {
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
    public static ProkerFragment newInstance(String param1, String param2) {
        ProkerFragment fragment = new ProkerFragment();
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
        return inflater.inflate(R.layout.fragment_proker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        showLoading(true);
        Objects.requireNonNull(((MainActivity) requireActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(false);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        prokerViewModel = ViewModelProviders.of(requireActivity()).get(ProkerViewModel.class);
        prokerViewModel.init(helper.getAccessToken());
        prokerViewModel.getProker().observe(requireActivity(), observer);

        rv_proker.setLayoutManager(new LinearLayoutManager(getActivity()));
        prokerAdapter = new ProkerAdapter(getActivity());
    }

    private Observer<List<Proker>> observer = new Observer<List<Proker>>() {
        @Override
        public void onChanged(List<Proker> prokers) {
            if (prokers != null){
                prokerAdapter.setProkerList(prokers);
                prokerAdapter.notifyDataSetChanged();
                rv_proker.setAdapter(prokerAdapter);
                showLoading(false);
            }
        }
    };

    private void showLoading(Boolean state) {
        if (state){
            rv_proker.setVisibility(View.GONE);
            loading_bar.setVisibility(View.VISIBLE);
        }
        else {
            rv_proker.setVisibility(View.VISIBLE);
            loading_bar.setVisibility(View.GONE);
        }
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