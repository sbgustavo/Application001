package br.com.appCar.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import br.com.appCar.R;
import br.com.appCar.control.Calculo;
import br.com.appCar.control.RelacaoCombustivel;

public class RelationFuelActivity extends Activity {

    private EditText editTextPrecoGasolina;
    private TextView editTextPrecoAlcool;
    private Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	setContentView(R.layout.relacacao_combustivel);

	initView();

    }

    private void initView() {
	editTextPrecoGasolina = (EditText) findViewById(R.id.editTextPrecoGasolina);
	editTextPrecoGasolina.setKeyListener(DigitsKeyListener.getInstance(true, true)); // TODO: VERIFICAR FUNCIONAMENTO
	editTextPrecoAlcool = (EditText) findViewById(R.id.editTextPrecoAlcool);
	editTextPrecoAlcool.setKeyListener(DigitsKeyListener.getInstance(true, true));
	btCalcular = (Button) findViewById(R.id.buttonCalcular);

	final Calculo c = new RelacaoCombustivel();

	btCalcular.setOnClickListener(new View.OnClickListener() {
	    public void onClick(View arg0) {

		AlertDialog.Builder dialogo = new AlertDialog.Builder(RelationFuelActivity.this);

		dialogo.setNeutralButton("OK", null);
		if ((editTextPrecoAlcool.length() == 0) || (editTextPrecoGasolina.length() == 0)) {
		    dialogo.setTitle("Atenção");
		    dialogo.setMessage("Preencha todos os campos!");
		    dialogo.show();

		} else {
		    double precoGasolina = Double.parseDouble(editTextPrecoGasolina.getText().toString());
		    double precoAlcool = Double.parseDouble(editTextPrecoAlcool.getText().toString());
		    String resultado = calculaRelacaoCombustivel(c.calcular(precoAlcool, precoGasolina));

		    dialogo.setTitle("AppCar");
		    dialogo.setMessage("Abasteça com " + resultado + "!");
		    dialogo.show();
		    limpaEditText();
		}
	    }
	});

    }
    
    private String calculaRelacaoCombustivel(double porcentagem) {
	if (porcentagem > 0.7) {
	    return "Gasolina";
	}

	return "Alcool";
    }
    
    private void limpaEditText() {
	editTextPrecoGasolina.setText(null);
	editTextPrecoAlcool.setText(null);
    }

}
