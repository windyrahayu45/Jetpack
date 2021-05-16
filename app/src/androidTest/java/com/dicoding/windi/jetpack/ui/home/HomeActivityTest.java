package com.dicoding.windi.jetpack.ui.home;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.dicoding.windi.jetpack.R;
import com.dicoding.windi.jetpack.data.DataEntity;
import com.dicoding.windi.jetpack.utils.DataDummy;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

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
    public void loadCourses() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition(dataEntityArrayList.size()));
    }

    @Test
    public void loadDetailCourse() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_title)).check(matches(withText(dataEntityArrayList.get(0).getTitle())));
        onView(withId(R.id.text_date)).check(matches(isDisplayed()));

    }



    @Test
    public void loadBookmarks() {
        onView(withText("TV Show")).perform(click());
        onView(withId(R.id.rv_show)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.scrollToPosition(dataShow.size()));
    }

}