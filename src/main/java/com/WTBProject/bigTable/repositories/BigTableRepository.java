package com.WTBProject.bigTable.repositories;

import com.WTBProject.bigTable.model.BigTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BigTableRepository extends JpaRepository<BigTable, String> {

  //List<BookingBigTable> findAll(String namedQuery);
}
