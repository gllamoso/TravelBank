package dev.gtcl.travelbank

import dev.gtcl.travelbank.tests.ExpenseDetailsFragmentTest
import dev.gtcl.travelbank.tests.ExpenseListFragmentTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    ExpenseDetailsFragmentTest::class,
    ExpenseListFragmentTest::class
)
class TestSuite