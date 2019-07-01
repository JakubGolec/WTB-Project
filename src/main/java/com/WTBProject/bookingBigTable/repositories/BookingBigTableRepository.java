package com.WTBProject.bookingBigTable.repositories;

import com.WTBProject.bookingBigTable.model.BookingBigTable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookingBigTableRepository extends CrudRepository<BookingBigTable, Long> {

  Optional<BookingBigTable> findTopByOrderByIdDesc();
}
