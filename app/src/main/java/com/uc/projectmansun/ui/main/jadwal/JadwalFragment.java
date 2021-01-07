package com.uc.projectmansun.ui.main.jadwal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import com.uc.projectmansun.R;
import com.uc.projectmansun.model.local.Task;
import com.uc.projectmansun.ui.MainActivity;
import com.uc.projectmansun.ui.main.beranda.BerandaViewModel;
import com.uc.projectmansun.ui.main.beranda.tugas.TugasAdapter;
import com.uc.projectmansun.util.SharedPreferenceHelper;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JadwalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JadwalFragment extends Fragment {

    @BindView(R.id.calendarView)
    CalendarView calendarView;

    @BindView(R.id.nama_jadwal)
    TextView nama_jadwal;

    @BindView(R.id.deskripsi_jadwal)
    TextView deskripsi_jadwal;

    @BindView(R.id.jumlah_tugas)
    TextView jumlah_tugas;

    private Task task;
    private JadwalViewModel jadwalViewModel;
    private SharedPreferenceHelper helper;
    private List<Task> jadwalList;
    private List<Task> todayJadwal;
    private int currentIndex = 0;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public JadwalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JadwalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JadwalFragment newInstance(String param1, String param2) {
        JadwalFragment fragment = new JadwalFragment();
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
        return inflater.inflate(R.layout.fragment_jadwal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        jadwalViewModel = ViewModelProviders.of(requireActivity()).get(JadwalViewModel.class);
        jadwalViewModel.init(helper.getAccessToken());
        jadwalViewModel.getJadwalTask().observe(requireActivity(), observer);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                for (int tes = 0; tes < jadwalList.size(); tes++){
                    Log.d("Jadwal Fragment: ", "jadwalLists: "+jadwalList.get(tes).getDeadline());
                    Log.d("Jadwal Fragment: ", "jadwalLists: "+year + "-" + (month+1) + "-" + dayOfMonth);
                    if (jadwalList.get(tes).getDeadline().equals(year + "-" + (month+1) + "-" + dayOfMonth)){

                        todayJadwal.add(jadwalList.get(tes));
                    }
                }
                Log.d("Jadwal Fragment: ", "tasks : "+todayJadwal);
                nama_jadwal.setText(todayJadwal.get(0).getJudul());
                deskripsi_jadwal.setText(todayJadwal.get(0).getDeskripsi());
                jumlah_tugas.setText("Jadwal " + (0+1) + "/" + todayJadwal.size());
            }
        });

    }

    private Observer<List<Task>> observer = new Observer<List<Task>>() {
        @Override
        public void onChanged(List<Task> tasks) {
            jadwalList = tasks;
            Log.d("Jadwal Fragment: ", "tasks : "+jadwalList);
        }

    };

}
