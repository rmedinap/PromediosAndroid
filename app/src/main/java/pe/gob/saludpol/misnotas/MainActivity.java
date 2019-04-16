package pe.gob.saludpol.misnotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNota1, txtNota2, txtNota3;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtNota1 = (EditText) findViewById(R.id.txtNota1);
        txtNota2 = (EditText) findViewById(R.id.txtNota2);
        txtNota3 = (EditText) findViewById(R.id.txtNota3);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mostrar_Resultado();
            }
        });
    }

    private void Mostrar_Resultado() {

        String pNota1 = txtNota1.getText().toString();

        String pNota2 = txtNota2.getText().toString();

        String pNota3 = txtNota3.getText().toString();

        if (pNota1.isEmpty()) {
            Toast.makeText(this, "Ingrese nota 1", Toast.LENGTH_SHORT).show();
            return;
        }

        if (pNota2.isEmpty()) {
            Toast.makeText(this, "Ingrese nota 2", Toast.LENGTH_SHORT).show();
            return;
        }

        if (pNota3.isEmpty()) {
            Toast.makeText(this, "Ingrese nota 3", Toast.LENGTH_SHORT).show();
            return;
        }

        double nResultado = (Double.parseDouble(pNota1) + Double.parseDouble(pNota2) + Double.parseDouble(pNota3))/3;

        String estado = ( nResultado >= 13 ) ? "aprobado":"desaprobado";

        String vMostrarResultado = "Resultado: " + nResultado + " Ud. está " + estado;

        Toast.makeText(this, vMostrarResultado, Toast.LENGTH_LONG).show();
    }
}
