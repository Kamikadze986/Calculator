package com.example.calculator.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.calculator.R;

public class MainFragment extends Fragment implements View.OnClickListener  {
    char[] signs =new char[] { '/', '*','-', '+'};
    String item;
    TextView number0,number1,number2,number3,number4,number5,number6,number7,
            number8,number9,plus,minus,mult,div, numberLine,clears,resultLine,result;
    ImageView clear;

    public static Fragment newInstance() {
        return new MainFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        item=new String("");
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        number0 = (TextView) view.findViewById(R.id.number0);
        number0.setOnClickListener(numberOnClick);
        number1 = (TextView) view.findViewById(R.id.number1);
        number1.setOnClickListener(numberOnClick);
        number2 = (TextView) view.findViewById(R.id.number2);
        number2.setOnClickListener(numberOnClick);
        number3 = (TextView) view.findViewById(R.id.number3);
        number3.setOnClickListener(numberOnClick);
        number4 = (TextView) view.findViewById(R.id.number4);
        number4.setOnClickListener(numberOnClick);
        number5 = (TextView) view.findViewById(R.id.number5);
        number5.setOnClickListener(numberOnClick);
        number6 = (TextView) view.findViewById(R.id.number6);
        number6.setOnClickListener(numberOnClick);
        number7 = (TextView) view.findViewById(R.id.number7);
        number7.setOnClickListener(numberOnClick);
        number8 = (TextView) view.findViewById(R.id.number8);
        number8.setOnClickListener(numberOnClick);
        number9 = (TextView) view.findViewById(R.id.number9);
        number9.setOnClickListener(numberOnClick);

        plus = (TextView) view.findViewById(R.id.plus);
        plus.setOnClickListener(signOnClick);
        minus = (TextView) view.findViewById(R.id.minus);
        minus.setOnClickListener(signOnClick);
        mult=(TextView) view.findViewById(R.id.mult);
        mult.setOnClickListener(signOnClick);
        div=(TextView) view.findViewById(R.id.div);
        div.setOnClickListener(signOnClick);
        numberLine = (TextView) view.findViewById(R.id.numberLine);

        result =view.findViewById(R.id.result);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processing();
            }
        });

        resultLine = (TextView) view.findViewById(R.id.resultLine);
        clear=(ImageView) view.findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(item.length()>0){
                    if(item.charAt(item.length()-1)==' ') {
                        item=item.substring(0,item.length()-3);
                    }else{
                        item=item.substring(0,item.length()-1);
                    }

                    numberLine.setText(item);
                }
            }
        });

        clears=(TextView) view.findViewById(R.id.clears);
        clears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item="";
                numberLine.setText(item);
            }
        });
        return view;
    }
    private View.OnClickListener numberOnClick =new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            item+=((TextView) v).getText().toString();
            numberLine.setText(item);
        }
    };
    private View.OnClickListener signOnClick =new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            checkForSign((((TextView) v).getText().toString()).charAt(0));
            numberLine.setText(item);
        }
    };
    public void checkForSign(char sign){
        if(item.length()<1)
            return;
        if (item.length()>=3) {
            for (int i = 0; i <signs.length ; i++) {
                if ( item.charAt(item.length()-2) == signs[i]) {
                    item=item.substring(0,item.length()-3);
                    item+=" "+sign+" ";
                    return;
                }
            }
        }
        item+=" "+sign+" ";
    }

    private void processing(){
        String result=item;
        for(int i=0;i<signs.length;i++){
            for(int j = 0; j < result.length(); j++) {
               if(result.charAt(j)==signs[i]){
                   int maxIndex = Processing.serchMaxIndex(result,j+2);
                   int minIndex = Processing.serchMinIndex(result,j-2);
                   int nextJ=Processing.processingExpression(result.substring(minIndex,maxIndex),
                           result.substring(minIndex+2,maxIndex).indexOf(result.charAt(j))+2).length();
                   result=result.replace(result.substring(minIndex,maxIndex),
                           Processing.processingExpression(result.substring(minIndex,maxIndex),
                                   result.substring(minIndex+2,maxIndex).indexOf(result.charAt(j))+2));
                   j=nextJ;
               }
            }
        }
        resultLine.setText(result);
    }
    @Override
    public void onClick(View v) {}
}