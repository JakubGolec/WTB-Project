package com.WTBProject.smallTable.controller;

import com.WTBProject.smallTable.model.SmallTable;
import com.WTBProject.smallTable.repositories.SmallTableRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SmallTableController {


    @GetMapping("/allSmallTables")
    public String getAllSmallTables(SmallTableRepository smallTableRepository, Model model) {
        List<SmallTable> allSmallTablesDTOS = (List<SmallTable>) smallTableRepository.findAll();
        model.addAttribute("allSmallTables", allSmallTablesDTOS);
        return "/allSmallTables";
    }
}
