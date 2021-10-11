package com.stores.stores.controllers;

import java.sql.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.stores.stores.login.LoginUser;
import com.stores.stores.login.LoginUserResponse;
import com.stores.stores.models.EmpleadosModel;
import com.stores.stores.models.UsuarioModel;
import com.stores.stores.services.EmpleadosService;
import com.stores.stores.services.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("api/login")
public class LoginController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	EmpleadosService empleadosService;

	/*
	 * @GetMapping(path = "/list") public ArrayList<UsuarioModel> obtenerUsuarios(){
	 * return usuarioService.listarUsuarios(); }
	 */

	/*
	 * @PostMapping() public UsuarioModel guardarUsuario(@RequestBody UsuarioModel
	 * usuario) { return usuarioService.guardarUsuario(usuario); }
	 * 
	 * /*@GetMapping(path = "/{id}") public Optional<UsuarioModel>
	 * obtenerById(@PathVariable("id") Long id){ return usuarioService.userById(id);
	 * }
	 */

	/*
	 * @GetMapping(path = "/login") public String
	 * buscarByEmail(@RequestParam("email") String email){ ArrayList<UsuarioModel>
	 * user = usuarioService.userByEmail(email);
	 * 
	 * return user.get(0).getPassword(); }
	 */

	@PostMapping()
	public ResponseEntity<LoginUserResponse> loginUser(@RequestBody LoginUser login) {
		LoginUserResponse response = new LoginUserResponse();
		Optional<UsuarioModel> user = usuarioService.userByEmail(login.getEmail());
		if (!user.isPresent()) {
			Optional<EmpleadosModel> empleado = empleadosService.buscarByEmail(login.getEmail());
			if (empleado.isPresent()) {
				if (empleado.get().getPassword().equals(login.getPassword())) {
					response.setId(empleado.get().getId());
					response.setNombre(empleado.get().getNombre());
					response.setEmail(empleado.get().getEmail());
					response.setRol(empleado.get().getRol());
					response.setToken(getJWTToken(login.getEmail()));
					response.setTienda_id(empleado.get().getTienda().getId());
					response.setNombreTienda(empleado.get().getTienda().getNombre());
					return ResponseEntity.ok(response);
				} else {
					return ResponseEntity.notFound().build();
				}
			} else {
				return ResponseEntity.notFound().build();
			}
		} else {
			if (user.get().getPassword().equals(login.getPassword())) {
				response.setId(user.get().getId());
				response.setNombre(user.get().getNombre());
				response.setEmail(user.get().getEmail());
				response.setRol(user.get().getRol());
				response.setToken(getJWTToken(login.getEmail()));
				return ResponseEntity.ok(response);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
	}

	private String getJWTToken(String email) {
		String secretKey = "Huak1siberi@no-1989@--";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		String token = Jwts.builder().setId("softtekJWT").setSubject(email)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 4800000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
