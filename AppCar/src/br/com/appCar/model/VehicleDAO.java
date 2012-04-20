package br.com.appCar.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import br.com.appCar.modelDatabase.DatabaseDelegate;

public class VehicleDAO {

    private SQLiteDatabase database;
    private DatabaseDelegate dbHelper;

    private static VehicleDAO vehicleDao;
    
    public VehicleDAO(Context context) {
	dbHelper = new DatabaseDelegate(context);
    }

    public static VehicleDAO getInstance(Context applicationContext) {
	if (vehicleDao == null) {
	    vehicleDao = new VehicleDAO(applicationContext);
	}
	return vehicleDao;
    }    
    
    public void open() throws SQLException {
	database = dbHelper.getWritableDatabase();
    }

    public void close() {
	dbHelper.close();
    }

    /**
     * Insert a new vehicle in database
     * 
     * @param Vehicle
     */
    public synchronized long addVehicle(Vehicle vehicle) {
	Long success;
	ContentValues cv = new ContentValues();

	// Open Database
	database = dbHelper.getWritableDatabase();

	cv.put("trademark", vehicle.getBrand());
	cv.put("model", vehicle.getModel());
	cv.put("plate", vehicle.getPlate());
	cv.put("currentKm", vehicle.getCurrentKm());
	cv.put("currentVolume", vehicle.getCurrentVolume());

	success = database.insert(DatabaseDelegate.TBL_VEHICLE, null, cv);

	// Close database
	dbHelper.close();

	return success;
    }

}
