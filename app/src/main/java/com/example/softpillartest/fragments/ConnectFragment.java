package com.example.softpillartest.fragments;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.softpillartest.R;
import com.example.softpillartest.adapter.ListAdapterV;
import com.example.softpillartest.database.DataSourceProject;
import com.example.softpillartest.model.Project;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class ConnectFragment extends Fragment implements View.OnClickListener{
    View view;
    private ArrayList<Project> projectArrayList = new ArrayList<>();
    private DataSourceProject dataSourceProject;
    SharedPreferences prefs = null;
    private ListView lv_Project;
    private ListAdapterV listAdapterv;
    private TextView tv_Leads,tv_Distributor,tv_Retailers;
    public ConnectFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_connect, container, false);

        dataSourceProject = DataSourceProject.getInstance(getActivity());
        lv_Project = (ListView)view.findViewById(R.id.lv_Project);
        tv_Leads= view.findViewById(R.id.tv_Leads);
        tv_Distributor= view.findViewById(R.id.tv_Distributor);
        tv_Retailers= view.findViewById(R.id.tv_Retailers);
        tv_Leads.setOnClickListener(this);
        tv_Distributor.setOnClickListener(this);
        tv_Retailers.setOnClickListener(this);
        lv_Project.setFastScrollEnabled(true);
        prefs = getActivity().getSharedPreferences("com.example.softpillartest", MODE_PRIVATE);
        if (prefs.getBoolean("firstrun", true)) {
            insertData();
            prefs.edit().putBoolean("firstrun", false).commit();
        }
        dataSourceProject.open();
        projectArrayList = dataSourceProject.getRecords();
        dataSourceProject.close();
        setAdapter();

        return view;
    }

    private void setAdapter() {
        listAdapterv = new ListAdapterV(getActivity(),projectArrayList);
        lv_Project.setAdapter(listAdapterv);
        listAdapterv.notifyDataSetChanged();
    }

    private void insertData() {

        dataSourceProject.open();
        dataSourceProject.insert(new Project("1","Farah Baria","Hindustan Feed,India","Demo","Leads","8 Feb,2021"));
        dataSourceProject.insert(new Project("2","Abbas Rav Chavla","Hari Inc,Iran","Demo","Leads","9 Feb,2021"));
        dataSourceProject.insert(new Project("3","Nandini Chad","Hind Traders,India","Demo","Leads","10 Feb,2021"));
        dataSourceProject.insert(new Project("4","Kajol Sibal","Herry Ltd,India","Demo","Leads","11 Feb,2021"));
        dataSourceProject.insert(new Project("5","Farah Baria Test","Hindustan Feed,India T","Test","Distributors","12 Feb,2021"));
        dataSourceProject.insert(new Project("6","Abbas Rav Chavla Test","Hari Inc,Iran T","Test","Distributors","11 Feb,2021"));
        dataSourceProject.insert(new Project("7","Nandini Chad Test","Hind Traders,India T","Test","Retailer","12 Feb,2021"));
        dataSourceProject.insert(new Project("8","Kajol Sibal Test","Herry Ltd,India T","Test","Retailer","3 Feb,2021"));

        dataSourceProject.close();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.tv_Leads:
                tv_Leads.setBackgroundResource(R.drawable.texviewshape1);
                tv_Leads.setTextColor(Color.parseColor("#FFFFFF"));
                tv_Distributor.setBackgroundResource(R.drawable.texviewshape);
                tv_Distributor.setTextColor(Color.parseColor("#000000"));
                tv_Retailers.setBackgroundResource(R.drawable.texviewshape);
                tv_Retailers.setTextColor(Color.parseColor("#000000"));
                projectArrayList.clear();
                dataSourceProject.open();
                projectArrayList = dataSourceProject.getRecordsByCategory("Leads");
                dataSourceProject.close();
                setAdapter();
                break;

            case R.id.tv_Distributor:
                tv_Leads.setBackgroundResource(R.drawable.texviewshape);
                tv_Leads.setTextColor(Color.parseColor("#000000"));
                tv_Distributor.setBackgroundResource(R.drawable.texviewshape1);
                tv_Distributor.setTextColor(Color.parseColor("#FFFFFF"));
                tv_Retailers.setBackgroundResource(R.drawable.texviewshape);
                tv_Retailers.setTextColor(Color.parseColor("#000000"));
                projectArrayList.clear();
                dataSourceProject.open();
                projectArrayList = dataSourceProject.getRecordsByCategory("Retailer");
                dataSourceProject.close();
                setAdapter();
                break;

            case R.id.tv_Retailers:
                tv_Leads.setBackgroundResource(R.drawable.texviewshape);
                tv_Leads.setTextColor(Color.parseColor("#000000"));
                tv_Distributor.setBackgroundResource(R.drawable.texviewshape);
                tv_Distributor.setTextColor(Color.parseColor("#000000"));
                tv_Retailers.setBackgroundResource(R.drawable.texviewshape1);
                tv_Retailers.setTextColor(Color.parseColor("#FFFFFF"));
                projectArrayList.clear();
                dataSourceProject.open();
                projectArrayList = dataSourceProject.getRecordsByCategory("Distributors");
                dataSourceProject.close();
                setAdapter();
                break;
        }
    }
}