package com.example.quixoteinternshiptask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
public class NoteAdapter extends ArrayAdapter {
    List<Notetype> userDataInfo = new ArrayList<Notetype>();
    public NoteAdapter(@NonNull Context context, List<Notetype> userDataInfo) {
        super(context, R.layout.item_note, userDataInfo);
        this.userDataInfo = userDataInfo;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.item_note,parent,false);

        TextView title = row.findViewById(R.id.title1);
        TextView description = row.findViewById(R.id.description1);
        ImageView imageView1 = row.findViewById(R.id.profile_image);


        title.setText(userDataInfo.get(position).getNtitle());
        description.setText(userDataInfo.get(position).getNdescription());
        imageView1.setImageResource(userDataInfo.get(position).getmImg());

        return row;
    }


}