package com.kpyvara.ec.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class OauthAccessToken {
    @Id
    @Column
    private String tokenId;
    private byte[] token;
    @Column
    private String authenticationId;
    @Column
    private String userName;
    @Column
    private String clientId;
    @Column
    private byte[] authentication;
    @Column
    private String refresh_token;

}

