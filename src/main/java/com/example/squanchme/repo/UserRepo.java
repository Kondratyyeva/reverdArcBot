package com.example.squanchme.repo;

import com.example.squanchme.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Екатерина
 */
@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    public Optional<User> findByChatId(Long chatId);
}
