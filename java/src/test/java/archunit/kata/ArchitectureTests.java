package archunit.kata;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packages = "rules", importOptions = DoNotIncludeTests.class)
public class ArchitectureTests {
    @ArchTest
    public static final ArchRule cycles = ensureNoCycle("sample");

    @ArchTest
    public static final ArchRule exceptions_resides_in_pkg_exception = classes().that()
            .areAssignableTo(Exception.class)
            .or().areAssignableTo(RuntimeException.class)
            .should().resideInAnyPackage("..exception..", "..exceptions..");

    public static ArchRule ensureNoCycle(String projectPackage) {
        return slices().matching(projectPackage + ".(*)..").should()
                .beFreeOfCycles();
    }
}