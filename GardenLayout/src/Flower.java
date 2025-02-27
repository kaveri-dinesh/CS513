import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Flower implements Node{
	public Circle circle;
	@Override
	public void move(double X,double Y) {
		// TODO Auto-generated method stub
		circle.setCenterX(circle.getCenterX()+X);
		circle.setCenterY(circle.getCenterY()+Y);
	}
	public Flower(Color color, Point2D point, boolean moveable)
	{
		circle = new Circle();
		circle.setCenterX(point.getX());
		circle.setCenterY(point.getY());
		circle.setFill(color);
		circle.setRadius(10);
		circle.setStroke(Color.BLACK);
		circle.setStrokeWidth(2);
	}
	public Circle getCircle()
	{
		return this.circle;
	}
	
}
