import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GardenLayout extends Application{
	Pane root;
	Scene scene;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		root = new AnchorPane();
		scene = new Scene(root,800,800);
		root.setStyle("-fx-background-color: green;");
		stage.setScene(scene);
		stage.setTitle("Garden Layout");
		stage.show();
		Flower flower = new Flower(Color.RED,new Point2D(400,400),false);
		root.getChildren().add(flower.getCircle());
		Box garden = new Box(500,500,100,200);
		root.getChildren().add(garden.getRectangle());
		EventHandler eventHandler = new EventHandler<MouseEvent>()
		{			
			@Override
			public void handle(MouseEvent mouseEvent) {
				// TODO Auto-generated method stub
			Point2D clickPoint = new Point2D(mouseEvent.getX(),mouseEvent.getY());
			String eventName = mouseEvent.getEventType().getName();
			switch(eventName)
			{
			case("MOUSE_DRAGGED"):
				if(flower.getCircle()!=null
				&&flower.getCircle().contains(clickPoint)
				)
				{
					double delataX = clickPoint.getX()-flower.getCircle().getCenterX();
					double delataY = clickPoint.getY()-flower.getCircle().getCenterY();
					flower.move(delataX,delataY);
					
				}
				else if(garden.getRectangle()!=null&&garden.getRectangle().contains(clickPoint))
				{
					double delataX = clickPoint.getX()-(garden.getRectangle().getX()+(garden.getRectangle().getWidth()/2));
					double delataY = clickPoint.getY()-(garden.getRectangle().getY()+(garden.getRectangle().getHeight()/2));
					garden.move(delataX,delataY);
				}
			break;
			case("MOUSE_RELEASED"):	
//				System.out.println("Mouse Released");
				if(flower.getCircle().contains(clickPoint)&&garden.getRectangle().contains(clickPoint))
				{
					garden.addNode(flower);
//					garden.printNodes();
				}
				break;
			}			
			}			
		};
		scene.setOnMouseDragged(eventHandler);
		scene.setOnMouseReleased(eventHandler);
		scene.setOnMousePressed(eventHandler);
	}

}
