package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

import java.util.Scanner;

public class Read extends ZeroOperand {
    private Scanner scanner;

    public Read() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        int value = scanner.nextInt();
        push(new Value<>(value));
    }
}