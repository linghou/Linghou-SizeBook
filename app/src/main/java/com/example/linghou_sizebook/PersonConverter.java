package com.example.linghou_sizebook;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by linghou on 2017-02-03.
 */

public class PersonConverter {
    public  static String dateToString (Calendar date){
        //based on http://stackoverflow.com/questions/9243578/java-util-date-and-getyear/12273692#12273692
        if (date == null) return "";
        String sign = "-";
        String yearResult = Integer.toString(date.get(Calendar.YEAR));
        String monthResult = Integer.toString(date.get(Calendar.MONTH));
        String dayResult = Integer.toString(date.get(Calendar.DAY_OF_MONTH));
        return yearResult + sign + monthResult + sign + dayResult;
    }
    public  static Calendar stringToDate(String string){
        String[] values = string.split("\\-");
        if (values[0].equals("")) {
            return null;
        }
        //Based on https://docs.oracle.com/javase/7/docs/api/java/util/GregorianCalendar.html
        return new GregorianCalendar(Integer.parseInt(values[0]), Integer.parseInt(values[1]),
                Integer.parseInt(values[2]));

    }
    public  static String personToString (Person person){
        String splitCh = "*";

        String dateValue = "", neckValue = "", bustValue = "", chestValue = "", waistValue = "",
                hipValue = "", inseamValue = "";

        if (person.getDate() != null) {
            dateValue = PersonConverter.dateToString(person.getDate());
        }

        if (person.getNeck() != null) {
            neckValue = person.getNeck().toString();
        }

        if (person.getBust() != null) {
            bustValue = person.getBust().toString();
        }

        if (person.getChest() != null) {
            chestValue = person.getChest().toString();
        }

        if (person.getWaist() != null) {
            waistValue = person.getWaist().toString();
        }

        if (person.getHip() != null) {
            hipValue = person.getHip().toString();
        }

        if (person.getInseam() != null) {
            inseamValue = person.getInseam().toString();
        }

        String result = person.getName()+ splitCh + dateValue + splitCh
                + neckValue + splitCh + bustValue + splitCh + chestValue + splitCh + waistValue + splitCh
                + hipValue + splitCh + inseamValue + splitCh + person.getComment();
        return result;
    }
    public  static Person stringToPerson (String string){
        String[] values = string.split("\\*", -1);

        Calendar dateValue = null;
        Float neckValue = null, bustValue = null, chestValue = null, waistValue = null, hipValue = null, inseamValue = null;

        if(!values[1].equals("")) {
            dateValue = PersonConverter.stringToDate(values[1]);
        }
        if (!values[2].equals("")) {
            neckValue = Float.parseFloat(values[2]);
        }
        if (!values[3].equals("")) {
            bustValue = Float.parseFloat(values[3]);
        }
        if (!values[4].equals("")) {
            chestValue = Float.parseFloat(values[4]);
        }
        if (!values[5].equals("")) {
            waistValue = Float.parseFloat(values[5]);
        }
        if (!values[6].equals("")) {
            hipValue = Float.parseFloat(values[6]);
        }
        if (!values[7].equals("")) {
            inseamValue = Float.parseFloat(values[7]);
        }



        return new Person(values[0], dateValue,neckValue,bustValue,chestValue,waistValue,hipValue,inseamValue,values[8]);
    }

}

