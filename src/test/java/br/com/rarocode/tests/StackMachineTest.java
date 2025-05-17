package br.com.rarocode.tests;

import br.com.rarocode.is.*;
import br.com.rarocode.machine.OutputNotifier;
import br.com.rarocode.machine.StackMachine;
import br.com.rarocode.machine.Value;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StackMachineTest {

    @Test
    public void shouldAddTwoNumbers(){
        //Arrange

        List<Instruction> program = Arrays.asList(
          new Push(new Value<>(33)),
          new Push(new Value<>(51)),
          new Add(),
          new Print(),
          new End()
        );

        List<String> expected = Arrays.asList(
            "84"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        });

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }

    @Test
    public void shouldSubtractTwoNumbers(){
        //Arrange

        List<Instruction> program = Arrays.asList(
                new Push(new Value<>(10)),
                new Push(new Value<>(7)),
                new Sub(),
                new Print(),
                new End()
        );

        List<String> expected = Arrays.asList(
                "3"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        });

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }

    @Test
    public void shouldMultiplyTwoNumbers(){
        //Arrange

        List<Instruction> program = Arrays.asList(
                new Push(new Value<>(10)),
                new Push(new Value<>(7)),
                new Mul(),
                new Print(),
                new End()
        );

        List<String> expected = Arrays.asList(
                "70"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        });

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }

    @Test
    public void shouldDivideTwoNumbers(){
        //Arrange

        List<Instruction> program = Arrays.asList(
                new Push(new Value<>(20)),
                new Push(new Value<>(7)),
                new Div(),
                new Print(),
                new End()
        );

        List<String> expected = Arrays.asList(
                "2"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        });

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }

    @Test
    public void shouldCalcExpression(){
        //Arrange

        List<Instruction> program = Arrays.asList(
                new Push(new Value<>(10)),
                new Push(new Value<>(5)),
                new Add(),
                new Push(new Value<>(3)),
                new Sub(),
                new Push(new Value<>(2)),
                new Mul(),
                new Push(new Value<>(6)),
                new Div(),
                new Print(),
                new End()
        );

        List<String> expected = Arrays.asList(
                "4"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        });

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }

    @Test
    public void shouldPrintFromZeroToTen(){
        //Arrange

        List<Instruction> program = Arrays.asList(
                new Push(new Value<>(5)),
                new Push(new Value<>(0)),
                new Label("Inicio"),
                new Print(),
                new Inc(),
                new Equal(),
                new GotoF("Inicio"),
                new Print(),
                new End()
        );

        List<String> expected = Arrays.asList(
                "0","1","2","3","4","5"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        }, false);

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }

    @Test
    public void shouldStoreAndLoad(){
        //Arrange
        List<Instruction> program = Arrays.asList(
                new Push(new Value<>(5)),
                new Store("limite"),
                new Push(new Value<>(0)),
                new Store("i"),
                new Label("Inicio"),
                new Load("i"),
                new Print(),
                new Load("limite"),
                new Equal(),
                new Load("i"),
                new Inc(),
                new Store("i"),
                new GotoF("Inicio"),
                new End()
        );


        List<String> expected = Arrays.asList(
                "0","1","2","3","4","5"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        }, true);

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }
}
