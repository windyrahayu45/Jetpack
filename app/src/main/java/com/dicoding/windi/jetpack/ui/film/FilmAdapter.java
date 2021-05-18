package com.dicoding.windi.jetpack.ui.film;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.windi.jetpack.R;
import com.dicoding.windi.jetpack.data.DataEntity;
import com.dicoding.windi.jetpack.databinding.ItemsFilmBinding;
import com.dicoding.windi.jetpack.ui.detail.DetailActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.MoviesViewHolder>{
    private final  FilmFragmentCallback filmFragmentCallback ;
    private final List<DataEntity> listMovies = new ArrayList<>();
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
        DataEntity dataEntity = listMovies.get(position);
        holder.bind(dataEntity);
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    class MoviesViewHolder extends RecyclerView.ViewHolder {
        private final ItemsFilmBinding binding;
        MoviesViewHolder(ItemsFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        void bind(DataEntity data) {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date newDate = null;
            try {
                newDate = format.parse(data.getReleaseDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            format = new SimpleDateFormat("MMM dd, yyyy");
            String date = format.format(newDate);
            binding.tvItemTitle.setText(data.getTitle());
            binding.tvReleaseDate.setText(date);
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_ID, data.getFilmId());
                intent.putExtra(DetailActivity.JENIS_ID, "1");
                itemView.getContext().startActivity(intent);
            });
            binding.imgShareFilm.setOnClickListener(v -> filmFragmentCallback.onShareClick(data));
            Glide.with(itemView.getContext())
                    .load(data.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(binding.imgPoster);
        }
    }
}
