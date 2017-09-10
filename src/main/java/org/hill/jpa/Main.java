package org.hill.jpa;

import org.apache.commons.lang3.ArrayUtils;
import org.hill.jpa.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    private static final String[] PERSISTENCE_UNITS = {"h2PU", "oraclePU"};

    public static void main(String[] args) {
        if (ArrayUtils.isEmpty(args) || !ArrayUtils.contains(PERSISTENCE_UNITS, args[0])) {
            System.out.println("Only one of the following PU's is supported: " + ArrayUtils.toString(PERSISTENCE_UNITS));
            System.exit(0);
        }

        int puIdx = ArrayUtils.indexOf(PERSISTENCE_UNITS, args[0]);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNITS[puIdx]);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Customer customer = getCustomer("Ahmed", "Hillawi", "Hill", LocalDate.of(1983, 7, 11), Gender.MALE);
        Address address1 = new Address("Belgium", "Brussels", "Uccle", "Rue de Stalle", 162);
        Address address2 = new Address("Belgium", "Brussels", "Ville de Bruxelles", "Rue de la Croix de Fer", 68);
        customer.setAddresses(Arrays.asList(address1, address2));
        em.persist(customer);
        em.getTransaction().commit();

        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
        List<Customer> customers = query.getResultList();

        System.out.println(customers);

        em.getEntityManagerFactory().close();
    }

    private static Customer getCustomer(String fName, String lName, String nName, LocalDate bDate, Gender gender) {
        Customer customer = new Customer(fName, lName, nName, bDate, gender);

        Set<Product> products = new HashSet<>();
        products.add(new Product(ProductCategory.PHONE, "Samsung Galaxy S3"));
        products.add(new MobilePhone("OnePlus 2", OperatingSystem.ANDROID));
        products.add(new Product(ProductCategory.BOOK, "Mastering JPA"));

        Book book = new Book();
        book.setName("Pro JPA");
        book.setDescription("A book about JPA 2.0");

        Set<Book> books = new HashSet<>();
        books.add(book);

        Set<Author> authors = new HashSet<>();
        authors.add(new Author("Mike", "Keith", books));
        authors.add(new Author("Merrick", "Schincariol", books));

        book.setAuthors(authors);

        products.add(book);

        Set<Order> orders = new HashSet<>();
        orders.add(new Order(customer, products));

        customer.setOrders(orders);
        return customer;
    }
}
