package andmyapp7.com.andmyapp7databasemanager;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FileUtils fileUtils = null;
    private EditText txtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
        fileUtils = new FileUtils();
    }

    private void initLayout() {
        //Llamamos a los botonesId del XML
        Button btnSaveInternMemory = findViewById(R.id.btnInterMemo);
        Button btnSaveExternMemory = findViewById(R.id.btnExternMemo);
        Button btnDataBase = findViewById(R.id.btnInsertDb);
        Button btnQuery = findViewById(R.id.btnQueryDb);
        //Seteamos los botones
        btnSaveInternMemory.setOnClickListener(this);
        btnSaveExternMemory.setOnClickListener(this);
        btnDataBase.setOnClickListener(this);
        btnQuery.setOnClickListener(this);

        txtText = findViewById(R.id.txtText);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInterMemo:
                if (fileUtils != null) {
                    String texto = txtText.getText().toString();
                    fileUtils.saveInternalMemory(this, texto);
                }
                break;
            case R.id.btnExternMemo:
                String texto = txtText.getText().toString();
                try {
                    fileUtils.saveExternalMemory(this, texto);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnInsertDb:
                DataBaseManager dataBaseManager = new DataBaseManager();
                dataBaseManager.insertData(this, "Juan", "Garcia",
                        4, 1, "foto.jpg");
                break;

            case R.id.btnQueryDb:
                Cursor cursor = new DataBaseManager().getPassport(this);
                //Cursor cursor = new DataBaseManager().getPassportByname(this, "namePassport");
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    for (int i = 0; i < cursor.getCount(); i++) {
                        Log.i(MainActivity.class.getSimpleName(),
                                "-> Passport nº" + i + "\n" +
                                        "- Nombre: " + cursor.getString(ConstantUtils.COLUMN_NAME_INDEX) + "\n" +
                                        "- Apellidos: " + cursor.getString(ConstantUtils.COLUMN_APELLIDOS_INDEX) + "\n" +
                                        "- SpinnerSelection: " + cursor.getInt(ConstantUtils.COLUMN_SPINNER_SELECTION_INDEX) + "\n" +
                                        "- CheckBoxStatus: " + cursor.getInt(ConstantUtils.COLUMN_CHECKBOX_INDEX) + "\n" +
                                        "- Foto: " + cursor.getString(ConstantUtils.COLUMN_FOTO_INDEX) + "\n\n");
                        cursor.moveToNext();
                    }
                    cursor.close();
                }else{
                    Log.d(MainActivity.class.getSimpleName(), "-> No Data!");
                }
                break;

        }
    }
}
