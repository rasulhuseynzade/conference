package com.az.example.conference.service;

import com.az.example.conference.dao.repository.SessionRepository;
import com.az.example.conference.mapper.SessionMapper;
import com.az.example.conference.model.SessionViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionRepository sessionRepository;
    private final SessionMapper sessionMapper;

    public Page<SessionViewDto> getSessionList(Pageable pageable){
        var sessionEntityList = sessionRepository.findAll(pageable);
        var list = sessionEntityList.stream()
                .map(sessionMapper::entityToDto)
                .toList();

        return new PageImpl<>(list, pageable, pageable.getPageSize());
    }
    public void createdSession(SessionViewDto sessionViewDto){
        var sessionEntity = sessionMapper.dtoToEntity(sessionViewDto);
        sessionRepository.save(sessionEntity);

    }
    public void updateSession(Long sessionId, SessionViewDto sessionViewDto){
        var sessionEntity = sessionMapper.dtoToEntity(sessionId, sessionViewDto);
        sessionRepository.save(sessionEntity);
    }
    public void deleteSession(Long sessionId){
        sessionRepository.deleteById(sessionId);
    }
}
