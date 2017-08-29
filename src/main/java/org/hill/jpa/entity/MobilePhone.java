package org.hill.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class MobilePhone extends Product {

    @Column(name = "OS", length = 50)
    private OperatingSystem operatingSystem;

    public MobilePhone() {
        super();
        setProductCategory(ProductCategory.PHONE);
    }

    public MobilePhone(String description, OperatingSystem operatingSystem) {
        super(ProductCategory.PHONE, description);
        this.operatingSystem = operatingSystem;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
