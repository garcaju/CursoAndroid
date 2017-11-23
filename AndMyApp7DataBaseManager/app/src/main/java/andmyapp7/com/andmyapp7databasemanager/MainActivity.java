package andmyapp7.com.andmyapp7databasemanager;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        Button btnDataBase = findViewById(R.id.btnDb);
        //Seteamos los botones
        btnSaveInternMemory.setOnClickListener(this);
        btnSaveExternMemory.setOnClickListener(this);
        btnDataBase.setOnClickListener(this);

        txtText = findViewById(R.id.txtText);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInterMemo:
                if (fileUtils!= null){
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
            case R.id.btnDb:
                MyDataBase db = new MyDataBase(this);
                SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();
                break;
        }
    }
}
