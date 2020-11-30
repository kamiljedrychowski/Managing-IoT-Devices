package com.iot.user.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ROLE")
@Data
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    Long roleId;
    @Column(name = "role_name")
    String roleName;
    @Column(name = "role_creation_time")
    LocalDateTime roleCreationTime;

}