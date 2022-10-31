package archunit.kata;

import archunit.kata.examples.annotations.ExcludeFromCoverage;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(importOptions = ImportOption.DoNotIncludeTests.class)
public class AnnotationTests {
    @ArchTest
    public static final ArchRule coverage_attributes_should_not_be_used = classes()
            .should()
            .notBeAnnotatedWith(ExcludeFromCoverage.class);

    @ArchTest
    public static final ArchRule repositories_reside_in_pkg_repository = classes()
            .that()
            .areAnnotatedWith(Repository.class).should()
            .resideInAnyPackage("..repository..", "..repositories..").andShould()
            .beInterfaces();
}