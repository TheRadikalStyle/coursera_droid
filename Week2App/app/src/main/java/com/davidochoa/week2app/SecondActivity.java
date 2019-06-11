package com.davidochoa.week2app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Bundle dataFromMain;
    TextView dataShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        dataShow = findViewById(R.id.second_textview_showdata);
        dataFromMain = getIntent().getExtras();
        if(dataFromMain != null){
            SetDataOnUI(dataFromMain);
        }

        Button editButton = findViewById(R.id.second_button_editdata);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editDataIntent = new Intent(SecondActivity.this, MainActivity.class);
                editDataIntent.putExtra("dataBundle", dataFromMain);
                startActivity(editDataIntent);
                finish();
            }
        });
    }

    private void SetDataOnUI(Bundle data){
        StringBuilder datos = new StringBuilder(data.getString("dataNombre"));
        datos.append("\n");
        datos.append("Fecha de nacimiento: ").append(data.getString("dataDay")).append("/")
            .append();
        datos.append("\n");
        datos.append("Tel: ").append(data.getString("dataTel"));
        datos.append("\n");
        datos.append("Email: ").append(data.getString("dataEmail"));
        datos.append("\n");
        datos.append("Descripción: ").append(data.getString("dataDesc"));

        dataShow.setText(datos.toString());
    }
}
