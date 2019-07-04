package com.WTBProject.bigTable.repositories;

import com.WTBProject.bigTable.model.BigTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BigTableRepository extends JpaRepository<BigTable, String> {

  //List<BigTable> findAll(String namedQuery);
}
