package com.az.example.conference.mapper;

import com.az.example.conference.dao.entity.AttendeeEntity;
import com.az.example.conference.model.AttendeeViewDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
    public interface AttendeeMapper {

     AttendeeViewDto entityToDto(AttendeeEntity attendeeEntity);
     AttendeeEntity dtoToEntity(AttendeeViewDto attendeeViewDto);
     AttendeeEntity dtoToEntity(Long id, AttendeeViewDto attendeeViewDto);

}
