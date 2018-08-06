package com.ice.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ice.bean.Department;
import com.ice.bean.Employee;
import com.ice.dao.DepartmentMapper;
import com.ice.dao.EmployeeMapper;

/**
 * 测试dao层 mapper文件是否通
 * @author 雪糕
 * 推荐spring项目使用 spring单元测试  自动注入需要的组件
 * 导入SpringTest的模块
 * @ContextConfiguration 指定spring 配置文件的位置 自动创建ioc容器
 * 直接autowired 要使用的组件即可
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
     @Autowired  
	 DepartmentMapper departmentMapper;
     @Autowired
     EmployeeMapper employeeMapper;
     @Autowired
     SqlSession sqlSession;
     private static Logger log =LoggerFactory.getLogger(MapperTest.class);
	
	@Test
	public void testCRUD(){
		
           System.out.println(departmentMapper);
           //插入几个部门         
//           departmentMapper.insertSelective(new Department(null,"开发部"));
//           departmentMapper.insertSelective(new Department(null,"测试部"));
           
           
           //插入几个员工
//           employeeMapper.insertSelective(new Employee(null, "雪糕", "M", "kiritovo@163.com", 1));
//           employeeMapper.insertSelective(new Employee(null, "三三", "F", "loveice@163.com", 2));
           
           
           //批量插入  使用可以执行批量操作的sqlSession 
          /* for(){
        	   employeeMapper.insertSelective(new Employee(null, xxx, "M", "kiritovo@163.com", 1));
           }
         */
           
           //在applicationContext 配置sqlsession 才能进行如下批量
         /* EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
           for(int i=0 ;i<20; i++){
        	    String uuid =UUID.randomUUID().toString().substring(0, 5);
        	    mapper.insertSelective(new Employee(null,uuid,"M",uuid+"@xuegao.com",1));
           } */
           
           employeeMapper.deleteByPrimaryKey(5);         log.info("删除完");
	}
	      
}
