import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Box implements Node{
	List<Node>nodes=new ArrayList<>();
	Rectangle rectangle;
	@Override
	public void move(double X,double Y) {
		// TODO Auto-generated method stub
		rectangle.setX(rectangle.getX()+X);
		rectangle.setY(rectangle.getY()+Y);
		for(Node n:nodes)
			n.move(X,Y);
	}
	public Box(int x,int y, int length,int width)
	{
		rectangle = new Rectangle(x,y,length,width);
		rectangle.setStroke(Color.BLACK);
		rectangle.setFill(Color.LIGHTGREY);
	}
	public Rectangle getRectangle()
	{
		return rectangle;
	}
	public void addNode(Node node)
	{
		nodes.add(node);
	}
	public void printNodes()
	{
		for(Node n:nodes)
			System.out.println(n);
	}
}
