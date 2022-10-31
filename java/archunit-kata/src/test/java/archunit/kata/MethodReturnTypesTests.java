package archunit.kata;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static archunit.kata.ArchRuleUtils.emptyRule;
import static com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;

@AnalyzeClasses(importOptions = DoNotIncludeTests.class)
public class MethodReturnTypesTests {
    @ArchTest
    public static final ArchRule command_handlers_should_only_return_ints =
            emptyRule("Command handlers should only return ints");

    @ArchTest
    public static final ArchRule controllers_should_only_return_api_response =
            emptyRule("Controllers public methods should only return ApiResponse");
}
