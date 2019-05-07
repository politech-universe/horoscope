package com.product.bugnado.horoscope.internet_enabled_tests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import android.widget.EditText;
import com.product.bugnado.horoscope.R;
import com.product.bugnado.horoscope.SignIn;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class DreamerInternetAvaible {

    static String bdate = "";

    @Rule
    public ActivityTestRule<SignIn> mActivityRule =
            new ActivityTestRule<>(SignIn.class);

    @Before
    public void initialize(){
        onView(withId(R.id.textNameInput))
                .perform(typeText("HELLO"), closeSoftKeyboard());
        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        bdate = dateFormat.format(date);
        onView(withId(R.id.buttonContinue)).perform(click());
        onView(withId(R.id.b2)).perform(click());
    }

    @Test
    public void dreamerInitTest() {
        onView(withId(R.id.text_search)).check(matches(isDisplayed()));
        onView(withId(R.id.b11)).check(matches(isDisplayed()));
        onView(withId(R.id.b22)).check(matches(isDisplayed()));
    }

    @Test
    public void searchLupaTest(){
        onView(withId(R.id.text_search)).perform(click());
        onView(withId(R.id.text_search)).perform(typeText("test"));
    }

    @Test
    public void searchEmptyLupaTest(){
        onView(withId(R.id.text_search)).perform(click());
        onView(withId(R.id.text_search)).perform(typeText(""));
    }

    @Test
    public void searchDisgustingLupaTest(){
        onView(withId(R.id.text_search)).perform(click());
        onView(withId(R.id.text_search)).perform(typeText("fasdhjfdhgnjgf"));
    }



}
