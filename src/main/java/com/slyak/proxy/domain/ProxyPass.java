package com.slyak.proxy.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * .
 *
 * @author stormning 2018/3/26
 * @since 1.3.0
 */
@Entity
@Table(name = "t_proxy_pass", uniqueConstraints = {@UniqueConstraint(name = "ns-ctx", columnNames = {"ctx", "nsId"})})
@Data
public class ProxyPass {

    @Id
    @GeneratedValue
    private int id;

    private String ctx;

    private String host;

    private int nsId;
}