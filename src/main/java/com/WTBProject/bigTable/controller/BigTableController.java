package com.WTBProject.bigTable.controller;

import com.WTBProject.bigTable.model.BigTable;
import com.WTBProject.bigTable.repositories.BigTableRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BigTableController {


    @GetMapping("/allBigTables")
    public String getAllBigTables(BigTableRepository bigTableRepository, Model model) {
        List<BigTable> allBigTablesDTOS = (List<BigTable>) bigTableRepository.findAll();
        model.addAttribute("allBigTables", allBigTablesDTOS);
        return "/allBigTables";
    }
}
