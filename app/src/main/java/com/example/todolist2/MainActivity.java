package com.example.todolist2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    //deklarasi variabel
    private TextView txtNama,txtStatus, txtTanggal;
    private ImageView imgLogo;
    private ListView listview;

    //deklarasi array
    String[] nama;
    String[] status;
    String[] tanggal;
    //String[] gambar;

    //Adapter
    SimpleAdapter sa;

    //Map
    HashMap<String, String> map;

    //Array list
    ArrayList<HashMap<String, String>> listSiswa;

    //list adapter
    ListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("To Do List");

        setContentView(R.layout.activity_main);

        //isi data array
        nama = new String[]{"Safira", "Rokhman", "Indryana", "Ainur", "Sylvi"};
        status = new String[]{"online", "offline", "offline", "pending", "online"};
        tanggal = new String[]{"31-08-2018", "31-08-2018", "31-08-2018", "31-08-2018", "31-08-2018"};

        //deklarasi id komponen
        txtNama = (TextView) findViewById(R.id.nama);
        txtStatus = (TextView) findViewById(R.id.status);
        txtTanggal = (TextView) findViewById(R.id.txtTanggal);
        //imgLogo = (ImageView) findViewById(R.id.imgLogo);
        listview = (ListView) findViewById(R.id.listview);

        //inisialisasi list user baru
        listSiswa = new ArrayList<HashMap<String, String>>();

        //looping dengan for
        for (int i = 0; i < nama.length; i++) {
            map = new HashMap<String, String>();
            map.put("nama", nama[i]);
            map.put("status", status[i]);
            map.put("tanggal", tanggal[i]);

            //add map to list view
            listSiswa.add(map);
        }

        sa = new SimpleAdapter(this, listSiswa, R.layout.list_item, new String[]{"nama", "status", "tangal"}, new int[]{R.id.nama, R.id.status, R.id.txtTanggal});
        listview.setAdapter(sa);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object data = listSiswa.get(position);
                String ItemYangDipilih = data.toString();
                Toast.makeText(MainActivity.this,
                        "Item yang dipilih adalah " + ItemYangDipilih,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}