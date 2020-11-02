package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class SellerService {

	// Dependencia e injeção de dependencia para o meu DAO
	private SellerDao dao = DaoFactory.createSellerDao();
	
	public List<Seller> findAll() {
		
/*		//MOCK - trazer os dados de mentirinha
		List<Seller> list = new ArrayList<>();
		list.add(new Seller(1, "Books"));
		list.add(new Seller(2, "Computers"));
		list.add(new Seller(3, "Eletronics"));
		return list; */

		//Agora estamos acessando diretamente o banco de dados
		return dao.findAll();

	}
	
	public void saveOrUpdate(Seller obj) {
		if (obj.getId() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
	
	public void remove(Seller obj) {
		dao.deleteById(obj.getId());
	}
}
