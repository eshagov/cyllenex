package eu.shagov.security.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import eu.shagov.security.SecurityUtils;
import eu.shagov.security.model.User;
import eu.shagov.security.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
public class UserService {

   private final UserRepository userRepository;

   public UserService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Transactional(readOnly = true)
   public Optional<User> getUserWithAuthorities() {
      return SecurityUtils.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
   }

}
