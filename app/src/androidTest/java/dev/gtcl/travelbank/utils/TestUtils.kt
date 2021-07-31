package dev.gtcl.travelbank.utils

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

fun withRecyclerView(@IdRes recyclerViewId: Int) =
    RecyclerViewMatcher(recyclerViewId)

fun hasSizeOf(size: Int) =
    RecyclerViewListSizeAssertion(size)