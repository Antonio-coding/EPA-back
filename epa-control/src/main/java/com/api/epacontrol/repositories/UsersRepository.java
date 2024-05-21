package com.api.epacontrol.repositories;

import com.api.epacontrol.models.Users;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, UUID> {}
