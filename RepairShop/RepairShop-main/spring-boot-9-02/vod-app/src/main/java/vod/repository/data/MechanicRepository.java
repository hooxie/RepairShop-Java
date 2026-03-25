package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Mechanic;

public interface MechanicRepository extends JpaRepository<Mechanic,Integer> {
}
