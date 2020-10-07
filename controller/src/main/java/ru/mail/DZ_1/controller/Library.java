package ru.mail.DZ_1.controller;

import com.google.gson.Gson;
import ru.mail.DZ_1.models.*;

import java.io.*;
import java.util.*;

public class Library {
    private HashSet<Author> authors;
    private HashSet<Book> books;

    public Library() {
        authors = new HashSet<>();
        books = new HashSet<>();
    }

    void createListOfBooks() {

        try (BufferedReader br = new BufferedReader(new FileReader("controller\\src\\main\\resources\\listOfBooks.txt"))) {
            String str;
            while ((str = br.readLine()) != null) {

                String authorName = str.substring(0, str.indexOf('—') - 1);
                String bookTitle = str.substring(str.indexOf('—') + 1);

                Author author = new Author();
                Book book = new Book();

                author.setAuthorName(authorName);
                author.setAuthorID(authorName.hashCode());
                authors.add(author);

                book.setBookTitle(bookTitle);
                book.setAuthorID(authorName.hashCode());
                books.add(book);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void createLibrary() {
        for (Author a : authors) {
            HashSet<Book> bookHashSet = new HashSet<>();
            for (Book b : books) {
                if (a.getAuthorID() == b.getAuthorID()) {
                    bookHashSet.add(b);

                }
            }
            a.setBooks(bookHashSet);
        }
    }

    Author findAuthor(String authorName) {

        Author author = new Author();
        boolean find = false;
        for (Author a : authors) {
            if (a.getAuthorName().equals(authorName)) {
                author = a;
                find = true;
            }
        }

        if (!find) throw new NoSuchElementException();

        return author;
    }

    String printBooks(Author author) {


        System.out.println();
        Gson gson = new Gson();
        return gson.toJson(author);
    }

}