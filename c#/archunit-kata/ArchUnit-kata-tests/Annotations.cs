using System.Diagnostics.CodeAnalysis;
using Xunit;
using static ArchUnit.Kata.Tests.ArchUnitExtensions;
using static ArchUnitNET.Fluent.ArchRuleDefinition;

namespace ArchUnit.Kata.Tests;

public class Annotations
{
    [Fact]
    public void CoverageAttributesShouldNotBeUsedOnClasses() =>
        EmptyRule("ExcludeFromCoverage attribute should not be used")
            .Check();
    
    [Fact]
    public void CoverageAttributesShouldNotBeUsedOnMethods() =>
        EmptyRule("ExcludeFromCoverage attribute should not be used")
            .Check();
    
    [Fact]
    public void CoverageAttributesShouldNotBeUsedOnProperties() =>
        EmptyRule("ExcludeFromCoverage attribute should not be used")
            .Check();
}