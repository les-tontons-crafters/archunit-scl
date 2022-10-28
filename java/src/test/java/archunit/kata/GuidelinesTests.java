package archunit.kata;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

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
    public static final ArchRule service_slice_have_no_cycle_dependencies =
            slices().matching("archunit.kata.modules.(*)..").should()
                    .beFreeOfCycles();
}