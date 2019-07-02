package com.WTBProject.bookingBigTable.service;

import com.WTBProject.bookingBigTable.dto.BookingBigTableDTO;
import com.WTBProject.bookingBigTable.model.BookingBigTable;
import com.WTBProject.bookingBigTable.repositories.BookingBigTableRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

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


  public Long saveBookingBigTable(BookingBigTableDTO bookingBigTableDTO) {
    BookingBigTable bookingBigTable = modelMapper.map(bookingBigTableDTO, BookingBigTable.class);
    if(!bookingBigTableRepository.findByBigTableAndStartDateAndEndDate(bookingBigTable.getBigTable(), bookingBigTable.getStartDate(), bookingBigTable.getEndDate()).isPresent()) {
      BookingBigTable insertedBookingBigTable = bookingBigTableRepository.save(bookingBigTable);
      return insertedBookingBigTable.getId();
    }
    throw new IllegalArgumentException("Table already booked");
  }

  public List getReservationsForTheTable(String id){
   return bookingBigTableRepository.getReservationsForTheTable(id);
  }


}
