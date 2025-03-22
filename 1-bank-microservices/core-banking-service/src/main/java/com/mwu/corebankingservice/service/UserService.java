package com.mwu.corebankingservice.service;

import com.mwu.corebankingservice.repository.UserRepository;
import com.mwu.corebankingservice.mapper.UserMapper;
import com.mwu.corebankingservice.model.UserEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserMapper userMapper = new UserMapper();

    private final UserRepository userRepository;

    public Object readUser(String identification) {
        UserEntity userEntity = userRepository.findByIdentificationNumber(identification)
                .orElseThrow(EntityNotFoundException::new);
        return userMapper.convertToDto(userEntity);
    }

    public Object readUsers(Pageable pageable) {
        return userMapper.convertToDtoList(userRepository.findAll(pageable).getContent());
    }
}
