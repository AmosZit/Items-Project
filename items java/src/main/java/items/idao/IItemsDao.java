package items.idao;

import org.springframework.data.repository.CrudRepository;

import items.bean.Items;

public interface IItemsDao extends CrudRepository<Items, Long> {

}