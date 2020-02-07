package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Animals")
public class Animals {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "Specias")
	private String specias;
	@Column(name = "Population")
	private String amount;

	public Animals() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Animals(String species, String amount) {
		this.specias = species;
		this.amount = amount;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpecies() {
		return specias;
	}

	public void setSpecies(String species) {
		this.specias = species;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String returnItemDetails() {
		return "----" + specias + "--:--" + amount + "--";
	}

}
