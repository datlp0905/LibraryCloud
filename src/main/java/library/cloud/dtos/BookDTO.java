package library.cloud.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private int id;

    private String title;

    private String author;

    private String position;

    private int publishYear;

    private boolean isActive;

    private int total;

    private CategoryDTO category;
}
