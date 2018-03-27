package com.slyak.proxy.web;

import com.slyak.proxy.domain.Namespace;
import com.slyak.proxy.service.NginxConfigService;
import com.slyak.support.freemarker.FmUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * .
 *
 * @author stormning 2018/3/26
 * @since 1.3.0
 */
@Controller
public class NginxConfigController {

    @Autowired
    private NginxConfigService configService;


    @GetMapping("/namespaces")
    public void namespaces(Namespace namespace, Pageable pageable, ModelMap modelMap) {
        modelMap.put("page", configService.queryNamespaces(namespace, pageable));
    }

    @GetMapping("/namespaces/{}")
    public void namespace(Namespace namespace, Pageable pageable, ModelMap modelMap) {


        modelMap.put("page", configService.queryNamespaces(namespace, pageable));
    }


    @GetMapping("/{namespace}.conf")
    @ResponseBody
    public String index(ModelMap modelMap) {
        return FmUtils.renderTpl("nginx-proxy.ftl", null);
    }
}