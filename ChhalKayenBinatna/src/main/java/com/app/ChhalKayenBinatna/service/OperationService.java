package com.app.ChhalKayenBinatna.service;

import com.app.ChhalKayenBinatna.dto.OperationDto;
import com.app.ChhalKayenBinatna.entity.Operation;
import com.app.ChhalKayenBinatna.exception.InvalidInputException;
import com.app.ChhalKayenBinatna.repository.OperationRepository;
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
public class OperationService implements IBaseService<Operation, OperationDto> {
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    @Transactional
    public OperationDto save(OperationDto operationDto) {
        return modelMapper.map(operationRepository.save(modelMapper.map(operationDto, Operation.class)), OperationDto.class);
    }

    @Override
    @Transactional
    public OperationDto update(OperationDto operationDto) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        operationRepository.deleteById(id);
    }

    @Override
    public OperationDto findById(Long id) {
        OperationDto operationDto = modelMapper.map(operationRepository.findById(id).get(), OperationDto.class);
        if (operationDto == null) throw new InvalidInputException("Operation not fond");
        return operationDto;
    }

    @Override
    public List<OperationDto> findAll() {
        return operationRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    private OperationDto convertEntityToDto(Operation operation){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(operation, OperationDto.class);
    }

    @Override
    public Page<OperationDto> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        if (query.isEmpty()) {
            throw new InvalidInputException("Argument is required");
        }
        if (size > 20) {
            size = 20;
        }
        return (Page<OperationDto>) modelMapper.map(operationRepository.findAll(RSQLJPASupport.toSpecification(query), PageRequest.of(page, size, Sort.Direction.fromString(order), sort)), OperationDto.class);
    }
}
