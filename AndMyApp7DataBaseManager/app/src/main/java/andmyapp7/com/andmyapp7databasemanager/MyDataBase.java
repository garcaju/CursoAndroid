package andmyapp7.com.andmyapp7databasemanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by A8Alumno on 23/11/2017.
 */

public class MyDataBase extends SQLiteOpenHelper {
    public MyDataBase(Context context) {
        super(context, ConstantUtils.MY_DATA_BASE, null, ConstantUtils.MY_DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ConstantUtils.MY_DATA_BASE_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
