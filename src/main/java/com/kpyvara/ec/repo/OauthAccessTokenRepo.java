package com.kpyvara.ec.repo;


import com.kpyvara.ec.model.OauthAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthAccessTokenRepo extends JpaRepository<OauthAccessToken, String> {
}
