package com.example.workshop01.repo;

import com.example.workshop01.model.IndexModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IndexRepository extends JpaRepository<IndexModel, Integer> {

}