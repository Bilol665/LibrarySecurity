package uz.pdp.librarysecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookCreateDto {
    private String title;
    private String author;
    private Double price;
    private Integer pages;
}
