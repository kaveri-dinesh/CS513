package com;

import javafx.scene.effect.Light.Point;

public class Ship {
	Point currentLocation;
	public Ship()
	{
		this.currentLocation=new Point();
		currentLocation.setX(4);
		currentLocation.setY(7);
	}
	public Point getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(Point currentLocation) {
		this.currentLocation = currentLocation;
	}
	public void goEast()
	{
		if(currentLocation.getX()+1<10&&currentLocation.getX()+1>=0)
			currentLocation.setX(currentLocation.getX()+1);
	}
	public void goWest()
	{
		if(currentLocation.getX()-1<10&&currentLocation.getX()-1>=0)
			currentLocation.setX(currentLocation.getX()-1);
	}
	public void goNorth()
	{
		if(currentLocation.getY()-1<10&&currentLocation.getY()-1>=0)
			currentLocation.setY(currentLocation.getY()-1);
	}
	public void goSouth()
	{
		if(currentLocation.getY()+1<10&&currentLocation.getY()+1>=0)
			currentLocation.setY(currentLocation.getY()+1);
	}
}
