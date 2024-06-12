package fpoly.namdv.asmxuong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import fpoly.namdv.asmxuong.adapters.SpinnerPhongBanAdapter;
import fpoly.namdv.asmxuong.models.NhanVien;
import fpoly.namdv.asmxuong.models.PhongBan;
import fpoly.namdv.asmxuong.screens.PhongBanscreenActivity;

public class SuanhanvienActivity extends AppCompatActivity {
    private String tenpb="";

    private EditText edtMaNv;
    private EditText edtTenNv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.suanhanvien);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtMaNv=findViewById(R.id.edtMaNv);
        edtTenNv=findViewById(R.id.edtTenNv);
        Spinner spnTenPB = findViewById(R.id.spnTenPb);
        Button btnSuaNV=findViewById(R.id.btnSuaNV);
        Button btnTroVe=findViewById(R.id.btnTroVe);

        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuanhanvienActivity.this,NhanvienScreenActivity.class));
            }
        });




        ArrayList<PhongBan> listPB = new PhongBanscreenActivity().getDSPB();
        SpinnerPhongBanAdapter adapter=new SpinnerPhongBanAdapter(SuanhanvienActivity.this, listPB);
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

        //nhaanj duuwex lieu
        Intent intent= getIntent();
        Bundle bundle=intent.getExtras();
        NhanVien nhanVien=(NhanVien) bundle.getSerializable("nhanVienSua");
        int ViTriSua = bundle.getInt("ViTriSua");
        edtMaNv.setText(nhanVien.getManv());
        edtTenNv.setText(nhanVien.getTenvn());

        int viTri = -1;
        for (int i =0 ; i<listPB.size();i++){
            if (listPB.get(i).getTenpb().equals(nhanVien.getTenpb())){
                viTri=i;
                break;
            }
        }
        spnTenPB.setSelection(viTri);

        //chinh sua thong tin
        btnSuaNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mannv=edtMaNv.getText().toString();
                String tennv=edtTenNv.getText().toString();

                NhanVien nhanviensua=new NhanVien(mannv,tennv,tenpb);
                Intent intentSua=new Intent();
                Bundle bundleSua=new Bundle();
                bundleSua.putSerializable("nhanVienSua",nhanviensua);
                bundleSua.putInt("ViTriSua",ViTriSua);
                intentSua.putExtras(bundleSua);
                setResult(2,intentSua);
                finish();
            }
        });
    }
}