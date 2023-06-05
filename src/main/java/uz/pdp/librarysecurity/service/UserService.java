package uz.pdp.librarysecurity.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.librarysecurity.dto.LoginDto;
import uz.pdp.librarysecurity.dto.RegisterDto;
import uz.pdp.librarysecurity.entity.user.UserEntity;
import uz.pdp.librarysecurity.entity.user.UserRole;
import uz.pdp.librarysecurity.exceptions.DataNotFoundException;
import uz.pdp.librarysecurity.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    public UserEntity save(RegisterDto register, List<UserRole> roles) {
        UserEntity map = modelMapper.map(register, UserEntity.class);
        map.setUserRoles(roles);
        map.setHasBlocked(false);
        map.setPassword(passwordEncoder.encode(map.getPassword()));
        return userRepository.save(map);
    }
    public UserEntity login(LoginDto loginDto) {
        UserEntity userEntity = userRepository.findByUsername(loginDto.getUsername())
                .orElseThrow(() -> new DataNotFoundException("User not found!"));
        if(passwordEncoder.matches(loginDto.getPassword(),userEntity.getPassword())) {
            return userEntity;
        }
        throw new DataNotFoundException("User not found!");
    }
}
