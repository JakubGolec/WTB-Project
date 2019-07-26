package com.WTBProject.bookingBigTable.service;

import com.WTBProject.bigTable.dto.BigTableDTO;
import com.WTBProject.bigTable.model.BigTable;
import com.WTBProject.bookingBigTable.dto.BookingBigTableDTO;
import com.WTBProject.bookingBigTable.model.BookingBigTable;
import com.WTBProject.bookingBigTable.repositories.BookingBigTableRepository;
import com.WTBProject.user.dto.UserDTO;
import com.WTBProject.user.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@PropertySource("classpath:values.properties")
public class BookingBigTableService {

  private final BookingBigTableRepository bookingBigTableRepository;
  private ModelMapper modelMapper;


  @Autowired
  public BookingBigTableService(BookingBigTableRepository bookingBigTableRepository, ModelMapper modelMapper) {
    this.bookingBigTableRepository = bookingBigTableRepository;
    this.modelMapper = modelMapper;
  }

  public void saveBigTableReservation(BookingBigTableDTO bookingBigTableDTO) {
    BookingBigTable bookingBigTable = modelMapper.map(bookingBigTableDTO, BookingBigTable.class);
    BookingBigTable insertBooking = bookingBigTableRepository.save(bookingBigTable);
  }


//  public Long saveBookingBigTable(BookingBigTableDTO bookingBigTableDTO) {
//    BookingBigTable bookingBigTable = modelMapper.map(bookingBigTableDTO, BookingBigTable.class);
//    if (!bookingBigTableRepository.findByBigTableAndStartDateAndEndDate(bookingBigTable.getBigTable(), bookingBigTable.getStartDate(), bookingBigTable.getEndDate()).isPresent()) {
//      BookingBigTable insertedBookingBigTable = bookingBigTableRepository.save(bookingBigTable);
//      return insertedBookingBigTable.getId();
//    }
//    throw new IllegalArgumentException("Table already booked");
//  }

//  public List<BookingBigTableDTO> allReservationsForTheTable(String id) {
//    List<BookingBigTableDTO> allTableReservationsDTO = new ArrayList<>();
//    List<BookingBigTable> allTableReservations = bookingBigTableRepository.findAllByBigTable_Id("I");
//    if (!allTableReservations.isEmpty()) {
//      for (BookingBigTable bT : allTableReservations) {
//        allTableReservationsDTO.add(modelMapper.map(bT, BookingBigTableDTO.class));
//      }
//    }
//    return allTableReservationsDTO;
//
//
//  }



}
