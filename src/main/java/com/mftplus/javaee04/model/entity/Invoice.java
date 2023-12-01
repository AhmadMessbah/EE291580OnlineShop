package com.mftplus.javaee04.model.entity;

import com.mftplus.javaee04.model.entity.enums.InvoiceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity(name = "invoiceEntity")
@Table(name = "invoice_tbl")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private InvoiceType invoiceType;

    @OneToOne(cascade = CascadeType.ALL)
    private User customer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<InvoiceItem> items = new ArrayList<>();

    private int amount;
    private int discount;
    private int purePayment;

    public void addItem(InvoiceItem invoiceItem){
        items.add(invoiceItem);
    }


    @PrePersist
    public void calculateAmount() {
        int sum = 0;
        for (InvoiceItem item : items) {
            sum += (item.getCount() * item.getPrice());
        }
        amount = sum;
        purePayment = sum - discount;
    }
}
