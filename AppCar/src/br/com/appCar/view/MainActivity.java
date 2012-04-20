package br.com.appCar.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import br.com.appCar.R;

public class MainActivity extends Activity {

    private Button buttonRelationFuel;
    private Button buttonRegisterFuel;
    private Button buttonLocateGasStation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	setContentView(R.layout.main);

	initView();
    }

    private void initView() {
	buttonRelationFuel = (Button) findViewById(R.id.buttonRelationFuel);
	buttonRelationFuel.setOnClickListener(new OnClickListener() {

	    @Override
	    public void onClick(View v) {
		startActivity(new Intent(getApplicationContext(), RelationFuelActivity.class));
	    }
	});

	buttonRegisterFuel = (Button) findViewById(R.id.buttonNewFuel);
	buttonRegisterFuel.setOnClickListener(new OnClickListener() {

	    @Override
	    public void onClick(View v) {
		startActivity(new Intent(getApplicationContext(), RegisterVehicleActivity.class)); // TODO: CHAMAR CLASSE QUE MOSTRA TODOS OS VEÍCULOS CADASTRADOS
	    }
	});

	buttonLocateGasStation = (Button) findViewById(R.id.buttonLocateGasStation);
	buttonLocateGasStation.setOnClickListener(new OnClickListener() {

	    @Override
	    public void onClick(View v) {
		// startActivity(new Intent());
	    }
	});
    }

    /**
     * Create the menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	MenuInflater inflater = getMenuInflater();
	inflater.inflate(R.menu.main_menu, menu);
	return true;
    }

    /**
     * Set actions of menu's options
     */
    public boolean onOptionsItemSelected(MenuItem item) {
	// Handle item selection
//	String title;
//	String message;
//	Alerts al = new Alerts();
	switch (item.getItemId()) {
	case R.id.exit:
	    finish();
	    return true;

	case R.id.about:
//	    title = getResources().getString(R.string.app_name);
	    // TODO: REFAZER
//	    message = getResources().getString(R.string.about_txt);
//	    al.AlertAbout(this, title, message);
	    return true;
	default:
	    return super.onOptionsItemSelected(item);

	}
    }

}