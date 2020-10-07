package ru.mail.DZ_1.controller;


import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        System.out.println("\nВедите имя автора в фромате 'Иван Иванов'.");
        System.out.println("Если авторов несколько (имеют совместно написанные книги)," +
                " введите имена через запятую: 'Иван Иванов, Петр Петров'.");
        Scanner scanner = new Scanner(System.in);

        String authorName = scanner.nextLine();

        LibraryFactory library = new LibraryFactory();

        library.findAllAuthorBooks(authorName);

    }
}