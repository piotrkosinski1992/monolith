package monolith.inventory.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class InventoryItemEntity {

	@Id
	@GeneratedValue
	private Long id;

	public InventoryItemEntity() {
	}
	
}
