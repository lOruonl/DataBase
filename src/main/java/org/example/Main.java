package org.example;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static DataBase dataBase = new DataBase();

    public static void main(String[] args) throws SQLException {

        System.out.println("Wybierz jaką operacie chcesz wykonac:\n" +
                "1. Wyświetl wszystkie dane użytkowników.\n" +
                "2. Dodaj użytkownika.\n" +
                "3. Modyfikuj użytkownika.\n" +
                "4. Usuń użytkownika.");
        switch (scan.nextInt()) {
            case 1 -> dataBase.selectRows();
            case 2 -> {
                System.out.println("Wpisz email i dodaj haslo");
                System.out.print("Wpisz email: ");
                String email = scan.next();
                System.out.print("Wpish haslo: ");
                String haslo = scan.next();
                dataBase.addUser(email, haslo);
            }
            case 3 ->{
                System.out.println("Jaką operacie chcesz wykonac:\n" +
                        "1. Zmienic Email.\n" +
                        "2. Zmienic Haslo.\n" +
                        "3. Zmienic Email ta Haslo.");
                switch (scan.nextInt()){
                    case 1 -> {
                        System.out.print("Wpisz ID uzytkownika: ");
                        int id = scan.nextInt();
                        System.out.print("Wpisz nowy email: ");
                        String newEmail = scan.next();
                        dataBase.updateEmail(id, newEmail);
                    }
                    case 2 ->{
                        System.out.print("Wpisz ID uzytkownika: ");
                        int id = scan.nextInt();
                        System.out.print("Wpisz nowe Haslo: ");
                        String newHaslo = scan.next();
                        dataBase.updateHaslo(id, newHaslo);
                    }
                    case 3 ->{
                        System.out.print("Wpisz ID uzytkownika: ");
                        int id = scan.nextInt();
                        System.out.print("Wpisz nowy email: ");
                        String newEmail = scan.next();
                        System.out.print("Wpisz nowe Haslo: ");
                        String newHaslo = scan.next();
                        dataBase.updateAllRows(id, newEmail, newHaslo);
                    }
                }
            }
            case 4->{
                System.out.print("Wpisz ID uzytkownika: ");
                dataBase.deleteUser(scan.nextInt());
            }
        }
    }
}