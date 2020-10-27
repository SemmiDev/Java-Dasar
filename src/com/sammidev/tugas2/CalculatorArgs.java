package com.sammidev.tugas2;

import java.util.*;

public class CalculatorArgs {
	public static void main(String[] args) {
		try {
	      // Ensure inputs are valid
	      String operation = args[0];
	      int firstInput = Integer.parseInt(args[1]);
	      int secondInput = Integer.parseInt(args[2]);

	      CalculatorCommand cmd = Calculator.getCallculatorCommand(operation);
	      int result = cmd.execute(firstInput, secondInput);
	      System.out.print(result);

	    } catch (InvalidOperationException e) {
	      System.out.print(e.getMessage());
	    } catch (NumberFormatException e) {
	      System.out.print("Invalid number format, " + e.getMessage());
	    }
	}
}


class Calculator {
  private static Map<String, CalculatorCommand> commandMap = new HashMap<>();

  static {
    commandMap.put("add", new AddCommand());
    commandMap.put("substract", new SubstractCommand());
    commandMap.put("multiply", new MultiplyCommand());
    commandMap.put("divide", new DivideCommand());
  }

  public static CalculatorCommand getCallculatorCommand(String command) {
    return commandMap.getOrDefault(command, new UnknownCommand());
  }
}


interface CalculatorCommand {
    int execute(int x, int y);
}

class AddCommand implements CalculatorCommand {
    @Override
    public int execute(int x, int y) {
        return x + y;
    }
}


class DivideCommand implements CalculatorCommand {
    @Override
    public int execute(int x, int y) {

	if (y == 0) {
		throw new CannotDividedByZero("pembagi tak bole nol yaw");
	}
        return x / y;
    }
}


class MultiplyCommand implements CalculatorCommand {
    @Override
    public int execute(int x, int y) {
        return x * y;
    }
}


class SubstractCommand implements CalculatorCommand {
    @Override
    public int execute(int x, int y) {
        return x - y;
    }
}

class UnknownCommand implements CalculatorCommand {
    @Override
    public int execute(int x, int y)  {
        throw new InvalidOperationException("command not implemented");
    }
}

class CannotDividedByZero extends ArithmeticException {
	public CannotDividedByZero(String message) {
		super("message");
	}
}

class InvalidOperationException extends RuntimeException {
  public InvalidOperationException(String errorMessage) {
    super(errorMessage);
  }
}