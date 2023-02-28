package com.dictionary.auth.user;

import com.dictionary.auth.dto.LoginDTO;
import com.dictionary.auth.dto.RegisterDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if (user == null) return null;
        else return user;
    }

    public Boolean checkCredentials(LoginDTO loginDTO) {
        User user = getUserByEmail(loginDTO.email());

        if (user != null && passwordEncoder.matches(loginDTO.password(), user.getPassword()))
            return true;

        return false;
    }

    public User saveUser(RegisterDTO registerDTO) {
        User checkUser = userRepository.findByEmail(registerDTO.email());

        if (checkUser != null) {
            log.info("korisnik {} vec postoji", registerDTO.email());
            return null;
        }

        User newUser = User.builder()
                .name(registerDTO.name())
                .email(registerDTO.email())
                .password(passwordEncoder.encode(registerDTO.password()))
                .role(Role.USER)
                .build();

        return userRepository.save(newUser);
    }
}
