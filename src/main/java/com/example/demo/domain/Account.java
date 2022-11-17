package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double balance;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="player_id",referencedColumnName = "id")
    private Player player;
    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
     @JsonIgnore
    private List<Transaction> transactions;


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "record",joinColumns = {
//            @JoinColumn(name = "acc_id",referencedColumnName = "id")},
//            inverseJoinColumns ={
//                    @JoinColumn(name = "trans_id",referencedColumnName = "id")
//            })
//    private Set<Transaction> transactions = new HashSet<>();
//    @OneToMany(mappedBy="account",cascade = CascadeType.ALL)
//    private Set<Record> records;

}
