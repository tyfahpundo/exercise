package zw.co.afrosoft.exercise.service;

import zw.co.afrosoft.exercise.domain.Lecturer;
import zw.co.afrosoft.exercise.dto.LecturerDto;
import zw.co.afrosoft.exercise.dto.LecturerResponseDto;
import zw.co.afrosoft.exercise.exceptions.CourseNotFoundException;
import zw.co.afrosoft.exercise.exceptions.CustomException;
import zw.co.afrosoft.exercise.repository.LecturerRepository;

import java.util.Objects;
import java.util.Optional;

public class LecturerServiceImpl implements LecturerService{
    private final LecturerRepository lecturerRepository;

    public LecturerServiceImpl(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
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
        if(lecturer.isEmpty()){
            throw new CourseNotFoundException("No lecturer with id "+lecturerId+" was found");
        }
        return LecturerResponseDto.createLecturerResponseDto(lecturer.get());
    }

}
