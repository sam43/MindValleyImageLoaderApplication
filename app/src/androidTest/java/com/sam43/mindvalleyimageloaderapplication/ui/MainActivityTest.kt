package com.sam43.mindvalleyimageloaderapplication.ui


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.sam43.mindvalleyimageloaderapplication.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val imageView = onView(
            allOf(
                withId(R.id.ivImage), withContentDescription("MindValleyApp"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        AssertionError(imageView.check(matches(isDisplayed())))

        val textView = onView(
            allOf(
                withId(R.id.tvUserName), withText("Nicholas Kampouris"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                        2
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        AssertionError(textView.check(matches(withText("Nicholas Kampouris"))))

        val imageView3 = onView(
            allOf(
                withId(R.id.ivUserImage),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                        2
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        AssertionError(imageView3.check(matches(isDisplayed())))

        val textView2 = onView(
            allOf(
                withId(R.id.tvCaption), withText("nicholaskampouris"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                        2
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        AssertionError(textView2.check(matches(withText("nicholaskampouris"))))

        val textView3 = onView(
            allOf(
                withId(R.id.tvCountHeart), withText("13"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.view.ViewGroup::class.java),
                        2
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        AssertionError(textView3.check(matches(withText("13"))))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
