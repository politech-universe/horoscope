package com.product.bugnado.horoscope.internet_enabled_tests;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import android.support.test.uiautomator.UiDevice;
import com.product.bugnado.horoscope.R;
import com.product.bugnado.horoscope.SignIn;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;


@RunWith(AndroidJUnit4.class)
public class SignInTest {

    @Rule
    public ActivityTestRule<SignIn> mActivityRule =
            new ActivityTestRule<>(SignIn.class);

    @Test
    public void signInInitializationTest() {
        onView(withId(R.id.imageView2)).check(matches(isDisplayed()));
        onView(withId(R.id.textNameInput)).check(matches(isDisplayed()));
        onView(withId(R.id.textDateInput)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonContinue)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonVk)).check(matches(isDisplayed()));
    }

    @Test
    public void signInToHoroscopeTest() {
        onView(withId(R.id.textNameInput))
                .perform(typeText("HELLO"), closeSoftKeyboard());
        onView(withId(R.id.buttonContinue)).perform(click());

        onView(withId(R.id.username)).check(matches(isDisplayed()));
    }

    @Test
    public void isNameEnteredTest() {
        onView(withId(R.id.buttonContinue)).perform(click());

        onView(withId(R.id.textNameMissing)).check(matches(isDisplayed()));
    }

    @Test
    public void isBirthDateEnteredTest() {
        onView(withId(R.id.textNameInput))
                .perform(typeText("HELLO"), closeSoftKeyboard());
        onView(withId(R.id.textDateInput))
                .perform(clearText(), closeSoftKeyboard());
        onView(withId(R.id.buttonContinue)).perform(click());

        onView(withId(R.id.textDateMissing)).check(matches(isDisplayed()));
    }

    @Test
    public void nameIsNameTest() {
        onView(withId(R.id.textNameInput))
                .perform(typeText("HELLO"), closeSoftKeyboard());
        onView(withId(R.id.buttonContinue)).perform(click());
        onView(withId(R.id.username)).check(matches(withText("HELLO")));
    }

    @Test
    public void vkButtonIsAvailableTest() {
        onView(withId(R.id.buttonVk)).perform(click());
    }

    @Test
    public void vkButtonIsNameIsNameTest() throws InterruptedException {
        onView(withId(R.id.textNameInput))
                .perform(typeText("HELLO"), closeSoftKeyboard());
        onView(withId(R.id.buttonVk)).perform(click());
        Thread.sleep(500);
        UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressBack();
        onView(withId(R.id.textNameInput)).check(matches(withText("HELLO")));
    }

}