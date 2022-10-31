package archunit.kata;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;
import static java.util.Arrays.copyOf;

@AnalyzeClasses(importOptions = DoNotIncludeTests.class)
public class GuidelinesTests {
    @ArchTest
    public static final ArchRule class_should_not_depend_on_another = noClasses()
            .that()
            .haveSimpleName("SomeExample")
            .should()
            .dependOnClassesThat()
            .haveSimpleName("Other");

    @ArchTest
    public static final ArchRule controllers_should_reside_in_controller_package = classes()
            .that()
            .areAnnotatedWith(RestController.class).should()
            .resideInAnyPackage("..controller..", "..controllers..");

    @ArchTest
    public static final ArchRule service_slice_have_no_cycle_dependencies = slices()
            .matching("archunit.kata.modules.(*)..").should()
            .beFreeOfCycles();

    @ArchTest
    public static final ArchRule interfaces_should_not_have_name_starting_with_i_in_Java = noClasses()
            .that()
            .areInterfaces().should()
            .haveNameMatching("^.*[.]I[A-Z].*")
            .because("This is not C# you're doing here :-)");

    @ArchTest
    public static final ArchRule classes_in_domain_can_only_depend_on_classes_in_domain_itself =
            restrictClassDependencyOnItselfAndJavaPackages("..domain..", "..domains..")
                    .because("Domain should be isolated and reference only itself");

    private static ArchRule restrictClassDependencyOnItselfAndJavaPackages(String... packages) {
        // Append java packages to authorized packages
        var authorizedPackages = appendToArray(packages, "java..");

        return classes().that()
                .resideInAnyPackage(packages).should()
                .onlyDependOnClassesThat()
                .resideInAnyPackage(authorizedPackages);
    }

    private static <T> T[] appendToArray(T[] array, T element) {
        var authorizedPackages = copyOf(array, array.length + 1);
        authorizedPackages[array.length] = element;

        return authorizedPackages;
    }
}