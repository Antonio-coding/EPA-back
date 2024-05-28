package com.api.epacontrol.repositories;

import com.api.epacontrol.models.UsersModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, UUID> {
  boolean existsByEmail(String email);

  UsersModel findByEmail(String email);
}
