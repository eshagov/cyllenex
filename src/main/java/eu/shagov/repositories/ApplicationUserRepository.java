package eu.shagov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.shagov.entities.ApplicationUser;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
