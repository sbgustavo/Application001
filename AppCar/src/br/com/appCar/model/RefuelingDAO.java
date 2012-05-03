package br.com.appCar.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import br.com.appCar.modelDatabase.SQLiteHelper;

public class RefuelingDAO {

    private static RefuelingDAO mRefuelingDAO;
    
    /** Hold an instance of SQLiteHelper */
    private SQLiteHelper mDatabaseHelper;

    /** Hold the data base while open */
    private SQLiteDatabase mDataBase;    
    
    // TODO: CRIAR COLUNAS DA TABELA E REFAZER SCRIPT DE CRIAÇÃO DA TABELA
    private static final String TBL_REFUELING = "Refueling";
    public static final String REFUELING_ID = "_id";
    public static final String VEHICLE_PLATE = "plate";
    public static final String VEHICLE_TRADEMARK = "trademark";
    public static final String VEHICLE_MODEL = "model";
    public static final String VEHICLE_CUR_VOLUME = "current_volume";
    public static final String VEHICLE_CUR_KM = "current_km";

    private static final String CREATE_FUEL = "create table " + TBL_REFUELING
	    + "( " + REFUELING_ID + " integer primary key autoincrement, "
	    + VEHICLE_PLATE + " text not null, " + VEHICLE_TRADEMARK
	    + " text not null, " + VEHICLE_MODEL + " text not null, "
	    + VEHICLE_CUR_VOLUME + " integer not null, " + VEHICLE_CUR_KM
	    + " integer not null);";

    private static final String DROP_FUEL = "DROP TABLE IF EXISTS " + TBL_REFUELING;
    
    public RefuelingDAO(Context context) {
	mDatabaseHelper = new SQLiteHelper(context, CREATE_FUEL, DROP_FUEL);
    }
    
    /**
     * Get a instance of database
     * 
     * @param Context
     */
    public static RefuelingDAO getInstance(Context applicationContext) {
	if (mRefuelingDAO == null) {
	    mRefuelingDAO = new RefuelingDAO(applicationContext);
	}
	return mRefuelingDAO;
    }
    
    /**
     * Insert a new refueling in database
     * 
     * @param Refueling
     */
    public synchronized long addVehicle(Refueling refueling) {
	Long success;
	ContentValues cv = new ContentValues();

	// Open Database
	mDataBase = mDatabaseHelper.getWritableDatabase();

//	cv.put(, );
//	cv.put(, );
//	cv.put(, );
//	cv.put(, );
//	cv.put(, );

	success = mDataBase.insert(TBL_REFUELING, null, cv);

	// Close database
	mDatabaseHelper.close();

	return success;
    }      

}
