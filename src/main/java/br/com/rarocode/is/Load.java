package br.com.rarocode.is;


import br.com.rarocode.machine.Value;

import java.util.Map;

public class Load extends Statement {
    private final String variable;
    private String label;

    public Load(String variable) {
        this.variable = variable;
    }

    @Override
    public int execute(int count, Map<String, Value> memory) {
        push(memory.get(variable));
        return count + 1;
    }

    @Override
    public double executeDouble(double count, Map<String, Value> memory) {
        return 0;
    }

    public String getVariable() {
        return variable;
    }

    public String toString() {
        return getClass().getSimpleName() + " " + this.label ;
    }
}
