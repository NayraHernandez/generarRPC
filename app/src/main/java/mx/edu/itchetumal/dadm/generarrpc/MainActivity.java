package mx.edu.itchetumal.dadm.generarrpc;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import android.widget.DatePicker;
import android.app.DatePickerDialog;


public class MainActivity extends AppCompatActivity {

    EditText editDate;
    EditText editA_Paterno;
    EditText editA_Materno;
    EditText editNombre;
    EditText editHomo;
    TextView editRFC;

    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGenerar;
        btnGenerar = findViewById(R.id.btnGenerar);
        editDate = (EditText) findViewById(R.id.editDate);
        editA_Paterno = (EditText) findViewById(R.id.editA_Paterno);
        editA_Materno = (EditText) findViewById(R.id.editA_Materno);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editRFC = (TextView) findViewById(R.id.editRFC);

        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            //Generar calendario para ingresar la fecha de nacimiento
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        editDate.setText(checkDigit(day) + "/" + checkDigit((month + 1)) + "/" + year);
                    }
                }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });
        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Condiciones para generar el RFC
                if((editNombre.getText().toString().trim().length() == 0) || (editNombre.getText().toString().trim().length() < 1)) {
                    Toast.makeText(getApplicationContext(), "Introduce tu nombre", Toast.LENGTH_SHORT).show();
                    editRFC.setText("");
                    editNombre.setError(editNombre.getResources().getString(R.string.CampoObligatorio));
                }else if ((editA_Paterno.getText().toString().trim().length() == 0) || (editA_Paterno.getText().toString().trim().length() <2) ){
                    Toast.makeText(getApplicationContext(), "Introduce tu apellido paterno", Toast.LENGTH_SHORT).show();
                    editRFC.setText("");
                    editA_Paterno.setError(editA_Paterno.getResources().getString(R.string.CampoObligatorio));
                }else if ((editA_Materno.getText().toString().trim().length() == 0) || (editA_Materno.getText().toString().trim().length() <1) ){
                    Toast.makeText(getApplicationContext(), "Introduce tu apellido materno", Toast.LENGTH_SHORT).show();
                    editRFC.setText("");
                    editA_Materno.setError(editA_Materno.getResources().getString(R.string.CampoObligatorio));
                }else if(editDate.getText().toString().trim().length() == 0){
                    Toast.makeText(getApplicationContext(), "Introduce tu fecha de nacimiento", Toast.LENGTH_SHORT).show();
                    editRFC.setText("");
                    editDate.setError(editDate.getResources().getString(R.string.CampoObligatorio));
                }else{
                    generarRFC(view);
                    editNombre.setError(null);
                    editA_Paterno.setError(null);
                    editA_Materno.setError(null);
                    editDate.setError(null);

                }
            }
        });
    }
    public String checkDigit(int number)
    {
        return number<=9?"0"+number:String.valueOf(number);
    }
    public void generarRFC(View v) {
        //Variables
        String appaterno = (editA_Paterno.getText().toString().toUpperCase().trim());
        String apmaterno = (editA_Materno.getText().toString().toUpperCase().trim());
        String nombre = (editNombre.getText().toString().toUpperCase().trim());

        String año = (editDate.getText().toString().trim().substring(8));
        String mes = (editDate.getText().toString().trim().substring(3, 5));
        String dia = (editDate.getText().toString().trim().substring(0, 2));
        String rfc = " ";

        //Primer Letra del Apellido Paterno
        char primerLetraAP = appaterno.charAt(0);

        //Primer Letra del Apellido Materno
        char primerLetraAM = apmaterno.charAt(0);

        //Primer Letra del Nombre
        char primerLetraN = nombre.charAt(0);

        //Primer Vocal del Apellido Paterno
        char primervocal = 0;
        int desplazamiento = 0;

        for (int i = 1; (desplazamiento == 0 && i < appaterno.length()); i++) {
            primervocal = appaterno.charAt(i);
            if (primervocal == ('A') || primervocal == ('E') ||
                    primervocal == ('I') || primervocal == ('O') ||
                    primervocal == ('U'))
                desplazamiento++;
        }

        //Crear la Homoclave
        char[] caracteres = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S',
                'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] conjunto = new char[3];
        String homoclave = "";

        for (int i = 0; i <= 2; i++) {
            conjunto[i] = caracteres[(int) (Math.random() * 37)];
            homoclave = homoclave += conjunto[i];
        }
        //Homo clave
       // editHomo.setText(homoclave.toUpperCase().trim());

        //Concatenar los datos
        rfc += primerLetraAP;
        rfc += primervocal;
        rfc += primerLetraAM;
        rfc += primerLetraN;
        rfc += año;
        rfc += mes;
        rfc += dia;
        rfc += homoclave;

        editRFC.setText(rfc.toUpperCase().trim());

    }
        // Para limpiar los textos introducidos
     public void Limpiar(View v) {
        ((EditText) findViewById(R.id.editA_Paterno)).setText("");
        ((EditText) findViewById(R.id.editA_Materno)).setText("");
        ((EditText) findViewById(R.id.editNombre)).setText("");
        ((EditText) findViewById(R.id.editDate)).setText("");
        ((EditText) findViewById(R.id.editRFC)).setText("");
        ((EditText) findViewById(R.id.editHomo)).setText("");
    }
}




