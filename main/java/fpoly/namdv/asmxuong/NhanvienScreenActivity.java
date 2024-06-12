package fpoly.namdv.asmxuong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import fpoly.namdv.asmxuong.adapters.NhanVienAdepter;
import fpoly.namdv.asmxuong.models.NhanVien;

public class NhanvienScreenActivity extends AppCompatActivity {
    private ArrayList<NhanVien>listNV;
    private  ListView lvNhanVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.nhanvien);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //anhxa
        Button btnthemNV = findViewById(R.id.btnhemNV);
        lvNhanVien=findViewById(R.id.lvNhanVien);

        //data
        listNV = new ArrayList<>();
        listNV.add(new NhanVien("PH 53698","Đỗ Văn Nam","Nhân Sự"));
        listNV.add(new NhanVien("GC 74628","Hạ Viết Hải","Hành Chính"));
        listNV.add(new NhanVien("LV 43235","Phùng Duy Việt","Đào Tạo"));
        listNV.add(new NhanVien("NV 73523","Lại Duy Anh","Nhân  Sự"));

        //adapter
        loadData();


        btnthemNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NhanvienScreenActivity.this, ThemnvActivity.class);
                myLauncher.launch(intent);
            }
        });
    }

    private void loadData(){
        NhanVienAdepter adepter=new NhanVienAdepter(NhanvienScreenActivity.this,listNV,myLauncher);
        lvNhanVien.setAdapter(adepter);
    }
    private  ActivityResultLauncher<Intent> myLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode()==1){
                                Intent intent=result.getData();
                                Bundle bundle=intent.getExtras();
                                NhanVien nhanvienMoi=(NhanVien) bundle.getSerializable("nhanvienMoi");
                                listNV.add(nhanvienMoi);
                                loadData();
                            }

                            if (result.getResultCode()==2){
                                Intent intent=result.getData();
                                Bundle bundle = intent.getExtras();
                                NhanVien nhanvienSua=(NhanVien) bundle.getSerializable("nhanVienSua");
                                int ViTriSua = bundle.getInt("ViTriSua");
                                listNV.set(ViTriSua,nhanvienSua);
                                loadData();
                            }

                        }
                    });
}