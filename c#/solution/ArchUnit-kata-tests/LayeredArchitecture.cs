using ArchUnitNET.Fluent.Syntax.Elements.Types;
using Xunit;
using static ArchUnit.Kata.Tests.ArchUnitExtensions;

namespace ArchUnit.Kata.Tests
{
    public class LayeredArchitecture
    {
        private static GivenTypesConjunctionWithDescription PresentationLayer() =>
            TypesInAssembly().And()
                .ResideInNamespace("Controllers", true)
                .As("Presentation Layer");

        private static GivenTypesConjunctionWithDescription ApplicationLayer() =>
            TypesInAssembly().And()
                .ResideInNamespace("Services", true)
                .As("Application Layer");

        private static GivenTypesConjunctionWithDescription DataAccessLayer() =>
            TypesInAssembly().And()
                .ResideInNamespace("Repositories", true)
                .As("Data Access Layer");

        private GivenTypesConjunctionWithDescription ModelLayer() =>
            TypesInAssembly().And()
                .ResideInNamespace("Models", true)
                .As("Model Layer");
        
        [Fact]
        public void PresentationRules() =>
            PresentationLayer().Should()
                .NotDependOnAny(DataAccessLayer())
                .Check();

        [Fact]
        public void ApplicationRules() =>
            ApplicationLayer().Should()
                .NotDependOnAny(PresentationLayer())
                .Check();

        [Fact]
        public void DataAccessRules() =>
            DataAccessLayer().Should()
                .NotDependOnAny(ApplicationLayer()).AndShould()
                .NotDependOnAny(PresentationLayer())
                .Check();

        [Fact]
        public void ModelRules() =>
            ModelLayer().Should()
                .NotDependOnAny(PresentationLayer()).AndShould()
                .NotDependOnAny(ApplicationLayer()).AndShould()
                .NotDependOnAny(DataAccessLayer())
                .Check();
    }
}