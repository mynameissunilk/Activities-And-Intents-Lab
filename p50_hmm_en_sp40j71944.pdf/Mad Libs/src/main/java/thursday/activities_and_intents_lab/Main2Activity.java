package thursday.activities_and_intents_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView madlib;
    String adj1, adj2, noun1, noun2, anmls, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        madlib = (TextView) findViewById(R.id.madlibbed);
        Intent i = getIntent();
        adj1 = getIntent().getStringExtra("ADJ1");
        adj2 = getIntent().getStringExtra("ADJ2");
        noun1 = getIntent().getStringExtra("NOUN1");
        noun2 = getIntent().getStringExtra("NOUN2");
        anmls = getIntent().getStringExtra("ANIML");
        name = getIntent().getStringExtra("NAME");

        madlib.setText(adj1 + " " +  adj2 + " " + noun1 + " " + noun2 + " " + anmls + " " + name );
    }
}
