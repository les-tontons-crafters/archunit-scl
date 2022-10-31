package archunit.kata;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import static com.tngtech.archunit.lang.CompositeArchRule.of;
import static com.tngtech.archunit.library.GeneralCodingRules.*;

@AnalyzeClasses(importOptions = DoNotIncludeTests.class)
public class ProvidedJavaRulesTests {
    @ArchTest
    public static final ArchRule no_joda_time = NO_CLASSES_SHOULD_USE_JODATIME;

    @ArchTest
    public static final ArchRule no_field_injection = NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

    @ArchTest
    public static final ArchRule no_classes_should_access_standard_streams_or_throw_generic_exceptions =
            of(NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS)
                    .and(NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS);
}
