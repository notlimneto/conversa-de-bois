package br.com.notlimneto.conversadebois.backend.controllers;

import br.com.notlimneto.conversadebois.backend.dto.AuthDTO;
import br.com.notlimneto.conversadebois.backend.dto.LoginResponseDTO;
import br.com.notlimneto.conversadebois.backend.dto.RegisterDTO;
import br.com.notlimneto.conversadebois.backend.entities.User;
import br.com.notlimneto.conversadebois.backend.enumeration.RoleEnum;
import br.com.notlimneto.conversadebois.backend.repositories.UserRepository;
import br.com.notlimneto.conversadebois.backend.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = authManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if(userRepository.findByUsername(data.username()) != null) return ResponseEntity.badRequest().build();
        if(userRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassowrd = passwordEncoder.encode(data.password());
        User newUser = new User(data.username(), data.email(), encryptedPassowrd, RoleEnum.USER);

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register-admin")
    public ResponseEntity registerAdmin(@RequestBody @Valid RegisterDTO data) {
        if(userRepository.findByUsername(data.username()) != null) return ResponseEntity.badRequest().build();
        if(userRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassowrd = passwordEncoder.encode(data.password());
        User newUser = new User(data.username(), data.email(), encryptedPassowrd, RoleEnum.ADMIN);

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
