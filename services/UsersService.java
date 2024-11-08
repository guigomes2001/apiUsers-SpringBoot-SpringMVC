package com.apiUsers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.apiUsers.Users;
import com.users.apiUsers.UsersRepository;

@Service
public class UsersService {

	//Aqui é feito a injeção de dependências do USersService no Controller da aplicação (Usei @Autowired ao invés de um contrutor)
	@Autowired
	private UsersRepository usersRepository;
	
	//Método para buscar todos os usuários
	public List<Users> getAllUsers(){
		return usersRepository.findAll();
	}
	
	//Método para cadastrar um usuário
	public Users createUser(Users user) {
		return usersRepository.save(user);
	}
	
	//Método para excluir um usuário por id
	public void deleteUser(Long id) {
		usersRepository.deleteById(id);
	}
	
	//Método para alterar um usuário
	 public Users updateUser(Long id, Users updatedUser) {
	        // Buscar o usuário existente pelo ID
	        Users existingUser = usersRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

	        // Atualizar os campos que foram enviados no corpo da requisição (sem sobrescrever os não enviados)
	        if (updatedUser.getName() != null) {
	            existingUser.setName(updatedUser.getName());
	        }
	        if (updatedUser.getAge() != 0) {
	            existingUser.setAge(updatedUser.getAge());
	        }
	        if (updatedUser.getBirthDate() != null) {
	            existingUser.setBirthDate(updatedUser.getBirthDate());
	        }
	        if (updatedUser.getGenerous() != null) {
	            existingUser.setGenerous(updatedUser.getGenerous());
	        }
	        if (updatedUser.getEmail() != null) {
	            existingUser.setEmail(updatedUser.getEmail());
	        }

	        // Salvar o usuário com as alterações
	        return usersRepository.save(existingUser);
	    }
}


