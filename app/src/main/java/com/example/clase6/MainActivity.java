package com.example.clase6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.clase6.databinding.ActivityMainBinding;
import com.example.clase6.entity.Persona;
import com.example.clase6.fragmentos.BlueFragment;
import com.example.clase6.fragmentos.datepicker.DatePickerFragment;
import com.example.clase6.viewModels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mainActivityViewModel =
                new ViewModelProvider(MainActivity.this).get(MainActivityViewModel.class);

        binding.buttonAgregarFragmento.setOnClickListener(view -> {

            String dniStr = binding.editTextDni.getText().toString();
            Persona persona = new Persona(dniStr);
            Bundle bundle = new Bundle();
            bundle.putSerializable("persona", persona);
            bundle.putString("dni", dniStr);

            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .add(binding.fragmentContainerViewBlue.getId(), BlueFragment.class, bundle)
                    .commit();
        });

        binding.buttonEnviarMuchaData.setOnClickListener(view -> {
            mainActivityViewModel.getListMutableLiveData().setValue(create10People());
        });

        mainActivityViewModel.getTexto().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.editTextDni.setText(s);
            }
        });

        binding.buttonGoNavigation.setOnClickListener( view -> {
            Intent intent = new Intent(this, NavigationActivity.class);
            startActivity(intent);
        });

    }

    public List<Persona> create10People() {
        ArrayList<Persona> lista = new ArrayList<>();
        lista.add(new Persona("12300505"));
        lista.add(new Persona("23401414"));
        lista.add(new Persona("96437373"));
        lista.add(new Persona("56867272"));
        lista.add(new Persona("86876161"));
        lista.add(new Persona("65876060"));
        lista.add(new Persona("75686565"));
        lista.add(new Persona("35341010"));
        return lista;
    }

    //En el activity
    public void respuestaDateDialog(int year, int month, int day ){
        Log.d("msg-test-DateDialog","day/month/year selected: " +
                String.valueOf(day) + "/" +
                String.valueOf(month) + "/" +
                String.valueOf(year));
    }

    public void mostrarDateDialog(View view){
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(),"datepicker");
    }


}