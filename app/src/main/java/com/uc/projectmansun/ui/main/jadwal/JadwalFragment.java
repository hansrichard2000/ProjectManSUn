package com.uc.projectmansun.ui.main.jadwal;

import android.annotation.SuppressLint;
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
import android.widget.ImageButton;
import android.widget.TextView;

import com.uc.projectmansun.R;
import com.uc.projectmansun.model.local.Task;
import com.uc.projectmansun.ui.MainActivity;
import com.uc.projectmansun.ui.main.beranda.BerandaViewModel;
import com.uc.projectmansun.ui.main.beranda.tugas.TugasAdapter;
import com.uc.projectmansun.util.SharedPreferenceHelper;

import java.util.ArrayList;
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

    @BindView(R.id.tombolKiri)
    ImageButton tombol_kiri;

    @BindView(R.id.tombolKanan)
    ImageButton tombol_kanan;

    private Task task;
    private JadwalViewModel jadwalViewModel;
    private SharedPreferenceHelper helper;
    private List<Task> jadwalList;
    ArrayList<String> judul, deskripsi;
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

    @SuppressLint("ResourceAsColor")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        judul = new ArrayList<String>();
        deskripsi = new ArrayList<String>();

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        jadwalViewModel = ViewModelProviders.of(requireActivity()).get(JadwalViewModel.class);
        jadwalViewModel.init(helper.getAccessToken());
        jadwalViewModel.getJadwalTask().observe(requireActivity(), observer);
        calendarView.setUnfocusedMonthDateColor(R.color.button_red);
        calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {

            String ye, mo, da; //year month date maksudnya
            judul.clear();
            deskripsi.clear();
            //ngeset year
            ye = year + "";

            //ngeset month
            if(month < 10){
                mo = "0" + (month+ 1);
            }else{
                mo = (month+1) + "";
            }

            //ngeset date
            if (dayOfMonth<10){
                da = "0" + dayOfMonth;
            }else{
                da = dayOfMonth + "";
            }

            for (int tes = 0; tes < jadwalList.size(); tes++){
//                    Log.d("Jadwal Fragment: ", "jadwalLists: " +jadwalList.get(tes).getDeadline());
//                    Log.d("Jadwal Fragment: ", "jadwalLists: " + ye + "-" + mo + "-" + da);
                if (jadwalList.get(tes).getDeadline().equals(ye + "-" + mo + "-" + da)){
//                        todayJadwal.add(jadwalList.get(tes));
                    judul.add(jadwalList.get(tes).getJudul());
                    deskripsi.add(jadwalList.get(tes).getDeskripsi());
                }
            }
//                Log.d("Jadwal Fragment: ", "tasks : "+todayJadwal);
            currentIndex = 0;

            if (judul.size() == 0 || deskripsi.size() == 0){
                jumlah_tugas.setText("Tugas 0/0");
                nama_jadwal.setText("Tidak ada tugas");
                deskripsi_jadwal.setText("Tidak ada deskripsi");
            }else{
                jumlah_tugas.setText("Tugas "+(currentIndex+1)+"/"+judul.size());
                nama_jadwal.setText(judul.get(currentIndex));
                deskripsi_jadwal.setText(deskripsi.get(currentIndex));
            }

        });

        tombol_kiri.setOnClickListener(v -> {
            if (currentIndex > 0){
                currentIndex--;

                try{
                    jumlah_tugas.setText("Tugas "+(currentIndex+1)+"/"+judul.size());
                    nama_jadwal.setText(judul.get(currentIndex));
                    deskripsi_jadwal.setText(deskripsi.get(currentIndex));

                }catch (Exception e){
                    currentIndex++;
                    jumlah_tugas.setText("Tugas "+(currentIndex+1)+"/"+judul.size());
                    nama_jadwal.setText(judul.get(currentIndex));
                    deskripsi_jadwal.setText(deskripsi.get(currentIndex));
                }
            }
        });

        tombol_kanan.setOnClickListener(v -> {
            if (currentIndex < judul.size() && currentIndex < deskripsi.size()){
                currentIndex++;

                try{
                    jumlah_tugas.setText("Tugas "+(currentIndex+1)+"/"+judul.size());
                    nama_jadwal.setText(judul.get(currentIndex));
                    deskripsi_jadwal.setText(deskripsi.get(currentIndex));

                }catch (Exception e){
                    currentIndex--;
                    jumlah_tugas.setText("Tugas "+(currentIndex+1)+"/"+judul.size());
                    nama_jadwal.setText(judul.get(currentIndex));
                    deskripsi_jadwal.setText(deskripsi.get(currentIndex));
                }
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
