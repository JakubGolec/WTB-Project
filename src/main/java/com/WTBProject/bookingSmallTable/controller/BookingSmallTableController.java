package com.WTBProject.bookingSmallTable.controller;

import com.WTBProject.bookingSmallTable.model.BookingSmallTable;
import com.WTBProject.bookingSmallTable.repositories.BookingSmallTableRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookingSmallTableController {

    @GetMapping("/allSmallTableBookings")
    public String getAllSmallTablesBookings(BookingSmallTableRepository bookingSmallTableRepository, Model model) {
        List<BookingSmallTable> allSmallTablesBookingsDTOS = (List<BookingSmallTable>) bookingSmallTableRepository.findAll();
        model.addAttribute("allSmallTablesBookings", allSmallTablesBookingsDTOS);
        return "/allSmallTablesBookings";
    }
}
