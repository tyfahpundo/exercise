package zw.co.afrosoft.exercise.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String courseCode;
    private String courseName;
    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer Lecturer;

    public void assignLecturer(Lecturer lecturer) {
        this.Lecturer = lecturer;
    }


}
