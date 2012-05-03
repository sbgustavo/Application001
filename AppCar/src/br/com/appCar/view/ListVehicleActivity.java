package br.com.appCar.view;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.Toast;
import br.com.appCar.adapter.ListVehicleAdapter;
import br.com.appCar.model.Vehicle;
import br.com.appCar.model.VehicleDAO;

public class ListVehicleActivity extends ListActivity {

    private VehicleDAO vehicleDAO;

    private ArrayList<Vehicle> mVehicles;

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	vehicleDAO = VehicleDAO.getInstance(getApplicationContext());

	atualizarLista();
    }

    private void atualizarLista() {

	try {
	    mVehicles = vehicleDAO.readAll();
	} catch (Exception e) {
	    Toast.makeText(this, "Erro ao ler o banco de dados",
		    Toast.LENGTH_SHORT).show();
	}

	if (mVehicles.size() > 0) {
	    setListAdapter(new ListVehicleAdapter(this, mVehicles));
	} else {
	    Toast.makeText(this, "Não há nenhum veículo cadastrado!",
		    Toast.LENGTH_SHORT).show();
	}
    }
}
