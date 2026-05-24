package com.studi.room;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.studi.room.databinding.ActivityDetailBinding;

import java.util.concurrent.Executors;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;
    private String nama, kelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //tangkap bundle
        Bundle bundle = this.getIntent().getExtras();
        if (bundle == null) {
            finish();
            return;
        }

        //letakkan isi bundle
        final int id = bundle.getInt("b_id", 0);
        binding.etNama.setText(bundle.getString("b_nama"));

        //set spinner
        int idx_spinner = setSpinner(binding.spKelas, bundle.getString("b_kelas"));
        binding.spKelas.setSelection(idx_spinner);

        // Back Button
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Siswa");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        binding.btUbah.setOnClickListener(v -> {
            nama = binding.etNama.getText().toString().trim();
            kelas = binding.spKelas.getSelectedItem().toString();

            if (!nama.isEmpty()) {
                Executors.newSingleThreadExecutor().execute(() -> {
                    AppDatabase.getDatabase(getApplicationContext()).siswaDAO().update(new Siswa(id, nama, kelas));
                    runOnUiThread(() -> {
                        Toast.makeText(getApplicationContext(), "Data " + nama + " berhasil diubah", Toast.LENGTH_SHORT).show();
                        setResult(RESULT_OK);
                        finish();
                    });
                });
            } else {
                Toast.makeText(this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btHapus.setOnClickListener(v -> {
            nama = binding.etNama.getText().toString();
            kelas = binding.spKelas.getSelectedItem().toString();

            new AlertDialog.Builder(this)
                    .setTitle("Hapus Data")
                    .setMessage("Apakah Anda yakin ingin menghapus data " + nama + "?")
                    .setPositiveButton("Ya", (dialog, which) -> {
                        Executors.newSingleThreadExecutor().execute(() -> {
                            AppDatabase.getDatabase(getApplicationContext()).siswaDAO().delete(new Siswa(id, nama, kelas));
                            runOnUiThread(() -> {
                                Toast.makeText(getApplicationContext(), "Data " + nama + " dihapus", Toast.LENGTH_SHORT).show();
                                setResult(RESULT_OK);
                                finish();
                            });
                        });
                    })
                    .setNegativeButton("Tidak", null)
                    .show();
        });
    }

    private int setSpinner(Spinner spinner, String myString){
        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                return i;
            }
        }
        return 0;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
