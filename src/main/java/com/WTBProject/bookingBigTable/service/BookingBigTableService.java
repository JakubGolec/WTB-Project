package com.WTBProject.bookingBigTable.service;

import com.WTBProject.bookingBigTable.dto.BookingBigTableDTO;
import com.WTBProject.bookingBigTable.model.BookingBigTable;
import com.WTBProject.bookingBigTable.repositories.BookingBigTableRepository;
import com.WTBProject.bookingSmallTable.dto.BookingSmallTableDTO;
import com.WTBProject.bookingSmallTable.model.BookingSmallTable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

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

    public Long makeReservation(BookingBigTableDTO bookingBigTableDTO){
        BookingBigTable bookingBigTable = modelMapper.map(bookingBigTableDTO, BookingBigTable.class);
        BookingBigTable insertedBigTableBooking = bookingBigTableRepository.save(bookingBigTable);
        return insertedBigTableBooking.getId();
    }

  public Long saveBookingBigTable(BookingBigTableDTO bookingBigTableDTO) {
    BookingBigTable bookingBigTable = modelMapper.map(bookingBigTableDTO, BookingBigTable.class);
    BookingBigTable insertedBookingBigTable = bookingBigTableRepository.save(bookingBigTable);
    return insertedBookingBigTable.getId();
  }


}
