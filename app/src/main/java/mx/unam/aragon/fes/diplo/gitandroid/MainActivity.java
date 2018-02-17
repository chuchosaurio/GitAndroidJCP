package mx.unam.aragon.fes.diplo.gitandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button miBoton, miBoton2, miBoton3;
    private TextView miTexto;
    private ImageView miImagen;
    private Bitmap imagendescargada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miBoton = findViewById(R.id.button);
        miBoton2 = findViewById(R.id.button2);
        miBoton3 = findViewById(R.id.button3);
        miTexto = findViewById(R.id.textView);
        miImagen = findViewById(R.id.imagen);


        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miTexto.setText("Hola GitHub");
                Toast.makeText(MainActivity.this, "Se cambió el mensaje en el textView",
                        Toast.LENGTH_SHORT).show();
            }
        });
        miBoton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miTexto.setText("Diplomado Android");
            }
        });
        miBoton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miTexto.setText("Diplomado Android");
            }
        });

        miBoton3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                try {
                    new ObtenerImagen().execute(new URL ("https://vignette.wikia.nocookie.net/toontown/images/8/8a/Toontown_Online_Game_Screenshot_Toons.png"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }



    class ObtenerImagen extends AsyncTask<URL,Integer,Bitmap> {
        @Override
        protected Bitmap doInBackground(URL... urls) {
            try{
                imagendescargada = BitmapFactory.decodeStream(urls[0].openConnection().getInputStream());
            }catch (Exception e){
                Log.e("diplo", "Error"+e.toString());
            }
            return imagendescargada;
        }

        protected void onPostExecute(Bitmap bitmap) {
            //establecer eÃ± ImageView sobre el layout
            miImagen.setImageBitmap(imagendescargada);
            super.onPostExecute(bitmap);
        }

    }



}
