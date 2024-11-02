package skaterental;

import java.io.*;
import java.util.Scanner;

public class Main {
    /*
        Creational Pattern: Factory Pattern to create different types of skateboards.
        1.
        Structural Pattern: Decorator Pattern to add additional features or services.
        2. Maybe add feature of pochinit' skateboard
        Behavioral Pattern: Strategy Pattern to manage different pricing schemes.
        3. Make payment with Strategy Pattern

        Somewhere use structural facade
        1. Single Responsibility Principles
        2. Open Closed principles
    */
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        SkateRentalFacade skateRentalFacade = new SkateRentalFacade();
        while (true) {
            System.out.print("Do you want to sign up or log in?: ");
            String signUpOrLogin = sc.nextLine();
            if (signUpOrLogin.equalsIgnoreCase("log in")) {
                Main.logIn();
            } else if (signUpOrLogin.equalsIgnoreCase("sign up")) {
                Main.signUp();
            }
        }
    }

    public static void logIn(){
        System.out.println("Logging...");
        System.out.print("Enter your login: ");
        String login = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        String file_path = "skaterental/users.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file_path));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(";");

                if (login.equals(row[0]) && password.equals(row[1])) {
                    SkateRentalFacade.run();
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    public static void signUp(){
        System.out.println("Signing up...");
        System.out.print("Enter your login: ");
        String login = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        String filePath = "skaterental/users.csv";

        try (FileWriter writer = new FileWriter(filePath, true)) {
            StringBuilder sb = new StringBuilder();
            sb.append(login).append(";").append(password).append("\n");
            writer.write(sb.toString());
            System.out.println("Login and password was added.");
        } catch (Exception e){
            System.out.println(e.getMessage());;
        }
    }
}
