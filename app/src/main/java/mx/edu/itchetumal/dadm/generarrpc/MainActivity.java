package mx.edu.itchetumal.dadm.generarrpc;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void GeneraRFC (View v){
        //Tomar la primer letra y primer vocal del apellido paterno
       EditText editA_Paterno = (EditText)findViewById(R.id.editA_Paterno);
        char primerLetraAP = editA_Paterno.getText().charAt(0);

        char[] vocales = {'A','E','I','O','U','a','e','i','o','u'};
       String cadAux= "Pedro Pérez";
       char primerLetra = cadAux.charAt(0);
       Character LetraAp = new Character(cadAux.CharArt(0));
      // LetraAp.compareTo()

        //Tomar la primer letra del apellido materno

        //Tomar la primer letra del primer nombre

        //Tomar los ultimos digitos del año de nacimiento

        //Tomar los dos digitos del mes de nacimiento

        //Tomar los dos digitos del dia de nacimiento

        //Generar tres caracteres (letras mayusculas o números) para la homonimia

        //Concatenar lo anterior y mostrar el RFC
    }
}
