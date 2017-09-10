package org.hill.jpa.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

@Entity
@EntityListeners({CustomerPersistenceListener.class})
@Table(name = "CUSTOMER")
@NamedQueries({@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @TableGenerator(name = "CUSTOMER_GEN", table = "ID_GENERATOR", pkColumnValue = "CUSTOMER", pkColumnName = "ID", valueColumnName = "VAL")
    //@SequenceGenerator(name = "CUSTOMER_GEN", sequenceName = "CUSTOMER_SEQUENCE")
    @GeneratedValue(generator = "CUSTOMER_GEN")
    @Column(name = "CUSTOMER_ID")
    private long id;
    @Column(name = "F_NAME", length = 50)
    private String firstName;
    @Column(name = "L_NAME", length = 50)
    private String lastName;
    @Column(name = "N_NAME")
    private String nickName;
    @Column(name = "B_DATE")
    private LocalDate birthDate;
    private Gender gender;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> orders;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "CUSTOMER_ID"))
    private Collection<Address> addresses;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String nickName, LocalDate birthDate, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
