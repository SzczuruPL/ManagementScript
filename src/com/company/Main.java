package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Task> assignmentList = new ArrayList<>();
        assignmentList.add(new Task("1", "Sprzątanie", 5));
        assignmentList.add(new Task("2", "Naprawianie", 3));
        assignmentList.add(new Task("3", "Modyfikowanie", 8));
        assignmentList.add(new Task("4", "Obsługiwanie", 10));
        assignmentList.add(new Task("5", "Nadzorowanie", 2));
        assignmentList.add(new Task("6", "Spanie", 21));
        assignmentList.add(new Task("7", "Udawanie", 37));

        Factory factory = new Management(assignmentList);

        Scanner scanner = new Scanner(System.in);

        int choice;
        String name, taskId;

        do {
            System.out.println("\n=== MENU GŁÓWNE ===");
            System.out.println("1. Przypisz zadanie");
            System.out.println("2. Odepnij zadanie");
            System.out.println("3. Wyświetl dostępne zadania");
            System.out.println("4. Wyświetl zadania alfabetycznie");
            System.out.println("5. Wyświetl zadania po czasie realizacji");
            System.out.println("6. Zakończ");

            System.out.print("Wybierz opcję: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Podaj imię pracownika: ");
                    name = scanner.next();
                    System.out.print("Podaj ID zadania: ");
                    taskId = scanner.next();
                    factory.assign(name, taskId);
                    break;
                case 2:
                    System.out.print("Podaj imię pracownika: ");
                    name = scanner.next();
                    System.out.print("Podaj ID zadania: ");
                    taskId = scanner.next();
                    factory.remove(name, taskId);
                    break;
                case 3:
                    /*System.out.print("Podaj imię pracownika: ");
                    name = scanner.next();
                    List<Task> getTasks = factory.get(name);
                    System.out.println("Dostępne zadania dla pracownika " + name + ":");
                    for (Task task : getTasks) {
                        System.out.println(task.getId() + " - " + task.getName() + " (" + task.getTime() + ")");
                    }*/
                    for (Task task : assignmentList) {
                        System.out.println(task.getId() + " - " + task.getName() + " (" + task.getTime() + ")");
                    }
                    break;
                case 4:
                    List<Task> alphaSort = new ArrayList<>(assignmentList);
                    alphaSort.sort(Comparator.comparing(Task::getName));
                    System.out.println("Zadania posortowane alfabetycznie:");
                    for (Task task : alphaSort) {
                        System.out.println(task.getId() + " - " + task.getName() + " (" + task.getTime() + ")");
                    }
                    break;
                case 5:
                    List<Task> timeSort = new ArrayList<>(assignmentList);
                    timeSort.sort(Comparator.comparingInt(Task::getTime));
                    System.out.println("Zadania posortowane według czasu realizacji:");
                    for (Task task : timeSort) {
                        System.out.println(task.getId() + " - " + task.getName() + " (" + task.getTime() + ")");
                    }
                    break;
                case 6:
                    System.out.println("Zakończono program.");
                    break;
                default:
                    System.out.println("Nieznana opcja. Spróbuj ponownie.");
            }
        } while (choice != 6);
    }
}

//kolokwium jest sus
