package com.WTBProject.smallTable.service;

import com.WTBProject.smallTable.dto.SmallTableDTO;
import com.WTBProject.smallTable.model.SmallTable;
import com.WTBProject.smallTable.repositories.SmallTableRepository;
import com.WTBProject.user.dto.UserDTO;
import com.WTBProject.user.model.User;
import com.WTBProject.user.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@PropertySource("classpath:values.properties")
public class SmallTableService {

  private final SmallTableRepository smallTableRepository;
  private ModelMapper modelMapper;


  @Autowired
  public SmallTableService(SmallTableRepository smallTableRepository, ModelMapper modelMapper) {
    this.smallTableRepository = smallTableRepository;
    this.modelMapper = modelMapper;
  }


  public SmallTableDTO getSmallTableById(String id) {
    Optional<SmallTable> smallTable = smallTableRepository.findById(id);
    if (smallTable.isPresent()) {
      return modelMapper.map(smallTable.get(), SmallTableDTO.class);
    } else {
      throw new IllegalArgumentException("Small table with such id not found");
    }
  }


}
