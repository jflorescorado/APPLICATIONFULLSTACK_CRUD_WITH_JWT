package com.test.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.backend.dto.LoginRequest;
import com.test.backend.dto.TokenResponse;
import com.test.backend.entity.User;
import com.test.backend.security.JwtUtil;
import com.test.backend.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private final UserService userService;
	private final JwtUtil jwtUtil;
	private final BCryptPasswordEncoder passwordEncoder;

	public AuthController(UserService userService, JwtUtil jwtUtil, BCryptPasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.jwtUtil = jwtUtil;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest req) {
		var userOpt = userService.findByEmail(req.getEmail());
		if (userOpt.isEmpty()) {
			return ResponseEntity.status(401).body("Usuario no encontrado");
		}
		var user = userOpt.get();
		if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
			return ResponseEntity.status(401).body("Credenciales incorrectas");
		}

		String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
		return ResponseEntity.ok(new TokenResponse(token));
	}

	// endpoint para crear usuario (opcional, para pruebas)
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User u) {
		var created = userService.createUser(u);
		created.setPassword(null);
		return ResponseEntity.ok(created);
	}
}