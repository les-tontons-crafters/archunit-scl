package archunit.kata;

import archunit.kata.examples.CommandHandler;
import archunit.kata.examples.models.ApiResponse;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.elements.GivenMethodsConjunction;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@AnalyzeClasses(importOptions = DoNotIncludeTests.class)
public class MethodReturnTypesTests {
    @ArchTest
    public static final ArchRule command_handlers_should_only_return_ints = publicMethods().and()
            .areDeclaredInClassesThat()
            .implement(CommandHandler.class)
            .should()
            .haveRawReturnType(int.class)
            .orShould()
            .haveRawReturnType(Integer.class);

    @ArchTest
    public static final ArchRule controllers_should_only_return_api_response = publicMethods().and()
            .areDeclaredInClassesThat()
            .areAnnotatedWith(RestController.class)
            .should()
            .haveRawReturnType(ApiResponse.class);

    private static GivenMethodsConjunction publicMethods() {
        return methods().that().arePublic();
    }
}
