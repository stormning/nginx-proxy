package com.slyak.proxy.repo;

import com.slyak.proxy.domain.Namespace;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * .
 *
 * @author stormning 2018/3/27
 * @since 1.3.0
 */
public interface NamespaceRepository extends JpaRepository<Namespace, Integer> {
}
