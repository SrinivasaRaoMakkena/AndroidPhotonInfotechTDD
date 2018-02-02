package com.example.androidphotoninfotechtdd;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewParent;
import android.widget.TableLayout;
import android.widget.TableRow;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.matchers.TypeSafeMatcher;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void rowsEnter() {
        onView(withId(R.id.row)).perform(typeText("3"));
        onView(withId(R.id.col)).perform(typeText("3"));
        onView(withId(R.id.gen)).perform(click());
//        for(int i=1;i<30;i++) {
        onView(withId(1)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("3"));
        onView(withId(R.id.set_node)).perform(click());

        onView(withId(2)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("3"));
        onView(withId(R.id.set_node)).perform(click());
        onView(withId(3)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("3"));
        onView(withId(R.id.set_node)).perform(click());
//        onView(withId(4)).perform(click());
//        onView(withId(R.id.input_e)).perform(typeText("3"));
//        onView(withId(R.id.set_node)).perform(click());
//
//        onView(withId(5)).perform(click());
//        onView(withId(R.id.input_e)).perform(typeText("3"));
//        onView(withId(R.id.set_node)).perform(click());
//        }
        // onView(withId(2)).perform(click());

    }


    @Test
    public void testAtPositionInTableMatcher() {
//        onView(atPositionInTable(0,0)).check(matches(withText("0,0")));

        onView(withId(R.id.row)).perform(typeText("2"));
        onView(withId(R.id.col)).perform(typeText("2"));
        onView(withId(R.id.gen)).perform(click());

        // onView(withId(R.id.matrix));
        onView(atPositionInTable(0, 0)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("3"));
        onView(withId(R.id.set_node)).perform(click());
        onView(atPositionInTable(0, 1)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("3"));
        onView(withId(R.id.set_node)).perform(click());
        onView(atPositionInTable(0, 2)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("3"));
        onView(withId(R.id.set_node)).perform(click());

//
    }

    static Matcher<View> atPositionInTable(final int x, final int y) {
        return new TypeSafeMatcher<View>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("is at position # " + x + " , " + y);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent viewParent = view.getParent();
                if (!(viewParent instanceof TableRow)) {
                    return false;
                }
                TableRow row = (TableRow) viewParent;
                TableLayout table = (TableLayout) row.getParent();
                row.getChildCount();

                return false;
            }


        };
    }
}