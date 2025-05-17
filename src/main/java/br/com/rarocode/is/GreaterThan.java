package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

public class GreaterThan extends BinaryOperation<Integer>{
    @Override
    public void execute(Value<Integer> a, Value<Integer> b) {
        push(a);
        push(b);
        push(new Value<>(b.getValue() > a.getValue()));
    }
}
