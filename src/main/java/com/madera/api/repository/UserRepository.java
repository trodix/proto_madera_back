package com.madera.api.repository;

import com.madera.api.models.User;
import com.madera.api.models.UserAuth;
import com.madera.api.security.SecurityUser;
import com.madera.api.utils.Helper;

import org.jooq.DSLContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.madera.jooq.Tables.ROLE;
import static com.madera.jooq.Tables.UTILISATEUR;

/**
 * Repository User
 *
 * @author LADOUCE Fabien, CHEVALLIER Romain, HELIOT David
 * @version 0.2-PRE-RELEASE
 */
@Repository
public class UserRepository {

    @Autowired
    DSLContext context;

    public User checkUser(UserAuth user) {
        return context.select(UTILISATEUR.fields()).from(UTILISATEUR)
                .where(UTILISATEUR.V_LOGIN.eq(user.getLogin()).and(UTILISATEUR.V_PASSWORD.eq(user.getPassword())))
                .fetchOne(Helper::recordToUser);
    }

    public void insertToken(UserAuth user, String token) {
        context.update(UTILISATEUR).set(UTILISATEUR.V_TOKEN, token).where(UTILISATEUR.V_LOGIN.eq(user.getLogin()))
                .execute();
    }

    public SecurityUser verifyTokenAndRole(DSLContext context, String token) {
        // Vérifie si le token reçu est le même en base de données
        return context.select(UTILISATEUR.V_LOGIN, ROLE.V_LIBELLE_ROLE).from(UTILISATEUR).join(ROLE)
                .on(ROLE.I_ROLE_ID.eq(UTILISATEUR.I_ROLE_ID)).where(UTILISATEUR.V_TOKEN.like(token))
                // .and(UTILISATEUR.I_ROLE_ID.notEqual(3)) TODO: trier les roles dans
                // AuthentificationFilter
                .fetchOne(Helper::recordToSecurityUser);
    }

    public int deleteToken(String login) {
        return context.update(UTILISATEUR).setNull(UTILISATEUR.V_TOKEN).where(UTILISATEUR.V_LOGIN.eq(login)).execute();
    }
}
