package org.lzk.memcache.config;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

@Configuration
public class MemcachedBuilder {
    protected static Logger logger =  LoggerFactory.getLogger(MemcachedBuilder.class);
    @Resource
    private XMemcachedProperties xMemcachedProperties;

    @Component
    @ConfigurationProperties(prefix = "memcached")
    public class XMemcachedProperties {
        private String servers;
        private int poolSize;
        private long opTimeout;

        public String getServers() {
            return servers;
        }

        public void setServers(String servers) {
            this.servers = servers;
        }

        public int getPoolSize() {
            return poolSize;
        }

        public void setPoolSize(int poolSize) {
            this.poolSize = poolSize;
        }

        public long getOpTimeout() {
            return opTimeout;
        }

        public void setOpTimeout(long opTimeout) {
            this.opTimeout = opTimeout;
        }
    }

    @Bean
    public MemcachedClient getMemcachedClient() {
        MemcachedClient memcachedClient = null;
        try {
            MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(xMemcachedProperties.getServers()));
            builder.setConnectionPoolSize(xMemcachedProperties.getPoolSize());
            builder.setOpTimeout(xMemcachedProperties.getOpTimeout());
            memcachedClient = builder.build();
        } catch (IOException e) {
            logger.error("inint MemcachedClient failed ",e);
        }
        return memcachedClient;
    }
}