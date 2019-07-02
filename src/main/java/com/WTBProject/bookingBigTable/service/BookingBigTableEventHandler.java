package com.WTBProject.bookingBigTable.service;

import com.WTBProject.bookingBigTable.dto.BookingBigTableDTO;
import com.WTBProject.bookingBigTable.model.BookingBigTable;
import com.WTBProject.bookingBigTable.repositories.BookingBigTableRepository;
import com.WTBProject.bookingSmallTable.dto.BookingSmallTableDTO;
import com.WTBProject.bookingSmallTable.repositories.BookingSmallTableRepository;
import com.WTBProject.bookingSmallTable.service.BookingSmallTableService;
import com.WTBProject.smallTable.dto.SmallTableDTO;
import com.WTBProject.smallTable.repositories.SmallTableRepository;
import com.WTBProject.smallTable.service.SmallTableService;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import java.util.Optional;


@RepositoryEventHandler(BookingBigTable.class)
public class BookingBigTableEventHandler {

  private BookingSmallTableRepository bookingSmallTableRepository;
  private BookingBigTableRepository bookingBigTableRepository;
  ModelMapper modelMapper;
  private BookingBigTableDTO bookingBigTableDTO;
  private SmallTableRepository smallTableRepository;
  private SmallTableDTO smallTableDTO;
  private SmallTableService smallTableService;
  private BookingSmallTableService bookingSmallTableService;

  @HandleAfterSave
  public void makeSmallTableReservation() {

    Optional<BookingBigTable> bookingBigTable = bookingBigTableRepository.findTopByOrderByIdDesc();

    if (bookingBigTable.isPresent()) {
      bookingBigTableDTO = modelMapper.map(bookingBigTable.get(), BookingBigTableDTO.class);
    } else {
      throw new IllegalArgumentException("Brak rezerwacji w bazie");
    }

    switch (bookingBigTableDTO.getBigTableDTO().getId()) {
      case "I":
        insertSmallTables("1", "2");
        break;
      case "II":
        insertSmallTables("2", "3");
        break;
      case "III":
        insertSmallTables("4", "5");
        break;
      case "IV":
        insertSmallTables("5", "6");
        break;
      case "V":
        insertSmallTables("7", "8");
        break;
      case "VI":
        insertSmallTables("8", "9");
        break;
      case "VII":
        insertSmallTables("10");
        break;
      case "VIII":
        insertSmallTables("11");
        break;
      case "IX":
        insertSmallTables("12");
        break;
      case "X":
        insertSmallTables("13", "14");
        break;
      case "XI":
        insertSmallTables("14", "15");
        break;
    }
  }

  private void insertSmallTables(String id1, String id2) {
    SmallTableDTO smallTableDTO1 = smallTableService.getSmallTableById(id1);
    SmallTableDTO smallTableDTO2 = smallTableService.getSmallTableById(id2);

    BookingSmallTableDTO bookingSmallTableDTO1 = new BookingSmallTableDTO(bookingBigTableDTO.getStartDate(), bookingBigTableDTO.getEndDate(), bookingBigTableDTO.getUser(), smallTableDTO1, bookingBigTableDTO.getGame());
    BookingSmallTableDTO bookingSmallTableDTO2 = new BookingSmallTableDTO(bookingBigTableDTO.getStartDate(), bookingBigTableDTO.getEndDate(), bookingBigTableDTO.getUser(), smallTableDTO2, bookingBigTableDTO.getGame());

    bookingSmallTableService.saveBookingSmallTable(bookingSmallTableDTO1);
    bookingSmallTableService.saveBookingSmallTable(bookingSmallTableDTO2);
  }

  private void insertSmallTables(String id) {
    SmallTableDTO smallTableDTO = smallTableService.getSmallTableById(id);
    BookingSmallTableDTO bookingSmallTableDTO = new BookingSmallTableDTO(bookingBigTableDTO.getStartDate(), bookingBigTableDTO.getEndDate(), bookingBigTableDTO.getUser(), smallTableDTO, bookingBigTableDTO.getGame());
    bookingSmallTableService.saveBookingSmallTable(bookingSmallTableDTO);

  }

}
