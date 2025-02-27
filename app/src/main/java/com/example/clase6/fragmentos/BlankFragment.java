package com.example.clase6.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.clase6.databinding.FragmentBlankBinding;
import com.example.clase6.viewModels.MainActivityViewModel;

import java.util.Random;

public class BlankFragment extends Fragment {

    FragmentBlankBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBlankBinding.inflate(inflater, container, false);

        MainActivityViewModel mainActivityViewModel =
                new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);

        binding.button.setOnClickListener(view -> {
            Toast.makeText(container.getContext(), "Un toast desde el fragmento",
                    Toast.LENGTH_LONG).show();
            String s = binding.editTextName.getText().toString();

            mainActivityViewModel.getTexto().setValue(s);
        });



        mainActivityViewModel.getListMutableLiveData().observe(getViewLifecycleOwner(), personas -> {
            Random r = new Random();
            String dni = personas.get(r.nextInt(personas.size())).getDni();
            binding.textViewDNIRandom.setText(dni);
        });

        return binding.getRoot();
    }

}