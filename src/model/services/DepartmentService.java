package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {

	// Dependencia e injeção de dependencia para o meu DAO
	private DepartmentDao dao = DaoFactory.createDepartmentDao();
	
	public List<Department> findAll() {

		//Agora estamos acessando diretamente o banco de dados
		return dao.findAll();
		
/*		//MOCK - trazer os dados de mentirinha
		List<Department> list = new ArrayList<>();
		list.add(new Department(1, "Books"));
		list.add(new Department(2, "Computers"));
		list.add(new Department(3, "Eletronics"));
		return list; */
	}
}
