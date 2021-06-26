package ar.edu.unq.desapp.grupoL012021.backenddesappapl.architecture;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures.*;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

public class ArchitectureTest {

    JavaClasses projectClasses = new ClassFileImporter().importPackages("ar.edu.unq.desapp.grupoL012021.backenddesappapl");

    @Test
    public void servicesInServicePackageTest() {
        ArchRule rule = classes().that().areAnnotatedWith(Service.class).should().resideInAPackage("..services..");

        rule.check(projectClasses);
    }



    @Test
    public void repositoryInPersistencePackageTest() {
        ArchRule rule = classes().that().areAnnotatedWith(Repository.class).should().resideInAPackage("..persistence..");

        rule.check(projectClasses);
    }

    @Test
    public void restControllerInWebServicePackageTest() {
        ArchRule rule = classes().that().areAnnotatedWith(RestController.class).should().resideInAPackage("..webservices..");

        rule.check(projectClasses);
    }

    @Test
    public void layersTest() {
        LayeredArchitecture layers = layeredArchitecture()
                .layer("WebService").definedBy("..webservices..")
                .layer("Service").definedBy("..services..")
                .layer("Persistence").definedBy("..persistence..")
                .whereLayer("WebService").mayNotBeAccessedByAnyLayer()
                .whereLayer("Service").mayOnlyBeAccessedByLayers("WebService")
                .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service");

        layers.check(projectClasses);
    }
}
