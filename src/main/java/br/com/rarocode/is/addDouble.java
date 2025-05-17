package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

// TODO FEITO -> ADICIONANDO DOUBLE (COLOCADO EM OUTRAS PARTES TAMBÉM)
public class addDouble extends BinaryOperation<Double> {
    @Override
    public void execute(Value<Double> a, Value<Double> b) {
        Value<Double> resultado = new Value<>(b.getValue() + a.getValue());
        push(resultado);
    }
}
