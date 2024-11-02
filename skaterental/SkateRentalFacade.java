package skaterental;

import skaterental.boards.Skateboard;
import skaterental.strategy_scenarios.Default;
import skaterental.strategy_scenarios.Premium;
import skaterental.strategy_scenarios.Common;
import skaterental.strategy_scenarios.Tariff;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SkateRentalFacade {
    private static Map <String, Tariff> tariffMap = new HashMap<String, Tariff>();
    private static SkateboardFactory skateboardFactory;
    private static double cash = 2300;
    SkateRentalFacade() {
        tariffMap.put("common", new Common());
        tariffMap.put("premium", new Premium());
        tariffMap.put("default", new Default());
        skateboardFactory = new SkateboardFactory();
    }
    public static void run() {
        System.out.println("Hello and welcome to terminal application named Skate Rental.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter the board you want to rent?: ");
                String board = scanner.nextLine();
                Skateboard skateboard;
                skateboard = skateboardFactory.createSkateboard(board);

                System.out.print("Enter your tariff (Common, Premium): ");
                String tariffName = scanner.nextLine();
                Tariff tariff = tariffMap.get(tariffName.toLowerCase());

                tariff.getDescription();
                PaymentTariffStrategy paymentTariffStrategy = new PaymentTariffStrategy(tariff);

                System.out.print("Enter how much time you want to rent?: ");
                int time = Integer.parseInt(scanner.nextLine());
                while (time < 0) {
                    System.out.println("Invalid time");
                    System.out.print("Enter how much time you want to rent?: ");
                    time = Integer.parseInt(scanner.nextLine());
                }
                double price = paymentTariffStrategy.pay(skateboard, time);
                System.out.print("Do you want to continue? (y/n): ");

                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    if ((cash -price) < 0){
                        System.out.println("You don't have enough money!");
                    }
                    cash -= price;
                    System.out.println("Now you have " + (cash) + " cash");
                } else {
                    break;
                }

                System.out.println("Still want to rent something?");
                if (scanner.nextLine().equalsIgnoreCase("no")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
