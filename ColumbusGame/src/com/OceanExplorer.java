package com;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class OceanExplorer extends Application{
	final int dimesion = 10;
	final int scale = 50;
	Pane root;
	Image shipImage;
	ImageView shipImageView;
	Ship ship =new Ship();
	Scene scene;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	public void loadShipImage()
	{
		shipImage = new Image("file:ship.png", scale, scale, false, false);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getCurrentLocation().getX()*scale);
		shipImageView.setY(ship.getCurrentLocation().getY()*scale);		
		root.getChildren().add(shipImageView);
	}
	public void drawMap()
	{
		for(int i=0;i<dimesion;i++)
		{
			for(int j=0;j<dimesion;j++)
			{
				Rectangle rect = new Rectangle(i*scale,j*scale,scale,scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				root.getChildren().add(rect);
			}
		}
	}
	public void startSailing()
	{
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){ 
			@Override 
			public void handle(KeyEvent ke) { 
			switch(ke.getCode()){ 
			case RIGHT: 
			ship.goEast(); 
			break; 
			case LEFT: 
			ship.goWest(); 
			break; 
			case UP: 
			ship.goNorth(); 
			break; 
			case DOWN: 
			ship.goSouth(); 
			break; 
			default: 
			break; 
			}       
			shipImageView.setX(ship.getCurrentLocation().getX()*scale); 
			shipImageView.setY(ship.getCurrentLocation().getY()*scale); 
			} 
			});
	}
	@Override
	public void start(Stage oceanStage) throws Exception {
		// TODO Auto-generated method stub
		root = new AnchorPane();
		scene = new Scene(root,500,500);
		oceanStage.setScene(scene);
		oceanStage.setTitle("Ocean Game");
		oceanStage.show();
		drawMap();
		startSailing();
		OceanMap oceanMap = new OceanMap();
		boolean[][] oceanGrid = oceanMap.getOceanCell();			
		loadShipImage();
	}
}
