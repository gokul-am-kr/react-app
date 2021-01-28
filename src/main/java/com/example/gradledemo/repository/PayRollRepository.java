package com.example.gradledemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gradledemo.model.PayRoll;
public interface PayRollRepository extends JpaRepository<PayRoll, Long>{

}
