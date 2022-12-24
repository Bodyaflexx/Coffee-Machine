package machine;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class IngredientCalculator {
    static int availableMoney = 550;
    static int availableWater = 400;
    static int availableMilk = 540;
    static int availableBeans = 120;
    static int availableCups = 9;

    public static void availableInfo() {
        System.out.printf("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                %d of money
                """, availableWater, availableMilk, availableBeans, availableCups, availableMoney);
    }

    public static void mainMethod(String action) {
        Scanner scanner = new Scanner(System.in);
        if (action.equalsIgnoreCase("buy")) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
            String selectedNum = scanner.nextLine();
            if (Objects.equals(selectedNum, "1")) {
                buy(250, 0, 16, 4);
            }
            if (Objects.equals(selectedNum, "2")) {
                buy(350, 75, 20, 7);
            }
            if (Objects.equals(selectedNum, "3")) {
                buy(200, 100, 12, 6);
            }
            if (Objects.equals(selectedNum, "back")) {
                return;
            }
        } else if (action.equalsIgnoreCase("fill")) {
            List<Integer> result = new ArrayList<>();
            System.out.println("Write how many ml of water you want to add:");
            result.add(scanner.nextInt());
            System.out.println("Write how many ml of milk you want to add:");
            result.add(scanner.nextInt());
            System.out.println("Write how many grams of coffee beans you want to add:");
            result.add(scanner.nextInt());
            System.out.println("Write how many disposable cups you want to add:");
            result.add(scanner.nextInt());
            fill(result.get(0), result.get(1), result.get(2), result.get(3));
        } else if (action.equalsIgnoreCase("take")) {
            System.out.printf("I gave you $%d", IngredientCalculator.availableMoney);
            take();
        } else if (action.equalsIgnoreCase("remaining")) {
            availableInfo();
        }

    }

    private static void buy(int needWater, int needMilk, int needBean, int needMoney) {
        if (needWater > availableWater) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (needMilk > availableMilk) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (needBean > availableBeans) {
            System.out.println("Sorry, not enough beans!");
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        availableBeans -= needBean;
        availableWater -= needWater;
        availableMilk -= needMilk;
        availableMoney += needMoney;
        availableCups--;
    }

    private static void fill(int addWater, int addMilk, int addBean, int addCups) {
        availableBeans += addBean;
        availableWater += addWater;
        availableMilk += addMilk;
        availableCups += addCups;
    }

    private static void take() {
        availableMoney = 0;
    }

}
