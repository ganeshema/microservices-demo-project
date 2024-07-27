package com.ganeshgc.userservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="users")
public class User {
    @Id
    @Column(name="USER_ID")
    private String userId;
    @Column(name = "NAME")
    private String userName;
    @Column(name="EMAIL")
    private String email;
    @Column(name="ABOUT")
    private String about;
    @Transient
    private List<Rating> ratings=new ArrayList<>();
}
