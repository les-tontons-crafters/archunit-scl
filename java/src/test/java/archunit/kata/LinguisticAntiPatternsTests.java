package archunit.kata;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

// https://www.veneraarnaoudova.com/linguistic-anti-pattern-detector-lapd/las/
@AnalyzeClasses(importOptions = DoNotIncludeTests.class)
public class LinguisticAntiPatternsTests {
    @ArchTest
    public static final ArchRule no_getter_can_return_void = methods().that()
            .haveNameMatching("get.*")
            .should()
            .notHaveRawReturnType(void.class);

    @ArchTest
    public static final ArchRule iser_haser_must_return_booleans = methods().that()
            .haveNameMatching("is[A-Z].*")
            .or().haveNameMatching("has[A-Z].*")
            .should()
            .haveRawReturnType(Boolean.class).orShould()
            .haveRawReturnType(boolean.class);

    @ArchTest
    public static final ArchRule setters_should_not_return_something = methods().that()
            .haveNameMatching("set[A-Z].*")
            .should()
            .haveRawReturnType(void.class);
}
