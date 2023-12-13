package com.az.example.conference.controller;

import com.az.example.conference.model.SessionViewDto;
import com.az.example.conference.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sessions")
@RequiredArgsConstructor
public class SessionController {
    private final SessionService sessionService;

    @GetMapping
    public Page<SessionViewDto> getSessionList(Pageable pageable){
        return  sessionService.getSessionList(pageable);
    }
    @PostMapping
    public void createdSession(@RequestBody SessionViewDto sessionViewDto){
    sessionService.createdSession(sessionViewDto);

    }
    @PutMapping("/{id}")
    public void updateSession(
            @PathVariable Long id,
            @RequestBody SessionViewDto sessionViewDto
    ){
        sessionService.updateSession(id, sessionViewDto);

    }
    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable Long id){
        sessionService.deleteSession(id);
    }
}
