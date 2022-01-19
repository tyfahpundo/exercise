package zw.co.afrosoft.exercise.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.afrosoft.exercise.dto.LecturerDto;

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

    public void assignLecturer(LecturerDto lecturerDto) {
        Lecturer lecture = new Lecturer();
        lecture.setName(lecturerDto.getName());
        lecture.setAge(lecturerDto.getAge());
        lecture.setTitle(lecturerDto.getTitle());
        lecture.setNationalId(lecturerDto.getNationalId());
        lecture.setEmployeeNumber(lecturerDto.getEmployeeNumber());
        this.Lecturer = lecture;
    }
    public String generateCourseCode(){
        long counter = 1;
        String var = String.format("%04d",counter);
        return getPrefix() + var;
    }
    public String getPrefix(){
        return "CS";
    }

}
