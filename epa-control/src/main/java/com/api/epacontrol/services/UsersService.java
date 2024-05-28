package com.api.epacontrol.services;

import com.api.epacontrol.models.UsersModel;
import com.api.epacontrol.repositories.UsersRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

  final UsersRepository usersRepository;

  UsersService(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  @Transactional
  public UsersModel save(UsersModel usersModel) {
    return usersRepository.save(usersModel);
  }

  public boolean existsByEmail(String email) {
    return usersRepository.existsByEmail(email);
  }

  public Page<UsersModel> findAll(Pageable pageable) {
    return usersRepository.findAll(pageable);
  }

  public Optional<UsersModel> findById(UUID id) {
    return usersRepository.findById(id);
  }

  @Transactional
  public void delete(UsersModel usersModel) {
    usersRepository.delete(usersModel);
  }
}


