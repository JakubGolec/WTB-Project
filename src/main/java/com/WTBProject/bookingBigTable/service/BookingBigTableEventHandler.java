package com.WTBProject.bookingBigTable.service;

import com.WTBProject.bigTable.model.BigTable;
import com.WTBProject.bookingBigTable.dto.BookingBigTableDTO;
import com.WTBProject.bookingBigTable.model.BookingBigTable;
import com.WTBProject.bookingBigTable.repositories.BookingBigTableRepository;
import com.WTBProject.bookingSmallTable.dto.BookingSmallTableDTO;
import com.WTBProject.bookingSmallTable.model.BookingSmallTable;
import com.WTBProject.bookingSmallTable.repositories.BookingSmallTableRepository;
import com.WTBProject.game.model.Game;
import com.WTBProject.smallTable.dto.SmallTableDTO;
import com.WTBProject.smallTable.model.SmallTable;
import com.WTBProject.smallTable.repositories.SmallTableRepository;
import com.WTBProject.user.model.User;
import javafx.scene.control.Tab;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;


@RepositoryEventHandler(BookingBigTable.class)
public class BookingBigTableEventHandler {

  private BookingSmallTableRepository bookingSmallTableRepository;
  private BookingBigTableRepository bookingBigTableRepository;
  ModelMapper modelMapper;
  private BookingBigTableDTO bookingBigTableDTO;
  private SmallTableRepository smallTableRepository;
  private SmallTableDTO smallTableDTO;

  @HandleAfterSave
  public void makeSmallTableReservation() {

    Optional<BookingBigTable> bookingBigTable = bookingBigTableRepository.findTopByOrderByIdDesc();

    if (bookingBigTable.isPresent()) {
      bookingBigTableDTO = modelMapper.map(bookingBigTable.get(), BookingBigTableDTO.class);
    }


    //todo Do zmiany stoły
    Optional<SmallTable> smallTable = smallTableRepository.findById("I");
    if (smallTable.isPresent()) {
      smallTableDTO = modelMapper.map(smallTable.get(), SmallTableDTO.class);
    }

    BookingSmallTableDTO bookingSmallTableDTO = new BookingSmallTableDTO(bookingBigTableDTO.getStartDate(), bookingBigTableDTO.getEndDate(), bookingBigTableDTO.getUser(), smallTableDTO, bookingBigTableDTO.getGame());

    BookingSmallTable bookingSmallTable = modelMapper.map(bookingSmallTableDTO, BookingSmallTable.class);

    bookingSmallTableRepository.save(bookingSmallTable);

  }
}
