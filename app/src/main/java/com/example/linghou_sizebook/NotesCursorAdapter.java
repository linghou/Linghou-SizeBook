package com.example.linghou_sizebook;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by linghou on 2017-02-03.
 */
//Based on the tutorial from https://www.lynda.com/Android-tutorials/Building-Note-Taking-App-Android/377485-2.html
public class NotesCursorAdapter extends CursorAdapter{
    public NotesCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(
                R.layout.note_list_item, parent, false
        );
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {



        String noteText = cursor.getString(
                cursor.getColumnIndex(DBOpenHelper.NOTE_TEXT));

        Person person = PersonConverter.stringToPerson(noteText);
        String bustValue, chestValue,
                waistValue, inseamValue;
        if (person.getBust() == null ){
            bustValue = "";
        } else{
            bustValue = person.getBust().toString();
        }


        if (person.getChest() == null ){
            chestValue = "";
        }else {
            chestValue = person.getChest().toString();
        }
        if (person.getWaist() == null) {
            waistValue = "";
        }else{
            waistValue = person.getChest().toString();
        }
        if (person.getInseam() == null) {
            inseamValue = "";
        }else {
            inseamValue = person.getInseam().toString();
        }

        TextView tv = (TextView) view.findViewById(R.id.tvNote);



        String finalText = person.getName() + "\n" +
                "Bust: " + bustValue + "\n" +
                "Chest: " + chestValue + "\n" +
                "Waist: " + waistValue + "\n" +
                "Inseam: " + inseamValue;

        tv.setText(finalText);

    }
}
