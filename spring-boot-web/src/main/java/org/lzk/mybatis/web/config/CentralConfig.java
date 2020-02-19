package org.lzk.mybatis.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: lzk
 * @version:
 * @date:2020/2/15 15:27
 * @description:
 */
@Configuration
@Import({WebSocketConfig.class})
public class CentralConfig {
}
