package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

import java.util.Map;

public class primeNumber extends Statement {

    private final int parameter;

    public primeNumber(int value) {
        this.parameter = value;
    }

    @Override
    public int execute (int count, Map<String, Value> memory) {
        push(new Value<>(isprimeNumber(this.parameter)));
        return count +1;
    }

    @Override
    public double executeDouble(double count, Map<String, Value> memory) {
        return 0;
    }

    private boolean isprimeNumber(int value) {
        if (value < 2) {
            return false;
        }
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

}
