package iot.summerschool.z02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private EditText edit1, edit2;
    private Button btn_add;
    private ListView listView;

    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ItemAdapter(this);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        btn_add = findViewById(R.id.btn_add);
        listView = findViewById(R.id.listView);

        listView.setAdapter(adapter);

        for(int i = 0; i < 10; ++i){
            adapter.addItem(new Item("Contact " + i, "123"+i, getDrawable(R.drawable.stan)));
        }


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp1, tmp2;
                tmp1 = edit1.getText().toString();
                tmp2 = edit2.getText().toString();
                if(!tmp1.isEmpty() && !tmp2.isEmpty()){
                    adapter.addItem(new Item(tmp1, tmp2, getDrawable(R.drawable.stan)));
                }
            }
        });


    }

}
