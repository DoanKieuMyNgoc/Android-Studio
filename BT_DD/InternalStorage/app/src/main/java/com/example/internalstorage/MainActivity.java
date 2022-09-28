package com.example.internalstorage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    Button saveButton;
    Button readButton;

    TextView textView;
    EditText editText;

    // Is a simple file name.
    // Note!! Do not allow the path.
    String simpleFileName = "note.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.saveButton = (Button) this.findViewById(R.id.button_save);
        this.readButton = (Button) this.findViewById(R.id.button_read);
        this.textView = (TextView) this.findViewById(R.id.textView);
        this.editText = (EditText) this.findViewById(R.id.editText);

        this.saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        this.readButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                readData();
            }
        });
    }


    private void saveData() {
        String data = this.editText.getText().toString();
        try {
            // Open Stream to write file.
            FileOutputStream out = this.openFileOutput(simpleFileName, MODE_PRIVATE);
            // Ghi dữ liệu.
            out.write(data.getBytes());
            out.close();
            Toast.makeText(this, "File saved!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void readData() {
        try {
            // Open stream to read file.
            FileInputStream in = this.openFileInput(simpleFileName);

            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            StringBuilder sb = new StringBuilder();
            String s = null;
            while ((s = br.readLine()) != null) {
                sb.append(s).append("\n");
            }
            this.textView.setText(sb.toString());

        } catch (Exception e) {
            Toast.makeText(this, "Error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}