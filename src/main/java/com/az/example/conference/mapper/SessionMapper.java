package com.az.example.conference.mapper;

import com.az.example.conference.dao.entity.SessionEntity;
import com.az.example.conference.model.SessionViewDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SessionMapper {

    SessionViewDto entityToDto(SessionEntity sessionEntity);
    SessionEntity dtoToEntity(SessionViewDto sessionViewDto);
    SessionEntity dtoToEntity(Long id, SessionViewDto sessionViewDto);

}
