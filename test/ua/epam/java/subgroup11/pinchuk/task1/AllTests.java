package ua.epam.java.subgroup11.pinchuk.task1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ua.epam.java.subgroup11.pinchuk.task1.task12.ProductListTest;
import ua.epam.java.subgroup11.pinchuk.task1.task12.iterator.PredicateIteratorTest;


@RunWith(Suite.class)
@SuiteClasses({ ProductListTest.class, PredicateIteratorTest.class })
public class AllTests {

}
