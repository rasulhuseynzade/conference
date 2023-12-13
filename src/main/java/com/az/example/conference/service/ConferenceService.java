package com.az.example.conference.service;

import com.az.example.conference.dao.repository.ConferenceRepository;
import com.az.example.conference.mapper.ConferenceMapper;
import com.az.example.conference.model.ConferenceViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConferenceService {
    private final ConferenceRepository conferenceRepository;
    private final ConferenceMapper conferenceMapper;

    public Page<ConferenceViewDto> getConferenceList(Pageable pageable){
        var conferenceEntityList = conferenceRepository.findAll(pageable);
        var list = conferenceEntityList.stream()
                .map(conferenceMapper::entityToDto)
                .toList();

        return new PageImpl<>(list, pageable, pageable.getPageSize());
    }
    public void createdConference(ConferenceViewDto conferenceViewDto){
        var conferenceEntity = conferenceMapper.dtoToEntity(conferenceViewDto);
        conferenceRepository.save(conferenceEntity);
    }

    public void updateConference(Long conferenceId, ConferenceViewDto conferenceViewDto){
        var conferenceEntity = conferenceMapper.dtoToEntity(conferenceId, conferenceViewDto);
        conferenceRepository.save(conferenceEntity);
    }
    public void deleteConference(Long conferenceId){
        conferenceRepository.deleteById(conferenceId);
    }

}
