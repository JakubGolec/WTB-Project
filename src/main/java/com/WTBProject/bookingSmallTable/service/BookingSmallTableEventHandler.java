//package com.WTBProject.bookingSmallTable.service;
//
//import com.WTBProject.bigTable.dto.BigTableDTO;
//import com.WTBProject.bigTable.service.BigTableService;
//import com.WTBProject.bookingBigTable.dto.BookingBigTableDTO;
//import com.WTBProject.bookingBigTable.model.BookingBigTable;
//import com.WTBProject.bookingBigTable.repositories.BookingBigTableRepository;
//import com.WTBProject.bookingBigTable.service.BookingBigTableService;
//import com.WTBProject.bookingSmallTable.dto.BookingSmallTableDTO;
//import com.WTBProject.bookingSmallTable.model.BookingSmallTable;
//import com.WTBProject.bookingSmallTable.repositories.BookingSmallTableRepository;
//import com.WTBProject.smallTable.dto.SmallTableDTO;
//import com.WTBProject.smallTable.repositories.SmallTableRepository;
//import com.WTBProject.smallTable.service.SmallTableService;
//import org.modelmapper.ModelMapper;
//import org.springframework.data.rest.core.annotation.HandleAfterSave;
//import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
//
//import java.util.Optional;
//
//
//@RepositoryEventHandler(BookingSmallTable.class)
//public class BookingSmallTableEventHandler {
//
//  private BookingSmallTableRepository bookingSmallTableRepository;
//  private BookingBigTableRepository bookingBigTableRepository;
//  ModelMapper modelMapper;
//  private BookingSmallTableDTO bookingSmallTableDTO;
//  private SmallTableRepository smallTableRepository;
//  private SmallTableDTO smallTableDTO;
//  private BookingBigTableService bookingBigTableService;
//  private BookingSmallTableService bookingSmallTableService;
//  private BigTableService bigTableService;
//
//  @HandleAfterSave
//  public void makeBigTableReservation() {
//
//    Optional<BookingSmallTable> bookingSmallTable = bookingSmallTableRepository.findTopByOrderByIdDesc();
//
//    if (bookingSmallTable.isPresent()) {
//      bookingSmallTableDTO = modelMapper.map(bookingSmallTable.get(), BookingSmallTableDTO.class);
//    } else {
//      throw new IllegalArgumentException("Brak rezerwacji w bazie");
//    }
//
//    switch (bookingSmallTableDTO.getSmallTableDTO().getId()) {
//      case "1":
//        insertBigTables("I");
//        break;
//      case "2":
//        insertBigTables("I", "II");
//        break;
//      case "3":
//        insertBigTables("II");
//        break;
//      case "4":
//        insertBigTables("III");
//        break;
//      case "5":
//        insertBigTables("III", "IV");
//        break;
//      case "6":
//        insertBigTables("IV");
//        break;
//      case "7":
//        insertBigTables("V");
//        break;
//      case "8":
//        insertBigTables("V", "VI");
//        break;
//      case "9":
//        insertBigTables("VI");
//        break;
//      case "10":
//        insertBigTables("VII");
//        break;
//      case "11":
//        insertBigTables("VIII");
//        break;
//      case "12":
//        insertBigTables("IX");
//        break;
//      case "13":
//        insertBigTables("X");
//        break;
//      case "14":
//        insertBigTables("X", "XI");
//        break;
//      case "15":
//        insertBigTables("XI");
//        break;
//    }
//  }
//
////  private void insertBigTables(String id1, String id2) {
////    BigTableDTO bigTableDTO1 = bigTableService.getBigTableById(id1);
////    BigTableDTO bigTableDTO2 = bigTableService.getBigTableById(id2);
////
////    BookingBigTableDTO bookingBigTableDTO1 = new BookingBigTableDTO(bookingSmallTableDTO.getStartDate(), bookingSmallTableDTO.getEndDate(), bookingSmallTableDTO.getUser(), bigTableDTO1, bookingSmallTableDTO.getGame());
////    BookingBigTableDTO bookingBigTableDTO2 = new BookingBigTableDTO(bookingSmallTableDTO.getStartDate(), bookingSmallTableDTO.getEndDate(), bookingSmallTableDTO.getUser(), bigTableDTO2, bookingSmallTableDTO.getGame());
////
////    bookingBigTableService.saveBookingBigTable(bookingBigTableDTO1);
////    bookingBigTableService.saveBookingBigTable(bookingBigTableDTO2);
////  }
////
////  private void insertBigTables(String id) {
////    BigTableDTO bigTableDTO = bigTableService.getBigTableById(id);
////    BookingBigTableDTO bookingBigTableDTO = new BookingBigTableDTO(bookingSmallTableDTO.getStartDate(), bookingSmallTableDTO.getEndDate(), bookingSmallTableDTO.getUser(), bigTableDTO, bookingSmallTableDTO.getGame());
////    bookingBigTableService.saveBookingBigTable(bookingBigTableDTO);
////
////  }
//
//}
