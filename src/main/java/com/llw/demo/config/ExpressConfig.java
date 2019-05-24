package com.llw.demo.config;

import com.happy.express.sql.ExpressSql;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: express配置
 * @author: llw
 * @date: 2019-05-09
 */
@Configuration
public class ExpressConfig {

    /**引入express sql*/
    @Bean
    public ExpressSql expressSqlStarter() {
        return ExpressSql.startup("com.llw.demo.entity", true, false);
    }

}
