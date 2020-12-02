package com.iot.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "USER_DATA")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserData {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_username")
    private String userUsername;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_creation_time")
    private LocalDateTime userCreationTime;


}

