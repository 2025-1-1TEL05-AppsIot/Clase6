package com.example.clase6.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clase6.databinding.FragmentBlueBinding;
import com.example.clase6.entity.Persona;

public class BlueFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static int contador = 1;

    FragmentBlueBinding binding;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlueFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlueFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlueFragment newInstance(String param1, String param2) {
        BlueFragment fragment = new BlueFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("msg-test", "contador: " + contador++);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBlueBinding.inflate(inflater, container, false);

        //Aquí se coloca toda la lógica del fragmento
        Bundle bundle = requireArguments();
        String dni = bundle.getString("dni");
        Persona persona = (Persona) bundle.getSerializable("persona");

        binding.textViewDniP.setText(persona.getDni());
        binding.textViewDniStr.setText(dni);

        //hasta aquí

        return binding.getRoot();
    }
}