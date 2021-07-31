package dev.gtcl.travelbank

import dev.gtcl.travelbank.tests.DetailsFragmentTest
import dev.gtcl.travelbank.tests.ListFragmentTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    DetailsFragmentTest::class,
    ListFragmentTest::class
)
class TestSuite