package fpoly.namdv.asmxuong.screens;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import fpoly.namdv.asmxuong.R;

public class SignupscreensActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.signupscreens);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //anh xa
        TextInputEditText edtUser=findViewById(R.id.edtUser);
        TextInputLayout txtUser=findViewById(R.id.txtUser);
        TextInputEditText edtPass= findViewById(R.id.edtPass);
        TextInputLayout txtPass= findViewById(R.id.txtPass);
        TextInputEditText edtRePass=findViewById(R.id.edtRePass);
        TextInputLayout txtRePass=findViewById(R.id.txtRePass);
        Button btnBack=findViewById(R.id.btnBack);
        Button btnRegister= findViewById(R.id.btnRegister);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignupscreensActivity.this, "Hủy Đăng Kí", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignupscreensActivity.this,LogincreensActivity.class));
            }
        });


        edtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0){
                    txtUser.setError("Vui lòng nhập Username");
                }else {
                    txtUser.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()==0){
                    txtPass.setError("Vui lòng nhập passwork");
                }else{
                    txtPass.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtRePass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()==0){
                    txtRePass.setError("Vui lòng nhập lại passwork");
                }else {
                    txtRePass.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();
                String rePass = edtRePass.getText().toString();


                if (user.equals("") || pass.equals("") || rePass.equals("")){
//                    Toast.makeText(SignupscreensActivity.this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();

                    if (user.equals("")){
                        txtUser.setError("Vui lòng nhập user name");
                    }else{
                        txtUser.setError(null);
                    }

                    if (pass.equals("")){
                        txtPass.setError("Vui lòng nhập passwork");
                    }else{
                        txtPass.setError(null);
                    }

                    if (rePass.equals("")){
                        txtRePass.setError("Vui lòng nhập lại passwork");
                    }else {
                        txtRePass.setError(null);
                    }
                }else if(!pass.equals(rePass)){
                    Toast.makeText(SignupscreensActivity.this, "Nhập mật khẩu không trung ", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent();
                    intent.putExtra("user",user);
                    intent.putExtra("pass",pass);
                    setResult(1,intent);
                    finish();
                }
            }
        });
    }
}