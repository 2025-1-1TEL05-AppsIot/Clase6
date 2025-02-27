package com.example.clase6.fragmentos.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.clase6.MainActivity;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    //En el fragmento
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.respuestaDateDialog(year,month,day);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();

        return new DatePickerDialog(getActivity(), this,
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH));
    }

}
