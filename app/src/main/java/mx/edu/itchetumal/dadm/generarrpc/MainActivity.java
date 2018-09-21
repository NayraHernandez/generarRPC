package mx.edu.itchetumal.dadm.generarrpc;


import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public String adecuarCadena(String cadena){
        String cadAux = cadena.toUpperCase().trim();

        char[] vocalesAcentuadas = {'Á', 'É', 'Í', 'Ó', 'Ú'};
        char[] vocales = {'A', 'E', 'I', 'O', 'U'};

        for (byte pos=0; pos<appaterno.length(); pos++) {
            cadAux.replace(vocalesAcentuadas[pos], vocales[pos]);

        }
        return cadAux;
    }
    public void GeneraRFC(View v) {
        //Tomar la primer letra apellido paterno
        EditText editApPaterno = (EditText) findViewById(R.id.editA_Paterno);

        String appterno = adecuarCadena(editApPaterno.getText().toString());

        Toast.makeText(this, "cadena convertida", Toast.LENGTH_LONG).show();

        char primerLetraAP = appaterno.charAt(0);

        char[] vocales = {'A', 'E', 'I', 'O', 'U'};
        char primerVocal = ' ';
        byte pos;
        boolean encontrada = false;

        for (pos=0; pos<vocales.length(); pos++) {
            if (appterno.indexOf(vocales[pos]) >= 0) {
                encontrada = true;
                break;
            }
            if (encontrada)
                primerVocal = vocales[pos];
        }
        //Hacer un método que reciba cadena y la devuelve en mayusculas,sin espacios al inicio o fin, sin acentos

        //2. Tomar la primer letra del apellido materno
        EditText editA_Materno = (EditText)findViewById(R.id.editA_Materno);
        char primerLetraAM = editA_Materno.getText().charAt(0);

        //3. Tomar la primer letra del primer nombre
        EditText editNombre = (EditText)findViewById(R.id.editNombre);
        char primerLetraNom = editNombre.getText().charAt(0);

        //4. Tomar los ultimos digitos del año de nacimiento


        //5. Tomar los dos digitos del mes de nacimiento

        //6. Tomar los dos digitos del dia de nacimiento


        //7. Generar tres caracteres (letras mayusculas o números) para la homonimia

        //8. Concatenar lo anterior y mostrar el RFC
    }
}


