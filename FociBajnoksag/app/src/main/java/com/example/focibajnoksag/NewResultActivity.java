package com.example.focibajnoksag;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class NewResultActivity extends AppCompatActivity {

    EditText home;
    EditText away;
    EditText homepts;
    EditText awaypts;
    EditText date;

    CollectionReference item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        home = findViewById(R.id.home);
        away = findViewById(R.id.away);
        homepts = findViewById(R.id.homepts);
        awaypts = findViewById(R.id.awaypts);
        date = findViewById(R.id.date);

        item = FirebaseFirestore.getInstance().collection("Results");

    }

    public void cancel(View view) {
        finish();
    }

    public void createResult(View view) {

        int homeimg = 0;
        int awayimg = 0;

        List<String> team = new ArrayList<>();
        team.add("REAL MADRID");
        team.add("BARCELONA");
        team.add("PSG");
        team.add("ATLETICO");
        team.add("DORTMUND");
        team.add("BAYERN MÜNCHEN");
        team.add("ARSENAL");
        team.add("MACHESTER CITY");


        if (home.getText().toString().equals("") || away.getText().toString().equals("") || homepts.getText().toString().equals("") || awaypts.getText().toString().equals("") || date.getText().toString().equals("")) {
            Toast.makeText(NewResultActivity.this, "Minden beviteli mezőt tölts ki!", Toast.LENGTH_LONG).show();
            return;
        }


        if (!(team.contains(home.getText().toString()) && team.contains(away.getText().toString()))) {
            Toast.makeText(NewResultActivity.this, "Csak ezeket a csapatokat adhatod meg!\n(REAL MADRID,BARCELON,PSG,ATLETICO,DORTMUND,BAYERN MÜNCHEN,ARSENAL,MACHESTER CITY)", Toast.LENGTH_LONG).show();
            return;
        }

        int a;
        int b;
        try {
            a = Integer.parseInt(homepts.getText().toString());
            b = Integer.parseInt(awaypts.getText().toString());
        } catch (Exception e) {
            Toast.makeText(NewResultActivity.this, "Csak számot adhatsz meg pontnak!", Toast.LENGTH_LONG).show();
            return;
        }

        if (a > 10 || b > 10) {
            Toast.makeText(NewResultActivity.this, "Irreálisan nagy szám lett megadva!", Toast.LENGTH_LONG).show();
            return;
        }

        if (date.getText().toString().length() > 5) {
            Toast.makeText(NewResultActivity.this, "Rossz a dátumformátum!", Toast.LENGTH_LONG).show();
            return;
        }


        switch (home.getText().toString()) {
            case "REAL MADRID":
                homeimg = ResultListActivity.imgPath.get("realmadrid");
                break;
            case "ATLETICO MADRID":
                homeimg = ResultListActivity.imgPath.get("atletico");
                break;
            case "BAYERN MÜNCHEN":
                homeimg = ResultListActivity.imgPath.get("bayern");
                break;
            case "ARSENAL":
                homeimg = ResultListActivity.imgPath.get("arsenal");
                break;
            case "BARCELONA":
                homeimg = ResultListActivity.imgPath.get("barcelona");
                break;
            case "MANCHESTER CITY":
                homeimg = ResultListActivity.imgPath.get("manchestercity");
                break;
            case "DORTMUND":
                homeimg = ResultListActivity.imgPath.get("dortmund");
                break;
            case "PSG":
                homeimg = ResultListActivity.imgPath.get("psg");
                break;
        }

        switch (away.getText().toString()) {

            case "ATLETICO MADRID":
                awayimg = ResultListActivity.imgPath.get("atletico");
                break;
            case "BAYERN MÜNCHEN":
                awayimg = ResultListActivity.imgPath.get("bayern");
                break;
            case "ARSENAL":
                awayimg = ResultListActivity.imgPath.get("arsenal");
                break;
            case "BARCELONA":
                awayimg = ResultListActivity.imgPath.get("barcelona");
                break;
            case "MANCHESTER CITY":
                awayimg = ResultListActivity.imgPath.get("manchestercity");
                break;
            case "DORTMUND":
                awayimg = ResultListActivity.imgPath.get("dortmund");
                break;
            case "PSG":
                awayimg = ResultListActivity.imgPath.get("psg");
                break;
            case "REAL MADRID":
                awayimg = ResultListActivity.imgPath.get("realmadrid");
        }


        item.add(new MatchResult(home.getText().toString(), away.getText().toString(), homepts.getText().toString(), awaypts.getText().toString(), homeimg, awayimg, date.getText().toString()));
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
