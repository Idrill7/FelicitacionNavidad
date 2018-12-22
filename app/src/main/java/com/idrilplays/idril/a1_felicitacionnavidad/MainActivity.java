package com.idrilplays.idril.a1_felicitacionnavidad;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.view.View;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
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
    private View marcoVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marcoVideo = findViewById(R.id.marcoVideo);
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
        //Le asignamos el controlador de eventos a los botones
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnRest.setOnClickListener(this);

        // Animaciones
        Animation animacionTitulo = AnimationUtils.loadAnimation(this, R.anim.animaciontitulo);
        Animation animacionVideo = AnimationUtils.loadAnimation(this, R.anim.animacionvideo);
        Animation animacionMarco = AnimationUtils.loadAnimation(this, R.anim.animacionmarco);
        //Las asignamos
        tituloFeliz.startAnimation(animacionTitulo);
        tituloNavidad.startAnimation(animacionTitulo);
        video.startAnimation(animacionVideo);
        marcoVideo.startAnimation(animacionMarco);
        btnPlay.startAnimation(animacionVideo);
        btnPause.startAnimation(animacionVideo);
        btnRest.startAnimation(animacionVideo);




    }

    @Override
    public void onClick(View v) {

        Animation animacionBotonClick = AnimationUtils.loadAnimation(this, R.anim.animacionbotonclick);


        //Comprobamos el identificador del boton que ha llamado al evento para ver
        //cual de los botones es y ejecutar la acción correspondiente
        switch(v.getId()){
            case R.id.imageButtonPlay:
                //Iniciamos el video
                btnPlay.startAnimation(animacionBotonClick);
                video.start();
                break;
            case R.id.imageButtonPause:
                //Pausamos el video
                btnPause.startAnimation(animacionBotonClick);
                video.pause();
                break;
            case R.id.imageButtonRestart:
                //Reiniciamos el video
                //video.stopPlayback();
                //video.seekTo(0);
                btnRest.startAnimation(animacionBotonClick);
                video.resume();
                video.start();
                break;

        }

    }

}
