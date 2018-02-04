package com.example.androidphotoninfotechtdd;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

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
public class ShortPathCostUITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void testAtPositionInTableMatcher() {

////       60 3 3 6
//
//        6 3 7 9
//
//        5 6 8 3

        onView(withId(R.id.row)).perform(typeText("3"));
        onView(withId(R.id.col)).perform(typeText("4"));
        onView(withId(R.id.gen)).perform(click());


        onView(atPositionInTable(0, 0)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("60"));
        onView(withId(R.id.set_node)).perform(click());
        onView(atPositionInTable(0, 1)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("3"));
        onView(withId(R.id.set_node)).perform(click());
        onView(atPositionInTable(0, 2)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("3"));
        onView(withId(R.id.set_node)).perform(click());
        onView(atPositionInTable(0, 3)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("6"));
        onView(withId(R.id.set_node)).perform(click());

        onView(atPositionInTable(1, 0)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("6"));
        onView(withId(R.id.set_node)).perform(click());
        onView(atPositionInTable(1, 1)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("3"));
        onView(withId(R.id.set_node)).perform(click());
        onView(atPositionInTable(1, 2)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("7"));
        onView(withId(R.id.set_node)).perform(click());
        onView(atPositionInTable(1, 3)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("9"));
        onView(withId(R.id.set_node)).perform(click());


        onView(atPositionInTable(2, 0)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("5"));
        onView(withId(R.id.set_node)).perform(click());
        onView(atPositionInTable(2, 1)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("6"));
        onView(withId(R.id.set_node)).perform(click());
        onView(atPositionInTable(2, 2)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("8"));
        onView(withId(R.id.set_node)).perform(click());
        onView(atPositionInTable(2, 3)).perform(click());
        onView(withId(R.id.input_e)).perform(typeText("3"));
        onView(withId(R.id.set_node)).perform(click());

        onView(withId(R.id.get_result)).perform(click());

        // cheking values of short cost, full path? and path
        onView(withId(R.id.results)).check(matches(withText("Total Cost: " + "14" + "\nFull path: " + "Yes" + "\n Path: " + "3113")));

    }

    // to match the table elements at particular position.
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
                int currentRowIndex = table.indexOfChild(row);

                if (currentRowIndex == x && row.indexOfChild(view) == y) {
                    return true;
                }

                return false;
            }


        };
    }
}