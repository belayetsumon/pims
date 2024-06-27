/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springboot/CfgProperties.java to edit this template
 */
package itgarden.config;

import org.springframework.cache.annotation.*;
import org.springframework.context.annotation.*;

/**
 *
 * @author Admin
 */
@Configuration
@EnableCaching
public class CacheConfig {
    
    
    
//   @Bean
//  public CacheManager cacheManager() {
//    ConcurrentMapCacheManager mgr = new ConcurrentMapCacheManager();
//    mgr.setCacheNames(asList("employees"));
//    return mgr;
//  }
}
