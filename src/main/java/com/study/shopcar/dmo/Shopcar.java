package com.study.shopcar.dmo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the shopcar database table.
 * 
 */
@Entity
@NamedQuery(name = "Shopcar.findAll", query = "SELECT s FROM Shopcar s")
public class Shopcar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime;

	// bi-directional many-to-one association to Buy
	@OneToMany(mappedBy = "shopcar")
	private List<Buy> buys;

	// bi-directional many-to-one association to User
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Shopcar() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<Buy> getBuys() {
		return this.buys;
	}

	public void setBuys(List<Buy> buys) {
		this.buys = buys;
	}

	public Buy addBuy(Buy buy) {
		getBuys().add(buy);
		buy.setShopcar(this);

		return buy;
	}

	public Buy removeBuy(Buy buy) {
		getBuys().remove(buy);
		buy.setShopcar(null);

		return buy;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}