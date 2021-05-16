package com.dicoding.windi.jetpack.ui.film;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.dicoding.windi.jetpack.data.DataEntity;
import com.dicoding.windi.jetpack.databinding.FragmentFilmBinding;

import java.util.List;

public class FilmFragment extends Fragment  implements FilmFragmentCallback{
    private FragmentFilmBinding fragmentFilmBinding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        fragmentFilmBinding = FragmentFilmBinding.inflate(inflater, container, false);
        return fragmentFilmBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            FilmViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(FilmViewModel.class);
            List<DataEntity> movies = viewModel.getMovie();
            //List<CourseEntity> courses = DataDummy.generateDummyCourses();
            FilmAdapter filmAdapter = new FilmAdapter(this);
            filmAdapter.setMovies(movies);
            fragmentFilmBinding.rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentFilmBinding.rvMovies.setHasFixedSize(true);
            fragmentFilmBinding.rvMovies.setAdapter(filmAdapter);
        }
    }

    @Override
    public void onShareClick(DataEntity data) {
        if (getActivity() != null) {
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(getActivity())
                    .setType(mimeType)
                    .setChooserTitle("Bagikan tentang film ini sekarang.")
                    .setText(String.format("Saksikan Movies %s di platform kesayangan anda", data.getTitle()))
                    .startChooser();
        }
    }
}