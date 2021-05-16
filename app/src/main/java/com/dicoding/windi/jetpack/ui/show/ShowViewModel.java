package com.dicoding.windi.jetpack.ui.show;

import androidx.lifecycle.ViewModel;

import com.dicoding.windi.jetpack.data.DataEntity;
import com.dicoding.windi.jetpack.utils.DataDummy;

import java.util.List;

public class ShowViewModel extends ViewModel {
    public List<DataEntity> getShow() {
        return DataDummy.generateDummyShow();
    }
}
