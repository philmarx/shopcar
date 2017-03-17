package com.study.shopcar.dmo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "goods_type")
public class GoodsType implements Serializable {

	private static final long serialVersionUID = -6683263723997257362L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	@Column(name = "parent_id")
	private Integer parent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public GoodsType() {
		super();
	}

	public GoodsType(String name, Integer parent) {
		super();
		this.name = name;
		this.parent = parent;
	}

	public GoodsType(String name) {
		super();
		this.name = name;
	}

	public GoodsType(Integer id, String name, Integer parent) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
	}

}
