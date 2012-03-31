package br.com.appCar.view;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.com.android.R;
import br.com.appCar.control.Calculo;
import br.com.appCar.control.RelacaoAlcoolGasolina;
import android.app.Activity;

public class RelacaoCombustivelActivity extends Activity{

	EditText editTextPrecoGasolina;
	EditText editTextPrecoAlcool;
	Button btCalcular;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        initView();
    }
    
    private void initView() {
    	
        editTextPrecoGasolina = (EditText) findViewById(R.id.editTextPrecoGasolina);
        editTextPrecoAlcool = (EditText) findViewById(R.id.editTextPrecoAlcool);
        btCalcular = (Button) findViewById(R.id.buttonCalcular);
        
        final Calculo c = new RelacaoAlcoolGasolina();
        
        btCalcular.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View arg0) {
        		
        		AlertDialog.Builder dialogo = new AlertDialog.Builder(RelacaoCombustivelActivity.this);
        		
        		if( (editTextPrecoAlcool.length() == 0) || (editTextPrecoGasolina.length() == 0) ) {
            		dialogo.setTitle("Atenção");
            		dialogo.setMessage("Preencha todos os campos!");
            		
        		} else {
        			double precoGasolina = Double.parseDouble(editTextPrecoGasolina.getText().toString());
            		double precoAlcool = Double.parseDouble(editTextPrecoAlcool.getText().toString());        			
	        		String resultado = calculaRelacaoCombustivel(c.calcular(precoAlcool, precoGasolina)); 
	        		
	        		dialogo.setTitle("AppCar");
	        		dialogo.setMessage("Abasteça com " + resultado + "!");
        		}
        		
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
