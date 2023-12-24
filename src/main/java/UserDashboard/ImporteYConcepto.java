package UserDashboard;

import javafx.scene.layout.Pane;

public class ImporteYConcepto {

    private Pane mainLayoutImporte;

    public ImporteYConcepto(){

        setupUI();
    }

    private void setupUI(){

        mainLayoutImporte = new Pane();
        mainLayoutImporte.setId("PanelImporte");
        mainLayoutImporte.getChildren().addAll(importe(),concepto());
        mainLayoutImporte.setLayoutX(0);
        mainLayoutImporte.setLayoutY(0);
    }

    private Pane importe(){
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #ab2222;");
        pane.setLayoutX(0);
        pane.setLayoutY(0);
        pane.setPrefSize(328, 100);
        pane.setId("Importe");
        return pane;
    }

    private Pane concepto(){
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #182785;");
        pane.setLayoutX(0);
        pane.setLayoutY(100);
        pane.setPrefSize(328, 100);
        pane.setId("Concepto");
        return pane;
    }

    public Pane getRoot(){
        return mainLayoutImporte;
    }

}
