package com.example.codemamak_noname;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MarkerKutuphane extends AppCompatActivity {

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
        setContentView(R.layout.activity_marker_kutuphane);

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
                    imageView1.setImageResource(R.drawable.tabmavi);
                    btnOpinion.setVisibility(View.VISIBLE);
                } else {
                    isClicked = true;
                    imageView1.setImageResource(R.drawable.tick);
                    imageView2.setImageResource(R.drawable.tabpembe);
                    imageView3.setImageResource(R.drawable.tabbeyaz);
                    imageView4.setImageResource(R.drawable.tabrandom);
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
                    imageView2.setImageResource(R.drawable.tabpembe);
                    btnOpinion.setVisibility(View.VISIBLE);
                } else {
                    isClicked = true;
                    imageView1.setImageResource(R.drawable.tabmavi);
                    imageView2.setImageResource(R.drawable.tick);
                    imageView3.setImageResource(R.drawable.tabbeyaz);
                    imageView4.setImageResource(R.drawable.tabrandom);
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
                    imageView3.setImageResource(R.drawable.tabbeyaz);
                    btnOpinion.setVisibility(View.VISIBLE);
                } else {
                    isClicked = true;
                    imageView1.setImageResource(R.drawable.tabmavi);
                    imageView2.setImageResource(R.drawable.tabpembe);
                    imageView3.setImageResource(R.drawable.tick);
                    imageView4.setImageResource(R.drawable.tabrandom);
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
                    imageView4.setImageResource(R.drawable.tabrandom);
                    btnOpinion.setVisibility(View.VISIBLE);
                } else {
                    isClicked = true;
                    imageView1.setImageResource(R.drawable.tabmavi);
                    imageView2.setImageResource(R.drawable.tabpembe);
                    imageView3.setImageResource(R.drawable.tabbeyaz);
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
                AlertDialog alert = new AlertDialog.Builder(MarkerKutuphane.this).create();
                alert.setTitle("Başarılı!");
                alert.setMessage("Seçiminiz başarılı şekilde iletilmiştir.");
                alert.setCancelMessage(null);
                alert.show();
            }
        });
    }
}