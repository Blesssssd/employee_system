package eam.app.employee_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eam.app.employee_system.models.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
}
