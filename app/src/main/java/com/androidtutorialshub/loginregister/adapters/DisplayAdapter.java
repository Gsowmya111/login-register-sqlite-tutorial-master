package com.androidtutorialshub.loginregister.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.androidtutorialshub.loginregister.R;

import java.util.ArrayList;

public class DisplayAdapter extends BaseAdapter {
    private Context mContext;
    //list fields to be displayed
    private ArrayList<String> stafid;
    private ArrayList<String> nama;
    private ArrayList<String> jbt;
    private ArrayList<String> gen;
    private ArrayList<String> hob;



    public DisplayAdapter(Context c, ArrayList<String> gender, ArrayList<String> hobies, ArrayList<String> stafid, ArrayList<String> nama, ArrayList<String> jbt) {
        this.mContext = c;
        //transfer content from database to temporary memory
        this.gen=gender;
        this.hob=hobies;
        this.stafid = stafid;
        this.nama = nama;
        this.jbt = jbt;

    }

    public int getCount() {
        // TODO Auto-generated method stub
        return stafid.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public View getView(int pos, View child, ViewGroup parent) {
        Holder mHolder;
        LayoutInflater layoutInflater;
        if (child == null) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.listcell, null);
            mHolder = new Holder();

            //link to TextView
            mHolder.txtstafid = (TextView) child.findViewById(R.id.txtstafid);
            mHolder.txtnama = (TextView) child.findViewById(R.id.txtnama);
            mHolder.txtjbt = (TextView) child.findViewById(R.id.txtjbt);
            mHolder.gendr = (TextView) child.findViewById(R.id.txtgendr);
            mHolder.hobe = (TextView) child.findViewById(R.id.txthob);
            child.setTag(mHolder);
        } else {
            mHolder = (Holder) child.getTag();
        }
        //transfer to TextView in screen
        mHolder.txtstafid.setText(stafid.get(pos));
        mHolder.txtnama.setText(nama.get(pos));
        mHolder.txtjbt.setText(jbt.get(pos));
        mHolder.gendr.setText(gen.get(pos));
        mHolder.hobe.setText(hob.get(pos));


        return child;
    }

    public class Holder {
        TextView txtstafid;
        TextView txtnama;
        TextView txtjbt;
        TextView gendr;
        TextView hobe;
    }

}