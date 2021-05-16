package com.dicoding.windi.jetpack.ui.detail;

import com.dicoding.windi.jetpack.data.DataEntity;
import com.dicoding.windi.jetpack.utils.DataDummy;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class DetailViewModelTest {

    private DetailViewModel viewModel;
    private DataEntity dummyMovie = DataDummy.generateDummyMovie().get(0);
    private String idMovie = dummyMovie.getFilmId();
    private DataEntity dummyShow = DataDummy.generateDummyShow().get(0);
    private String idShow = dummyShow.getFilmId();

    @Before
    public void setUp() {
        viewModel = new DetailViewModel();

    }

    @Test
    public void getMovie() {
        viewModel.setSelected(dummyMovie.getFilmId(),"1");
        DataEntity dataEntity = viewModel.getData();
        assertNotNull(dataEntity);
        assertEquals(dummyMovie.getFilmId(), dataEntity.getFilmId());
        assertEquals(dummyMovie.getTitle(), dataEntity.getTitle());
        assertEquals(dummyMovie.getDescription(), dataEntity.getDescription());
        assertEquals(dummyMovie.getPosterPath(), dataEntity.getPosterPath());
        assertEquals(dummyMovie.getReleaseDate(), dataEntity.getReleaseDate());
        assertEquals(dummyMovie.getVote(), dataEntity.getVote());
    }

    @Test
    public void getShow() {
        viewModel.setSelected(dummyShow.getFilmId(),"2");
        DataEntity dataEntity = viewModel.getData();
        assertNotNull(dataEntity);
        assertEquals(dummyShow.getFilmId(), dataEntity.getFilmId());
        assertEquals(dummyShow.getTitle(), dataEntity.getTitle());
        assertEquals(dummyShow.getDescription(), dataEntity.getDescription());
        assertEquals(dummyShow.getPosterPath(), dataEntity.getPosterPath());
        assertEquals(dummyShow.getReleaseDate(), dataEntity.getReleaseDate());
        assertEquals(dummyShow.getVote(), dataEntity.getVote());
    }

}