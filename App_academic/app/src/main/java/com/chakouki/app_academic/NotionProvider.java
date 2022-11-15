package com.chakouki.app_academic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.Toast;

public class NotionProvider extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);
    }

    public void onClickAjouterNoteInptiste(View view) {
        // Ajouter une note d etudiant
        ContentValues values = new ContentValues();
        values.put(InptisteProvider.NOM, ((EditText) findViewById(R.id.nom)).getText().toString());
        values.put(InptisteProvider.NOTE, ((EditText) findViewById(R.id.note)).getText().toString());
        Uri uri = getContentResolver().insert(InptisteProvider.CONTENT_URI, values);
        assert uri != null;
        Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();
    }

    @SuppressLint("Range")
    public void onClickRetrouverNotesInptistes(View view) {
        // Retrouver les notes des etudiants
        String URL = "content://com.chakouki.app_academic.InptisteProvider";
        Uri inptistes = Uri.parse(URL);
        Cursor c;
        c = getContentResolver().query(inptistes, null, null, null, "nom");
        assert c != null;
        if (c.moveToFirst()) {
            do Toast.makeText(this,c.getString(c.getColumnIndex(InptisteProvider._ID)) +"; "
                            + c.getString(c.getColumnIndex(InptisteProvider.NOM)) + "; "
                            + c.getString(c.getColumnIndex(InptisteProvider.NOTE)),
                    Toast.LENGTH_SHORT).show(); while (c.moveToNext());
        }
    }
}