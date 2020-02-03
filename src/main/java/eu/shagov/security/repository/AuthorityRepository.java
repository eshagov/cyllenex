package eu.shagov.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import eu.shagov.security.model.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
