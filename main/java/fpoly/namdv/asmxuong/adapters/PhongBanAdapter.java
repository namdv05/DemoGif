package fpoly.namdv.asmxuong.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import fpoly.namdv.asmxuong.R;
import fpoly.namdv.asmxuong.models.PhongBan;

public class PhongBanAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<PhongBan> listPB;


    public PhongBanAdapter(Context context, ArrayList<PhongBan> listPB) {
        this.context = context;
        this.listPB = listPB;
    }

    @Override
    public int getCount() {
        return listPB.size();
    }

    @Override
    public Object getItem(int position) {
        return listPB.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View view=inflater.inflate(R.layout.itemphongban,parent,false);
        TextView txttenPB=view.findViewById(R.id.txttenPB);
        String data=listPB.get(position).getMapb()+ " - " + listPB.get(position).getTenpb();
        txttenPB.setText(data);
        return view;
    }
}
