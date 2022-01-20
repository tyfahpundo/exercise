package zw.co.afrosoft.exercise.service;

import zw.co.afrosoft.exercise.domain.Lecturer;
import zw.co.afrosoft.exercise.dto.LecturerDto;
import zw.co.afrosoft.exercise.dto.LecturerResponseDto;

public interface LecturerService {
    LecturerDto createLecturer(LecturerDto lecturerDto);

    LecturerResponseDto getLecturerById(Long lecturerId);

    LecturerDto findLecturerById(Long lecturerId);

}
