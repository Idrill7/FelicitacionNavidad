package com.idrilplays.idril.a1_felicitacionnavidad;


import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener{
    private TextView ho1;
    private TextView ho2;
    private TextView ho3;
    private ImageView papanoel;
    private View  logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Obtenemos las views mediante el id
        papanoel = (ImageView) findViewById(R.id.papanoelvector);
        ho1 = (TextView) findViewById(R.id.textHo1);
        ho2 = (TextView) findViewById(R.id.textHo2);
        ho3 = (TextView) findViewById(R.id.textHo3);
        logo = findViewById(R.id.circularFillable);
        //Obtenemos la fuente
        Typeface miFuente = Typeface.createFromAsset(getAssets(), "merrysugar.otf");
        //Establecemos la fuente
        ho1.setTypeface(miFuente);
        ho2.setTypeface(miFuente);
        ho3.setTypeface(miFuente);

        //Animaciones
        Animation animacionNoel = AnimationUtils.loadAnimation(this, R.anim.animacionpapanoel);
        Animation animacionHo = AnimationUtils.loadAnimation(this, R.anim.animacionho);
        Animation animacionLogo = AnimationUtils.loadAnimation(this, R.anim.animacionlogosplash);
        //Ligamos las animaciones
        papanoel.startAnimation(animacionNoel);
        ho1.startAnimation(animacionHo);
        ho2.startAnimation(animacionHo);
        ho3.startAnimation(animacionHo);
        logo.startAnimation(animacionLogo);

        //Ponemos la animacion a la escucha
        // Escojo la ultima animacion, tendra como parametro el propio objeto, es una instancia de la clase que implementa la interfaz
        animacionLogo.setAnimationListener(this);
    }
    //Metodos de la interfaz  implementada
    @Override
    public void onAnimationStart(Animation animation) {

    }
    //Usaremos este metodo para que cuando acabe la animacion, se lance la activity main
    @Override
    public void onAnimationEnd(Animation animation) {
    //Para cambiar de una activity a otra hay que crear un Intent
        //Establecemos por parametro la "ruta" del origen y el destino
        Intent intent = new Intent(SplashActivity.this,MainActivity.class);
        // Iniciamos el cambio de activity
        startActivity(intent);
        //Acabamos el Activity del splash ya que no vamos a retrodecer a ella
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
