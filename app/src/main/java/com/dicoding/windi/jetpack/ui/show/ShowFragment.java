package com.dicoding.windi.jetpack.ui.show;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dicoding.windi.jetpack.R;
import com.dicoding.windi.jetpack.data.DataEntity;
import com.dicoding.windi.jetpack.databinding.FragmentFilmBinding;
import com.dicoding.windi.jetpack.databinding.FragmentShowBinding;
import com.dicoding.windi.jetpack.ui.film.FilmAdapter;
import com.dicoding.windi.jetpack.ui.film.FilmViewModel;

import java.util.List;


public class ShowFragment extends Fragment implements  ShowFragmentCallback{
    private FragmentShowBinding fragmentShowBinding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        fragmentShowBinding = FragmentShowBinding.inflate(inflater, container, false);
        return fragmentShowBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            ShowViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ShowViewModel.class);
            List<DataEntity> movies = viewModel.getShow();
            //List<CourseEntity> courses = DataDummy.generateDummyCourses();
            ShowAdapter showAdapter = new ShowAdapter(this);
            showAdapter.setShow(movies);
            fragmentShowBinding.rvAcademy.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentShowBinding.rvAcademy.setHasFixedSize(true);
            fragmentShowBinding.rvAcademy.setAdapter(showAdapter);
        }
    }

    @Override
    public void onShareClick(DataEntity dataEntity) {

    }
}