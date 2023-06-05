package uz.pdp.librarysecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.librarysecurity.dto.LoginDto;
import uz.pdp.librarysecurity.dto.RegisterDto;
import uz.pdp.librarysecurity.entity.user.UserEntity;
import uz.pdp.librarysecurity.entity.user.UserRole;
import uz.pdp.librarysecurity.service.UserService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final UserService userService;
    @PostMapping("/librarian/sign-up")
    public ResponseEntity<UserEntity> signUp(
            @RequestBody RegisterDto register
    ){
        UserEntity user = userService.save(register, List.of(UserRole.LIBRARIAN));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
