package zw.co.afrosoft.exercise.service;

import zw.co.afrosoft.exercise.domain.Course;
import zw.co.afrosoft.exercise.domain.CourseLecturer;
import zw.co.afrosoft.exercise.domain.Lecturer;
import zw.co.afrosoft.exercise.dto.CourseResponseDto;
import zw.co.afrosoft.exercise.dto.LecturerDto;
import zw.co.afrosoft.exercise.dto.LecturerResponseDto;
import zw.co.afrosoft.exercise.exceptions.CourseNotFoundException;
import zw.co.afrosoft.exercise.exceptions.CustomException;
import zw.co.afrosoft.exercise.exceptions.LecturerNotFoundException;
import zw.co.afrosoft.exercise.repository.CourseLecturerRepository;
import zw.co.afrosoft.exercise.repository.LecturerRepository;

import java.util.*;
import java.util.stream.Collectors;

public class LecturerServiceImpl implements LecturerService{
    private final LecturerRepository lecturerRepository;
    private final CourseLecturerRepository courseLecturerRepository;

    public LecturerServiceImpl(LecturerRepository lecturerRepository, CourseLecturerRepository courseLecturerRepository) {
        this.lecturerRepository = lecturerRepository;
        this.courseLecturerRepository = courseLecturerRepository;
    }

    @Override
    public LecturerDto createLecturer(LecturerDto lecturerDto) {
        if(Objects.isNull(lecturerDto)){
            throw new CustomException("Lecturer fields must not be null");
        }
        Lecturer lecturer = new Lecturer();
        lecturer.setName(lecturerDto.getName());
        lecturer.setAge(lecturerDto.getAge());
        lecturer.setTitle(lecturerDto.getTitle());
        lecturer.setEmployeeNumber(lecturerDto.getEmployeeNumber());
        lecturer.setNationalId(lecturerDto.getNationalId());
        lecturerRepository.save(lecturer);
        return LecturerDto.createLecturerDto(lecturer);

    }

    @Override
    public LecturerResponseDto getLecturerById(Long lecturerId) {
        Optional<Lecturer> lecturer = lecturerRepository.findById(lecturerId);
        List<CourseLecturer> coursesLecturer = courseLecturerRepository.findAllByLecturer(lecturer.get());
        Set<Course> courses = coursesLecturer.stream()
                .map(CourseLecturer::getCourse)
                .collect(Collectors.toSet());
        return LecturerResponseDto.createLecturerResponseDto(lecturer.get(),courses);
    }

}
