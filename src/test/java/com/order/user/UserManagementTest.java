//package com.order.user;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.util.Optional;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import monolith.ShopMonolithApplication;
//import monolith.user.dataaccess.api.UserEntity;
//import monolith.user.dataaccess.api.dao.UserDao;
//import monolith.user.logic.api.UserManagement;
//import monolith.user.logic.api.to.UserTO;
//import monolith.user.logic.impl.UserManagementImpl;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ShopMonolithApplication.class ,webEnvironment = WebEnvironment.RANDOM_PORT)
//public class UserManagementTest {
//
//	private static final long ID = 1;
//	
//	private UserManagement userManagement;
//	
//	@Before
//	public void init() {
//		userManagement = new UserManagementImpl();
//	}
//	
//	@Test
//	public void getByIdTest() {
//		// given
//		Optional<UserEntity> userEntity = Optional.of(mock(UserEntity.class));
//		
//		UserDao userDao = mock(UserDao.class);
//		
//		when(userDao.findById(ID)).thenReturn(userEntity);
//		
//		//when
//		UserTO userTO = userManagement.getById(ID);
//		
//		//then
//		assertThat(userTO).isNotNull();
//		assertThat(userTO).isEqualTo(userEntity.get());
//	}
//}
