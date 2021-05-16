package com.dicoding.windi.jetpack.ui.detail;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.windi.jetpack.data.DataEntity;
import com.dicoding.windi.jetpack.databinding.ActivityDetailBinding;
import com.dicoding.windi.jetpack.databinding.ContentDetailBinding;
import com.dicoding.windi.jetpack.utils.DataDummy;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.View;

import com.dicoding.windi.jetpack.R;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "extra_id";
    public static final String JENIS_ID = "jenis_id";
    private ContentDetailBinding detailContentBinding;
    List<DataEntity> dataEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActivityDetailBinding activityDetailCourseBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        detailContentBinding = activityDetailCourseBinding.detailContent;
        setContentView(activityDetailCourseBinding.getRoot());

        setSupportActionBar(activityDetailCourseBinding.toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        DetailViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailViewModel.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String courseId = extras.getString(EXTRA_ID);
            String jenisId = extras.getString(JENIS_ID);
            if (courseId != null) {
                viewModel.setSelected(courseId,jenisId);

              // populateCourse(viewModel.getData());


                if(jenisId.equals("1")){
                    dataEntities = DataDummy.generateDummyMovie();
                }
                else{
                    dataEntities = DataDummy.generateDummyShow();
                }
                for (int i = 0; i < dataEntities.size(); i++) {
                    DataEntity courseEntity = dataEntities.get(i);
                    if (courseEntity.getFilmId().equals(courseId)) {
                        populateCourse(courseEntity);


                    }
                }




            }
        }

    }

    private void populateCourse(DataEntity courseEntity) {
        detailContentBinding.textTitle.setText(courseEntity.getTitle());
        detailContentBinding.textDescription.setText(courseEntity.getDescription());
        detailContentBinding.textDate.setText(courseEntity.getReleaseDate());

        Glide.with(this)
                .load(courseEntity.getPosterPath())
                .transform(new RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imagePoster);

                Log.e("hasil", String.valueOf(courseEntity.getDescription()));


    }
}