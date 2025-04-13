package learn.spring_boot.hands_on.repository;

import learn.spring_boot.hands_on.domain.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
