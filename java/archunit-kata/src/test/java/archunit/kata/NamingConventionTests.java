package archunit.kata;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static archunit.kata.ArchRuleUtils.emptyRule;
import static com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;

@AnalyzeClasses(importOptions = DoNotIncludeTests.class)
public class NamingConventionTests {
    @ArchTest
    public static final ArchRule services_should_be_suffixed_by_service =
            emptyRule("Services should be suffixed by Service");

    @ArchTest
    public static final ArchRule command_handlers_should_be_suffixed_by_command_handler =
            emptyRule("Command handlers should be suffixed by CommandHandler");

    @ArchTest
    public static final ArchRule methods_should_start_with_lower_case =
            emptyRule("Method names should start by a lowercase letter");
}
