package com.example.squanchme.service.user;

import com.example.squanchme.model.User;
import com.example.squanchme.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Екатерина
 */
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public Optional<User> findByChatId(Long chatId){
        return userRepo.findByChatId(chatId);
    }

}
