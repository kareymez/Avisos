package com.example.avisos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //agregar tag para invocarlo en estados de la app
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate");
        //con esto se crea un aviso emergente en el cel
        // Toast.makeText(this, "La publicación se ha creado", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
        // Toast.makeText(this, "La aplicación se ha creado", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        //Agregar toast personalizado
        LayoutInflater inflater = getLayoutInflater();
        View layout =inflater.inflate(R.layout.toast_personalizado_onresume, (ViewGroup) findViewById(R.id.toast_on_resume));
        TextView texto_Toast = (TextView) layout.findViewById(R.id.texto_Toast);
        texto_Toast.setText("La aplicación no se ha recuperado");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
        // Toast.makeText(this, "La aplicación está pausada", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Log.i(TAG, "onStop");
        //Toast.makeText(this, "La aplicación se detuvo", Toast.LENGTH_SHORT).show();
        Context context = getApplicationContext();
        CharSequence text = "La aplicación se ha detenido";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.TOP | Gravity.LEFT, 150, 100);
        toast.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
       // Toast.makeText(this, "La aplicación se ha cerrado", Toast.LENGTH_SHORT).show();


    }
}