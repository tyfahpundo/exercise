package zw.co.afrosoft.exercise.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "course_code",unique = true,nullable = false)
    private String courseCode;
    @Column(name = "course_name",unique = true,nullable = false)
    private String courseName;
    @Column(name = "created_date",nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "modified_date",nullable = false)
    private LocalDateTime modifiedDate;


}
