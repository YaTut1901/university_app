package university.app.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "lectors")
public class Lector extends Person {
    private double salary;
    @ManyToOne
    private Degree degree;
    @ToString.Exclude
    @ManyToMany
    private List<Department> departments;

    public Lector(String name, String surname, Degree degree, double salary) {
        super(name, surname);
        this.degree = degree;
        departments = new ArrayList<>();
        this.salary = salary;
    }
}
