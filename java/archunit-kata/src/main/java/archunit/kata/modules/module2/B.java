package archunit.kata.modules.module2;

import archunit.kata.modules.module1.A;

public class B {
    private A createA() {
        return new A(this);
    }
}
