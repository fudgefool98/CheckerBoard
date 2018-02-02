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
import javafx.scene.layout.AnchorPane;
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
    AnchorPane anchorPane;
       
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
        numRows = 16;
        numCols = 16;
        refresh();
    }
    
    @FXML
    private void handle10(ActionEvent event) {
        numRows = 10;
        numCols = 10;
        refresh();
    }
    
    @FXML
    private void handle8(ActionEvent event) {
        numRows = 8;
        numCols = 8;
        refresh();    
    }
    
    @FXML
    private void handle3(ActionEvent event) {
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
        board.build(stage.getWidth(),stage.getHeight());
        anchorPane = board.getBoard();
    }    
}
