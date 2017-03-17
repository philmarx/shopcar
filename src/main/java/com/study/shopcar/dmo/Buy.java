package com.study.shopcar.dmo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value={"shopcar"})
public class Buy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer count;

	// bi-directional many-to-one association to Shopcar
	@ManyToOne
	private Shopcar shopcar;

	// bi-directional many-to-one association to Goods
	@ManyToOne
	@JoinColumn(name = "goods_id")
	private Goods goods;

	public Buy() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Shopcar getShopcar() {
		return this.shopcar;
	}

	public void setShopcar(Shopcar shopcar) {
		this.shopcar = shopcar;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}


}