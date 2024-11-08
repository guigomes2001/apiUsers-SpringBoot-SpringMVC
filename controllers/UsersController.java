package com.apiUsers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiUsers.services.UsersService;
import com.users.apiUsers.Users;

//Definido como RestController para passar dados em JSON

@RestController
@RequestMapping("/users")
public class UsersController {

	//Aqui é feito a injeção de dependências do USersService no Controller da aplicação (Usei @Autowired ao invés de um contrutor)
	@Autowired
	private UsersService usersService;
	
	//Método HHTP Get para buscar todos os users a partir do método definido no UsersService
	@GetMapping
	public List<Users> getAllUsers(){
		return usersService.getAllUsers();
	}
	
	//Método HHTP Post para criar uma user a partir de uma requisição de envio de dados no formato JSON
	@PostMapping
	public Users createUsers(@RequestBody Users user) {
		return usersService.createUser(user);
	}
	
	//Método HTTP Delete para excluir um user a partir do ID vinculado ap user
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id){
		usersService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	
	//Método HTTP Patch para atualizar uma dado de um user a partir do ID e da informação a ser atualizada passada em formato JSON
	@PatchMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users updatedUser) {
        Users updated = usersService.updateUser(id, updatedUser);
        return ResponseEntity.ok(updated);
    }
}
