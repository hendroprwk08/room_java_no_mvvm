package com.studi.room;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.studi.room.databinding.ActivityMainBinding;
import com.studi.room.databinding.InputLayoutBinding;

import java.util.List;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppDatabase db;
    private LAdapter lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        db = AppDatabase.getDatabase(this);
        setupRecyclerView();
        viewRecyclerView(null);

        // Pasang listener pada tombol cari
        binding.contentMain.btCari.setOnClickListener(v -> {
            String cari = binding.contentMain.etCari.getText().toString();
            viewRecyclerView(cari);
        });

        binding.floatingActionButton.setOnClickListener(view -> showAddDialog());
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewRecyclerView(null);
    }

    private void setupRecyclerView() {
        lAdapter = new LAdapter();
        // Sesuai dengan id di activity_main.xml: content_main
        binding.contentMain.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.contentMain.recyclerView.setAdapter(lAdapter);
    }

    private void showAddDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        InputLayoutBinding dialogBinding = InputLayoutBinding.inflate(getLayoutInflater());

        dialog.setView(dialogBinding.getRoot());
        dialog.setCancelable(true);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Tambah Siswa");

        dialog.setPositiveButton("SIMPAN", (d, which) -> {
            String nama = dialogBinding.etNama.getText().toString().trim();
            Object selectedItem = dialogBinding.spKelas.getSelectedItem();
            String kelas = (selectedItem != null) ? selectedItem.toString() : "";

            if (!nama.isEmpty()) {
                // Operasi database harus di background thread
                Executors.newSingleThreadExecutor().execute(() -> {
                    db.siswaDAO().insertAll(new Siswa(nama, kelas));
                    runOnUiThread(() -> {
                        viewRecyclerView(null);
                        binding.contentMain.etCari.setText("");
                    });
                });
                d.dismiss();
            } else {
                Toast.makeText(MainActivity.this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton("BATAL", (d, which) -> d.dismiss());
        dialog.show();
    }

    public void viewRecyclerView(String cari) {
        // Operasi database harus di background thread
        Executors.newSingleThreadExecutor().execute(() -> {
            List<Siswa> siswas;
            if (cari == null || cari.trim().isEmpty()) {
                siswas = db.siswaDAO().getAll();
            } else {
                siswas = db.siswaDAO().findByName("%" + cari.trim() + "%");
            }

            // Update UI harus kembali ke main thread
            runOnUiThread(() -> {
                lAdapter.submitList(siswas);
                if (siswas.isEmpty() && cari != null && !cari.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
