package org.hill.jpa.entity;

import javax.persistence.PostLoad;
import javax.persistence.PrePersist;

public class CustomerPersistenceListener {
    @PrePersist
    public void prePersist(Customer customer) {
        System.out.println(customer);
    }

    @PostLoad
    public void postLoad(Customer customer) {
        System.out.println(customer);
    }
}
