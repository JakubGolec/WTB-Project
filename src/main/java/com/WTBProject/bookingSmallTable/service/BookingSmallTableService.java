package com.WTBProject.bookingSmallTable.service;

import com.WTBProject.bookingSmallTable.dto.BookingSmallTableDTO;
import com.WTBProject.bookingSmallTable.model.BookingSmallTable;
import com.WTBProject.bookingSmallTable.repositories.BookingSmallTableRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:values.properties")
public class BookingSmallTableService {

  private ModelMapper modelMapper;
  private BookingSmallTableRepository bookingSmallTableRepository;

  @Autowired
  public BookingSmallTableService(BookingSmallTableRepository bookingSmallTableRepository, ModelMapper modelMapper) {
    this.bookingSmallTableRepository = bookingSmallTableRepository;
    this.modelMapper = modelMapper;
  }


  public Long saveBookingSmallTable(BookingSmallTableDTO bookingSmallTableDTO) {
    BookingSmallTable bookingSmallTable = modelMapper.map(bookingSmallTableDTO, BookingSmallTable.class);
    if(!bookingSmallTableRepository.findBySmallTableAndStartDateAndEndDate(bookingSmallTable.getSmallTable(), bookingSmallTable.getStartDate(), bookingSmallTable.getEndDate()).isPresent()){
      BookingSmallTable insertedBookingSmallTable = bookingSmallTableRepository.save(bookingSmallTable);
      return insertedBookingSmallTable.getId();
    }
    throw new IllegalArgumentException("Table already booked");
  }
}
