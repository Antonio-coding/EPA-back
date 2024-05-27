package com.api.epacontrol.services;

import com.api.epacontrol.models.UsersModel;
import com.api.epacontrol.repositories.UsersRepository;
import jakarta.transaction.Transactional;
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

  public UsersModel findById(Long id) {
    return usersRepository.findById(id).orElse(null); // Optional handling
  }
}
