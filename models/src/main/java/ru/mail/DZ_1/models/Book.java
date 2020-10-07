package ru.mail.DZ_1.models;

import lombok.*;

@NoArgsConstructor
@Data
public class Book {
    @NonNull String bookTitle;


    @NonNull transient int authorID;
}
