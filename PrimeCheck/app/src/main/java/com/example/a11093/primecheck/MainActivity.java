package com.example.a11093.primecheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private TextView outcome;
    private Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText)findViewById(R.id.input);
        outcome = (TextView)findViewById(R.id.output);
        submitButton = (Button)findViewById(R.id.Submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int inputnum = Integer.parseInt(input.getText().toString());
                    if (inputnum==1||inputnum==2||inputnum==3) {
                        outcome.setText(inputnum+" is a prime");
                        input.setText("");
                    }
                    else {
                        outcome.setText(inputnum+" is a prime");
                        input.setText("");
                        for(int i = 2;i<=Math.sqrt(inputnum);i++){
                            if(inputnum%i==0) {
                                outcome.setText(inputnum+" is a composite");
                                input.setText("");

                            }
                        }
                    }
                } catch (Exception e) {
                    outcome.setText("Please Type in something!!!");
                }

            }
        });
    }
}
