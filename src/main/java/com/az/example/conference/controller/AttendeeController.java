package com.az.example.conference.controller;

import com.az.example.conference.model.AttendeeViewDto;
import com.az.example.conference.service.AttendeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/attendees")
@RequiredArgsConstructor
public class AttendeeController {
    private final AttendeeService attendeeService;

    @GetMapping
    public Page<AttendeeViewDto> getAttendeeList(Pageable pageable){
        return attendeeService.getAttendeeList(pageable);
    }
    @PostMapping
    public void createdAttendee(@RequestBody AttendeeViewDto attendeeViewDto){
        attendeeService.createdAttendee(attendeeViewDto);
    }
    @PutMapping("/{id}")
    public void updateAttendee(
            @PathVariable Long id,
            @RequestBody AttendeeViewDto attendeeViewDto
    ){
        attendeeService.updateAttendee(id, attendeeViewDto);

    }
    @DeleteMapping("/{id}")
    public void deleteAttendee(@PathVariable Long id){
        attendeeService.deleteAttendee(id);
    }

}
