package com.uc.projectmansun.ui.main.profil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.uc.projectmansun.R;
import com.uc.projectmansun.model.local.Profil;
import com.uc.projectmansun.ui.MainActivity;
import com.uc.projectmansun.util.Constants;
import com.uc.projectmansun.util.SharedPreferenceHelper;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfilFragment extends Fragment {

    @BindView(R.id.profil_name)
    TextView profil_name;

    @BindView(R.id.profil_email)
    TextView profil_email;

    @BindView(R.id.profil_nim)
    TextView profil_nim;

    @BindView(R.id.profil_jurusan)
    TextView profil_jurusan;

    @BindView(R.id.profil_img)
    ImageView profil_img;

    @BindView(R.id.role_button)
    Button role_button;

    @BindView(R.id.help_button)
    Button help_button;

    @BindView(R.id.logout_button)
    Button logout;

    private Profil profil;
    private ProfilViewModel profilViewModel;
    private SharedPreferenceHelper helper;
    private static final String TAG = "ProfilFragment";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfilFragment newInstance(String param1, String param2) {
        ProfilFragment fragment = new ProfilFragment();
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
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        Objects.requireNonNull(((MainActivity) requireActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(false);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        profilViewModel = ViewModelProviders.of(requireActivity()).get(ProfilViewModel.class);
        profilViewModel.init(helper.getAccessToken());
        profilViewModel.getProfil().observe(requireActivity(), observer);

//        if (getArguments() != null){
//            profil = ProfilFragmentArgs.fromBundle(getArguments()).getProfil();
//
//            if (profil != null){
//                initProfil(profil);
//            }
//
//        }

    }

//    private void initProfil(Profil profil) {
//        profil_name.setText(profil.getUser_name());
//        profil_email.setText(profil.getUser_email());
//        profil_nim.setText(profil.getUser_nim());
//        profil_jurusan.setText(profil.getDepartement_name());
//    }

    private Observer<List<Profil>> observer = new Observer<List<Profil>>() {
        @Override
        public void onChanged(List<Profil> profils) {
            if (profils != null){
                Profil profil = profils.get(0);
                if (!profil.getGambar_profil().equals(Constants.BASE_IMAGE_URL_PROFILE + "null")){
//                    Log.d(TAG, "onChanged: Masuk" + profil.getGambar_profil());
                    Glide.with(getView()).load(profil.getGambar_profil()).centerCrop().into(profil_img);
                }
//                else{
//                    Log.d(TAG, "onChanged: Tidak masuk");
//                    Glide.with(getView()).load(Constants.BASE_IMAGE_URL_PROFILE_DEFAULT).centerCrop().into(profil_img);
//                }
                profil_name.setText(profil.getUser_name());
                profil_email.setText(profil.getUser_email());
                profil_nim.setText(profil.getUser_nim());
                profil_jurusan.setText(profil.getDepartement_name());
            }
        }
    };

    @OnClick(R.id.role_button)
    public void role(View view){
        if (view.getId() == R.id.role_button){
            NavDirections action = ProfilFragmentDirections.actionProfilFragmentToRoleFragment2();
            Navigation.findNavController(view).navigate(action);
        }
    }

    @OnClick(R.id.logout_button)
    public void logout(View view) {
        if (view.getId() == R.id.logout_button) {
            profilViewModel.logout().observe(requireActivity(), s -> {
                if (!s.isEmpty()) {
                    helper.clearPref();
                    NavDirections action = ProfilFragmentDirections.actionProfilFragmentToLoginFragment();
                    Navigation.findNavController(view).navigate(action);
                    Toast.makeText(ProfilFragment.this.getActivity(), s, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @OnClick(R.id.help_button)
    public void help(View view) {
        if (view.getId() == R.id.help_button){
            Intent intent = new Intent(String.valueOf(view.getContext()), Uri.parse("https://www.google.com/"));
            startActivity(intent);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }
}