package com.WTBProject.bigTable.service;

import com.WTBProject.bigTable.dto.BigTableDTO;
import com.WTBProject.bigTable.model.BigTable;
import com.WTBProject.bigTable.repositories.BigTableRepository;
import com.WTBProject.smallTable.dto.SmallTableDTO;
import com.WTBProject.smallTable.model.SmallTable;
import com.WTBProject.smallTable.repositories.SmallTableRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@PropertySource("classpath:values.properties")
public class BigTableService {

  private final BigTableRepository bigTableRepository;
  private ModelMapper modelMapper;


  @Autowired
  public BigTableService(BigTableRepository bigTableRepository, ModelMapper modelMapper) {
    this.bigTableRepository = bigTableRepository;
    this.modelMapper = modelMapper;
  }


  public BigTableDTO getBigTableById(String id) {
    Optional<BigTable> bigTable = bigTableRepository.findById(id);
    if (bigTable.isPresent()) {
      return modelMapper.map(bigTable.get(), BigTableDTO.class);
    } else {
      throw new IllegalArgumentException("Big table with such id not found");
    }
  }
}

