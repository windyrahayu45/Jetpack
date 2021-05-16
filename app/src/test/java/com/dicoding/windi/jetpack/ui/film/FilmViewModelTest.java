package com.dicoding.windi.jetpack.ui.film;

import com.dicoding.windi.jetpack.data.DataEntity;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class FilmViewModelTest {

    private FilmViewModel viewModel;
    @Before
    public void setUp() {
        viewModel = new FilmViewModel();
    }

    @Test
    public void getMovie() {
        List<DataEntity> dataEntities = viewModel.getMovie();
        assertNotNull(dataEntities);
        assertEquals(10, dataEntities.size());
    }

}