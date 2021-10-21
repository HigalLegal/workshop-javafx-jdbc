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
	private TableView<Department> tableViewDepartments;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Department, String> tableColumnName;
	
	@FXML
	private Button btNew;
	
	private ObservableList<Department> obsList;
	
	@FXML
	public void onBtNewAction() {
		System.out.println("Botão clicado.");
	}
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializableNodes();
		
	}

	private void initializableNodes() {
		
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
		
		//nas 2 linhas abaixo é feito um macete pra tabela acompanhar a altura da janela.
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartments.prefHeightProperty().bind(stage.heightProperty());
		
	}
	
	public void upadateTableView() {
		if(service == null) {
			throw new IllegalStateException("Service was null");
		}
		
		List<Department> list = service.findAll();
		
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartments.setItems(obsList);
		
	}

}

















