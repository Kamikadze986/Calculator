package com.example.calculator.ui.main;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.calculator.R;

public class MainFragment extends Fragment implements View.OnClickListener  {
    String[] signs = { "+", "-", "/", "*", "%","^"};
    String item;
    Spinner spinner;
    EditText first,second;
    TextView selection;

    public static Fragment newInstance() {
        return new MainFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        Button button = (Button) view.findViewById(R.id.button_procces);
        button.setOnClickListener(this);

        spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item, signs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item = (String)parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        selection = (TextView) view.findViewById(R.id.textView);

        first =(EditText) view.findViewById(R.id.first_calc);
        second=(EditText) view.findViewById(R.id.second_calc);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (item) {
            case "+":
                selection.setText(String.valueOf(Integer.parseInt(first.getText().toString())+
                        Integer.parseInt(second.getText().toString())));
                break;
            case "-":
                selection.setText(String.valueOf(Integer.parseInt(first.getText().toString())-
                        Integer.parseInt(second.getText().toString())));
                break;
            case"*":
                selection.setText(String.valueOf(Integer.parseInt(first.getText().toString())*
                        Integer.parseInt(second.getText().toString())));
                break;
            case "/":
                selection.setText(String.valueOf(Integer.parseInt(first.getText().toString())/
                        Integer.parseInt(second.getText().toString())));
                break;
            case "%":
                selection.setText(String.valueOf(Integer.parseInt(first.getText().toString())%
                        Integer.parseInt(second.getText().toString())));
                break;
            case"^":
                selection.setText(String.valueOf(Math.pow(Integer.parseInt(first.getText().toString()),
                        Integer.parseInt(second.getText().toString()))));
                break;

        }
    }
}