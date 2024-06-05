package pe.edu.unmsm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.unmsm.Model.DniModel;

public interface DniRepository extends JpaRepository<DniModel, Long> {
}
