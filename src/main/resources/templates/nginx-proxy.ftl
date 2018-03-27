<#-- @ftlvariable name="proxyPass" type="java.util.List<com.slyak.proxy.domain.ProxyPass>" -->
<!--http://sudhaker.com/60/caching-yum-proxy-->
server {
    listen 3128;
    root /www/html/repo;

    location / {
        autoindex on;
        root               /www/html/repo/$host;
        error_page         404 = @fetch_proxy;
    }

    location @fetch_proxy {
        internal;
        <#--resolver           192.168.1.1;-->
        proxy_pass         http://$host$uri;
        root               /www/html/repo/$host;
        proxy_store        on;
        proxy_store_access user:rw group:rw all:r;
        proxy_ignore_client_abort on;
    }
}

server {
    listen       80;
    server_name  ${serverName};
    root /www/html/repo;

    location / {
        autoindex on;
    }

    <#list proxyPass as pp>
    location ${pp.getContextPath} {
        autoindex on;
        proxy_pass http://127.0.0.1:3128/;
        proxy_set_header Host ${pp.host};
    }
    </#list>
}