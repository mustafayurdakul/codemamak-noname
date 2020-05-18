package com.example.codemamak_noname;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AddOpinion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_opinion);

        Button nextButton = findViewById(R.id.btnSend);

        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog alert = new AlertDialog.Builder(AddOpinion.this).create();
                alert.setTitle("Başarılı!");
                alert.setMessage("Fikriniz başarılı şekilde iletilmiştir.\n" +
                        "Teşekkürler.");
                alert.setButton(Dialog.BUTTON_POSITIVE, "Tamam", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent mapActivity = new Intent(getApplicationContext(), MapsActivity.class);
                        startActivity(mapActivity);
                    }
                });
                alert.show();


            }
        });
    }
}
