package org.example.hospital.repositories;

import org.example.hospital.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
