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
        // Obtenemos las views segun su identificador
        marcoVideo = findViewById(R.id.marcoVideo);
        tituloFeliz = findViewById(R.id.feliz);
        tituloNavidad = findViewById(R.id.navidad);
        // Podemos hacer un casting de ImageButton ya que el metodo findViewById devuelve una View general y no especifica el tipo
        btnPlay = (ImageButton) findViewById(R.id.imageButtonPlay);
        btnPause = (ImageButton) findViewById(R.id.imageButtonPause);
        btnRest = (ImageButton) findViewById(R.id.imageButtonRestart);

        // Inicializamos la clase VideoView y le asociamos el fichero que contiene el video
        video=(VideoView) findViewById(R.id.videoView);
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.videofeliznavidad;
        video.setVideoURI(Uri.parse(ruta));
        //MediaController vidControl = new MediaController(this);
        //video.setMediaController(vidControl);
        // Aniadimos una imagen inicial
        video.seekTo( 1 );

        // Creamos un objeto TypeFace, a este le indicamos que de los asset obtenga la fuente mediante el nombre dado
        Typeface miFuente  = Typeface.createFromAsset(getAssets(), "The Perfect Christmas.ttf");
        //Asociamos las etiquetas con la fuente mediante el metodo setTypeface
        tituloFeliz.setTypeface(miFuente);
        tituloNavidad.setTypeface(miFuente);

        //Le asignamos el controlador de eventos a los botones
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnRest.setOnClickListener(this);

        // Animaciones
        Animation animacionTitulo = AnimationUtils.loadAnimation(this, R.anim.animaciontitulo);
        Animation animacionVideo = AnimationUtils.loadAnimation(this, R.anim.animacionvideo);
        Animation animacionMarco = AnimationUtils.loadAnimation(this, R.anim.animacionmarco);
        //Asignacion de las animaciones a las views
        tituloFeliz.startAnimation(animacionTitulo);
        tituloNavidad.startAnimation(animacionTitulo);
        video.startAnimation(animacionVideo);
        marcoVideo.startAnimation(animacionMarco);
        btnPlay.startAnimation(animacionVideo);
        btnPause.startAnimation(animacionVideo);
        btnRest.startAnimation(animacionVideo);



    }
    // Sobreescribimos el metodo OnClick para que los botones reproduzcan, paren o reinicen el video al pulsarlos
    @Override
    public void onClick(View v) {
        // Tambien he aniadido una animacion para que los botones tengan una sensacion de ser pulsados
        Animation animacionBotonClick = AnimationUtils.loadAnimation(this, R.anim.animacionbotonclick);


        //Comprobamos el identificador del boton que ha llamado al evento para ver
        //cual de los botones es y ejecutar la acción correspondiente
        switch(v.getId()){
            case R.id.imageButtonPlay:
                //Asignamos la animacion
                btnPlay.startAnimation(animacionBotonClick);
                //Iniciamos el video
                video.start();
                break;
            case R.id.imageButtonPause:
                //Asignamos la animacion
                btnPause.startAnimation(animacionBotonClick);
                //Pausamos el video
                video.pause();
                break;
            case R.id.imageButtonRestart:
                //Asignamos la animacion
                btnRest.startAnimation(animacionBotonClick);
                //Reiniciamos el video, primero volvemos al inicio y lo iniciamos
                video.resume();
                video.start();
                break;

        }

    }

}
