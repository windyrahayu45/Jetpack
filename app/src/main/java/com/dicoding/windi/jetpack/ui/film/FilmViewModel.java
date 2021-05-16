package com.dicoding.windi.jetpack.ui.film;

import androidx.lifecycle.ViewModel;

import com.dicoding.windi.jetpack.data.DataEntity;
import com.dicoding.windi.jetpack.utils.DataDummy;

import java.util.List;

public class FilmViewModel extends ViewModel {
    public List<DataEntity> getMovie() {
        return DataDummy.generateDummyMovie();
    }
}
