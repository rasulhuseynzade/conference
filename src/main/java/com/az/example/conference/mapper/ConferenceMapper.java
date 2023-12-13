package com.az.example.conference.mapper;

import com.az.example.conference.dao.entity.ConferenceEntity;
import com.az.example.conference.model.ConferenceViewDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConferenceMapper {

    ConferenceViewDto entityToDto(ConferenceEntity conferenceEntity);
    ConferenceEntity dtoToEntity(ConferenceViewDto conferenceViewDto);
    ConferenceEntity dtoToEntity(Long id, ConferenceViewDto conferenceViewDto);
}
