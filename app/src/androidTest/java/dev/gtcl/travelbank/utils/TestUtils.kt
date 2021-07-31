package dev.gtcl.travelbank.utils

import androidx.annotation.IdRes

fun withRecyclerView(@IdRes recyclerViewId: Int) =
    RecyclerViewMatcher(recyclerViewId)

fun hasSizeOf(size: Int) =
    RecyclerViewListSizeAssertion(size)