package com.config;

import java.util.TimeZone;

import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class StringTimezoneConfig 
{
  @PostConstruct
  public void timezoneConfig()
  {
    TimeZone.setDefault(TimeZone.getTimeZone("Amercia/Sao_Paulo"));
  }
}