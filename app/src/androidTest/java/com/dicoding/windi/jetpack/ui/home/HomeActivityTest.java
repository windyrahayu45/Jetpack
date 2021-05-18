package com.dicoding.windi.jetpack.ui.home;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.dicoding.windi.jetpack.R;
import com.dicoding.windi.jetpack.data.DataEntity;
import com.dicoding.windi.jetpack.utils.DataDummy;

import org.junit.Rule;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class HomeActivityTest  {
    private ArrayList<DataEntity> dataEntityArrayList = (ArrayList<DataEntity>) DataDummy.generateDummyMovie();
    private ArrayList<DataEntity> dataShow = (ArrayList<DataEntity>) DataDummy.generateDummyShow();

    @Rule
    public ActivityScenarioRule activityRule = new ActivityScenarioRule<>(HomeActivity.class);

    @Test
    public void loadMovie() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition(dataEntityArrayList.size()));
    }

    @Test
    public void loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_title)).check(matches(withText(dataEntityArrayList.get(0).getTitle())));
        onView(withId(R.id.text_date)).check(matches(isDisplayed()));
        onView(withId(R.id.text_date)).check(matches(withText(parseDateToddMMyyyy(dataEntityArrayList.get(0).getReleaseDate()))));
        onView(withId(R.id.text_description)).check(matches(isDisplayed()));
        onView(withId(R.id.text_description)).check(matches(withText(dataEntityArrayList.get(0).getDescription())));
        onView(withId(R.id.text_vote)).check(matches(isDisplayed()));
        onView(withId(R.id.text_vote)).check(matches(withText(dataEntityArrayList.get(0).getVote())));
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()));

    }

    @Test
    public void loadShow() {
        onView(withText("TV Show")).perform(click());
        onView(withId(R.id.rv_show)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.scrollToPosition(dataShow.size()));
    }

    @Test
    public void loadDetailShow() {
        onView(withText("TV Show")).perform(click());
        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_title)).check(matches(withText(dataShow.get(0).getTitle())));
        onView(withId(R.id.text_date)).check(matches(isDisplayed()));
        onView(withId(R.id.text_date)).check(matches(withText(parseDateToddMMyyyy(dataShow.get(0).getReleaseDate()))));
        onView(withId(R.id.text_description)).check(matches(isDisplayed()));
        onView(withId(R.id.text_description)).check(matches(withText(dataShow.get(0).getDescription())));
        onView(withId(R.id.text_vote)).check(matches(isDisplayed()));
        onView(withId(R.id.text_vote)).check(matches(withText(dataShow.get(0).getVote())));
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()));

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