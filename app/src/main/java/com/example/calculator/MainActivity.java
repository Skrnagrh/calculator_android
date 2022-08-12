package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView Screen;
    private Button Ac,Power,C,Div,Mul,Plus,Min,One,Two,Three,Four,Six,Seven,Eight,Nine,Zero,Point,Equal;
    private String input,Answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Screen = findViewById(R.id.screen);
        Ac = findViewById(R.id.ac);

        C = findViewById(R.id.back);
        Power = findViewById(R.id.power);
        Div = findViewById(R.id.div);
        Mul = findViewById(R.id.mul);
        Plus = findViewById(R.id.add);
        Min = findViewById(R.id.min);
        One = findViewById(R.id.one);
        Two = findViewById(R.id.two);
        Three = findViewById(R.id.three);
        Four = findViewById(R.id.four);
        Six = findViewById(R.id.six);
        Seven = findViewById(R.id.seven);
        Eight = findViewById(R.id.eight);
        Nine = findViewById(R.id.nine);
        Zero = findViewById(R.id.zero);
//        Ans = findViewById(R.id.ans);
        Point = findViewById(R.id.point);
        Equal = findViewById(R.id.equals);

    }

    public void ButtonClick(View view){
        Button button = (Button) view;
        String data=button.getText().toString();
        switch (data) {
            case "ac":
                input="";
                break;
//            case "ans":
//                input +=Answer;
//                break;
            case "x":
                try {
                    Solve();
                    input += "*";
                }catch (Exception e){

                }
                break;
            case "^":
                try {
                    Solve();
                    input += "^";
                }catch (Exception e){

                }
                break;
            case "=":
                try {
                    Solve();
                    Answer = input;
                    break;
                }catch (Exception e){

                }
            case "C":
                try {
                    String newText = input.substring(0, input.length()-1);
                    input = newText;
                }catch (Exception e){

                }

                break;
            default:
                if (input == null){
                    input = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/")){
                    Solve();
                }
                input += data;
        }
        Screen.setText(input);
    }

    private void Solve(){

        if (input.split("\\*").length == 2 ){
            String number[] = input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0])*Double.parseDouble(number[1]);
                input = mul + "";
            }
            catch (Exception e){

            }
        }
        else if (input.split("/").length == 2 ){
            String number[] = input.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div + "";
            }
            catch (Exception e){

            }
        }
        else if (input.split("\\^").length == 2 ){
            String number[] = input.split("\\^");
            try {
                double pow = Math.pow(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
                input = pow + "";
            }
            catch (Exception e){

            }
        }
        else if (input.split("\\+").length == 2 ){
            String number[] = input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0])+ Double.parseDouble(number[1]);
                input = sum + "";
            }
            catch (Exception e){

            }
        }
        else if (input.split("-").length > 1 ){
            String number[] = input.split("-");
            if (number[0] == "" && number.length == 2){
                number[0] = 0+"";
            }
            try {
                double sub = 0;
                if (number.length==2){
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                    input = sub + "";
                }
                else if (number.length==3){
                    sub = -Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                input = sub+"";
            }
            catch (Exception e){

            }
        }
        String n[] = input.split("\\.");
        if (n.length > 1){
            if (n[1].equals("0")){
                input = n[0];
            }
        }
        Screen.setText(input);
    }
}

