package com.dicoding.windi.jetpack.ui.show;

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
import com.dicoding.windi.jetpack.databinding.FragmentShowBinding;
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
            fragmentShowBinding.rvShow.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentShowBinding.rvShow.setHasFixedSize(true);
            fragmentShowBinding.rvShow.setAdapter(showAdapter);
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
                    .setText(String.format("Saksikan TV Show %s di platform kesayangan anda", data.getTitle()))
                    .startChooser();
        }
    }
}