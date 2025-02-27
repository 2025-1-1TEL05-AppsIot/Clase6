package com.example.clase6.fragmentos.navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clase6.databinding.FragmentABinding;

public class FragmentA extends Fragment {

    FragmentABinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentABinding.inflate(inflater, container, false);

        binding.buttonToB.setOnClickListener(view -> {

            NavController navController = NavHostFragment.findNavController(FragmentA.this);
            navController.navigate(FragmentADirections.actionFragmentAToFragmentB("Juan"));
            //navController.navigate(R.id.action_fragmentA_to_fragmentB);
        });

        return binding.getRoot();
    }
}