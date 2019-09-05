package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView myinput;
    TextView myResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        myinput =findViewById(R.id.input);
        myResult=findViewById(R.id.res);

    }

    String lhs="";
    String operator="";
    String rhs="";

    public void onDigitClick(View view) {

        Button mybtn=((Button) view);
        String btnText=mybtn.getText().toString();
        String res=myResult.getText().toString();

        if(res.isEmpty())
        {
            if(operator.isEmpty())
            {

                myinput.append(btnText);
                lhs+=btnText;
            }
            else
            {
                myinput.append(btnText);
                rhs+=btnText;

            }


        }

        else
        {
            myResult.setText("");
            myinput.setText(btnText);
            lhs+=btnText;
        }

    }

    public String calcRes() {
        double n1= Double.parseDouble(lhs);
        double n2= Double.parseDouble(rhs);
        double r;
        String res="";
        if(operator.equals("+")) {
            r = n1 + n2;
            res+=r;

        }
        else if(operator.equals("-")) {
            r = n1 - n2;
            res+=r;
        }
        else if(operator.equals("*")) {
            r = n1 * n2;
            res+=r;

        }
        else if(operator.equals("/")) {
            r = n1 / n2;
            res+=r;

        }
        if(operator.equals("pow")) {
            r = Math.pow(n1,n2);
            res+=r;

        }

        lhs="";
        rhs="";
        operator="";
        return res;
    }





    public void onEqualeclick(View view) {

            String result=myResult.getText().toString();
            if(result.isEmpty()==false)
                return;

            if(result.isEmpty() && lhs.isEmpty())
                return;


            String res=calcRes();
            myResult.setText(res);
    }


    public void onOperatorClick(View view) {

        Button mybtn=((Button) view);
        String res = myResult.getText().toString();

        if(res.isEmpty()) {

            if (lhs.isEmpty())
                return;

            if (operator.isEmpty()) {

                operator = mybtn.getText().toString();
                myinput.append(operator);

            }

            else if(operator.isEmpty()==false && rhs.isEmpty()==false)
            {

                        String result=calcRes();
                        lhs=result;
                        myinput.setText(lhs);
                        operator = mybtn.getText().toString();
                        myinput.append(operator);

            }

            else {

                return;
            }

        }

        else
            {
                operator = mybtn.getText().toString();
                lhs=res;
                myinput.setText(res);
                myResult.setText("");
                myinput.append(operator);

            }
    }

    public void onDelClick(View view) {

        if(lhs.isEmpty())
            return;


        if(operator.isEmpty()) {

            lhs = lhs.substring(0, lhs.length() - 1);
            myinput.setText(lhs);
        }
        else if(rhs.isEmpty()) {
            operator = "";
            myinput.setText(lhs);
            myinput.append(operator);
        }
        else{
            rhs=rhs.substring(0,rhs.length()-1);
            myinput.setText(lhs);
            myinput.append(operator);
            myinput.append(rhs);
        }
    }

    public void onClearClick(View view) {

        myResult.setText("");
        myinput.setText("");
        lhs="";
        rhs="";
        operator="";

    }

    public void onDotClick(View view) {
        if(operator.isEmpty())
        {
            for(int i=0;i<lhs.length();i++)
            {
                if(lhs.charAt(i)=='.')
                    return;
            }

            lhs+=".";
            myinput.append(".");
        }

        else if(operator.isEmpty()==false )
        {
            for(int i=0;i<rhs.length();i++)
            {
                if(rhs.charAt(i)=='.')
                    return;
            }

            rhs+=".";
            myinput.append(".");

        }

        return;
    }
}
