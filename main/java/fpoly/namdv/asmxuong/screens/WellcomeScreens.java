package fpoly.namdv.asmxuong.screens;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import fpoly.namdv.asmxuong.R;

public class WellcomeScreens extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.wellcomescreens);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        CountDownTimer start = new CountDownTimer(3000, 3000) {

            @Override
            public void onTick(long millisUntilFinished) {
                // xử lý hành động trc khi kết thúc
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(WellcomeScreens.this, LogincreensActivity.class);
                startActivity(intent);
            }
        }.start();

    }
}