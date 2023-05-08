package algonquin.cst2335.jun00011;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {

        ViewInteraction appCompatEditText = onView(withId(R.id.editText));
        appCompatEditText.perform(replaceText("12345"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView));
        textView.check(matches(withText("You shall not pass!")));


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//
//        ViewInteraction appCompatEditText = onView(
//                allOf(withId(R.id.editText),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                1),
//                        isDisplayed()));
//        appCompatEditText.perform(click());
//
//        ViewInteraction appCompatEditText2 = onView(
//                allOf(withId(R.id.editText),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                1),
//                        isDisplayed()));
//        appCompatEditText2.perform(click());
//
//        ViewInteraction appCompatEditText3 = onView(
//                allOf(withId(R.id.editText),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                1),
//                        isDisplayed()));
//        appCompatEditText3.perform(replaceText("12345"), closeSoftKeyboard());
//
//        pressBack();
//
//        ViewInteraction materialButton = onView(
//                allOf(withId(R.id.button), withText("LOGIN"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                2),
//                        isDisplayed()));
//        materialButton.perform(click());
//
//        ViewInteraction textView = onView(
//                allOf(withId(R.id.textView), withText("You shall not pass!"),
//                        withParent(withParent(withId(android.R.id.content))),
//                        isDisplayed()));
//        textView.check(matches(withText("You shall not pass!")));
//    }
//
//    private static Matcher<View> childAtPosition(
//            final Matcher<View> parentMatcher, final int position) {
//
//        return new TypeSafeMatcher<View>() {
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("Child at position " + position + " in parent ");
//                parentMatcher.describeTo(description);
//            }
//
//            @Override
//            public boolean matchesSafely(View view) {
//                ViewParent parent = view.getParent();
//                return parent instanceof ViewGroup && parentMatcher.matches(parent)
//                        && view.equals(((ViewGroup) parent).getChildAt(position));
//            }
//        };
    }

    @Test
    public void testFindMissingUpperCase(){
        //find the view
        ViewInteraction appcompatEditText = onView(withId(R.id.editText));
        //type in chloe123#$*
        appcompatEditText.perform(replaceText("chloe123#$*"));

        //find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click the button
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView( withId(R.id.textView));
        //check the text
        textView.check(matches(withText("You shall not pass!")));
    }

    @Test
    public void testFindMissingLowerCase(){
        //find the view
        ViewInteraction appcompatEditText = onView(withId(R.id.editText));
        //type in CHLOE123#$*
        appcompatEditText.perform(replaceText("CHLOE123#$*"));

        //find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click the button
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView( withId(R.id.textView));
        //check the text
        textView.check(matches(withText("You shall not pass!")));
    }

    @Test
    public void testFindMissingNumberCase(){
        //find the view
        ViewInteraction appcompatEditText = onView(withId(R.id.editText));
        //type in CHloePASS#$*
        appcompatEditText.perform(replaceText("CHloePASS#$*"));

        //find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click the button
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView( withId(R.id.textView));
        //check the text
        textView.check(matches(withText("You shall not pass!")));
    }

    @Test
    public void testFindMissingSpecialCase(){
        //find the view
        ViewInteraction appcompatEditText = onView(withId(R.id.editText));
        //type in cCHLoe123
        appcompatEditText.perform(replaceText("CHLoe123"));

        //find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click the button
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView( withId(R.id.textView));
        //check the text
        textView.check(matches(withText("You shall not pass!")));
    }

    @Test
    public void testFindRightPasswordCase(){
        //find the view
        ViewInteraction appcompatEditText = onView(withId(R.id.editText));
        //type in DAWONchloe123!@#
        appcompatEditText.perform(replaceText("DAWONchloe123!@#"));

        //find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click the button
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView( withId(R.id.textView));
        //check the text
        textView.check(matches(withText("Your password is complex enough")));
    }
};
