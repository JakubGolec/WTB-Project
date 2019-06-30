package com.WTBProject.bigTable.repositories;

import com.WTBProject.bigTable.model.BigTable;
import org.springframework.data.repository.CrudRepository;

public interface BigTableRepository extends CrudRepository<BigTable, Integer> {
}
