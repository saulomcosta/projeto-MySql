package saulo.io.projeto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import saulo.io.projeto1.entity.Useres;

public interface UseresRepository extends JpaRepository<Useres, Long> {

	Useres findByName(String name);

	@Query("select u from Useres u where u.name like %?1%")
	Useres findByNameLike(String name);
	
	Useres findByNameIgnoreCase(String name);

}
