package com.uc.projectmansun.ui.main.profil.role;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uc.projectmansun.R;
import com.uc.projectmansun.model.local.Divisi;
import com.uc.projectmansun.model.local.DivisiRoleUser;
import com.uc.projectmansun.model.local.Periode;
import com.uc.projectmansun.ui.MainActivity;
import com.uc.projectmansun.ui.main.beranda.BerandaAdapter;
import com.uc.projectmansun.ui.main.beranda.BerandaViewModel;
import com.uc.projectmansun.ui.main.profil.ProfilFragment;
import com.uc.projectmansun.util.SharedPreferenceHelper;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RoleFragment extends Fragment {

    @BindView(R.id.rv_role)
    RecyclerView rv_role;

    private RoleViewModel roleViewModel;
    private RoleAdapter roleAdapter;
    private SharedPreferenceHelper helper;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RoleFragment(){

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
    public static RoleFragment newInstance(String param1, String param2) {
        RoleFragment fragment = new RoleFragment();
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
        return inflater.inflate(R.layout.fragment_role, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        Objects.requireNonNull(((MainActivity) requireActivity()).getSupportActionBar()).setTitle("Roles");

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        roleViewModel = ViewModelProviders.of(requireActivity()).get(RoleViewModel.class);
        roleViewModel.init(helper.getAccessToken());
        roleViewModel.getDivisiRoleUser().observe(requireActivity(), observer);

        rv_role.setLayoutManager(new LinearLayoutManager(getActivity()));
        roleAdapter = new RoleAdapter(getActivity());

    }

    private Observer<List<DivisiRoleUser>> observer = new Observer<List<DivisiRoleUser>>() {
        @Override
        public void onChanged(List<DivisiRoleUser> drus) {
            if (drus != null){
                roleAdapter.setDRUList(drus);
                roleAdapter.notifyDataSetChanged();
                rv_role.setAdapter(roleAdapter);
            }
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
