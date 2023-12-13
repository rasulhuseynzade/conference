package com.az.example.conference.controller;

import com.az.example.conference.model.ConferenceViewDto;
import com.az.example.conference.service.ConferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/conferences")
@RequiredArgsConstructor
public class ConferenceController {

    private final ConferenceService conferenceService;

    @GetMapping
    public Page<ConferenceViewDto> getConferenceList(Pageable pageable){
        return  conferenceService.getConferenceList(pageable);
    }
    @PostMapping
    public void createdConference(@RequestBody ConferenceViewDto conferenceViewDto){
        conferenceService.createdConference(conferenceViewDto);
    }
    @PutMapping("/{id}")
    public void updateConference(
            @PathVariable Long id,
            @RequestBody ConferenceViewDto conferenceViewDto
    ){
        conferenceService.updateConference(id, conferenceViewDto);

    }
    @DeleteMapping("/{id}")
    public void deleteConference(@PathVariable Long id){
        conferenceService.deleteConference(id);

    }
}
