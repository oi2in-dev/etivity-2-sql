// Assignment E-tivity 2 ED5042
// Oisin O'Sullivan 21304971



package com.example.etivity_2_sql;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText codeNameEdt, codeCreationEdt, codeDescriptionEdt;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button page = findViewById(R.id.accelerometer);
        page.setOnClickListener((View.OnClickListener) this);

        codeNameEdt = findViewById(R.id.idEdtcodeName);
        codeCreationEdt = findViewById(R.id.idEdtcodeCreation);
        codeDescriptionEdt = findViewById(R.id.idEdtcodeDescription);
        Button addCodeBtn = findViewById(R.id.idBtnAddCode);

        dbHandler = new DBHandler(MainActivity.this);


        addCodeBtn.setOnClickListener(v -> {

            String codeName = codeNameEdt.getText().toString();
            String codeCreation = codeCreationEdt.getText().toString();
            String codeDescription = codeDescriptionEdt.getText().toString();

            if (codeName.isEmpty() && codeCreation.isEmpty() && codeDescription.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter info in ALL fields.", Toast.LENGTH_SHORT).show();
                return;
            }


            dbHandler.addNewEntry(codeName, codeCreation, codeDescription);

            Toast.makeText(MainActivity.this, "Entry has been added!", Toast.LENGTH_SHORT).show();
            codeNameEdt.setText("");
            codeCreationEdt.setText("");
            codeDescriptionEdt.setText("");
        });

    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.accelerometer:
                Intent home = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(home);
                break;

        }
    }
}