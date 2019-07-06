package com.WTBProject.bookingSmallTable.repositories;

import com.WTBProject.bookingBigTable.model.BookingBigTable;
import com.WTBProject.bookingSmallTable.model.BookingSmallTable;
import com.WTBProject.smallTable.model.SmallTable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Optional;

public interface BookingSmallTableRepository extends CrudRepository<BookingSmallTable, Long> {

  Optional<BookingSmallTable> findBySmallTableAndStartDateAndEndDate(SmallTable smallTable, Date startDate, Date endDate);

  Optional<BookingSmallTable> findTopByOrderByIdDesc();
}
