package modules.module2;

import modules.module1.A;

public class B {
    private A createA() {
        return new A(this);
    }
}
