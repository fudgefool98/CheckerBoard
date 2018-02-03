/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Jordan
 */
public class CheckerBoardController implements Initializable, Startable {
    
   public Stage stage;
    
    private int numRows = 8;
    private int numCols = 8;
    protected Color lightColor;
    protected Color darkColor;
    
         
    @FXML
    VBox vBox = new VBox();
    public Board board;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    } 
    
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        
        board = new Board(numRows,numCols,stage.getWidth(),stage.getHeight());

        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        };
        this.stage.heightProperty().addListener(lambdaChangeListener);
        this.stage.widthProperty().addListener(lambdaChangeListener);
        
        refresh();       
    }

    @FXML
    private void handle16(ActionEvent event) {
        board.numRows = 16;
        board.numColumns = 16;
        numRows = 16;
        numCols = 16;
        refresh();
    }
    
    @FXML
    private void handle10(ActionEvent event) {
        board.numRows = 10;
        board.numColumns = 10;
        numRows = 10;
        numCols = 10;
        refresh();
    }
    
    @FXML
    private void handle8(ActionEvent event) {
        board.numRows = 8;
        board.numColumns = 8;
        numRows = 8;
        numCols = 8;
        refresh();    
    }
    
    @FXML
    private void handle3(ActionEvent event) {
        board.numRows = 3;
        board.numColumns = 3;
        numRows = 3;
        numCols = 3;
        refresh();    
    }
    @FXML
    private void handleDefault(ActionEvent event) {
        board = new Board(numRows, numCols, stage.getWidth(), stage.getHeight(), Color.RED, Color.BLACK);        
        refresh();
    }
    
    @FXML
    private void handleBlue(ActionEvent event) {
        board = new Board(numRows, numCols, stage.getWidth(), stage.getHeight(), Color.SKYBLUE, Color.DARKBLUE);        
        refresh();
    }
    
    private void refresh() {
        vBox.getChildren().remove(1);
        
        System.out.println("width = "+ stage.getWidth() +  " height = "+ stage.getHeight());
        vBox.getChildren().add(board.build());
        
        // vbox.getchildren.add(anchorPane)
        //remove existing anchorpane and replace with new each time.
    }    
}
