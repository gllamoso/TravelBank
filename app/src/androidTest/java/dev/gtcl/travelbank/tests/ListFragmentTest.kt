package dev.gtcl.travelbank.tests

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import dev.gtcl.travelbank.R
import dev.gtcl.travelbank.presentation.MainActivity
import dev.gtcl.travelbank.utils.hasSizeOf
import dev.gtcl.travelbank.utils.withRecyclerView
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class ListFragmentTest {

    // Fragment needs MainActivity to prevent crashes
    private lateinit var activityScenario: ActivityScenario<MainActivity>

    @Before
    fun setup(){
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
        Thread.sleep(3_000)
    }

    @Test
    fun checkListContent(){
        onView(withId(R.id.expense_list)).check(hasSizeOf(4))

        // Expense 1
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(0, R.id.merchant_title))
            .check(matches(withText("Lunch")))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(0, R.id.date))
            .check(matches(withText("Jul 13")))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(0, R.id.amount))
            .check(matches(withText("$20.00")))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(0, R.id.category))
            .check(matches(withText("PerDiem")))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(0, R.id.currency))
            .check(matches(not(isDisplayed())))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(0, R.id.attachment_preview))
            .check(matches(isDisplayed()))

        // Expense 2
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(1 , R.id.merchant_title))
            .check(matches(withText("New Laptop")))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(1, R.id.date))
            .check(matches(withText("Jul 13")))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(1, R.id.amount))
            .check(matches(withText("$2,421.79")))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(1, R.id.category))
            .check(matches(withText("Other")))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(1, R.id.currency))
            .check(matches(not(isDisplayed())))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(1, R.id.attachment_preview))
            .check(matches(isDisplayed()))

        // Expense 3
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(2 , R.id.merchant_title))
            .check(matches(withText("Breakfast")))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(2, R.id.date))
            .check(matches(withText("Jul 9")))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(2, R.id.amount))
            .check(matches(withText("$10.00")))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(2, R.id.category))
            .check(matches(withText("PerDiem")))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(2, R.id.currency))
            .check(matches(not(isDisplayed())))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(2, R.id.attachment_preview))
            .check(matches(not(isDisplayed())))

        // Expense 4
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(3 , R.id.merchant_title))
            .check(matches(withText("Coffee")))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(3, R.id.date))
            .check(matches(withText("Jul 9")))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(3, R.id.amount))
            .check(matches(withText("$1.82")))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(3, R.id.category))
            .check(matches(withText("PerDiem")))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(3, R.id.currency))
            .check(matches(allOf(isDisplayed(), withText("EUR"))))
        onView(withRecyclerView(R.id.expense_list)
            .atPositionOnView(3, R.id.attachment_preview))
            .check(matches(not(isDisplayed())))

    }
}