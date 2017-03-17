package com.study.shopcar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.shopcar.dmo.Shopcar;

public interface ShopcarDao extends JpaRepository<Shopcar, Integer>{

}
