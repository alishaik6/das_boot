package com.boot.util;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil 
{
 private static SqlSessionFactory factory;

 private MyBatisUtil() {
 }

 static
 {
  Reader reader = null;
  try {
   reader = Resources.getResourceAsReader("mybatis-config.xml");
   System.out.println("test");
  } catch (IOException e) {
   throw new RuntimeException(e.getMessage());
  }
  factory = new SqlSessionFactoryBuilder().build(reader);
  System.out.println("test");
 }

 public static SqlSessionFactory getSqlSessionFactory() 
 {
  return factory;
 }
}