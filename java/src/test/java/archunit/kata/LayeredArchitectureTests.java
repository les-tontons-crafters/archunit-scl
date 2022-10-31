package archunit.kata;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "archunit.kata.layered", importOptions = ImportOption.DoNotIncludeTests.class)
public class LayeredArchitectureTests {
    private static final String CONTROLLER = "Controller";
    private static final String SERVICE = "Service";
    private static final String DOMAIN = "Domain";
    private static final String MODEL = "Model";
    private static final String REPOSITORY = "Repository";

    @ArchTest
    public static final ArchRule layers_should_be_respected = layeredArchitecture()
            .consideringAllDependencies()
            .layer(CONTROLLER).definedBy("..controllers..")
            .layer(SERVICE).definedBy("..services..")
            .layer(DOMAIN).definedBy("..domain..")
            .layer(MODEL).definedBy("..models..")
            .layer(REPOSITORY).definedBy("..repositories..")
            .whereLayer(CONTROLLER).mayNotBeAccessedByAnyLayer()
            .whereLayer(SERVICE).mayOnlyBeAccessedByLayers(CONTROLLER)
            .whereLayer(DOMAIN).mayOnlyBeAccessedByLayers(REPOSITORY, SERVICE)
            .whereLayer(DOMAIN).mayNotAccessAnyLayer()
            .whereLayer(MODEL).mayOnlyBeAccessedByLayers(SERVICE, CONTROLLER)
            .whereLayer(MODEL).mayNotAccessAnyLayer()
            .whereLayer(REPOSITORY).mayOnlyBeAccessedByLayers(SERVICE);
}
