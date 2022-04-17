
package com.tienda;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration

public class webConfig implements WebMvcConfigurer{
    
    @Bean
    public LocaleResolver localResolver (){
      var slr = new SessionLocaleResolver(){
          slr.setDeafultLocale(new Locale("es"));
          return slr;
          
      }  
    
      @Bean    
   public LocaleChangeInterceptor localeChanceInterceptor(){
       var lci = new LocaleChangeInterceptor();
       lci.setParamName("lang");
       return lci;
       
   }
              
       @Override
public void addInterceptors(InterceptorRegistry registro){
    registro.addInterceptor(localeChanceInterceptor());
}       
}
