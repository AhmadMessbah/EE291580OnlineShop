package com.mftplus.javaee04.model.entity;

import com.mftplus.javaee04.model.entity.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity(name = "userEntity")
@Table(name = "user_tbl")

@NamedQueries({
        @NamedQuery(name = "User.FindByUsername",
                query = "select oo from userEntity oo where oo.username=:username"),
        @NamedQuery(name = "User.FindByUsernameAndPassword",
                query = "select oo from userEntity oo where oo.username=:username and password=:password")
})
public class User {
    @Id
    @Column(name = "u_username", length = 20)
    private String username;

    @Column(name = "u_name", length = 20)
    @Pattern(regexp = "^[a-zA-Z\\s]{2,20}$", message = "Name is Not Valid")
    private String name;

    @Column(name = "u_family", length = 20)
    private String family;

    @Column(name = "u_password", length = 20)
    private String password;

    @Enumerated
    private UserRole role;
}