package thursday.activities_and_intents_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String ADJ_ID1 = "ADJ1";
    public static final String ADJ_ID2 = "ADJ2";
    public static final String NOUN1 = "NOUN1";
    public static final String NOUN2 = "NOUN2";
    public static final String ANIML= "ANIML";
    public static final String NAME = "NAME";
    EditText adj1, adj2, noun1, noun2, animl, name;
    Button submitButton;
    List<EditText> edittexts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adj1 = (EditText) findViewById(R.id.adj1);
        adj2 = (EditText) findViewById(R.id.adj2);
        noun1 = (EditText) findViewById(R.id.noun1);
        noun2 = (EditText) findViewById(R.id.noun2);
        animl = (EditText) findViewById(R.id.animals);
        name = (EditText) findViewById(R.id.name);
        submitButton = (Button) findViewById(R.id.submit);

        edittexts.add(adj1);
        edittexts.add(adj2);
        edittexts.add(noun1);
        edittexts.add(noun2);
        edittexts.add(animl);
        edittexts.add(name);

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (EditText i : edittexts) {
                    if (i.getText().length() == 0) {
                        i.setError("Some entries are incomplete...");
                    }
                }
                Intent tent = new Intent(view.getContext(), Main2Activity.class);
                tent.putExtra("ADJ_ID1", adj1.getText().toString());
                tent.putExtra("ADJ_ID2", adj2.getText().toString());
                tent.putExtra("NOUN1", noun1.getText().toString());
                tent.putExtra("NOUN2", noun2.getText().toString());
                tent.putExtra("ANIML", animl.getText().toString());
                tent.putExtra("NAME", name.getText().toString());
                startActivity(tent);
            }
        };
        submitButton.setOnClickListener(buttonListener);
    }
}