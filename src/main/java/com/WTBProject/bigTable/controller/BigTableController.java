package com.WTBProject.bigTable.controller;

import com.WTBProject.bigTable.dto.BigTableDTO;
import com.WTBProject.bigTable.model.BigTable;
import com.WTBProject.bigTable.repositories.BigTableRepository;
import com.WTBProject.bigTable.service.BigTableService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BigTableController {


  private ModelMapper modelMapper;
  private BigTableRepository bigTableRepository;

  @Autowired
  public BigTableController(ModelMapper modelMapper, BigTableRepository bigTableRepository) {
    this.modelMapper = modelMapper;
    this.bigTableRepository = bigTableRepository;
  }


  @GetMapping("/allBigTables")
  public List<BigTableDTO> getAllBigTables(Model model) {
    List<BigTable> allBigTables = bigTableRepository.findAll();
    List<BigTableDTO> bigTableDTOS = new ArrayList<>();
    if(!allBigTables.isEmpty()){
      for (BigTable bT:allBigTables){
        bigTableDTOS.add(modelMapper.map(bT, BigTableDTO.class));
      }
    }
    model.addAttribute("allBigTables", bigTableDTOS);
    return bigTableDTOS;
  }

}
