package com.chitranshu.noteapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {
    public static final String NOTE_INFO = "NOTE_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        loadListData();
    }

    private void loadListData() {
        final ListView note_list_view = findViewById(R.id.note_list);
        List<NoteInfo> notes = DataManager.getInstance().getNotes();

        ArrayAdapter<NoteInfo> noteInfoArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);

        note_list_view.setAdapter(noteInfoArrayAdapter);

        note_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NoteListActivity.this, NoteActivity.class);
                NoteInfo note = (NoteInfo) note_list_view.getItemAtPosition(position);
                intent.putExtra(NOTE_INFO, note);
                startActivity(intent);
            }
        });
    }
}