package uz.pdp.librarysecurity.entity.book;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.librarysecurity.entity.BaseEntity;

@Entity(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookEntity extends BaseEntity {
    private String title;
    private String author;
    private Double price;
    private Integer pages;

}
