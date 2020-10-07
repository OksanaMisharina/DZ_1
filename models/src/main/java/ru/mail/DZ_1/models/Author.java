package ru.mail.DZ_1.models;

import lombok.*;


import java.util.HashSet;
@NoArgsConstructor
@Data
public class Author {
    @NonNull int authorID;

    @NonNull
    @EqualsAndHashCode.Include
    String authorName;

    @NonNull
    @EqualsAndHashCode.Exclude
    HashSet<Book> books;
}