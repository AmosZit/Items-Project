package items.idao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import items.bean.Quantity;

@Repository
public interface IQuantityDao extends CrudRepository<Quantity, Long> {


}