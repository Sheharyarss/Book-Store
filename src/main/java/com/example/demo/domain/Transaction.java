package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double amount;
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID uniqueId;
    private String type;
    private LocalDateTime dateTime;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "account_id")
    private Account account;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "transactions",cascade = {CascadeType.ALL})
//    private Set<Account> accounts=new HashSet<>();
//    @OneToMany(mappedBy="transaction")
//    private Set<Record> records;

}
