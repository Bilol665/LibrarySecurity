package uz.pdp.librarysecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.librarysecurity.entity.user.UserRole;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterDto {
    private String email;
    private String password;
    private List<UserRole> userRoles;
}