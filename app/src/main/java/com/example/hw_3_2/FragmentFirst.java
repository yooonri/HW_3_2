package com.example.hw_3_2;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentFirst extends Fragment {
    private int counter = 0;
    private TextView number;
    private Button btnDecrease;
    private Button btnIncrease;
    private Button btnNext;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
    }

    private void initView(){
        number = requireActivity().findViewById(R.id.textView);
        btnDecrease = requireActivity().findViewById(R.id.btn_number_decrease);
        btnIncrease = requireActivity().findViewById(R.id.btn_number_increase);
        btnNext = requireActivity().findViewById(R.id.btn_next);
    }

    private void initListener() {
        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                number.setText(String.valueOf(counter));

            }
        });
        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                number.setText(String.valueOf(counter));
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction().add(R.id.container,
                        new FragmentSecond()).addToBackStack(null).commit();
                MainActivity activity = (MainActivity) requireActivity();
                String value = String.valueOf(counter);
                activity.updateTextScore(value);
            }
        });
    }
}