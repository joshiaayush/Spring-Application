package com.codekul.java21febspring.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "po_number")
    private String purchaseOrderNumber;

    @Column(name = "po_date")
    private LocalDate purchaseOrderDate;

    @Column(name = "ship_to_address")
    private String shipToAddress;

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseOrderItem> purchaseOrderItems;

    @Column(name = "total_gst_amount")
    private BigDecimal totalGstAmount;

    @Column(name = "total_discount_amount")
    private BigDecimal totalDiscountAmount;

    @Column(name = "total_net_amount")
    private BigDecimal totalNetAmount;

    // Constructors, getters, and setters

    @PrePersist
    @PreUpdate
    private void calculateTotals() {
        totalGstAmount = calculateTotalGstAmount();
        totalDiscountAmount = calculateTotalDiscountAmount();
        totalNetAmount = calculateTotalNetAmount();
    }

    private BigDecimal calculateTotalGstAmount() {
        return purchaseOrderItems.stream()
                .map(item -> BigDecimal.valueOf(item.getRate())
                        .multiply(BigDecimal.valueOf(item.getQuantity()))
                        .multiply(BigDecimal.valueOf(item.getGst())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateTotalDiscountAmount() {
        return purchaseOrderItems.stream()
                .map(item -> BigDecimal.valueOf(item.getRate())
                        .multiply(BigDecimal.valueOf(item.getQuantity()))
                        .multiply(BigDecimal.valueOf(item.getDiscount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateTotalNetAmount() {
        return purchaseOrderItems.stream()
                .map(item -> {
                    BigDecimal itemAmount = BigDecimal.valueOf(item.getRate()).multiply(BigDecimal.valueOf(item.getQuantity()));
                    BigDecimal itemGstAmount = itemAmount.multiply(BigDecimal.valueOf(item.getGst()));
                    BigDecimal itemDiscountAmount = itemAmount.multiply(BigDecimal.valueOf(item.getDiscount()));
                    return itemAmount.add(itemGstAmount).subtract(itemDiscountAmount);
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}