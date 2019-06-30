package com.WTBProject.bookingBigTable.controller;

import com.WTBProject.bookingBigTable.model.BookingBigTable;
import com.WTBProject.bookingBigTable.repositories.BookingBigTableRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookingBigTableController {

    @GetMapping("/allBigTableBookings")
    public String getAllBigTablesBookings(BookingBigTableRepository bookingBigTableRepository, Model model) {
        List<BookingBigTable> allBigTablesBookingsDTOS = (List<BookingBigTable>) bookingBigTableRepository.findAll();
        model.addAttribute("allBigTablesBookings", allBigTablesBookingsDTOS);
        return "/allBigTablesBookings";
    }
}
