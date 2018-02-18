package br.edu.ifpe.tads.pdm.somdosbichos;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    MediaPlayer mediaPlayer;
    ImageView dogImageView, catImageView, lionImageView, monkeyImageView,
            sheepImageView, cowImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dogImageView = findViewById(R.id.dogImageId);
        catImageView = findViewById(R.id.catImageId);
        lionImageView = findViewById(R.id.lionImageId);
        monkeyImageView = findViewById(R.id.monkeyImageId);
        sheepImageView = findViewById(R.id.sheepImageId);
        cowImageView = findViewById(R.id.cowImageId);

        dogImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.cao);

                tocarSom();
            }
        });

        catImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer = MediaPlayer.create(MainActivity.this,
                        R.raw.gato);

                tocarSom();

            }
        });

        lionImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(MainActivity.this,
                        R.raw.leao);

                tocarSom();
            }
        });

        monkeyImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(MainActivity.this,
                        R.raw.macaco);
                tocarSom();
            }
        });

        sheepImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(),
                        R.raw.ovelha);

                tocarSom();
            }
        });

        cowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(),
                        R.raw.vaca);
                tocarSom();
            }
        });

    }

    private void tocarSom() {
        mediaPlayer.start();
    }

}
