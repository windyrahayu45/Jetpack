package com.dicoding.windi.jetpack.ui.show;

import android.annotation.SuppressLint;
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
import com.dicoding.windi.jetpack.databinding.ItemsShowBinding;
import com.dicoding.windi.jetpack.ui.detail.DetailActivity;
import com.dicoding.windi.jetpack.ui.film.FilmFragmentCallback;

import java.util.ArrayList;
import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ShowViewHolder>{
    ShowFragmentCallback showFragmentCallback;
    private final List<DataEntity> listCourses = new ArrayList<>();

    void setShow(List<DataEntity> listCourses) {
        if (listCourses == null) return;
        this.listCourses.clear();
        this.listCourses.addAll(listCourses);
    }

    ShowAdapter(ShowFragmentCallback callback) { this.showFragmentCallback = callback; }

    @NonNull
    @Override
    public ShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsShowBinding binding = ItemsShowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ShowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ShowViewHolder holder, int position) {
        DataEntity course = listCourses.get(position);
        holder.bind(course);
    }

    @Override
    public int getItemCount() {
        return listCourses.size();
    }

    static class ShowViewHolder extends RecyclerView.ViewHolder {

        private final ItemsShowBinding binding;
        private ShowFragmentCallback showFragmentCallback;

        ShowViewHolder(ItemsShowBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        @SuppressLint("StringFormatInvalid")
        void bind(DataEntity data) {
            binding.tvShowTitle.setText(data.getTitle());
            binding.tvFirstAirDate.setText(itemView.getResources().getString(R.string.release_date, data.getReleaseDate()));
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_ID, data.getFilmId());
                intent.putExtra(DetailActivity.JENIS_ID, "2");
                itemView.getContext().startActivity(intent);
            });
            binding.imgShare.setOnClickListener(v -> showFragmentCallback.onShareClick(data));
            Glide.with(itemView.getContext())
                    .load(data.getPosterPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(binding.imgPoster);
        }
    }
}
