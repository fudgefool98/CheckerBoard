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
    
    double width;
    double height;
    int rows;
    int columns;
    Color lightColor = Color.RED;
    Color darkColor = Color.BLACK;
    double rectWidth;
    double rectHeight;
    public AnchorPane anchorPane;
    
    public Board(int numRows, int numCols, double boardWidth, double boardHeight){
        this.rows = numRows;
        this.columns = numCols;
       
        anchorPane = new AnchorPane();
    }
    public Board(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this.rows = numRows;
        this.columns = numCols;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
       
        anchorPane = new AnchorPane();
    }
    
    public void build(double width, double height) {
        clear();
        this.width = width;
        this.height = height;
        rectWidth = Math.ceil(width / (double)columns);
        rectHeight = Math.ceil(height / (double)rows);       
        anchorPane.setPrefWidth(width);
        anchorPane.setPrefHeight(height);
        
        System.out.println(rectWidth +" "+ rectHeight);
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Rectangle rect = new Rectangle(rectWidth*row,rectHeight*col,rectWidth, rectHeight);                
                    if ( (col+row) % 2 == 0 ) {
                            rect.setFill(lightColor);
                        } 
                    else {
                            rect.setFill(darkColor);
                        }                                                   
                anchorPane.getChildren().add(rect);                
            }
        }      
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

