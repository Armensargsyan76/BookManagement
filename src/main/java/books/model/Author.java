package books.model;

import books.enumstorage.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private String name;
    private String surName;
    private String email;
    private Gender gender;


}
