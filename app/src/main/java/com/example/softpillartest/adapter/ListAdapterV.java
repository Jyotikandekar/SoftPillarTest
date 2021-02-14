package com.example.softpillartest.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.example.softpillartest.R;
import com.example.softpillartest.model.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ListAdapterV extends BaseAdapter implements SectionIndexer {

    String[] sections;
    ArrayList<Project> projectArrayList;
    List<String> sectionLetters=new ArrayList<String>();
    Context context;

    public ListAdapterV(Context context, ArrayList<Project> CatList) {
        this.context = context;
        this.projectArrayList = CatList;

        for (int x = 0; x < projectArrayList.size(); x++) {
            String fruit = projectArrayList.get(x).compony_name;
            String ch = fruit.charAt(0)+"";
            ch = ch.toUpperCase(Locale.US);

            sectionLetters.add(ch);
        }

        ArrayList<String> sectionList = new ArrayList<String>(sectionLetters);

        sections = new String[sectionList.size()];

        sectionList.toArray(sections);
    }

    @Override
    public int getCount() {
        return projectArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return projectArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = null;

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = mInflater.inflate(R.layout.item_list, null);

            TextView tv_shortName = convertView.findViewById(R.id.tv_shortName);
            TextView tv_Stage = convertView.findViewById(R.id.tv_Stage);
            TextView tv_Compony_name = convertView.findViewById(R.id.tv_Compony_name);
            TextView tv_Client_Name = convertView.findViewById(R.id.tv_Client_Name);
            TextView tv_Date = convertView.findViewById(R.id.tv_Date);

            Random r = new Random();
            int red=r.nextInt(255 - 0 + 1)+0;
            int green=r.nextInt(255 - 0 + 1)+0;
            int blue=r.nextInt(255 - 0 + 1)+0;

            GradientDrawable draw = new GradientDrawable();
            draw.setShape(GradientDrawable.OVAL);
            draw.setColor(Color.rgb(red,green,blue));
            tv_shortName.setBackground(draw);

            System.out.println("data : "+projectArrayList.get(position).getCompony_name());
            String s1 = projectArrayList.get(position).getCompony_name().trim();
            tv_shortName.setText(String.valueOf(s1.charAt(0)));
            tv_Stage.setText(projectArrayList.get(position).getProject_stage());
            tv_Compony_name.setText(projectArrayList.get(position).getCompony_name());
            tv_Client_Name.setText(projectArrayList.get(position).getClient_name());
            tv_Date.setText(projectArrayList.get(position).getProject_date());


        }
        return convertView;
    }

    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return 0;
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }
}
