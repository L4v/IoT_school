package iot.summerschool.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    // XML Components
    private ListView listView;
    private EditText edit;
    private Button btn;
    private boolean execute;

    // Utility
    private ArrayAdapter<String> adapter;
    private ArrayList<String> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        execute = false;

        cities = new ArrayList<String>();
        cities.add("Novi Sad");
        cities.add("Beograd");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cities);

        // XML Components
        listView = findViewById(R.id.lista);
        listView.setAdapter(adapter);
        edit = findViewById(R.id.edit);
        btn = findViewById(R.id.btn);

        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(edit.getText().toString().equals("Order 66")) {
                    btn.setText("EXECUTE");
                    execute = true;
                    listView.setAdapter(null);
                    listView.setAdapter(adapter);
                    adapter.add("Master Ali-Alann");
                    adapter.add("Master Stas-Allie");
                    adapter.add("Master Ferroda");
                    adapter.add("Master Sev");
                    adapter.add("Master Serra Keto");
                }else
                    btn.setText(getResources().getString(R.string.add_btn));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tmp;

                if(!(tmp = edit.getText().toString()).isEmpty())
                    if(execute) {
                        int items = adapter.getCount();
                        for (int i = 0; i < items; ++i) {
                            adapter.remove(adapter.getItem(0));
                            adapter.setNotifyOnChange(true);
                            adapter.notifyDataSetChanged();
                            SystemClock.sleep(10);
                        }
                        execute = false;
                    }else {
                        adapter.add(tmp);
                        edit.setText("");
                    }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.remove(adapter.getItem(position));
            }
        });


    }
}
