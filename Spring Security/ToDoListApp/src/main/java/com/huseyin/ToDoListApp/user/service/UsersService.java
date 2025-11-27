package com.huseyin.ToDoListApp.user.service;

import com.huseyin.ToDoListApp.mapper.Mapper;
import com.huseyin.ToDoListApp.user.model.dto.ChangePasswordRequest;
import com.huseyin.ToDoListApp.user.model.dto.GetUserInfoResponse;
import com.huseyin.ToDoListApp.user.model.entity.Users;
import com.huseyin.ToDoListApp.user.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersService implements UserDetailsService {

    private final UsersRepository usersRepository;


    @Autowired
    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public Users createUsers(Users users){
        return usersRepository.save(users);
    }

    @Transactional
    public void deleteUser(String username){
        Users user = usersRepository.findByUsername(username).get();
        usersRepository.delete(user);
    }

    @Transactional
    public String changePassword(String username, ChangePasswordRequest changePasswordRequest){
        Users user = usersRepository.findByUsername(username).get();
//        usersRepository.updatePassword(user.getId(),changePasswordRequest.getPassword());
        usersRepository.save(Mapper.mapChangePasswordRequest(changePasswordRequest,user));
        return "Password updated!";
    }

    public boolean existsByUsername(String username){
        return usersRepository.findByUsername(username).isPresent();
    }

    public Users findByUsername(String username){
       return usersRepository.findByUsername(username).get();
    }

    public GetUserInfoResponse getUserInfo(String username){
        return Mapper.mapUserToGetUserInfo(usersRepository.findByUsername(username).get());
    }


    @Override
    public UserDetails loadUserByUsername(String username){
        return usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with %s username not found ".formatted(username)));
    }
}
