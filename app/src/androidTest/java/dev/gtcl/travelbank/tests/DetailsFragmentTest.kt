package dev.gtcl.travelbank.tests

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.FragmentScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import dev.gtcl.travelbank.R
import dev.gtcl.travelbank.domain.model.Attachment
import dev.gtcl.travelbank.domain.model.Expense
import dev.gtcl.travelbank.presentation.expense.details.ExpenseDetailsFragment
import org.hamcrest.CoreMatchers.not
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DetailsFragmentTest {

    @Test
    fun testDetailsWithAttachment_viewsMatchingVisibilityAndText(){
        // Expected Data
        val expenseId = "123"
        val amount = 123.1F
        val attachmentFull = "https://preview-api.travelbank.com/v1/Expenses/60ed5fc9b2faef00125b6773/attachments/60ed6039a136fa0012bac147/thumbnail_full?access_token=3YA0PmWE4VP8CL4SgDQPQbjGjrJnSCFJNY2TRkpktRQFQgu2619WwEjneD6knjqO"
        val attachmentList = "https://preview-api.travelbank.com/v1/Expenses/60ed5fc9b2faef00125b6773/attachments/60ed6039a136fa0012bac147/thumbnail_list?access_token=3YA0PmWE4VP8CL4SgDQPQbjGjrJnSCFJNY2TRkpktRQFQgu2619WwEjneD6knjqO"
        val dateStr = "2021-07-13T00:00:00.000Z"
        val title = "Dinner"
        val currency = "USD"
        val category = "PerDiem"
        val expense = Expense(
            expenseId,
            amount,
            listOf(Attachment("image/jpeg", attachmentList, attachmentFull)),
            dateStr,
            title,
            currency,
            category
        )

        FragmentScenario.launchInContainer(
            ExpenseDetailsFragment::class.java,
            bundleOf("expense" to expense),
            R.style.Theme_TravelBank
        )

        onView(withId(R.id.merchant_title)).check(matches(withText(title)))
        onView(withId(R.id.expense_amount)).check(matches(withText("$123.10")))
        onView(withId(R.id.date)).check(matches(withText("Jul 13, 2021")))
        onView(withId(R.id.category)).check(matches(withText(category)))
        onView(withId(R.id.currency)).check(matches(withText(currency)))
        onView(withId(R.id.attachment_preview)).check(matches(isDisplayed()))
    }

    @Test
    fun testDetailsWithoutAttachment_isMatchingVisibilityAndText(){
        // Expected Data
        val expenseId = "123"
        val amount = 12345F
        val dateStr = "2021-07-13T00:00:00.000Z"
        val title = "Breakfast"
        val currency = "EUR"
        val category = "Other"
        val expense = Expense(
            expenseId,
            amount,
            null,
            dateStr,
            title,
            currency,
            category
        )

        FragmentScenario.launchInContainer(
            ExpenseDetailsFragment::class.java,
            bundleOf("expense" to expense),
            R.style.Theme_TravelBank
        )

        onView(withId(R.id.merchant_title)).check(matches(withText(title)))
        onView(withId(R.id.expense_amount)).check(matches(withText("$12,345.00")))
        onView(withId(R.id.date)).check(matches(withText("Jul 13, 2021")))
        onView(withId(R.id.category)).check(matches(withText(category)))
        onView(withId(R.id.currency)).check(matches(withText(currency)))
        onView(withId(R.id.attachment_preview)).check(matches(not(isDisplayed())))
    }
}