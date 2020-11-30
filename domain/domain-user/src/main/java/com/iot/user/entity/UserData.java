package com.iot.user.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "USER_DATA")
@Entity
@Builder
@Data
public class UserData {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    Long userId;
    @Column(name = "user_name")
    String userName;
    @Column(name = "user_username")
    String userUsername;
    @Column(name = "user_password")
    String userPassword;
    @Column(name = "user_creation_time")
    LocalDateTime userCreationTime;

}

