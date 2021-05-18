package com.dicoding.windi.jetpack.ui.detail;


import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.windi.jetpack.data.DataEntity;
import com.dicoding.windi.jetpack.databinding.ActivityDetailBinding;
import com.dicoding.windi.jetpack.databinding.ContentDetailBinding;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import com.dicoding.windi.jetpack.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "extra_id";
    public static final String JENIS_ID = "jenis_id";
    private ContentDetailBinding detailContentBinding;
    String jenisId;


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
            jenisId = extras.getString(JENIS_ID);
            if (courseId != null) {
                viewModel.setSelected(courseId,jenisId);
                populateData(viewModel.getData());
            }
        }

    }

    private void populateData(DataEntity dataEntity) {



        detailContentBinding.textTitle.setText(dataEntity.getTitle());
        detailContentBinding.textDescription.setText(dataEntity.getDescription());
        detailContentBinding.textDate.setText(parseDateToddMMyyyy(dataEntity.getReleaseDate()));
        detailContentBinding.textVote.setText(dataEntity.getVote());

        if(jenisId.equals("1")){
            detailContentBinding.textRelease.setText(R.string.release_date);
        }
        else{
            detailContentBinding.textRelease.setText(R.string.first_air_date);
        }

        Glide.with(this)
                .load(dataEntity.getPosterPath())
                .transform(new RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imagePoster);

    }

    public String parseDateToddMMyyyy(String strCurrentDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = null;
        try {
            newDate = format.parse(strCurrentDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        format = new SimpleDateFormat("MMM dd, yyyy");
        String date = format.format(newDate);

        return date;
    }
}