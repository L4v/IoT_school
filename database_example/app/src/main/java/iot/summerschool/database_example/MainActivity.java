package iot.summerschool.database_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private EditText mEditName, mEditSurname, mEditIndex;
    private Button btn_add, btn_refresh;
    private ListView listView;

    private StudentDbHelper mDb;

    private StudentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAdapter = new StudentAdapter(this);

        mDb = new StudentDbHelper(this);

        btn_add = findViewById(R.id.add_btn);
        btn_refresh = findViewById(R.id.refresh_btn);

        mEditName = findViewById(R.id.ime);
        mEditSurname = findViewById(R.id.prezime);
        mEditIndex = findViewById(R.id.indeks);

        listView = findViewById(R.id.students);
        listView.setAdapter(mAdapter);

        refresh();

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = mEditName.getText().toString(),
                        surname = mEditSurname.getText().toString(),
                        index = mEditIndex.getText().toString();

                if(!name.isEmpty() && !surname.isEmpty() && !index.isEmpty()){
                    Student s = new Student(name, surname, index);
                    mDb.insert(s);
                    Log.d("[MainActivity]", "[Adding student " + s +"]");

                    mEditName.setText("");
                    mEditSurname.setText("");
                    mEditIndex.setText("");

                    mAdapter.addStudent(s);
                }
            }
        });

        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refresh();
            }
        });

    }

    private void refresh(){
        Student[] students;
        students = mDb.readStudent();

        if(students == null)
            return;

        mAdapter.update(mDb.readStudent());
    }

}
