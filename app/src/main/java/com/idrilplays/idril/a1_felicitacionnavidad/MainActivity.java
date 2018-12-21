package com.idrilplays.idril.a1_felicitacionnavidad;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Creamos un objeto TypeFace, a este le decimos que de los asset obtenga la fuente
        Typeface miFuente  = Typeface.createFromAsset(getAssets(), "christmaseve.ttf");
        //Obtenemos la etiqueta de texto mediante el id, la guardamos en una variable del tipo TextView
        // Lo buscamos por identificador mediante findViewById, este estara en la clase R donde estan todos los recursos
        // Hacemos un casting para que devuelva un objeto TextView y no View
        TextView tituloFeliz = findViewById(R.id.feliz);
        TextView tituloNavidad = findViewById(R.id.navidad);
        //Asociamos la etiqueta con la fuente mediante el metodo setTypeface
        tituloFeliz.setTypeface(miFuente);
        tituloNavidad.setTypeface(miFuente);

    }
}
