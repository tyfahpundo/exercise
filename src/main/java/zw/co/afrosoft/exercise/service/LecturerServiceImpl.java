package zw.co.afrosoft.exercise.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.exercise.domain.Lecturer;
import zw.co.afrosoft.exercise.dto.LecturerDto;
import zw.co.afrosoft.exercise.dto.LecturerResponseDto;
import zw.co.afrosoft.exercise.repository.LecturerRepository;

import java.util.Optional;

@Service
public class LecturerServiceImpl implements LecturerService{
    private final LecturerRepository lecturerRepository;

    public LecturerServiceImpl(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    @Override
    public LecturerDto createLecturer(LecturerDto lecturerDto) {
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
        Lecturer lecturer = lecturerRepository.findById(lecturerId).get();
        return LecturerResponseDto.createLecturerResponseDto(lecturer);
    }

    @Override
    public LecturerDto findLecturerById(Long lecturerId) {
        Lecturer lecturer = lecturerRepository.findById(lecturerId).get();
        return LecturerDto.createLecturerDto(lecturer);
    }
}
