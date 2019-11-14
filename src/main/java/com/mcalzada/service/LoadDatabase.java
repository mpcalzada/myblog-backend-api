package com.mcalzada.service;

import com.mcalzada.crud.User;
import com.mcalzada.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@link LoadDatabase}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */
@Configuration
@Slf4j
public class LoadDatabase
{
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository)
    {
        return args -> {
            log.info("Preloading " + userRepository.save(new User("mcalzada", "ADMIN")));
            log.info("Preloading " + userRepository.save(new User("prodriguez", "USER")));
        };
    }
}
