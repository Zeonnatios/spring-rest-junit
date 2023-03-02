package br.com.dicasdeumdev.api.config;

import br.com.dicasdeumdev.api.domain.User;
import br.com.dicasdeumdev.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public void startDatabase() {
        User firstUser = new User(null, "Matheus", "matheus@email.com", "1234");
        User secondUser = new User(null, "Boris", "boris@email.com", "1234");
        User thirdUser = new User(null, "Antonio", "antonio@email.com", "1234");

        userRepository.saveAll(List.of(firstUser, secondUser, thirdUser));
    }

}
