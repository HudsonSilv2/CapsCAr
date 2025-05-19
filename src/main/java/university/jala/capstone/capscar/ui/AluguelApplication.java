package university.jala.capstone.capscar.ui;
import dao.AluguelDAO;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Aluguel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AluguelApplication extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Aluguel de Veículos");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        ComboBox<String> filialCombo = new ComboBox<>();
        filialCombo.getItems().addAll("Filial A", "Filial B"); //Pre setadas, mas o objetivo é criar uma segunda tela para cadastrar filiais, encontra-se em model/Filial.class

        ComboBox<String> veiculoCombo = new ComboBox<>();
        veiculoCombo.getItems().addAll("HB20", "Onix", "Gol"); // Pre setadas, mas o objetivo é criar uma segunda tela para cadastrar los carros, cada um tem coisas unicas, está em model/Veiculo.class

        TextField clienteField = new TextField();
        TextField retiradaField = new TextField();
        retiradaField.setPromptText("dd-MM-yyyy");
        TextField devolucaoField = new TextField();
        devolucaoField.setPromptText("dd-MM-yyyy");

        Label statusLabel = new Label();

        Button confirmarBtn = new Button("Confirmar Aluguel");
        confirmarBtn.setOnAction(e -> {
            try {
                String filial = filialCombo.getValue();
                String veiculo = veiculoCombo.getValue();
                String cliente = clienteField.getText();


                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate retirada = LocalDate.parse(retiradaField.getText(), formatter);
                LocalDate devolucao = LocalDate.parse(devolucaoField.getText(), formatter);

                Aluguel aluguel = new Aluguel();
                aluguel.setFilial(filial);
                aluguel.setVeiculo(veiculo);
                aluguel.setCliente(cliente);
                aluguel.setRetirada(retirada);
                aluguel.setDevolucao(devolucao);

                AluguelDAO dao = new AluguelDAO();
                dao.inserir(aluguel);

                statusLabel.setText("Aluguel confirmado para " + cliente);
            } catch (Exception ex) {
                statusLabel.setText("Erro: " + ex.getMessage());
            }
        });

        //grade de localização, não foi feito por mim.
        grid.add(new Label("Filial:"), 0, 0);
        grid.add(filialCombo, 1, 0);
        grid.add(new Label("Veículo:"), 0, 1);
        grid.add(veiculoCombo, 1, 1);
        grid.add(new Label("Cliente:"), 0, 2);
        grid.add(clienteField, 1, 2);
        grid.add(new Label("Data Retirada:"), 0, 3);
        grid.add(retiradaField, 1, 3);
        grid.add(new Label("Data Devolução:"), 0, 4);
        grid.add(devolucaoField, 1, 4);
        grid.add(confirmarBtn, 1, 5);
        grid.add(statusLabel, 1, 6);

        Scene scene = new Scene(grid, 450, 350); //tamanho do meu executavel.
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
