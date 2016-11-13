package com.boot.service;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.boot.mapper.UserMapper;
import com.boot.model.User;
import com.boot.sqlmapper.*;
import com.boot.util.MyBatisUtil;

public class UserService
{

 public void insertUser(User user) {
  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
  try{
//  UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//  
//  userMapper.insertUser(user);
	  sqlSession.insert("Usermap.insertUser",user );
  sqlSession.commit();
  }
  catch (Exception e)
  {
	  e.printStackTrace();
  }
  finally{
   sqlSession.close();
  }
 }

 public User getUserById(Integer userId) {
  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
  try{
  UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
  return userMapper.getUserById(userId);
  }finally{
   sqlSession.close();
  }
 }

 public List<User> getAllUsers() {
  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
  try{
  UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
  return userMapper.getAllUsers();
  }finally{
   sqlSession.close();
  }
 }

 public void updateUser(User user) {
  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
  try{
  UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
  userMapper.updateUser(user);
  sqlSession.commit();
  }finally{
   sqlSession.close();
  }

 }

 public void deleteUser(Integer userId) {
  SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
  try{
  UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
  userMapper.deleteUser(userId);
  sqlSession.commit();
  }finally{
   sqlSession.close();
  }

 }

}