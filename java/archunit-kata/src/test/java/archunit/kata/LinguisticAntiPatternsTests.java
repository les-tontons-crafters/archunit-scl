package archunit.kata;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static archunit.kata.ArchRuleUtils.emptyRule;
import static com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;

// https://www.veneraarnaoudova.com/linguistic-anti-pattern-detector-lapd/las/
@AnalyzeClasses(importOptions = DoNotIncludeTests.class)
public class LinguisticAntiPatternsTests {
    @ArchTest
    public static final ArchRule no_getter_can_return_void =
            emptyRule("getter should never return void");

    @ArchTest
    public static final ArchRule iser_haser_must_return_booleans =
            emptyRule("is/has methods should only return booleans");

    @ArchTest
    public static final ArchRule setters_should_not_return_something =
            emptyRule("setters should not return something");
}
