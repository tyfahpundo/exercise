package zw.co.afrosoft.exercise.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.exercise.domain.Course;
import zw.co.afrosoft.exercise.domain.Lecturer;
import zw.co.afrosoft.exercise.dto.CourseRequestDto;
import zw.co.afrosoft.exercise.dto.CourseResponseDto;
import zw.co.afrosoft.exercise.dto.LecturerDto;
import zw.co.afrosoft.exercise.dto.MessageResponse;
import zw.co.afrosoft.exercise.service.CourseService;
import zw.co.afrosoft.exercise.service.LecturerService;

@RestController
@RequestMapping("api/course")
public class CourseController {
    private final CourseService courseService;
    private final LecturerService lecturerService;

    public CourseController(CourseService courseService, LecturerService lecturerService) {
        this.courseService = courseService;
        this.lecturerService = lecturerService;
    }

    @PostMapping("/create")
    public ResponseEntity<CourseResponseDto> createCourse(@RequestBody CourseRequestDto courseRequestDto) {
        CourseResponseDto response = courseService.createCourse(courseRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping("/{courseId}/lecturer/{lecturerId}")
    public ResponseEntity<MessageResponse> assignLecturerToCourse(@PathVariable Long courseId, @PathVariable Long lecturerId){
        courseService.assignLecturerToCourse(courseId,lecturerId);
        MessageResponse messageResponse = MessageResponse.createMessageResponse("Assigned Lecturer to Course");
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }
    @GetMapping("/getById/{courseId}")
    public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable Long courseId){
        CourseResponseDto course = courseService.getCourseById(courseId);
        return new ResponseEntity<>(course,HttpStatus.FOUND);
    }
}
