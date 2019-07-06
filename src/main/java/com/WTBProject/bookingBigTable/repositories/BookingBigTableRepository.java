package com.WTBProject.bookingBigTable.repositories;

import com.WTBProject.bigTable.model.BigTable;
import com.WTBProject.bookingBigTable.model.BookingBigTable;
import com.WTBProject.bookingSmallTable.model.BookingSmallTable;
import com.WTBProject.smallTable.model.SmallTable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookingBigTableRepository extends CrudRepository<BookingBigTable, Long> {

  Optional<BookingBigTable> findTopByOrderByIdDesc();

  Optional<BookingSmallTable> findByBigTableAndStartDateAndEndDate(BigTable bigTable, Date startDate, Date endDate);

  List getReservationsForTheTable(String id);
}
