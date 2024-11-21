package com.dsi.tp1.entity;

import java.io.Serializable;
import java.util.List;

import com.dsi.tp1.Orderenum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "ordere")
public class Ordere implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "state")
	private Orderenum state;
	
	@Column(name = "consumerId")
	private int consumerId;
	
	@Column(name = "restaurantId")
	private int restaurantId;

	
	@OneToMany(mappedBy="ordere", cascade = CascadeType.ALL)
	private List<OrderLineItems> idOrder;
	 
    @OneToOne(mappedBy = "ordere", cascade = CascadeType.ALL)
    private DeliveryInfo deliveryInfo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Orderenum getState() {
		return state;
	}

	public void setState(Orderenum state) {
		this.state = state;
	}

	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public List<OrderLineItems> getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(List<OrderLineItems> idOrder) {
		this.idOrder = idOrder;
	}

	public DeliveryInfo getDeliveryInfo() {
		return deliveryInfo;
	}

	public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}

	public Ordere(Orderenum state, int consumerId, int restaurantId, List<OrderLineItems> idOrder,
			DeliveryInfo deliveryInfo) {
		super();
		this.state = state;
		this.consumerId = consumerId;
		this.restaurantId = restaurantId;
		this.idOrder = idOrder;
		this.deliveryInfo = deliveryInfo;
	}

	public Ordere() {
		super();
	}

	public Ordere(Orderenum state, int consumerId, int restaurantId) {
		super();
		this.state = state;
		this.consumerId = consumerId;
		this.restaurantId = restaurantId;
	}





	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
