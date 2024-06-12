package fpoly.namdv.asmxuong.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;

import java.util.ArrayList;

import fpoly.namdv.asmxuong.R;
import fpoly.namdv.asmxuong.SuanhanvienActivity;
import fpoly.namdv.asmxuong.models.NhanVien;

public class NhanVienAdepter extends BaseAdapter {

    private Context context;
    private ArrayList<NhanVien>listNV;

    private ActivityResultLauncher<Intent> myLauncher;

    public NhanVienAdepter(Context context, ArrayList<NhanVien> listNV, ActivityResultLauncher<Intent> myLauncher) {
        this.context = context;
        this.listNV = listNV;
        this.myLauncher = myLauncher;
    }

    @Override
    public int getCount() {
        return listNV.size();
    }

    @Override
    public Object getItem(int position) {
        return listNV.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View view=inflater.inflate(R.layout.item_nhanvien, parent,false);

        TextView txtManv = view.findViewById(R.id.txtManv);
        TextView txtTennv =view.findViewById(R.id.txtTennv);
        TextView txtTenpb = view.findViewById(R.id.txtTenpb);
        ImageView ivedit=view.findViewById(R.id.ivedit);
        ImageView ivDel=view.findViewById(R.id.ivdel);

        ivedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SuanhanvienActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable(("nhanVienSua"),listNV.get(position));
                bundle.putInt("ViTriSua",position);
                intent.putExtras(bundle);
                myLauncher.launch(intent);
            }
        });

        ivDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               listNV.remove(position);
               notifyDataSetChanged();
            }
        });


        txtManv.setText(listNV.get(position).getManv());
        txtTennv.setText(listNV.get(position).getTenvn());
        txtTenpb.setText(listNV.get(position).getTenpb());


        return view;
    }
}
