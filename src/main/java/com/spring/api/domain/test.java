package com.spring.api.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Long id;
    @Column(name = "test_name")
    private String name;
    @ManyToOne
    private Major major;


    @Builder
    public test(String name, Major major) {
        this.name = name;
        this.major = major;
    }
}
