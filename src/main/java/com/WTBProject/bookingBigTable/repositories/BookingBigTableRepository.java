package com.WTBProject.bookingBigTable.repositories;

import com.WTBProject.bigTable.model.BigTable;
import com.WTBProject.bookingBigTable.model.BookingBigTable;
import com.WTBProject.bookingSmallTable.model.BookingSmallTable;
import com.WTBProject.smallTable.model.SmallTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource
//@CrossOrigin(origins = "http://localhost:4200")
public interface BookingBigTableRepository extends JpaRepository<BookingBigTable, Long> {

  Optional<BookingBigTable> findTopByOrderByIdDesc();

  Optional<BookingSmallTable> findByBigTableAndStartDateAndEndDate(BigTable bigTable, Date startDate, Date endDate);

  List<BookingBigTable> findAllByBigTable_Id(String bigTableId);


}
