package com.example.ejercicio24breng;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicio24breng.clases.Firmas;
import com.example.ejercicio24breng.tablas.Transacciones;

import java.util.ArrayList;
import java.util.List;

public class Activity_Galeria extends AppCompatActivity {

    RecyclerView recycler;

    ArrayList<Firmas> galeria;
    List<Firmas> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        galeria = new ArrayList<>();

        GetListGallery();

        recycler = (RecyclerView) findViewById(R.id.list);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        AdapterFirma adapter = new AdapterFirma(items);
        recycler.setAdapter(adapter);
    }


    private void GetListGallery() {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();
        Firmas Items = null;
        galeria = new ArrayList<Firmas>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Transacciones.tabla_firmas, null);

        while (cursor.moveToNext()) {
            Items = new Firmas();
            Items.setId(cursor.getInt(0));
            Items.setImage(cursor.getBlob(1));
            Items.setDescripcion(cursor.getString(2));

            galeria.add(Items);
        }

        cursor.close();
        GalleryList();
    }

    private void GalleryList() {

        items = new ArrayList<>();

        for (int i = 0;  i < galeria.size(); i++){

            items.add(new Firmas(
                    galeria.get(i).getId(),
                    galeria.get(i).getImage(),
                    galeria.get(i).getDescripcion()));
        }
    }
}