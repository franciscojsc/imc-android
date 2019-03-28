package br.com.franciscochaves.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_imc;
    private EditText altura;
    private EditText peso;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_imc = findViewById(R.id.button_imc);
        altura = findViewById(R.id.edit_altura);
        peso = findViewById(R.id.edit_peso);
        resultado = findViewById(R.id.text_diagnostico);



    }

    public void verificarIMC(View view){

        if(altura.getText().toString().trim().length() > 0 && peso.getText().toString().trim().length() > 0){

            float imc =  (Float.parseFloat(peso.getText().toString()) /
                            (Float.parseFloat(altura.getText().toString()) *
                                    Float.parseFloat(altura.getText().toString())));

            if( imc < 18.5){
                resultado.setText("Diagnóstico: Abaixo do peso");
            }else if(imc >= 18.5 && imc < 24.9){
                resultado.setText("Diagnóstico: Peso normal");
            }else if(imc >= 25 && imc < 29.9){
                resultado.setText("Diagnóstico: Sobrepeso");
            }else if(imc >= 30 && imc < 34.9){
                resultado.setText("Diagnóstico: Obesidade grau 1");
            }else if(imc >= 35 && imc < 39.9){
                resultado.setText("Diagnóstico: Obesidade grau 2");
            }else{
                resultado.setText("Diagnóstico: Obesidade grau 3");
            }

            exibirMensagem("IMC: " + imc);

        }else{
            exibirMensagem("Preencher os campos altura e peso");
        }

    }

    private void exibirMensagem (String mensagem) {
        Toast.makeText(getBaseContext(), mensagem, Toast.LENGTH_LONG).show();
    }
}
