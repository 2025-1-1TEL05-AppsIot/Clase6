package com.example.clase6.fragmentos.navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clase6.R;
import com.example.clase6.databinding.FragmentCBinding;

public class FragmentC extends Fragment {

    FragmentCBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCBinding.inflate(inflater, container, false);

        binding.buttonToA.setOnClickListener(view -> {

            NavController navController = NavHostFragment.findNavController(FragmentC.this);
            navController.navigate(R.id.action_fragmentC_to_fragmentA);
            //navController.navigate(FragmentCDirections.actionFragmentCToFragmentA());
        });

        return binding.getRoot();
    }
}