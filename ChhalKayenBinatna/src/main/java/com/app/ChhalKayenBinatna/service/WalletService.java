package com.app.ChhalKayenBinatna.service;

import com.app.ChhalKayenBinatna.dto.WalletDto;
import com.app.ChhalKayenBinatna.entity.Participant;
import com.app.ChhalKayenBinatna.entity.Wallet;
import com.app.ChhalKayenBinatna.exception.InvalidInputException;
import com.app.ChhalKayenBinatna.repository.WalletRepository;
import com.app.ChhalKayenBinatna.service.impl.IBaseService;
import io.github.perplexhub.rsql.RSQLJPASupport;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class WalletService implements IBaseService<Wallet, WalletDto> {
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    @Transactional
    public WalletDto save(WalletDto walletDto) {
        return modelMapper.map(walletRepository.save(modelMapper.map(walletDto, Wallet.class)), WalletDto.class);
    }

    @SneakyThrows
    @Override
    @Transactional
    public WalletDto update(WalletDto walletDto) {
        Wallet wallet = walletRepository.findById(walletDto.getId()).orElseThrow(() -> new NotFoundException("Wallet not found"));
        if (walletDto.getCurrency() == null) wallet.setCurrency(walletDto.getCurrency());
        if (walletDto.getParticipantDto() == null) wallet.setParticipant(modelMapper.map(walletDto.getParticipantDto(), Participant.class));
        if (walletDto.getTotal() == null) wallet.setTotal(walletDto.getTotal());
        return modelMapper.map(walletRepository.save(wallet), WalletDto.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        walletRepository.deleteById(id);
    }

    @Override
    public WalletDto findById(Long id) {
        Optional<Wallet> wallet = walletRepository.findById(id);
        if (!wallet.isPresent()) throw new InvalidInputException("wallet not fond");
        return modelMapper.map(wallet.get(), WalletDto.class);
    }

    @Override
    public List<WalletDto> findAll() {
        return walletRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    private WalletDto convertEntityToDto(Wallet wallet){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(wallet, WalletDto.class);
    }

    @Override
    public Page<WalletDto> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        if (query.isEmpty()) {
            throw new InvalidInputException("Argument is required");
        }
        if (size > 20) {
            size = 20;
        }
        return (Page<WalletDto>) modelMapper.map(walletRepository.findAll(RSQLJPASupport.toSpecification(query), PageRequest.of(page, size, Sort.Direction.fromString(order), sort)), WalletDto.class);
    }
}
