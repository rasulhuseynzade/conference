package com.az.example.conference.service;

import com.az.example.conference.dao.repository.AttendeeRepository;
import com.az.example.conference.mapper.AttendeeMapper;
import com.az.example.conference.model.AttendeeViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendeeService {

    private final AttendeeRepository attendeeRepository;
    private final AttendeeMapper attendeeMapper;



    public Page<AttendeeViewDto> getAttendeeList(Pageable pageable){
        var attendeeEntity = attendeeRepository.findAll(pageable);
        var list = attendeeEntity.stream()
                .map(attendeeMapper::entityToDto)
                .collect(Collectors.toList());


        return new PageImpl<>(list, pageable, pageable.getPageSize());

    }
    public void createdAttendee(AttendeeViewDto attendeeViewDto){
        var attendeeEntity = attendeeMapper.dtoToEntity(attendeeViewDto);
        attendeeRepository.save(attendeeEntity);
    }
    public void updateAttendee(Long attendeeId, AttendeeViewDto attendeeViewDto){
       var attendeeEntity = attendeeMapper.dtoToEntity(attendeeId, attendeeViewDto);
       attendeeRepository.save(attendeeEntity);
    }
    public  void deleteAttendee(Long attendeeId){
        attendeeRepository.deleteById(attendeeId);
    }
}
