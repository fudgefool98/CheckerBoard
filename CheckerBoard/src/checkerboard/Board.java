/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author Jordan
 */
public class Board {
    private double width;
    private double height;
    int numRows;
    int numColumns;
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    double rectWidth;
    double rectHeight;
    private AnchorPane anchorPane;
    
    public Board(int numRows, int numCols, double boardWidth, double boardHeight){
        this.numRows = numRows;
        this.numColumns = numCols;
        
        this.width = boardWidth;
        this.height = boardHeight;
        anchorPane = new AnchorPane();
    }
    public Board(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this.numRows = numRows;
        this.numColumns = numCols;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
       
        anchorPane = new AnchorPane();
    }
    
    public AnchorPane build() {
        clear();
        anchorPane.setPrefWidth(width);
        anchorPane.setPrefHeight(height);
        rectWidth = Math.ceil(anchorPane.getWidth() / (double)numColumns);
        rectHeight = Math.ceil(anchorPane.getHeight() / (double)numRows);       
        
              
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                Rectangle rect = new Rectangle((double)numColumns*rectWidth,(double)numRows*rectHeight,rectWidth, rectHeight);                
                    if ( (col+row) % 2 == 0 ) {
                            rect.setFill(lightColor);
                        } 
                    else {
                            rect.setFill(darkColor);
                        }                                                   
                anchorPane.getChildren().add(rect);                
            }
        }  
        return anchorPane;
    }
    
    public void clear() {
        if (anchorPane != null) {
            anchorPane.getChildren().clear();
        }
    }
    
    public AnchorPane getBoard() {
        return anchorPane;
    }
    
}

