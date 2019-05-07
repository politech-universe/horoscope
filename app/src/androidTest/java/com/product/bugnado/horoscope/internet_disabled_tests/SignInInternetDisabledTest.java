package com.product.bugnado.horoscope.internet_disabled_tests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.product.bugnado.horoscope.R;
import com.product.bugnado.horoscope.SignIn;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class SignInInternetDisabledTest {
    @Rule
    public ActivityTestRule<SignIn> mActivityRule =
            new ActivityTestRule<>(SignIn.class);

    @Test
    public void vkButtonIsAvailableInternetDisableTest() {
        onView(withId(R.id.buttonVk)).perform(click());
    }

}
