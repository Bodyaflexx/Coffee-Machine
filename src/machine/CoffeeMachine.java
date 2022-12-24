package machine;

import java.util.Scanner;


public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = scanner.nextLine();
        while (!action.equalsIgnoreCase("exit")) {
            IngredientCalculator.mainMethod(action);
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.nextLine();
        }

    }

}
