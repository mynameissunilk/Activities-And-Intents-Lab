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

    private static final String ADJ1 = "ADJ1";
    private static final String ADJ2 = "ADJ2";
    private static final String NOUN1 = "NOUN1";
    private static final String NOUN2 = "NOUN2";
    private static final String ANIML= "ANIML";
    private static final String NAME = "NAME";

    EditText adj1, adj2, noun1, noun2, animl, name;
    Button submitButton;
    List<EditText> edittexts = new ArrayList<EditText>();

    public boolean formIsComplete(ArrayList<EditText> et){
        int typocount = 0;
        for (EditText i : et){
            if(i.getText().length() == 0) {
                typocount += 1;
                i.setError("Please complete all the entries!");
            }
        }
        if(typocount == 0)
            return true;
        else{
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adj1 =  (EditText) findViewById(R.id.adj1);
        adj2 =  (EditText) findViewById(R.id.adj2);
        noun1 = (EditText) findViewById(R.id.noun1);
        noun2 = (EditText) findViewById(R.id.noun2);
        animl = (EditText) findViewById(R.id.animals);
        name =  (EditText) findViewById(R.id.name);
        submitButton = (Button) findViewById(R.id.submit);

        edittexts.add(adj1);
        edittexts.add(adj2);
        edittexts.add(noun1);
        edittexts.add(noun2);
        edittexts.add(animl);
        edittexts.add(name);

        submitButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                if(formIsComplete((ArrayList<EditText>) edittexts)) {
                    Intent tent = new Intent(view.getContext(), Main2Activity.class);
                    tent.putExtra("ADJ1", adj1.getText().toString());
                    tent.putExtra("ADJ2", adj2.getText().toString());
                    tent.putExtra("NOUN1", noun1.getText().toString());
                    tent.putExtra("NOUN2", noun2.getText().toString());
                    tent.putExtra("ANIML", animl.getText().toString());
                    tent.putExtra("NAME", name.getText().toString());
                    startActivity(tent);
                }
            }
        });

    }
}