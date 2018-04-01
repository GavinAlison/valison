package com.alison.spring.ioc.autoconfig;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alison.spring.base.BaseJunitTest;

//使用junit4测试集成的spring
//@RunWith(SpringJUnit4ClassRunner.class)
// 加载配置文件
//
// @RunWith：用于指定junit运行环境，是junit提供给其他框架测试环境接口扩展， 为了便于使用spring的依赖注入，
// 	spring提供了org.springframework.test.context.junit4.SpringJUnit4ClassRunner作为Junit测试环境
// @ContextConfiguration({"classpath:applicationContext.xml",<br> 
//  "sclasspath:spring/buyer/applicationContext-service.xml"}) <br>
//	导入配置文件，这里我的applicationContext配置文件是根据模块来分类的。<br>
//  如果有多个模块就引入多个“applicationContext -service.xml” 文件。<br>
//  如果所有的都是写在“applicationContext。xml”中则这样导入：
// @ContextConfiguration(locations = "classpath:applicationContext.xml")
// @TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//	这里的事务关联到配置文件中的事务控制器 （transactionManager = "transactionManager" ），
//  同时指定自动回滚（defaultRollback =true）。 这样做操作的数据才不会污染数据库！
// @Transactional:这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！ 
//   AbstractTransactionalDataSourceSpringContextTests要想构建这一系列的无污染纯绿色事务
//   测试框架就必须找到这个基类！（即所有事务均不生效）
//
@Component
public class IOCTest extends BaseJunitTest {
	@Autowired
	private CDPlayer cd;

	// 注入失败， 原因是没有找到对应的配置文件， 注意claspath*:**.xml 字符的格式
	@Test
	public void test() {
		cd.method();
	}
}
