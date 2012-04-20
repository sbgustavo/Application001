package br.com.appCar.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import br.com.appCar.R;
import br.com.appCar.model.Vehicle;
import br.com.appCar.modelDatabase.DatabaseDelegate;

public class RegisterVehicleActivity extends Activity {

    private EditText editTextBrand;
    private EditText editTextModel;
    private EditText editTextCurrentKm;
    private EditText editTextCurrentVolume;
    private EditText editTextPlate;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	setContentView(R.layout.register_vehicle);

	initView();

    }

    private void initView() {
	editTextBrand = (EditText) findViewById(R.id.EditTextBrand);

	editTextCurrentKm = (EditText) findViewById(R.id.EditTextCurrentKm);

	editTextCurrentVolume = (EditText) findViewById(R.id.editTextCurrentVolume);

	editTextModel = (EditText) findViewById(R.id.EditTextModel);

	editTextPlate = (EditText) findViewById(R.id.EditTextPlate);

	buttonSave = (Button) findViewById(R.id.buttonSave);

	buttonSave.setOnClickListener(new OnClickListener() {

	    public void onClick(View v) {
		submitAction();
	    }
	});
    }

    private void submitAction() {
	if (validateFields()) {
	    DatabaseDelegate db = DatabaseDelegate.getInstance(getApplicationContext());
	    db.sendVehicleToDB(makeVehicleObject());
	}
    }

    private boolean validateFields() {

	if ( (editTextBrand.length() >= 2) && (editTextPlate.length() >= 2) && 
	     (editTextModel.length() >= 2) && (editTextCurrentKm.length() >= 5) &&
	     (editTextCurrentVolume.length() > 0)) {
	    return true;
	}

	return false;
    }

    private Vehicle makeVehicleObject() {

	Vehicle vh = new Vehicle();

	vh.setBrand(editTextBrand.getText().toString());
	vh.setModel(editTextModel.getText().toString());
	vh.setPlate(editTextPlate.getText().toString());
	vh.setCurrentKm(Integer.parseInt(editTextCurrentKm.getText().toString()));
	vh.setCurrentVolume(Integer.parseInt(editTextCurrentVolume.getText().toString()));

	return vh;
    }

}
