package com.dicoding.windi.jetpack.ui.show;

import com.dicoding.windi.jetpack.data.DataEntity;
import com.dicoding.windi.jetpack.ui.film.FilmViewModel;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class ShowViewModelTest {
    private ShowViewModel viewModel;
    @Before
    public void setUp() {
        viewModel = new ShowViewModel();
    }

    @Test
    public void getShow() {
        List<DataEntity> dataEntities = viewModel.getShow();
        assertNotNull(dataEntities);
        assertEquals(10, dataEntities.size());
    }

}