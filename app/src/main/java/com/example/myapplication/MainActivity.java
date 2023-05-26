package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    String tour = "X";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.titactoe_layout);

        Button btn1 = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button4);
        Button btn5 = findViewById(R.id.button5);
        Button btn6 = findViewById(R.id.button6);
        Button btn7 = findViewById(R.id.button7);
        Button btn8 = findViewById(R.id.button8);
        Button btn9 = findViewById(R.id.button9);

        btn1.setOnClickListener(btnListenerJouerCase);
        btn2.setOnClickListener(btnListenerJouerCase);
        btn3.setOnClickListener(btnListenerJouerCase);
        btn4.setOnClickListener(btnListenerJouerCase);
        btn5.setOnClickListener(btnListenerJouerCase);
        btn6.setOnClickListener(btnListenerJouerCase);
        btn7.setOnClickListener(btnListenerJouerCase);
        btn8.setOnClickListener(btnListenerJouerCase);
        btn9.setOnClickListener(btnListenerJouerCase);

        Button btnRecommencer = findViewById(R.id.btnRecommencer);
        btnRecommencer.setOnClickListener(btnListenerRecommencer);

        //btnRecommencer.setText(getString(R.string.test, "un test"));
    }

    View.OnClickListener btnListenerJouerCase = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            Button btn = (Button)v;
            TextView txtStatut = findViewById(R.id.txtStatut);

            if(btn.getText().toString() == ""){
               btn.setText(tour);

               if(verifierGagnant()){
                   Toast.makeText(getApplicationContext(), "Les " + tour + " ont gagné!", Toast.LENGTH_LONG).show();

               } else {
                   if(verifierNull()) {
                       txtStatut.setText(R.string.tourTermine);
                       Toast.makeText(getApplicationContext(), "C'est terminé par une nulle!", Toast.LENGTH_LONG).show();
                   } else {
                       if(Objects.equals(tour, "X")){
                           tour = "O";
                           txtStatut.setText(R.string.tourO);

                       } else {
                           tour = "X";
                           txtStatut.setText(R.string.tourX);
                       }
                   }
               }
            }
        }
    };


    public boolean verifierGagnant(){

        String btn1 = ((Button)findViewById(R.id.button)).getText().toString();
        String btn2 = ((Button)findViewById(R.id.button2)).getText().toString();
        String btn3 = ((Button)findViewById(R.id.button3)).getText().toString();
        String btn4 = ((Button)findViewById(R.id.button4)).getText().toString();
        String btn5 = ((Button)findViewById(R.id.button5)).getText().toString();
        String btn6 = ((Button)findViewById(R.id.button6)).getText().toString();
        String btn7 = ((Button)findViewById(R.id.button7)).getText().toString();
        String btn8 = ((Button)findViewById(R.id.button8)).getText().toString();
        String btn9 = ((Button)findViewById(R.id.button9)).getText().toString();

        if((btn1.equals(btn2) && btn1.equals(btn3) && btn1.equals(tour)) ||
                (btn4.equals(btn5) && btn4.equals(btn6) && btn4.equals(tour)) ||
                (btn6.equals(btn7) && btn6.equals(btn8) && btn6.equals(tour)) ||

                (btn1.equals(btn4) && btn1.equals(btn7) && (btn1.equals(tour))) ||
                (btn2.equals(btn5) && btn2.equals(btn8) && (btn2.equals(tour))) ||
                (btn3.equals(btn6) && btn3.equals(btn9) && (btn3.equals(tour))) ||

                (btn1.equals(btn5) && (btn1.equals(btn9)) && (btn1.equals(tour))) ||
                (btn3.equals(btn5) && (btn3.equals(btn7)) && (btn3.equals(tour)))){

            return true;

        } else {
            return false;
        }
    }

    public boolean verifierNull(){
        String btn1 = ((Button)findViewById(R.id.button)).getText().toString();
        String btn2 = ((Button)findViewById(R.id.button2)).getText().toString();
        String btn3 = ((Button)findViewById(R.id.button3)).getText().toString();
        String btn4 = ((Button)findViewById(R.id.button4)).getText().toString();
        String btn5 = ((Button)findViewById(R.id.button5)).getText().toString();
        String btn6 = ((Button)findViewById(R.id.button6)).getText().toString();
        String btn7 = ((Button)findViewById(R.id.button7)).getText().toString();
        String btn8 = ((Button)findViewById(R.id.button8)).getText().toString();
        String btn9 = ((Button)findViewById(R.id.button9)).getText().toString();


        return (!btn1.equals("") && !btn2.equals("") && !btn3.equals("") &&
                !btn4.equals("") && !btn5.equals("") && !btn6.equals("") &&
                !btn7.equals("") && !btn8.equals("") && !btn9.equals("") );
    }


    View.OnClickListener btnListenerRecommencer = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {

            tour = "X";
            TextView txtStatut = findViewById(R.id.txtStatut);
            txtStatut.setText(R.string.tourX);

            ((Button)findViewById(R.id.button)).setText("");
            ((Button)findViewById(R.id.button2)).setText("");
            ((Button)findViewById(R.id.button3)).setText("");
            ((Button)findViewById(R.id.button4)).setText("");
            ((Button)findViewById(R.id.button5)).setText("");
            ((Button)findViewById(R.id.button6)).setText("");
            ((Button)findViewById(R.id.button7)).setText("");
            ((Button)findViewById(R.id.button8)).setText("");
            ((Button)findViewById(R.id.button9)).setText("");
        }
    };
}