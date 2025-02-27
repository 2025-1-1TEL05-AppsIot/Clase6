package com.example.clase6.fragmentos.navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clase6.databinding.FragmentBBinding;

public class FragmentB extends Fragment {

    FragmentBBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBBinding.inflate(inflater, container, false);
        FragmentBArgs bundle = FragmentBArgs.fromBundle(getArguments());
        String name = bundle.getName();
        Log.d("msg-test-FragmentBArgs", "Name: " + name);
        binding.buttonToC.setOnClickListener(view -> {

            NavController navController = NavHostFragment.findNavController(FragmentB.this);
            navController.navigate(FragmentBDirections.actionFragmentBToFragmentC());
        });

        return binding.getRoot();
    }
}