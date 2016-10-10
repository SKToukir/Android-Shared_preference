package toukir.best.horoscope.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPass;
    SharedPreferences sharedPreferences;
    public static final String MY_SHARED = "mySharedPreference";
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);

        sharedPreferences = getSharedPreferences(MY_SHARED, Context.MODE_PRIVATE);

        editor = sharedPreferences.edit();

        if (sharedPreferences.contains("userName")){
            String nm = sharedPreferences.getString("userName","null");
            etName.setText(nm);
        }
    }

    public void btnRegister(View view) {

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPass.getText().toString();

        editor.putString("userName",name);
        editor.putString("userEmail",email);
        editor.putString("userPass", password);
        editor.commit();
        Toast.makeText(getApplicationContext(),"saved",Toast.LENGTH_LONG).show();
    }
}
