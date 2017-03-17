package com.study.shopcar.dmo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the goods database table.
 * 
 */
@Entity
@NamedQuery(name = "Goods.findAll", query = "SELECT g FROM Goods g")
public class Goods implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id")
	private GoodsType goodsType;

	private String info;

	private String maker;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "stock_time")
	private Date stockTime;

	@Column(name = "store_number")
	private int storeNumber;

	@Column(name = "view_pic")
	private String viewPic;

	public Goods() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getMaker() {
		return this.maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStockTime() {
		return this.stockTime;
	}

	public void setStockTime(Date stockTime) {
		this.stockTime = stockTime;
	}

	public int getStoreNumber() {
		return this.storeNumber;
	}

	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}

	public String getViewPic() {
		return this.viewPic;
	}

	public void setViewPic(String viewPic) {
		this.viewPic = viewPic;
	}

}