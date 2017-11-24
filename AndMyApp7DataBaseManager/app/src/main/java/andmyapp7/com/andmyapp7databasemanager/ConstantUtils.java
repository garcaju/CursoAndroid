package andmyapp7.com.andmyapp7databasemanager;

/**
 * Created by A8Alumno on 23/11/2017.
 */

public class ConstantUtils {
    public static final String INTERNAL_MEMORY_FILE = "internalMemoryFile.txt";
    public static final String EXTERNAL_MEMORY_FILE = "externalMemoryFile.txt";
    public static final String EXTERNAL_MEMORY_DIRECTORY = "NewDirectory/Subdirectory";
    public static final String MY_DATA_BASE = "MyDataBase";
    public static final int MY_DATA_VERSION = 1;

    public static final String PASSPORT_TABLE_NAME = "Passport";
    public static final String COLUMN_NAME = "Nombre";
    public static final String COLUMN_APELLIDOS = "Apellidos";
    public static final String COLUMN_FOTO = "Foto";
    public static final String COLUMN_SPINNER_SELECTION = "SpinnerSelection";
    public static final String COLUMN_CHECKBOX = "CheckBoxState";
    
    public static final String MY_DATA_BASE_CREATE_TABLE =
            "CREATE TABLE " + PASSPORT_TABLE_NAME +
                    "(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    COLUMN_NAME + "TEXT," +
                    COLUMN_APELLIDOS + "TEXT," +
                    COLUMN_FOTO + "TEXT," +
                    COLUMN_SPINNER_SELECTION + "INTEGER," +
                    COLUMN_CHECKBOX + "INTEGER);"; //TODO NO existe boolean en SQLite

}
