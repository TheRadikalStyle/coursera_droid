package com.davidochoa.week2app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nombre, telefono, mail, descripcion;
    DatePicker nacimientoPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.main_edittext_name);
        telefono = findViewById(R.id.main_edittext_phone);
        mail = findViewById(R.id.main_edittext_email);
        descripcion = findViewById(R.id.main_edittext_description);

        nacimientoPicker = findViewById(R.id.main_datepicker_birthday);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            SetData(bundle);
        }

        Button nextButton = findViewById(R.id.main_button_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNext = new Intent(MainActivity.this, SecondActivity.class);
                intentNext.putExtra("dataNombre", String.valueOf(nombre.getText()));
                intentNext.putExtra("dataTel", String.valueOf(telefono.getText()));
                intentNext.putExtra("dataEmail", String.valueOf(mail.getText()));
                intentNext.putExtra("dataDesc", String.valueOf(descripcion.getText()));
                intentNext.putExtra("dataYear", nacimientoPicker.getYear());
                intentNext.putExtra("dataMonth", nacimientoPicker.getMonth());
                intentNext.putExtra("dataDay", nacimientoPicker.getDayOfMonth());
                startActivity(intentNext);
            }
        });
    }

    private void SetData(Bundle data){
        nombre.setText(data.getString("dataNombre"));
        telefono.setText(data.getString("dataTel"));
        mail.setText(data.getString("dataMail"));
        descripcion.setText(data.getString("dataDesc"));
        nacimientoPicker.updateDate(data.getInt("dataYear", 0), data.getInt("dataMonth", 0), data.getInt("dataDay", 0));
    }
}
