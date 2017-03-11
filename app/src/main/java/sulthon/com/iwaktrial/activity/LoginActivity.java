package sulthon.com.iwaktrial.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import sulthon.com.iwaktrial.R;

public class LoginActivity extends AppCompatActivity {

    EditText textEmail, textPassword;
    TextView forgotPassword;
    Button btnLogin;

    String savedEmail = "petani@iwak.me";
    String savedPassword = "petani";
    String inputEmail, inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textEmail = (EditText) findViewById(R.id.et_email);
        textPassword = (EditText) findViewById(R.id.et_password);

        forgotPassword = (TextView) findViewById(R.id.tv_forgotPassword);

        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               inputEmail = textEmail.getText().toString();
                inputPassword = textPassword.getText().toString();

                if ((inputEmail.length() > 0) && (inputPassword.length() > 0)) {
                    if (inputEmail.matches(savedEmail) && inputPassword.matches(savedPassword)) {
                        Toast.makeText(getApplicationContext(), "Selamat Anda Berhasil Masuk", Toast.LENGTH_LONG)
                                .show();

                        Intent toHome = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(toHome);
                  } else {
                        Toast.makeText(getApplicationContext(), "Email atau Password Anda Salah", Toast.LENGTH_SHORT)
                                .show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Email & Username harus dimasukan",Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "'Email: petani@iwak.me', 'password:petani'",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
