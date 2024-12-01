package com.example.demo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	
	     @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;

	    @Column(nullable = false)
	    private String name;

	    private double price;

	     @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "category_id", nullable = false)
	    private Category category;

	    public Product() {
	    	
	    }


	    public Long getId() {
	        return id;
	    }
	    public void setId(Long id) {
	        this.id = id;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public double getPrice() {
	        return price;
	    }
	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public Category getCategory() {
	        return category;
	    }

	    public void setCategory(Category category) {
	        this.category = category;
	    }
	    
	    public Product(Long id, String name, double price) {
	        this.id = id;
	        this.name = name;
	        this.price = price;
	    }
	   
	    

}
