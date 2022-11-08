package se.project.Web.Front.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import se.project.Web.Front.dto.StudentDto;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    private RestTemplate restTemplate;

    public StudentDto deleteStudent(UUID id) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);

        String url = "http://localhost:8097/students/delete/"+id;

        ResponseEntity<StudentDto> response =
                restTemplate.exchange(url, HttpMethod.DELETE,
                        entity, StudentDto.class);

        return response.getBody();
    }

    public StudentDto getStudentById(UUID id) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);

        String url = "http://localhost:8097/students/"+id;

        ResponseEntity<StudentDto> response =
                restTemplate.exchange(url, HttpMethod.GET,
                        entity, StudentDto.class);

        return response.getBody();
    }

    public List<StudentDto> getScoreById(String Id) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);

        String url = "http://localhost:8097/students/id/"+Id;

        ResponseEntity<StudentDto[]> response =
                restTemplate.exchange(url, HttpMethod.GET,
                        entity, StudentDto[].class);

        StudentDto[] students = response.getBody();
        return Arrays.asList(students);
    }
    public List<StudentDto> getStudent() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);

        String url = "http://localhost:8097/students";

        ResponseEntity<StudentDto[]> response =
                restTemplate.exchange(url, HttpMethod.GET,
                        entity, StudentDto[].class);

        StudentDto[] students = response.getBody();
        return Arrays.asList(students);
    }

    public StudentDto addStudent(StudentDto studentDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_JSON.toString());
        HttpEntity entity = new HttpEntity(studentDto,headers);

        String url = "http://localhost:8097/students";

        ResponseEntity<StudentDto> response =
                restTemplate.exchange(url, HttpMethod.POST,
                        entity, StudentDto.class);

        return response.getBody();
    }

    public StudentDto updateStudent(StudentDto studentDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_JSON.toString());
        HttpEntity entity = new HttpEntity(studentDto,headers);

        String url = "http://localhost:8097/students";

        ResponseEntity<StudentDto> response =
                restTemplate.exchange(url, HttpMethod.PUT,
                        entity, StudentDto.class);

        return response.getBody();
    }
}
