package br.com.appCar.view;

import br.com.android.R;
import br.com.appCar.control.Calculo;
import br.com.appCar.control.RelacaoAlcoolGasolina;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AppCarActivity extends Activity {
	
	EditText editTextPrecoGasolina;
	EditText editTextPrecoAlcool;
	Button btCalcular;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        editTextPrecoGasolina = (EditText) findViewById(R.id.editTextPrecoGasolina);
        editTextPrecoAlcool = (EditText) findViewById(R.id.editTextPrecoAlcool);
        btCalcular = (Button) findViewById(R.id.buttonCalcular);
        
        final Calculo c = new RelacaoAlcoolGasolina();
        
        btCalcular.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View arg0) {
        		
        		double precoGasolina = Double.parseDouble(editTextPrecoGasolina.getText().toString());
        		double precoAlcool = Double.parseDouble(editTextPrecoAlcool.getText().toString());
        		
        		String resultado = calculaRelacaoCombustivel(c.calcular(precoAlcool, precoGasolina)); 
        		
        		AlertDialog.Builder dialogo = new
        		AlertDialog.Builder(AppCarActivity.this);
        		dialogo.setTitle("Aviso");
        		dialogo.setMessage("Abaste�a com " + resultado);
        		dialogo.setNeutralButton("OK", null);
        		dialogo.show();
        	}
        });
    }
    
    private String calculaRelacaoCombustivel (double porcentagem) {
    	if(porcentagem > 0.7) {
    		return "Gasolina";
    	}
    	
    	return "Alcool";
    }
}