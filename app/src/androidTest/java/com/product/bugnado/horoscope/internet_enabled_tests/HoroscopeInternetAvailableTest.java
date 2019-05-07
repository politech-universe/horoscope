package com.product.bugnado.horoscope.internet_enabled_tests;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.product.bugnado.horoscope.R;
import com.product.bugnado.horoscope.SignIn;
import com.product.bugnado.horoscope.Zodiac;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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


@RunWith(AndroidJUnit4.class)
public class HoroscopeInternetAvailableTest {

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
    }

    @Test
    public void horoscopeInitTest() {
        onView(withId(R.id.username)).check(matches(isDisplayed()));
        onView(withId(R.id.text_prediction)).check(matches(isDisplayed()));
        onView(withId(R.id.text_resource)).check(matches(isDisplayed()));
        onView(withId(R.id.spinner)).check(matches(isDisplayed()));
        onView(withId(R.id.b2)).check(matches(isDisplayed()));
        onView(withId(R.id.b1)).check(matches(isDisplayed()));
    }

    @Test
    public void horoscopeZodiacListTest() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_aquarius)).perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_aries)).perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_cancer)).perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_capricorn)).perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_gemini)).perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_leo)).perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_libra)).perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_pisces)).perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_sagittarius)).perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_scorpio)).perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_taurus)).perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_virgo)).perform(click());
    }

    @Test
    public void horoscopeSignInitTest() {
        onView(withId(R.id.textSign))
                .check(matches(withText(Zodiac.Companion.getSignId(Zodiac.Companion.getSignByDate(bdate)))));
    }

    @Test
    public void horoscopeIsAvailableTest() {
        onView(withId(R.id.text_prediction)).check(matches(not(withText(""))));
        onView(withId(R.id.text_prediction)).check(matches(not(withText(R.string.missing_prediction))));
    }

    @Test
    public void horoscopeNameClickedTest() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_aquarius)).perform(click());
        onView(withId(R.id.username)).perform(click());
        onView(withId(R.id.textSign))
                .check(matches(withText(Zodiac.Companion.getSignId(Zodiac.Companion.getSignByDate(bdate)))));
    }

    @Test
    public void horoscopeSpinnerTodayDefaultValueTest() {
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("на сегодня"))));
    }

    @Test
    public void horoscopeSignChangeTest() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_aquarius)).perform(click());
        onView(withId(R.id.textSign)).check(matches(withText(R.string.name_aquarius)));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_aries)).perform(click());
        onView(withId(R.id.textSign)).check(matches(withText(R.string.name_aries)));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_cancer)).perform(click());
        onView(withId(R.id.textSign)).check(matches(withText(R.string.name_cancer)));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_capricorn)).perform(click());
        onView(withId(R.id.textSign)).check(matches(withText(R.string.name_capricorn)));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_gemini)).perform(click());
        onView(withId(R.id.textSign)).check(matches(withText(R.string.name_gemini)));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_leo)).perform(click());
        onView(withId(R.id.textSign)).check(matches(withText(R.string.name_leo)));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_libra)).perform(click());
        onView(withId(R.id.textSign)).check(matches(withText(R.string.name_libra)));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_pisces)).perform(click());
        onView(withId(R.id.textSign)).check(matches(withText(R.string.name_pisces)));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_sagittarius)).perform(click());
        onView(withId(R.id.textSign)).check(matches(withText(R.string.name_sagittarius)));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_scorpio)).perform(click());
        onView(withId(R.id.textSign)).check(matches(withText(R.string.name_scorpio)));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_taurus)).perform(click());
        onView(withId(R.id.textSign)).check(matches(withText(R.string.name_taurus)));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.name_virgo)).perform(click());
        onView(withId(R.id.textSign)).check(matches(withText(R.string.name_virgo)));
    }

    @Test
    public void horoscopeSpinnerTest() {
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("на вчера"))).perform(click());
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("на вчера"))));

        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("на сегодня"))).perform(click());
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("на сегодня"))));

        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("на завтра"))).perform(click());
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("на завтра"))));

        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("на неделю"))).perform(click());
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("на неделю"))));

        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("на месяц"))).perform(click());
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("на месяц"))));

        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("на год"))).perform(click());
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("на год"))));
    }

    @Test
    public void horoscopeSpinnerAvailableTest() {
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("на вчера"))).perform(click());
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("на вчера"))));

        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("на сегодня"))).perform(click());
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("на сегодня"))));

        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("на завтра"))).perform(click());
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("на завтра"))));

        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("на неделю"))).perform(click());
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("на неделю"))));

        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("на месяц"))).perform(click());
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("на месяц"))));

        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("на год"))).perform(click());
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(containsString("на год"))));
    }

    @Test
    public void horoscopeSignAndNameCheckIsNotChangedTest() {
        onView(withId(R.id.b2)).perform(click());
        onView(withId(R.id.b11)).perform(click());
        onView(withId(R.id.textSign))
                .check(matches(withText(Zodiac.Companion.getSignId(Zodiac.Companion.getSignByDate(bdate)))));
        onView(withId(R.id.username)).check(matches(withText("HELLO")));
    }

}