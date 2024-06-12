package fpoly.namdv.asmxuong.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import fpoly.namdv.asmxuong.models.PhongBan;

public class SpinnerPhongBanAdapter extends BaseAdapter  {

    private Context context;
    private ArrayList<PhongBan>listPB;

    public SpinnerPhongBanAdapter(Context context, ArrayList<PhongBan> listPB) {
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
        View view=inflater.inflate(android.R.layout.simple_list_item_1, parent,false);

        TextView txtTenPB= view.findViewById(android.R.id.text1);
        txtTenPB.setText(listPB.get(position).getTenpb());
        return view;
    }
}

