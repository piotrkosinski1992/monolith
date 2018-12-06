package monolith.cart.common.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import monolith.cart.dataaccess.api.CartEntity;
import monolith.cart.dataaccess.api.CartItemEntity;
import monolith.cart.logic.api.to.CartItemTO;
import monolith.cart.logic.api.to.CartTO;

@Component
public final class Mapper {

	@Autowired
	private static ModelMapper modelMapper;
	
	
//	public static CartTO convertToCartTO(CartEntity cartEntity) {
//		
//		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.addMappings(new PropertyMap<CartEntity, CartTO>() {
//		  @Override
//		  protected void configure() {
//		    map().setId(source.getId());
//		  }
//		});
//		
//		CartTO mappedTO = modelMapper.map(cartEntity, CartTO.class);
//		
//		return mappedTO;
//	}
	

	public static CartItemEntity convertToCartItemEntity(CartItemTO cartItemTO) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<CartItemTO, CartItemEntity>() {
		  @Override
		  protected void configure() {
		    map().getProductEntity().setId(source.getProductTO().getId());
		    map().getProductEntity().setLongDescription(source.getProductTO().getLongDescription());
		    map().getProductEntity().setName(source.getProductTO().getName());
		    map().getProductEntity().setShortDescription(source.getProductTO().getShortDescription());
		  }
		});
		
		CartItemEntity mappedEntity = modelMapper.map(cartItemTO, CartItemEntity.class);
		
		
		return mappedEntity;
	}
	
	public static CartItemTO convertToCartItemTO(CartItemEntity cartItemEntity) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<CartItemEntity, CartItemTO>() {
		  @Override
		  protected void configure() {
		    map().getProductTO().setId(source.getProductEntity().getId());
		    map().getProductTO().setLongDescription(source.getProductEntity().getLongDescription());
		    map().getProductTO().setName(source.getProductEntity().getName());
		    map().getProductTO().setShortDescription(source.getProductEntity().getShortDescription());
		  }
		});
		
		CartItemTO mappedTO = modelMapper.map(cartItemEntity, CartItemTO.class);
		
		
		return mappedTO;
	}
	
	public static <A,B> B convertToEntity(A to,Class<B> targetClass) {
		modelMapper = new ModelMapper();
		
		B mappedEntity = modelMapper.map(to, targetClass);
	
		return mappedEntity;
	}
	
	public static <A,B> B convertToTO(A to,Class<B> targetClass) {
		modelMapper = new ModelMapper();
		B mappedEntity = modelMapper.map(to, targetClass);
	
		return mappedEntity;
	}
}
