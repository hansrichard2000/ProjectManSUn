package com.uc.projectmansun.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputLayout;
import com.uc.projectmansun.R;
import com.uc.projectmansun.model.response.TokenResponse;
import com.uc.projectmansun.ui.MainActivity;
import com.uc.projectmansun.ui.main.beranda.tugas.detail.DetailTugasFragment;
import com.uc.projectmansun.util.SharedPreferenceHelper;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment {

    @BindView(R.id.email_login)
    TextInputLayout email_login;

    @BindView(R.id.password_login)
    TextInputLayout password_login;

    @BindView(R.id.loginbtn)
    Button button;

    private LoginViewModel loginViewModel;
    private SharedPreferenceHelper helper;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
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
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        Objects.requireNonNull(((MainActivity) requireActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(false);

        loginViewModel = ViewModelProviders.of(requireActivity()).get(LoginViewModel.class);
        helper = SharedPreferenceHelper.getInstance(requireActivity());
//        button.setOnClickListener(view1 -> {
//            NavDirections actions = LoginFragmentDirections.actionLoginFragmentToDialogLoading();
//            Navigation.findNavController(view1).navigate(actions);
//        });
    }

    @OnClick({R.id.loginbtn})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.loginbtn:
                if(!email_login.getEditText().getText().toString().isEmpty() && !password_login.getEditText().getText().toString().isEmpty()){
                    String email = email_login.getEditText().getText().toString().trim();
                    String password = password_login.getEditText().getText().toString().trim();
                    loginViewModel.login(email, password).observe(requireActivity(), tokenResponse -> {
                        if (tokenResponse != null){
                            helper.saveAccessToken(tokenResponse.getAuthorization());
                            NavDirections actions = LoginFragmentDirections.actionLoginFragmentToDialogLoading();
                            Navigation.findNavController(view).navigate(actions);
                        }
                    });
                }
                break;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        ((MainActivity)getActivity()).getSupportActionBar().hide();
    }
}
