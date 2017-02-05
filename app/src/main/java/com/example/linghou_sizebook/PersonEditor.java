package com.example.linghou_sizebook;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by linghou on 2017-02-03.
 */
public class PersonEditor {

    private LinearLayout linearLayout;

    private EditTextWithLabel name;
    private EditTextWithLabel date;
    private EditTextWithLabel neck;
    private EditTextWithLabel bust;
    private EditTextWithLabel chest;
    private EditTextWithLabel waist;
    private EditTextWithLabel hip;
    private EditTextWithLabel inseam;
    private EditTextWithLabel comment;

    public PersonEditor(Context context){
        this.linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        this.name = new EditTextWithLabel(context, "Name");
        linearLayout.addView(this.name.getLinearLayout());
        this.date = new EditTextWithLabel(context, "Date");
        linearLayout.addView(this.date.getLinearLayout());
        this.neck = new EditTextWithLabel(context, "Neck");
        linearLayout.addView(this.neck.getLinearLayout());
        this.bust = new EditTextWithLabel(context, "Bust");
        linearLayout.addView(this.bust.getLinearLayout());
        this.chest = new EditTextWithLabel(context, "Chest");
        linearLayout.addView(this.chest.getLinearLayout());
        this.waist = new EditTextWithLabel(context, "Waist");
        linearLayout.addView(this.waist.getLinearLayout());
        this.hip = new EditTextWithLabel(context, "Hip");
        linearLayout.addView(this.hip.getLinearLayout());
        this.inseam = new EditTextWithLabel(context, "Inseam");
        linearLayout.addView(this.inseam.getLinearLayout());
        this.comment = new EditTextWithLabel(context, "Comment");
        linearLayout.addView(this.comment.getLinearLayout());
    }
    public LinearLayout getLinearLayout() {
        return this.linearLayout;
    }
    public void setValues(Person person){

        String dateValue = "", neckValue = "", bustValue = "", chestValue = "",
                waistValue = "", hipValue = "", inseamValue = "";
        if(person.getDate() != null){
            dateValue = PersonConverter.dateToString(person.getDate());
        }
        if(person.getNeck() != null){
            neckValue = Float.toString(person.getNeck());
        }
        if(person.getBust() != null){
            bustValue = Float.toString(person.getBust());
        }
        if(person.getChest() != null){
            chestValue = Float.toString(person.getChest());
        }
        if(person.getWaist() != null){
            waistValue = Float.toString(person.getWaist());
        }
        if(person.getHip() != null){
            hipValue = Float.toString(person.getHip());
        }
        if(person.getInseam() != null){
            inseamValue = Float.toString(person.getInseam());
        }


        this.name.setValue(person.getName());
        this.date.setValue(dateValue);
        this.neck.setValue(neckValue);
        this.bust.setValue(bustValue);
        this.chest.setValue(chestValue);
        this.waist.setValue(waistValue);
        this.hip.setValue(hipValue);
        this.inseam.setValue(inseamValue);
        this.comment.setValue(person.getComment());

    }
    public Person getPerson(){

        Float neckValue = null, bustValue = null, chestValue = null, waistValue = null,
                hipValue = null, inseamValue = null;

        if (!neck.getValue().equals("")) {
            neckValue = Float.parseFloat(neck.getValue());
        }
        if (!bust.getValue().equals("")) {
            bustValue = Float.parseFloat(bust.getValue());
        }
        if (!chest.getValue().equals("")) {
            chestValue = Float.parseFloat(chest.getValue());
        }
        if (!waist.getValue().equals("")) {
            waistValue = Float.parseFloat(waist.getValue());
        }
        if (!hip.getValue().equals("")) {
            hipValue = Float.parseFloat(hip.getValue());
        }
        if (!inseam.getValue().equals("")) {
            inseamValue = Float.parseFloat(inseam.getValue());
        }

        return new Person(name.getValue(),PersonConverter.stringToDate(date.getValue()),
                neckValue,bustValue,chestValue,waistValue,hipValue,inseamValue,comment.getValue());
    }


}