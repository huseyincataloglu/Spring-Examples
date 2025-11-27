package com.huseyin.ToDoListApp.auth.shared;

import com.huseyin.ToDoListApp.user.model.entity.Users;
import com.huseyin.ToDoListApp.user.repository.UsersRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AuthenticatedUserProvider {

    private final UsersRepository usersRepository;

    public AuthenticatedUserProvider(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public Users getAuthenticatedUser(Authentication authentication){
        return usersRepository.findByUsername(authentication.getName())
                .orElseThrow(()->  new IllegalStateException("Authenticated user not found"));
    }


}
