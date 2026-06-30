package com.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    EvenCheckerTest.class,
    ExceptionThrowerTest.class,
    OrderedTests.class,
    PerformanceTesterTest.class
})
public class AllTests {
}
