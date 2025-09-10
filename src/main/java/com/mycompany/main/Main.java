package com.mycompany.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLATEST SERIES - 2025\n");
            System.out.print("Enter (1) to launch menu or any other key to exit: ");
            String choice = scanner.nextLine();

            if (!choice.equals("1")) {
                System.out.println("Exiting application...");
                break;
            }

            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application.");

            System.out.print("\nEnter your choice: ");
            String menuChoice = scanner.nextLine();

            switch (menuChoice) {
                case "1":
                    Series.CaptureSeries();
                    break;
                case "2":
                    Series.SearchSeries();
                    break;
                case "3":
                    Series.UpdateSeries();
                    break;
                case "4":
                    Series.DeleteSeries();
                    break;
                case "5":
                    Series.SeriesReport();
                    break;
                case "6":
                    Series.ExitSeriesApplication();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

