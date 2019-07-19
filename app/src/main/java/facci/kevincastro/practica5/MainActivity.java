package facci.kevincastro.practica5;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    EditText campoColor, campoTamaño, campoTipo;
    TextView txtDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoColor = (EditText)findViewById(R.id.txtcolorMI);
        campoTamaño = (EditText)findViewById(R.id.txttamañoMI);
        campoTipo = (EditText)findViewById(R.id.txtTipoMI);
        txtDatos = (TextView)findViewById(R.id.txtDatosMI);


    }

    public void guardarPreferencia(View view){

        SharedPreferences preferencia = getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferencia.edit();
        editor.putString("color",campoColor.getText().toString());
        editor.putString("tamaño",campoTamaño.getText().toString());
        editor.putString("tipo",campoTipo.getText().toString());
        editor.apply();

        Toast.makeText(this,"datos guardados",Toast.LENGTH_LONG).show();




    }

    public void LeerPreferencias(View view) {

        SharedPreferences preferencia = getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);

        String color=preferencia.getString("color", "");
        String tamaño=preferencia.getString("tamaño", "");
        String tipo=preferencia.getString("tipo", "");

        txtDatos.setText(color +" "+ tamaño +" "+ tipo);



    }
}
