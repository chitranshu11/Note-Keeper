package com.chitranshu.noteapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class NoteActivity extends AppCompatActivity {
    private NoteInfo mNote;
    private boolean mIsNewNOte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        Spinner spinner_category = findViewById(R.id.spinner_category);

        List<CategoryInfo> categories = DataManager.getInstance().getCategory();
        ArrayAdapter<CategoryInfo> adapterCategory =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,categories);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_category.setAdapter(adapterCategory);

        readIntentData();

        EditText textNoteTitle = findViewById(R.id.text_note_title);
        EditText textNoteText = findViewById(R.id.text_note_text);

        if(!mIsNewNOte)
            displayNote(spinner_category, textNoteTitle, textNoteText);
    }

    private void displayNote(Spinner spinnerCourses, EditText textNoteTitle, EditText textNoteText) {
        List<CategoryInfo> courses = DataManager.getInstance().getCategory();
        int courseIndex = courses.indexOf(mNote.getCategory());
        spinnerCourses.setSelection(courseIndex);
        textNoteTitle.setText(mNote.getTitle());
        textNoteText.setText(mNote.getText());
    }

    private void readIntentData() {
        Intent intent = getIntent();
        mNote = intent.getParcelableExtra(NoteListActivity.NOTE_INFO);
        mIsNewNOte = mNote == null;
    }
}