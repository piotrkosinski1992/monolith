package monolith.cart.common.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import monolith.cart.dataaccess.api.CartEntity;
import monolith.user.dataaccess.api.UserEntity;
import monolith.user.logic.api.to.UserTO;

@Component
public final class Mapper {

	@Autowired
	private static ModelMapper mapper;
	
//	public static UserEntity convertToEntity(UserTO userTO) {
//		mapper = new ModelMapper();
//		UserEntity mappedEntity = mapper.map(userTO, UserEntity.class);
//		
//		
//		return mappedEntity;
//	}
	
	public static <A,B> B convertToEntity(A to,Class<B> targetClass) {
		mapper = new ModelMapper();
		B mappedEntity = mapper.map(to, targetClass);
	
		return mappedEntity;
	}
	
	public static <A,B> B convertToTO(A to,Class<B> targetClass) {
		mapper = new ModelMapper();
		B mappedEntity = mapper.map(to, targetClass);
	
		return mappedEntity;
	}
}
