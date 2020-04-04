package eu.andreirusu.daw.cardb.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserrRepository extends CrudRepository<Userr, Long> {
	Userr findByUsername(String username);
}
