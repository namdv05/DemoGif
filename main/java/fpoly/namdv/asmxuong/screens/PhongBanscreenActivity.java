package fpoly.namdv.asmxuong.screens;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import fpoly.namdv.asmxuong.R;
import fpoly.namdv.asmxuong.adapters.PhongBanAdapter;
import fpoly.namdv.asmxuong.models.PhongBan;

public class PhongBanscreenActivity extends AppCompatActivity {

    private  ListView lvPhongBan;
    private ArrayList<PhongBan>listPB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.phongbanscreen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        



        //giao dien
            //giao dien chua listview-ok
        ListView lvPhongBan=findViewById(R.id.lvPhongBan);
            //giao dien tung item hien thi len listview-ok


        //data


        //adapter

        PhongBanAdapter adapter=new PhongBanAdapter(PhongBanscreenActivity.this,getDSPB());
        lvPhongBan.setAdapter(adapter);
    }

    public ArrayList<PhongBan> getDSPB(){
        listPB=new ArrayList<>();
        listPB.add(new PhongBan("PB01","Nhân Sự"));
        listPB.add(new PhongBan("PB03","Hành Chính"));
        listPB.add(new PhongBan("PB02","Đào Tạo"));

        return listPB;
    }

}