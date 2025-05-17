package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

import java.util.Map;

public class GotoF extends Statement{

    private final String label;

    public GotoF(String label) {
        this.label = label;
    }

    @Override
    public int execute(int count, Map<String, Value> memory) {
        Value<Boolean> value = pop();
        if(value.getValue() == false){
            return getCounterByLabel(label);
            //Jump
        }
        return count + 1;
    }

    @Override
    public double executeDouble(double count, Map<String, Value> memory) {
        return 0;
    }

    public String toString() {
        return getClass().getSimpleName() + " " + this.label ;
    }
}
