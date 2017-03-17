package com.study.shopcar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.shopcar.dmo.Goods;

public interface GoodsDao extends JpaRepository<Goods, Integer>{

}
