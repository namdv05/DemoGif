package fpoly.namdv.asmxuong;

import static fpoly.namdv.asmxuong.R.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import fpoly.namdv.asmxuong.adapters.NhanVienAdepter;
import fpoly.namdv.asmxuong.adapters.SpinnerPhongBanAdapter;
import fpoly.namdv.asmxuong.models.NhanVien;
import fpoly.namdv.asmxuong.models.PhongBan;
import fpoly.namdv.asmxuong.screens.PhongBanscreenActivity;

public class ThemnvActivity extends AppCompatActivity {

    private String tenpb="";

    private EditText edtMaNv;
    private EditText edtTenNv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(layout.themnv);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtMaNv=findViewById(R.id.edtMaNv);
        edtTenNv=findViewById(id.edtTenNv);
        Spinner spnTenPB = findViewById(id.spnTenPb);
        Button btnThemNV=findViewById(id.btnThemNV);
        Button btnTroVe=findViewById(id.btnTroVe);

        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThemnvActivity.this,NhanvienScreenActivity.class));
            }
        });



        ArrayList<PhongBan> listPB = new PhongBanscreenActivity().getDSPB();
        SpinnerPhongBanAdapter adapter=new SpinnerPhongBanAdapter(ThemnvActivity.this, listPB);
        spnTenPB.setAdapter(adapter);

        spnTenPB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(ThemnvActivity.this, listPB.get(position).getTenpb(), Toast.LENGTH_SHORT).show();
                tenpb = listPB.get(position).getTenpb();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnThemNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String manv = edtMaNv.getText().toString();
                String tennv = edtTenNv.getText().toString();

                NhanVien nhanvienMoi = new NhanVien(manv,tennv,tenpb);
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                bundle.putSerializable("nhanvienMoi",nhanvienMoi);
                intent.putExtras(bundle);
                setResult(1,intent);
                finish();
            }
        });



    }
}