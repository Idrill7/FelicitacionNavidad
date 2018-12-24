package com.idrilplays.idril.a1_felicitacionnavidad;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SplashActivity extends AppCompatActivity {
    private TextView ho1;
    private TextView ho2;
    private TextView ho3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        TextView ho1 = (TextView) findViewById(R.id.textHo1);
        TextView ho2 = (TextView) findViewById(R.id.textHo2);
        TextView ho3 = (TextView) findViewById(R.id.textHo3);

        Typeface miFuente = Typeface.createFromAsset(getAssets(), "merrysugar");
        ho1.setTypeface(miFuente);
        ho2.setTypeface(miFuente);
        ho3.setTypeface(miFuente);


    }
}
