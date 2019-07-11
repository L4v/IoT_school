package iot.summerschool.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CharacterAdapter characterAdapter = new CharacterAdapter(this);

        characterAdapter.addCharacter(new Character("Stan", getDrawable(R.drawable.stan)));
        characterAdapter.addCharacter(new Character("Kyle", getDrawable(R.drawable.kyle)));
        characterAdapter.addCharacter(new Character("Kenny", getDrawable(R.drawable.kenny)));
        characterAdapter.addCharacter(new Character("Eric", getDrawable(R.drawable.eric)));

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(characterAdapter);
    }
}
