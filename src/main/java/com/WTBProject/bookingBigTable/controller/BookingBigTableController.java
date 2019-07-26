package com.WTBProject.bookingBigTable.controller;

import com.WTBProject.bigTable.dto.BigTableDTO;
import com.WTBProject.bigTable.model.BigTable;
import com.WTBProject.bookingBigTable.dto.BookingBigTableDTO;
import com.WTBProject.bookingBigTable.model.BookingBigTable;
import com.WTBProject.bookingBigTable.repositories.BookingBigTableRepository;
import com.WTBProject.bookingBigTable.service.BookingBigTableService;
import com.WTBProject.bookingSmallTable.service.BookingSmallTableService;
import com.WTBProject.game.dto.GameDTO;
import com.WTBProject.game.model.Game;
import com.WTBProject.user.dto.UserDTO;
import com.WTBProject.user.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookingBigTableController {

  private BookingBigTableRepository bookingBigTableRepository;
  private ModelMapper modelmapper;
  private BookingBigTableService bookingBigTableService;

  @Autowired
  public BookingBigTableController(BookingBigTableRepository bookingBigTableRepository, ModelMapper modelmapper, BookingBigTableService bookingBigTableService) {
    this.bookingBigTableRepository = bookingBigTableRepository;
    this.modelmapper = modelmapper;
    this.bookingBigTableService = bookingBigTableService;
  }


  @GetMapping("/allBigTableBookings")
  public String getAllBigTablesBookings(BookingBigTableRepository bookingBigTableRepository, Model model) {
    List<BookingBigTable> allBigTablesBookingsDTOS = (List<BookingBigTable>) bookingBigTableRepository.findAll();
    model.addAttribute("allBigTablesBookings", allBigTablesBookingsDTOS);
    return "/allBigTablesBookings";
  }

  @GetMapping("/allReservations")
  @CrossOrigin(origins = "http://localhost:4200")
  public List<BookingBigTableDTO> allReservationsForTheTable(@RequestParam String bigTableId, Model model) {
    List<BookingBigTableDTO> allTableReservationsDTO = new ArrayList<>();
    List<BookingBigTable> allTableReservations = bookingBigTableRepository.findAllByBigTable_Id(bigTableId);
    if (!allTableReservations.isEmpty()) {
      for (BookingBigTable bT : allTableReservations) {
        allTableReservationsDTO.add(new BookingBigTableDTO(bT.getId(), bT.getStartDate(), bT.getEndDate(), bT.getUser(), modelmapper.map(bT.getBigTable(), BigTableDTO.class), bT.getGame()));
      }
    }
    model.addAttribute("allReservations", allTableReservationsDTO);
    return allTableReservationsDTO;
  }

  @PostMapping("/reservation")
  @CrossOrigin(origins = "http://localhost:4200")
  public void addBigTableReservation(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Model model) throws ParseException {
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
    Date date1 = formatter.parse(startDate);
    Date date2 = formatter.parse(endDate);
//    BookingBigTableDTO bookingBigTableDTO = new BookingBigTableDTO(date1, date2, new UserDTO("gsv", "vdv", "vwswv", "vdsv", "fbsb"), new BigTableDTO("XX", true), new GameDTO("vdvdw", true));
//    bookingBigTableService.saveBigTableReservation(bookingBigTableDTO);
//    model.addAttribute("newReservation", bookingBigTableDTO);
//    List<BookingBigTableDTO> allReservations = bookingBigTableRepository.findAll().stream()
//      .map(bookingBigTable -> modelmapper.map(bookingBigTable, BookingBigTableDTO.class))
//      .collect(Collectors.toList());
//    model.addAttribute("allReservations", allReservations);
  }
}
