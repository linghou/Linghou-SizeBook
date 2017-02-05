package com.example.linghou_sizebook;

import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by linghou on 2017-02-03.
 */
public class EditTextWithLabel {
    private EditText editText;
    private LinearLayout linearLayout;
    public  EditTextWithLabel(Context context, String text){

        linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView label = new TextView(context);
        label.setText(text);
        linearLayout.addView(label);
        this.editText = new EditText(context);
        linearLayout.addView(editText);

    }

    public LinearLayout getLinearLayout() {
        return linearLayout;
    }

    public String getValue(){
        return editText.getText().toString();

    }

    public void setValue(String string){
        this.editText.setText(string);


    }
}

