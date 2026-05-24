package com.studi.room;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.studi.room.databinding.RvItemsBinding;

public class LAdapter extends ListAdapter<Siswa, LAdapter.MyViewHolder> {

    public LAdapter() {
        super(new SiswaDiffCallback());
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyViewHolder.from(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Siswa currentSiswa = getItem(position);
        holder.bind(currentSiswa);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final RvItemsBinding binding;

        public MyViewHolder(RvItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Siswa siswa) {
            binding.tvNama.setText(siswa.getNama());
            binding.tvKelas.setText(siswa.getKelas());

            binding.getRoot().setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putInt("b_id", siswa.getId());
                bundle.putString("b_nama", siswa.getNama());
                bundle.putString("b_kelas", siswa.getKelas());

                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtras(bundle);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                itemView.getContext().startActivity(intent);
            });
        }

        public static MyViewHolder from(ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            RvItemsBinding binding = RvItemsBinding.inflate(layoutInflater, parent, false);
            return new MyViewHolder(binding);
        }
    }

    private static class SiswaDiffCallback extends DiffUtil.ItemCallback<Siswa> {
        @Override
        public boolean areItemsTheSame(@NonNull Siswa oldItem, @NonNull Siswa newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Siswa oldItem, @NonNull Siswa newItem) {
            return oldItem.getNama().equals(newItem.getNama()) &&
                    oldItem.getKelas().equals(newItem.getKelas());
        }
    }
}
