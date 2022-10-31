package archunit.kata;

import archunit.kata.examples.CommandHandler;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@AnalyzeClasses(importOptions = DoNotIncludeTests.class)
public class NamingConventionTests {
    @ArchTest
    public static final ArchRule services_should_be_suffixed_by_service = classes().that()
            .resideInAnyPackage("..service..", "..services..").and()
            .areAnnotatedWith(Service.class)
            .should()
            .haveSimpleNameEndingWith("Service");

    @ArchTest
    public static final ArchRule command_handlers_should_be_suffixed_by_command_handler = classes().that()
            .implement(CommandHandler.class)
            .should()
            .haveSimpleNameEndingWith("CommandHandler");

    @ArchTest
    public static final ArchRule methods_should_start_with_lower_case = methods()
            .should()
            .haveNameMatching("[a-z].*")
            .because("We are not in C# 🤪");
}
