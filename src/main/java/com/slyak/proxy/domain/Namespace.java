package com.slyak.proxy.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * .
 *
 * @author stormning 2018/3/27
 * @since 1.3.0
 */
@Entity
@Table(name = "t_namespace", uniqueConstraints = {@UniqueConstraint(name = "key", columnNames = "key")})
@Data
public class Namespace {

    @Id
    @GeneratedValue
    private int id;

    private String key;

    private String description;


}
