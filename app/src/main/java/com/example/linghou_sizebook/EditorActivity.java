package com.example.linghou_sizebook;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by linghou on 2017-02-03.
 */
//Based on the tutorial from https://www.lynda.com/Android-tutorials/Building-Note-Taking-App-Android/377485-2.html
public class EditorActivity extends AppCompatActivity {

    private String action;

    //private EditText editor;
    private PersonEditor editor;
    private String noteFilter;
    private String oldText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        editor = new PersonEditor(this);
        setContentView(editor.getLinearLayout());

        Intent intent = getIntent();

        Uri uri = intent.getParcelableExtra(NotesProvider.CONTENT_ITEM_TYPE);

        if (uri == null) {
            action = Intent.ACTION_INSERT;
            setTitle(getString(R.string.new_name));
        } else {
            action = Intent.ACTION_EDIT;
            noteFilter = DBOpenHelper.NOTE_ID + "=" + uri.getLastPathSegment();

            Cursor cursor = getContentResolver().query(uri,
                    DBOpenHelper.ALL_COLUMNS, noteFilter, null, null);
            cursor.moveToFirst();
            oldText = cursor.getString(cursor.getColumnIndex(DBOpenHelper.NOTE_TEXT));
            Person oldPerson = PersonConverter.stringToPerson(oldText);
            editor.setValues(oldPerson);
            //editor.requestFocus();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (action.equals(Intent.ACTION_EDIT)) {
            getMenuInflater().inflate(R.menu.menu_editor, menu);
        }
        return true;
    }

  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                finishEditing();
                break;
            case R.id.action_delete:
                deleteNote();
                break;
        }

        return true;
    }

    private void deleteNote() {
        getContentResolver().delete(NotesProvider.CONTENT_URI,
                noteFilter, null);
        Toast.makeText(this, getString(R.string.name_deleted),
                Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();
    }

    private void finishEditing() {

        Person person = editor.getPerson();
//taken from http://stackoverflow.com/questions/2115758/how-do-i-display-an-alert-dialog-on-android
        if (person.getName().equals("")) {
            new AlertDialog.Builder(this)
                    .setTitle("Warning")
                    .setMessage("Name required!!")
                    .show();
            return;
        }

        switch (action) {
            case Intent.ACTION_INSERT:
                insertNote(person);
                break;
            case Intent.ACTION_EDIT:
                //if (PersonConverter.personToString(person).length() == 0) {
                //    deleteNote();
                //}

                if (oldText.equals(person)) {
                   setResult(RESULT_CANCELED);
                } else {
                    updateNote(person);
               }

        }
        finish();
    }

    private void updateNote(Person person) {
        String noteText = PersonConverter.personToString(person);
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.NOTE_TEXT, noteText);
        getContentResolver().update(NotesProvider.CONTENT_URI, values, noteFilter, null);
        Toast.makeText(this, getString(R.string.name_updated), Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
    }

    private void insertNote(Person person) {
        String noteText = PersonConverter.personToString(person);
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.NOTE_TEXT, noteText);
        getContentResolver().insert(NotesProvider.CONTENT_URI, values);
        setResult(RESULT_OK);
    }

    @Override
    public void onBackPressed() {
        finishEditing();
    }
}
