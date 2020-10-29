package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {

	private DepartmentService service;
	
	@FXML
	private TableView<Department> tableViewDepartment; //Criando as referências para meus objetos
	
	@FXML
	private TableColumn<Department, Integer> tableColumnId; //Criando as referências para meus objetos
	
	@FXML
	private TableColumn<Department, String> tableColumnName; //Criando as referências para meus objetos
	
	@FXML
	private Button btNew; //Criando as referências para meus objetos
	
	private ObservableList<Department> obsList;
	
	@FXML
	public void onBtNewAction() {  //Método do tratamento de eventos do click desse botão
		System.out.println("onBtNewAction");
	}
	
	public void setDepartmentService(DepartmentService service) { //método set para evitar fazer acoplamento forte
		this.service = service;	  								  // Dessa forma injetamos dependencia por outro lugar
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();  //Método auxiliar para iniciar meus controles
	}

	private void initializeNodes() {
		//comando para iniciar apropriadamente o comportamento das minhas colunas da minha tabela
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		//Massete para fazer minha tableView acompanhar a minha janela
		Stage stage = (Stage) Main.getMainScene().getWindow(); //Pegando a referencia da minha janela e fazendo o downcasting para Stage
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}
	
	public void updateTableView() { 
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Department> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartment.setItems(obsList);
	}
}
