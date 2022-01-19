package zw.co.afrosoft.exercise.service;

import zw.co.afrosoft.exercise.domain.Lecturer;
import zw.co.afrosoft.exercise.dto.LecturerDto;

public interface LecturerService {
    LecturerDto createLecturer(LecturerDto lecturerDto);

    LecturerDto getLecturerById(Long lecturerId);

}
