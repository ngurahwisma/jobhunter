package com.wisma.jobhunter.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.wisma.jobhunter.R;
import com.wisma.jobhunter.RegisterActivity;

public class DialogTanggal extends DialogFragment {
    private DatePicker dp;
    private Button btnSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.datepicker,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.dp =  view.findViewById(R.id.dpDatePicker);
        this.btnSubmit =  view.findViewById(R.id.btnDatePicker);

        this.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder tanggal = new StringBuilder();
                tanggal.append(dp.getYear());
                tanggal.append("-");
                tanggal.append(dp.getMonth());
                tanggal.append("-");
                tanggal.append(dp.getDayOfMonth());
                RegisterActivity.tvTanggal.setText(tanggal.toString());
                dismiss();
            }
        });
    }
}
