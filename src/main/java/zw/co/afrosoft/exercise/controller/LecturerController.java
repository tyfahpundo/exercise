package zw.co.afrosoft.exercise.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.exercise.dto.LecturerDto;
import zw.co.afrosoft.exercise.dto.LecturerResponseDto;
import zw.co.afrosoft.exercise.service.LecturerService;

@RestController
@RequestMapping("api/lecturer")
public class LecturerController {
    private final LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @PostMapping("/create")
    public ResponseEntity<LecturerDto> createLecturer(@RequestBody LecturerDto lecturerDto){
        LecturerDto lecturer = lecturerService.createLecturer(lecturerDto);
        return new ResponseEntity<>(lecturer, HttpStatus.CREATED);
    }
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<LecturerResponseDto> getById(@PathVariable Long id){
        LecturerResponseDto lecturer = lecturerService.getLecturerById(id);
        return new ResponseEntity<>(lecturer,HttpStatus.FOUND);
    }

}
