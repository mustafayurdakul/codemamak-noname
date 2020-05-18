package com.example.codemamak_noname;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MarkerDinlenmeParki extends AppCompatActivity {

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private Button btnOpinion;
    private Button btnSend;
    private Boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker_dinlenme_parki);

        define();
        clickImageView1();
        clickImageView2();
        clickImageView3();
        clickImageView4();
        clickBtnOpinion();
    }

    public void define() {
        imageView1 = findViewById(R.id.image1);
        imageView2 = findViewById(R.id.image2);
        imageView3 = findViewById(R.id.image3);
        imageView4 = findViewById(R.id.image4);
        btnOpinion = findViewById(R.id.btnOpinion);
        btnSend = findViewById(R.id.btnSend);
    }

    public void clickImageView1() {
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    isClicked = false;
                    imageView1.setImageResource(R.drawable.park02);
                    btnOpinion.setVisibility(View.VISIBLE);
                } else {
                    isClicked = true;
                    imageView1.setImageResource(R.drawable.tick);
                    imageView2.setImageResource(R.drawable.park01);
                    imageView3.setImageResource(R.drawable.parkrandom);
                    imageView4.setImageResource(R.drawable.parksari);
                    btnOpinion.setVisibility(View.GONE);
                    btnSend.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void clickImageView2() {
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    isClicked = false;
                    imageView2.setImageResource(R.drawable.park01);
                    btnOpinion.setVisibility(View.VISIBLE);
                } else {
                    isClicked = true;
                    imageView1.setImageResource(R.drawable.park02);
                    imageView2.setImageResource(R.drawable.tick);
                    imageView3.setImageResource(R.drawable.parkrandom);
                    imageView4.setImageResource(R.drawable.parksari);
                    btnOpinion.setVisibility(View.GONE);
                    btnSend.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void clickImageView3() {
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    isClicked = false;
                    imageView3.setImageResource(R.drawable.parkrandom);
                    btnOpinion.setVisibility(View.VISIBLE);
                } else {
                    isClicked = true;
                    imageView1.setImageResource(R.drawable.park02);
                    imageView2.setImageResource(R.drawable.park01);
                    imageView3.setImageResource(R.drawable.tick);
                    imageView4.setImageResource(R.drawable.parksari);
                    btnOpinion.setVisibility(View.GONE);
                    btnSend.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void clickImageView4() {
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    isClicked = false;
                    imageView4.setImageResource(R.drawable.parksari);
                    btnOpinion.setVisibility(View.VISIBLE);
                } else {
                    isClicked = true;
                    imageView1.setImageResource(R.drawable.park02);
                    imageView2.setImageResource(R.drawable.park01);
                    imageView3.setImageResource(R.drawable.parkrandom);
                    imageView4.setImageResource(R.drawable.tick);
                    btnOpinion.setVisibility(View.GONE);
                    btnSend.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void clickBtnOpinion() {
        btnOpinion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OpinionActivity.class);
                startActivity(intent);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alert = new AlertDialog.Builder(MarkerDinlenmeParki.this).create();
                alert.setTitle("Başarılı!");
                alert.setMessage("Seçiminiz başarılı şekilde iletilmiştir.");
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
