package andmyapp7.com.andmyapp7databasemanager;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DataBaseManager {

    public void insertData(Context context, String nombre, String apellidos,
                           int spinnerSelection, int checkBoxState, String foto){

        MyDataBase db = new MyDataBase(context);
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        String query = ConstantUtils.MY_DATABASE_INSERT_DATA;
        Log.i(DataBaseManager.class.getSimpleName(), "-> query replacing...= " + query);
        query = query.replace("%1", nombre);
        query = query.replace("%2", apellidos);
        query = query.replace("%3", foto);
        query = query.replace("%4", String.valueOf(spinnerSelection));
        query = query.replace("%5", String.valueOf(checkBoxState));
        Log.i(DataBaseManager.class.getSimpleName(), "-> query replaced! = " + query);
        sqLiteDatabase.execSQL(query);
    }

    public Cursor getPassport(Context context){
        MyDataBase db = new MyDataBase(context);
        SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " +
                                                ConstantUtils.PASSPORT_TABLE_NAME, null);
        //sqLiteDatabase.close();
        return cursor;
    }

    // Hacer consulta buscando el nombre
    /*public Cursor getPassportByname(Context context, String name){
        MyDataBase db = new MyDataBase(context);
        SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " +
                                                ConstantUtils.PASSPORT_TABLE_NAME
                                                + " WHERE " + ConstantUtils.COLUMN_NAME + " = '"
                                                + name + "'",null);
        return cursor;
    }*/
}
