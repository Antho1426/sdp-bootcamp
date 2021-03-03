package com.github.antho1426.bootcamp;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class) // this indicates that the test will be ran using a special version of JUnit4
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    private static final String TEST_NAME = "Alice";

    @Test
    public void intentIsFiredWhenUserClicksOnButton() {
        Intents.init();

        onView(withId(R.id.edit_text_username)).perform(clearText(), typeText(TEST_NAME));
        closeSoftKeyboard();
        onView(withId(R.id.button_greeting_activity)).perform(click());

        Intents.intended(Matchers.allOf(IntentMatchers.hasComponent(GreetingActivity.class.getName()), IntentMatchers.hasExtra(GreetingActivity.EXTRA_USER_NAME, TEST_NAME)));

        Intents.release();
    }
}
