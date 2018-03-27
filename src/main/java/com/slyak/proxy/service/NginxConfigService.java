package com.slyak.proxy.service;

import com.slyak.proxy.domain.Namespace;
import com.slyak.proxy.repo.NamespaceRepository;
import com.slyak.proxy.repo.ProxyPassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * .
 *
 * @author stormning 2018/3/27
 * @since 1.3.0
 */
@Service
public class NginxConfigService {
    @Autowired
    private NamespaceRepository namespaceRepository;

    @Autowired
    private ProxyPassRepository proxyPassRepository;

    public Page<Namespace> queryNamespaces(Namespace namespace, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Namespace> person = Example.of(namespace, matcher);
        return namespaceRepository.findAll(person, pageable);
    }
}