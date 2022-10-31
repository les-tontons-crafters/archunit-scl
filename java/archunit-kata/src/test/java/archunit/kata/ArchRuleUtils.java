package archunit.kata;

import com.tngtech.archunit.lang.ArchRule;
import lombok.experimental.UtilityClass;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@UtilityClass
public class ArchRuleUtils {
    public static ArchRule emptyRule(String because) {
        return classes()
                .should()
                .be("Empty rule")
                .because(because);
    }
}
