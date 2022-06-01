package com.example.demo.services;

import com.example.demo.entities.UserEntity;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // Repositorio, para operaciones CRUD

    // Listar los objetos de la base de datos
    public List<UserEntity> find(){
        return userRepository.findAll();
    }

    // Método pa'traer sólo un mono :)
    public UserEntity findById(Integer id){
        return userRepository.findById(id).get();
    }

    // Método pa'guardar datos en la base de datos
    public UserEntity save(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    public UserEntity update(Integer id, UserEntity userEntity){
        UserEntity updatedUserEntity = userEntity;
        updatedUserEntity.setId(id);
        return userRepository.save(updatedUserEntity);
    }

    // Método pa'eliminar un registro de la tabla
    public void deleteById(Integer id){
        userRepository.deleteById(id); // Tan-tán ... :)
    }

}
