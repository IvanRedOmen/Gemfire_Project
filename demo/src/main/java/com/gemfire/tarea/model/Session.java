package com.gemfire.tarea.model;

import java.util.concurrent.atomic.AtomicLong;
 
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.Region;
 
@Region("session")
public class Session {
  
  private static AtomicLong COUNTER = new AtomicLong(0L);
  
    @Id
    private Long id;
    private String customerName;
	
    @PersistenceConstructor
    public Session() {
		super();
		this.id = COUNTER.incrementAndGet();
	}

	public Session(Long id, String customerName) {
		super();
		this.id = id;
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", customerName=" + customerName + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
    
}