package archunit.kata;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static archunit.kata.ArchRuleUtils.emptyRule;

@AnalyzeClasses(importOptions = ImportOption.DoNotIncludeTests.class)
public class AnnotationTests {
    @ArchTest
    public static final ArchRule coverage_attributes_should_not_be_used =
            emptyRule("ExcludeFromCoverage attribute should not be used");

    @ArchTest
    public static final ArchRule repositories_reside_in_pkg_repository =
            emptyRule("Classes annotated with @Repository should be inside a repository/repositories package");
}