package br.com.appCar.modelDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import br.com.appCar.model.Vehicle;
import br.com.appCar.model.VehicleDAO;

public class DatabaseDelegate extends SQLiteOpenHelper {

    /** Hold the Database's name */
    private static final String DB_NAME = "AppCar";

    /** Hold the Database's version */
    private static final int DB_VERSION = 1;

    /** Hold the table's name */
    public static final String TBL_VEHICLE = "Vehicle";
    public static final String VEHICLE_ID = "_id";
    public static final String VEHICLE_PLATE = "plate";
    public static final String VEHICLE_TRADEMARK = "trademark";
    public static final String VEHICLE_MODEL = "model";
    public static final String VEHICLE_CUR_VOLUME = "current_volume";
    public static final String VEHICLE_CUR_KM = "current_km";

    // private static final String TBL_VEHICLE = "Fuel";
    // public static final String VEHICLE_ID = "_id";
    // public static final String VEHICLE_PLATE = "plate";
    // public static final String VEHICLE_TRADEMARK = "trademark";
    // public static final String VEHICLE_MODEL = "model";
    // public static final String VEHICLE_CUR_VOLUME = "current_volume";
    // public static final String VEHICLE_CUR_KM = "current_km";

    /** Hold the script to create the database */
    private static final String CREATE_VEHICLE = "create table " + TBL_VEHICLE
	    + "( " + VEHICLE_ID + " integer primary key autoincrement, "
	    + VEHICLE_PLATE + " text not null, " + VEHICLE_TRADEMARK
	    + " text not null, " + VEHICLE_MODEL + " text not null, "
	    + VEHICLE_CUR_VOLUME + " integer not null, " + VEHICLE_CUR_KM
	    + " integer not null);";

    // private static final String CREATE_FUEL = "create table " + TBL_VEHICLE
    // + "( " + VEHICLE_ID + " integer primary key autoincrement, "
    // + VEHICLE_PLATE + " text not null, " + VEHICLE_TRADEMARK
    // + " text not null, " + VEHICLE_MODEL + " text not null, "
    // + VEHICLE_CUR_VOLUME + " integer not null, " + VEHICLE_CUR_KM
    // + " integer not null);";

    /** Hold the script to delete the database */
    private static final String DROP_VEHICLE = "DROP TABLE IF EXISTS "
	    + TBL_VEHICLE;

    // private static final String DROP_FUEL = "DROP TABLE IF EXISTS "
    // + TBL_VEHICLE;

    /** Static instance to connect to database */
    private static DatabaseDelegate mDatabaseDelegate;

    public DatabaseDelegate(Context context) {
	super(context, DB_NAME, null, DB_VERSION);
    }

    /**
     * Get a instance of database
     * 
     * @param Context
     */
    public static DatabaseDelegate getInstance(Context applicationContext) {
	if (mDatabaseDelegate == null) {
	    mDatabaseDelegate = new DatabaseDelegate(applicationContext);
	}
	return mDatabaseDelegate;
    }

    public void onCreate(SQLiteDatabase database) {
	database.execSQL(CREATE_VEHICLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	Log.d("log", "upgrading DB");
	db.execSQL(DROP_VEHICLE);
	onCreate(db);

    }
    
    /**
     * Just send the vehicle to DataBase
     */
    public boolean sendVehicleToDB(Vehicle vh) {
	boolean statusSend = false;

	VehicleDAO vhDao = VehicleDAO.getInstance(null);
        if (vhDao.addVehicle(vh) > 0) {
            statusSend = true; 
        }
        
        return statusSend;
    }    

}
