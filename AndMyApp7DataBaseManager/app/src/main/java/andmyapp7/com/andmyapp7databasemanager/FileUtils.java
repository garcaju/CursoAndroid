package andmyapp7.com.andmyapp7databasemanager;

//Guarda datos en memoria interna
//Guarda datos en memoria externa
//Cargar datos en memoria interna & externa

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {

    public boolean saveInternalMemory(Context context, String textoAGuardar) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput
                    (ConstantUtils.INTERNAL_MEMORY_FILE, Context.MODE_PRIVATE);
            fileOutputStream.write(textoAGuardar.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            if (BuildConfig.DEBUG)
                e.printStackTrace();
            return false;
            //Feedback al usuario en caso de error
        }
        return true;
    }

    public boolean saveExternalMemory(Context context, String textoAGuardar) throws FileNotFoundException {
        //Check

        //File = path memoria externa + mi directorio
        File myExternalFolder =
                new File(context.getExternalFilesDir(null), "newDirectory/newSubDirectory");
        //Consulta si directiorio ya existe
        //false --> crea directorio
        if (myExternalFolder.exists() == false) {
            myExternalFolder.mkdir();
            Log.i(FileUtils.class.getSimpleName(), "-> Path = " + myExternalFolder.mkdirs());

        }
        Log.i(FileUtils.class.getSimpleName(), "-> Path = " + myExternalFolder.getAbsolutePath());
        File myFile = new File(myExternalFolder.getAbsolutePath() + "/" + ConstantUtils.EXTERNAL_MEMORY_FILE);
        FileOutputStream fileOutputStream = new FileOutputStream(myFile.getAbsolutePath().toString());
        try {
            fileOutputStream.write(textoAGuardar.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public String loadInternalMemory() {
        //TODO implementar loadInternalMemory
        return null;
    }

    public String loadExternalMemory() {
        //TODO implementar loadExternalMemory
        return null;
    }

}
