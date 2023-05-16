package com.app.ChhalKayenBinatna.service;

import com.app.ChhalKayenBinatna.dto.GroupOperationDto;
import com.app.ChhalKayenBinatna.entity.GroupOperation;
import com.app.ChhalKayenBinatna.exception.InvalidInputException;
import com.app.ChhalKayenBinatna.repository.GroupOperationRepository;
import com.app.ChhalKayenBinatna.service.impl.IBaseService;
import io.github.perplexhub.rsql.RSQLJPASupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class GroupOperationService implements IBaseService<GroupOperation, GroupOperationDto> {
    @Autowired
    private GroupOperationRepository groupOperationRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    @Transactional
    public GroupOperationDto save(GroupOperationDto groupOperationDto) {
        return modelMapper.map(groupOperationRepository.save(modelMapper.map(groupOperationDto, GroupOperation.class)), GroupOperationDto.class);
    }

    @Override
    @Transactional
    public GroupOperationDto update(GroupOperationDto groupOperationDto) {
        GroupOperationDto groupOperationDto1 = modelMapper.map(groupOperationRepository.findById(groupOperationDto.getId()), GroupOperationDto.class);
        groupOperationDto1.setUpdateOn(new Date());
        groupOperationDto1.setOperationType(groupOperationDto.getOperationType());
        groupOperationDto1.setName(groupOperationDto.getName());
        groupOperationDto1.setParticipantDto(groupOperationDto.getParticipantDto());
        return modelMapper.map(groupOperationRepository.save(modelMapper.map(groupOperationDto1, GroupOperation.class)), GroupOperationDto.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        groupOperationRepository.deleteById(id);
    }

    @Override
    public GroupOperationDto findById(Long id) {
        Optional<GroupOperation> groupOperation = groupOperationRepository.findById(id);
        if (groupOperation.isPresent()) return modelMapper.map(groupOperation.get(), GroupOperationDto.class);
        else throw new InvalidInputException("Group Operation not fond");
    }

    @Override
    public List<GroupOperationDto> findAll() {
        return groupOperationRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    private GroupOperationDto convertEntityToDto(GroupOperation groupOperation){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(groupOperation, GroupOperationDto.class);
    }

    @Override
    public Page<GroupOperationDto> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        if (query.isEmpty()) {
            throw new InvalidInputException("Argument is required");
        }
        if (size > 20) {
            size = 20;
        }
        return (Page<GroupOperationDto>) modelMapper.map(groupOperationRepository.findAll(RSQLJPASupport.toSpecification(query), PageRequest.of(page, size, Sort.Direction.fromString(order), sort)), GroupOperationDto.class);
    }
}
