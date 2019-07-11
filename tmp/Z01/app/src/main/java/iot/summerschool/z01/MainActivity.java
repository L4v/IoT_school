package iot.summerschool.z01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button clk_btn, yellow_btn, blue_btn, red_btn, next_btn;
    EditText edit;
    Switch sw;
    TextView text;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Utility buttons
        clk_btn = findViewById(R.id.click_btn);
        next_btn = findViewById(R.id.next_btn);
        sw = findViewById(R.id.sw);

        // Colors
        red_btn = findViewById(R.id.red_btn);
        yellow_btn = findViewById(R.id.yellow_btn);
        blue_btn = findViewById(R.id.blue_btn);

        // Fields
        edit = findViewById(R.id.edit);
        text = findViewById(R.id.nothing_text);

        // Switch text on / off
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    text.setVisibility(View.INVISIBLE);
                else
                    text.setVisibility(View.VISIBLE);
            }
        });

        // Set TextView text
        clk_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(edit.getText());
                InputMethodManager im = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });

        // Change TextView colors
        // Red
        red_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setTextColor(getResources().getColor(R.color.crvena));
            }
        });

        // Blue
        blue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setTextColor(getResources().getColor(R.color.plava));
            }
        });

        // Yellow
        yellow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setTextColor(getResources().getColor(R.color.zuta));
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}
