package com.ec.entity;

import javax.persistence.*;

@Entity
@Table(name = "bonus")
public class Prize
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long customerId;

    private int prize;

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }
}

