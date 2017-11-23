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
    public static final String MY_DATA_BASE_CREATE_TABLE =
            "CREATE TABLE Passport " +
                    "(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "Nombre TEXT," +
                    "Apellidos TEXT," +
                    "Foto TEXT," +
                    "SpinnerSelection INTEGER," +
                    "CheckBoxState INTEGER);"; //TODO NO existe boolean en SQLite
}
