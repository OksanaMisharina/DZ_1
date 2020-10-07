package ru.mail.DZ_1.controller;

public class LibraryFactory {
    Library library;

    public LibraryFactory() {
        this.library = new Library();
        library.createListOfBooks();
        library.createLibrary();
    }

    void findAllAuthorBooks(String authorName){
        System.out.println(library.printBooks(library.findAuthor(authorName)));
    }
}
