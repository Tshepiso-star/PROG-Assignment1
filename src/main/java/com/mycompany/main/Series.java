
package com.mycompany.main;
import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    private static ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void CaptureSeries() {
        System.out.print("Enter the series id: ");
        String id = scanner.nextLine();

        System.out.print("Enter the series name: ");
        String name = scanner.nextLine();

        int age = validateAgeInput();

        System.out.print("Enter the number of episodes for " + name + ": ");
        int episodes = validateIntInput();

        seriesList.add(new SeriesModel(id, name, age, episodes));
        System.out.println("Series processed successfully!!!");
    }

    public static void SearchSeries() {
        System.out.print("Enter the series id to search: ");
        String id = scanner.nextLine();

        for (SeriesModel s : seriesList) {
            if (s.seriesId.equals(id)) {
                printSeriesDetails(s);
                return;
            }
        }

        System.out.println("\nSeries with Series Id: " + id + " was not found!");
    }

    public static void UpdateSeries() {
        System.out.print("Enter the series id to update: ");
        String id = scanner.nextLine();

        for (SeriesModel s : seriesList) {
            if (s.seriesId.equals(id)) {
                System.out.print("Enter the series name: ");
                s.seriesName = scanner.nextLine();

                s.seriesAge = validateAgeInput();

                System.out.print("Enter the number of episodes: ");
                s.seriesNumberOfEpisodes = validateIntInput();

                System.out.println("Series updated successfully!");
                return;
            }
        }

        System.out.println("Series with Series Id: " + id + " was not found!");
    }

    public static void DeleteSeries() {
        System.out.print("Enter the series id to delete: ");
        String id = scanner.nextLine();

        for (SeriesModel s : seriesList) {
            if (s.seriesId.equals(id)) {
                System.out.print("Are you sure you want to delete series " + id + " from the system? Yes (y) to delete.\n");
                String confirm = scanner.nextLine();

                if (confirm.equalsIgnoreCase("y")) {
                    seriesList.remove(s);
                    System.out.println("Series with Series Id: " + id + " WAS deleted!");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                return;
            }
        }

        System.out.println("Series with Series Id: " + id + " was not found!");
    }

    public static void SeriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
            return;
        }

        int count = 1;
        for (SeriesModel s : seriesList) {
            System.out.println("\nSeries " + count++);
            printSeriesDetails(s);
        }
    }

    public static void ExitSeriesApplication() {
        System.out.println("Exiting application. Goodbye!");
        System.exit(0);
    }

    private static void printSeriesDetails(SeriesModel s) {
        System.out.println("SERIES ID: " + s.seriesId);
        System.out.println("SERIES NAME: " + s.seriesName);
        System.out.println("SERIES AGE RESTRICTION: " + s.seriesAge);
        System.out.println("NUMBER OF EPISODES: " + s.seriesNumberOfEpisodes);
    }

    private static int validateAgeInput() {
        while (true) {
            System.out.print("Enter the series age restriction: ");
            String input = scanner.nextLine();

            try {
                int age = Integer.parseInt(input);
                if (age >= 2 && age <= 18) {
                    return age;
                } else {
                    System.out.println("You have entered a incorrect series age !!!");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered a incorrect series age !!!");
            }
            System.out.print("Please re-enter the series age >> ");
        }
    }

    private static int validateIntInput() {
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Please re-enter >> ");
            }
        }
    }
}



