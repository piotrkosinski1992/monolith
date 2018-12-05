package monolith.product.dataaccess.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import monolith.product.dataaccess.api.ProductEntity;

public interface ProductDao extends JpaRepository<ProductEntity, Long> {

}
