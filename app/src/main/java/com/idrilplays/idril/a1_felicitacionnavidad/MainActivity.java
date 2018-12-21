package com.idrilplays.idril.a1_felicitacionnavidad;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import android.net.Uri;
public class MainActivity extends AppCompatActivity implements View.OnClickListener
       {
    private TextView tituloFeliz;
    private TextView tituloNavidad;
    private ImageButton btnPlay;
    private ImageButton btnPause;
    private ImageButton btnRest;
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos la clase VideoView y le asociamos el fichero que contiene el video
        video=(VideoView) findViewById(R.id.videoView);
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.videoesp;
        video.setVideoURI(Uri.parse(ruta));
        //MediaController vidControl = new MediaController(this);
        //video.setMediaController(vidControl);


        // Creamos un objeto TypeFace, a este le decimos que de los asset obtenga la fuente
        Typeface miFuente  = Typeface.createFromAsset(getAssets(), "The Perfect Christmas.ttf");
        //Obtenemos la etiqueta de texto mediante el id, la guardamos en una variable del tipo TextView
        // Lo buscamos por identificador mediante findViewById, este estara en la clase R donde estan todos los recursos
        // Hacemos un casting para que devuelva un objeto TextView y no View
        tituloFeliz = findViewById(R.id.feliz);
        tituloNavidad = findViewById(R.id.navidad);
        //Asociamos la etiqueta con la fuente mediante el metodo setTypeface
        tituloFeliz.setTypeface(miFuente);
        tituloNavidad.setTypeface(miFuente);



        //Obtengo los botones
        btnPlay = (ImageButton) findViewById(R.id.imageButtonPlay);
        btnPause = (ImageButton) findViewById(R.id.imageButtonPause);
        btnRest = (ImageButton) findViewById(R.id.imageButtonRestart);
        //Le asignamos el controlador de eventos
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnRest.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //Comprobamos el identificador del boton que ha llamado al evento para ver
        //cual de los botones es y ejecutar la acción correspondiente
        switch(v.getId()){
            case R.id.imageButtonPlay:
                //Iniciamos el video
                video.start();
                break;
            case R.id.imageButtonPause:
                //Pausamos el video
                video.pause();
                break;
            case R.id.imageButtonRestart:
                //Reiniciamos el video
                //video.stopPlayback();
                //video.seekTo(0);
                video.resume();
                video.start();
                break;

        }

    }

}
