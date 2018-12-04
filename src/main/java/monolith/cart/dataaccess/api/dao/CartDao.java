package monolith.cart.dataaccess.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import monolith.cart.dataaccess.api.CartEntity;

public interface CartDao extends JpaRepository<CartEntity, Long> {

}
