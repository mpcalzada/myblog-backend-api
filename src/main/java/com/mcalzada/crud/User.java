package com.mcalzada.crud;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * {@link User}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */
@Data
@Entity
public class User
{
    private @Id @GeneratedValue Long id;
    private String name;
    private String role;

    public User(String name, String role)
    {
        this.name = name;
        this.role = role;
    }
}
