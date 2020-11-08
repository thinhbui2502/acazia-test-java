package thinh.acazia.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Column(name = "name")
    private String name;

    @Id
    @NotNull
    @Column(name = "tag", length = 64)
    private String tag;

}
