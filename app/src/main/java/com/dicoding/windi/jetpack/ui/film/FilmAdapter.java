package com.dicoding.windi.jetpack.ui.film;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.windi.jetpack.R;
import com.dicoding.windi.jetpack.data.DataEntity;
import com.dicoding.windi.jetpack.databinding.FragmentFilmBinding;
import com.dicoding.windi.jetpack.databinding.ItemsFilmBinding;
import com.dicoding.windi.jetpack.ui.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.MoviesViewHolder>{
    private final List<DataEntity> listMovies = new ArrayList<>();
    FilmFragmentCallback filmFragmentCallback;
    FilmAdapter(FilmFragmentCallback callback) { this.filmFragmentCallback = callback; }
    void setMovies(List<DataEntity> listMovies) {
        if (listMovies == null) return;
        this.listMovies.clear();
        this.listMovies.addAll(listMovies);
    }


    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsFilmBinding binding = ItemsFilmBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MoviesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final MoviesViewHolder holder, int position) {
        DataEntity course = listMovies.get(position);
        holder.bind(course);
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    static class MoviesViewHolder extends RecyclerView.ViewHolder {

        private final ItemsFilmBinding binding;



        MoviesViewHolder(ItemsFilmBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        @SuppressLint("StringFormatInvalid")
        void bind(DataEntity data) {
            binding.tvItemTitle.setText(data.getTitle());
            binding.tvReleaseDate.setText(data.getReleaseDate());

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_ID, data.getFilmId());
                intent.putExtra(DetailActivity.JENIS_ID, "1");
                itemView.getContext().startActivity(intent);
            });
            //binding.imgShare.setOnClickListener(v -> filmFragmentCallback.onShareClick(data));
            Glide.with(itemView.getContext())
                    .load(data.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(binding.imgPoster);
        }
    }
}
