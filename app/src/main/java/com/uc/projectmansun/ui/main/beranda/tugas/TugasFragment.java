package com.uc.projectmansun.ui.main.beranda.tugas;

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
import android.widget.Button;
import android.widget.ProgressBar;

import com.uc.projectmansun.R;
import com.uc.projectmansun.model.local.Task;
import com.uc.projectmansun.ui.MainActivity;
import com.uc.projectmansun.util.SharedPreferenceHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TugasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TugasFragment extends Fragment {

    @BindView(R.id.rv_tugas)
    RecyclerView rv_tugas;

    @BindView(R.id.loading_task)
    ProgressBar loading_task;

    @BindView(R.id.button_all)
    Button button_all;

    @BindView(R.id.button_approved)
    Button button_approved;

    @BindView(R.id.button_rejected)
    Button button_rejected;

    @BindView(R.id.button_submitted)
    Button button_submitted;

    @BindView(R.id.button_not_submitted)
    Button button_not_submitted;

    private ArrayList<Task> tugasList = new ArrayList<>();
    private int currentFilter = 0;

    private TugasViewModel tugasViewModel;
    private TugasAdapter tugasAdapter;
    private SharedPreferenceHelper helper;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TugasFragment() {
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
    public static TugasFragment newInstance(String param1, String param2) {
        TugasFragment fragment = new TugasFragment();
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
        return inflater.inflate(R.layout.fragment_tugas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        showLoading(true);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        tugasViewModel = ViewModelProviders.of(requireActivity()).get(TugasViewModel.class);
        tugasViewModel.init(helper.getAccessToken());
        tugasViewModel.getTask(getArguments().getInt("divisiId")).observe(requireActivity(), observer);

        rv_tugas.setLayoutManager(new LinearLayoutManager(getActivity()));
        tugasAdapter = new TugasAdapter(getActivity());

        button_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentFilter = 0;
                tugasViewModel.getTask(getArguments().getInt("divisiId")).observe(requireActivity(), observer);
                //tugasList.clear();
            }
        });

        button_not_submitted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentFilter = 1;
                tugasViewModel.getTask(getArguments().getInt("divisiId")).observe(requireActivity(), observer);
                //tugasList.clear();
            }
        });

        button_submitted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentFilter = 2;
                tugasViewModel.getTask(getArguments().getInt("divisiId")).observe(requireActivity(), observer);
                //tugasList.clear();
            }
        });

        button_approved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentFilter = 3;
                tugasViewModel.getTask(getArguments().getInt("divisiId")).observe(requireActivity(), observer);
                //tugasList.clear();
            }
        });

        button_rejected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentFilter = 4;
                tugasViewModel.getTask(getArguments().getInt("divisiId")).observe(requireActivity(), observer);
                //tugasList.clear();
            }
        });

    }

    private Observer<List<Task>> observer = new Observer<List<Task>>() {
        @Override
        public void onChanged(List<Task> tasks) {
            tugasList.clear();
            for (int i = 0; i < tasks.size(); i++) {

                if (currentFilter == 0) {
                    tugasList.add(tasks.get(i));
                } else if (Integer.parseInt(tasks.get(i).getStatus_task_id()) == currentFilter) {
                    tugasList.add(tasks.get(i));
                }
            }

            if (tasks != null) {
                try {
                    Task task = tugasList.get(0);
                    Objects.requireNonNull((MainActivity) requireActivity()).getSupportActionBar().setTitle("List Tugas " + task.getNama_divisi());
                } catch (Exception e) {
                    Objects.requireNonNull((MainActivity) requireActivity()).getSupportActionBar().setTitle("Tidak ada Tugas");
                }

                tugasAdapter.setProkerList(tugasList);
                tugasAdapter.notifyDataSetChanged();
                rv_tugas.setAdapter(tugasAdapter);
                showLoading(false);
            }

        }
    };

    private void showLoading(boolean state) {
        if (state) {
            rv_tugas.setVisibility(View.GONE);
            loading_task.setVisibility(View.VISIBLE);
        } else {
            rv_tugas.setVisibility(View.VISIBLE);
            loading_task.setVisibility(View.GONE);
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