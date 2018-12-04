package monolith.inventory.dataaccess.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import monolith.inventory.dataaccess.api.InventoryItemEntity;

public interface InventoryDao extends JpaRepository<InventoryItemEntity, Long> {

}
