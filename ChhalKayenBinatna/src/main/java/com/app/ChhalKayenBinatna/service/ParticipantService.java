package com.app.ChhalKayenBinatna.service;

import com.app.ChhalKayenBinatna.dto.ParticipantDto;
import com.app.ChhalKayenBinatna.entity.Participant;
import com.app.ChhalKayenBinatna.exception.InvalidInputException;
import com.app.ChhalKayenBinatna.repository.ParticipantRepository;
import com.app.ChhalKayenBinatna.service.impl.IBaseService;
import io.github.perplexhub.rsql.RSQLJPASupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ParticipantService implements IBaseService<Participant, ParticipantDto> {
    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    @Transactional
    public ParticipantDto save(ParticipantDto participantDto) {
        return modelMapper.map(participantRepository.save(modelMapper.map(participantDto, Participant.class)), ParticipantDto.class);
    }

    @Override
    @Transactional
    public ParticipantDto update(ParticipantDto dto) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        participantRepository.deleteById(id);
    }

    @Override
    public ParticipantDto findById(Long id) {
        ParticipantDto participantDto = modelMapper.map(participantRepository.findById(id).get(), ParticipantDto.class);
        if (participantDto == null) throw new InvalidInputException("Participant not fond");
        return participantDto;
    }

    @Override
    public List<ParticipantDto> findAll() {
        return participantRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    private ParticipantDto convertEntityToDto(Participant participant){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(participant, ParticipantDto.class);
    }

    @Override
    public Page<ParticipantDto> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        if (query.isEmpty()) {
            throw new InvalidInputException("Argument is required");
        }
        if (size > 20) {
            size = 20;
        }
        return (Page<ParticipantDto>) modelMapper.map(participantRepository.findAll(RSQLJPASupport.toSpecification(query), PageRequest.of(page, size, Sort.Direction.fromString(order), sort)), ParticipantDto.class);
    }
}
