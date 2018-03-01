package io;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;


public abstract class Win {
    //todo: restrict Input dialogs to Win (if open)
    //todo: add centered text
    //todo: Polygon
    //todo: Button
    //todo: Groups (like id)  .group("alien");

    //abstract pane so it can be used in other applications

    //todo: hit area? invisible circle?

    //todo: Map.getImage(Location loc)
    //todo: Map.getDistance(Location loc)

    //todo: StageStyle.TRANSPARENT

    //todo: Translate.text("hello")   ?
    //todo: Weather.temp(Location loc)

    //todo: custom Exceptions for files and id duplicate attempts

    //todo: background image
    //todo: background texture image

    //todo: Sound.tts("hello wolrd")   - text to speech

    //todo: remove code warnings in IDE

    //todo: itemable platorm() gravity()

    //todo: output dialog with image
    //todo: output dialog buffer then display (so can show images and text)?  or daisy chain?

    //todo: use angles from math classes

    //todo: drag

    //todo: Data class (gets a json or xml feed)

    //if method is set an id instead of a constructor

    //todo: sound - play notes?  make music assignment

    //todo: setFps(int number)

    //todo: x() and y() methods

    //todo: auto trim transparent images

    //todo:  Live Connect  (abstract json services)

    //todo: next year - set fill and stroke seperately for window (not in constructors)

    //todo: increaseSpeed, decreaseSpeed

    //todo: sound
    //todo: random direction between angles
    //todo: collisions
    //todo: more keyhandlers
    //todo: grow() & shrink()


    private static Stage stage;
    private static Scene scene;
    private static BorderPane borderPane;
    private static AnchorPane anchorPane;
    private static EventHandler<KeyEvent> leftKeyHander;
    private static EventHandler<KeyEvent> rightKeyHander;
    private static EventHandler<KeyEvent> downKeyHander;
    private static EventHandler<KeyEvent> upKeyHander;
    private static EventHandler<KeyEvent> spaceKeyHander;
    private static EventHandler<KeyEvent> letterKeyHander;
    private static Timeline timeline;

    public static final int FPS = 24;
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 400;
    private static final double DEFAULT_FONT_SIZE = 18;
    private static final String DEFAULT_FONT_NAME = "Arial";
    private static final Color DEFAULT_TEXT_COLOR = Color.BLACK;
    private static final Color DEFAULT_FILL = Color.BLACK;
    private static final Color DEFAULT_STROKE = Color.BLACK;
    private static final double DEFAULT_STROKE_WIDTH = 0.5;
    private static final String DEFAULT_TITLE = "Application";

    private static String fontName = DEFAULT_FONT_NAME;
    private static double fontSize = DEFAULT_FONT_SIZE;
    private static Color fontColor = DEFAULT_TEXT_COLOR;

    private static Color fill = DEFAULT_FILL;
    private static Color stroke = DEFAULT_STROKE;
    private static double strokeWidth = DEFAULT_STROKE_WIDTH;

    private static double initialWidth;

    private static Map<String, Item> idMap = new HashMap<String, Item>();
    private static ItemGroup circles = new ItemGroup("javafx.scene.shape.Circle");
    private static ItemGroup rectangles = new ItemGroup("javafx.scene.shape.Rectangle");
    private static ItemGroup texts = new ItemGroup("javafx.scene.text.Text");
    private static ItemGroup images = new ItemGroup("javafx.scene.image.ImageView");
    private static ItemGroup all = new ItemGroup();


    private static Item registerNode(Node node) {
        Item item = new Item(node);

       // System.out.println("Registering .... " + node.getClass().getName());

        if (node instanceof Circle) {
            circles.add(item);
        } else if (node instanceof Rectangle) {
            rectangles.add(item);
        } else if (node instanceof Text) {
            texts.add(item);
        } else if (node instanceof ImageView) {
            images.add(item);
        }

        all.add(item);
        node.setUserData(item);

        anchorPane.getChildren().add(node);

        return item;
    }

    static Stage stage() {
        return stage;
    }

    public static void open(String title, int width, int height) {
        initialize(title, width, height);

        stage.show();
    }

    public static void open() {
        open(DEFAULT_TITLE);
    }

    public static void open(int width, int height) {
        open(DEFAULT_TITLE, width, height);
    }

    public static void open(String title) {
        Screen screen = Screen.getPrimary();

        Rectangle2D bounds = screen.getVisualBounds();

        if (stage == null) {
            stage = new Stage();
        }

        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());

      //  System.out.println(bounds.getWidth());

        open(title, (int) bounds.getWidth(), (int) bounds.getHeight());
    }

    private static void initialize() {
        if (stage == null) {
            initialize(DEFAULT_TITLE, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }

    private static void initialize(String title, int width, int height) {
        if (stage == null) {
            stage = new Stage();
        }

        initialWidth = width;

        stage.setTitle(title);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setResizable(false);
        stage.initStyle(StageStyle.DECORATED);

       // stage.setAlwaysOnTop(true);

        anchorPane = new AnchorPane();

        anchorPane.setClip(new Rectangle(0,0, width, height));
        anchorPane.setUserData(new Rectangle2D(0,0,width,height));
        anchorPane.setMaxWidth(width);
        anchorPane.setMaxHeight(height);

        //anchorPane.setStyle("-fx-background-color: crimson");
        borderPane = new BorderPane(anchorPane);

        scene = new Scene(borderPane);
        scene.setOnKeyPressed(e -> {
            keyPressed(e);
        });

        stage.setScene(scene);

        double duration = Math.round(1000 / FPS);

        timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(new Duration(duration), e -> tick()));
        timeline.play();
    }

    public static double width() {
        return stage.getWidth();
       // return ((Rectangle2D)anchorPane.getUserData()).getWidth();
    }

    public static double height() {
        return ((Rectangle2D)anchorPane.getUserData()).getHeight();
    }



    public static void fill(Color color) {
        fill = color;
    }

    public static void stroke(Color color) {
        stroke = color;
    }

    public static void stroke(Color color, double width) {
        stroke = color;
        strokeWidth = width;
    }

    public static void stroke(double width) {
        strokeWidth = width;
    }


    public static void font(String name, double size, Color color) {
        fontName = name;
        fontSize = size;
        fontColor = color;
    }

    public static void font(double size, Color color) {
        fontSize = size;
        fontColor = color;
    }

    public static void font(String name, Color color) {
        fontName = name;
        fontColor = color;
    }


    public static void font(Color color) {
        fontColor = color;
    }

    public static void font(String name, double size) {
        fontName = name;
        fontSize = size;
    }

    public static void font(double size) {
        fontSize = size;
    }

    public static void font(String name) {
        fontName = name;
    }

    private static void tick() {
        for (int i = 0; i < anchorPane.getChildren().size(); i++) {
            Node node = anchorPane.getChildren().get(i);

            if (node.getUserData() != null) {
                Item item = (Item)node.getUserData();
                item.tick();
            }
        }
        Sound.tick();
    }


    private static void keyPressed(KeyEvent e) {

        if (leftKeyHander != null && e.getCode() == KeyCode.LEFT) {
          //  System.out.println(e.getCode());
            leftKeyHander.handle(e);
        } else if (rightKeyHander != null && e.getCode() == KeyCode.RIGHT) {
        //    System.out.println(e.getCode());
            rightKeyHander.handle(e);
        } else if (downKeyHander != null && e.getCode() == KeyCode.DOWN) {
        //    System.out.println(e.getCode());
            downKeyHander.handle(e);
        } else if (upKeyHander != null && e.getCode() == KeyCode.UP) {
            //    System.out.println(e.getCode());
            upKeyHander.handle(e);
        } else if (spaceKeyHander != null && e.getCode() == KeyCode.SPACE) {
            //    System.out.println(e.getCode());
            spaceKeyHander.handle(e);
        } else if (letterKeyHander != null && e.getCode().isLetterKey()) {
            //    System.out.println(e.getCode());
            letterKeyHander.handle(e);
        }
    }

    public static Itemable addText(String text, double topY) {
        Text displayText = new Text(text);
        displayText.applyCss();

        double x = initialWidth / 2.0 - displayText.getBoundsInLocal().getWidth();

        return addText(text, x, topY);
    }

    private static Itemable addText(String text, double leftX, double topY) {
        initialize();

        Text displayText = new Text(text);

        displayText.setLayoutX(leftX);
        displayText.setLayoutY(topY);

        displayText.setFont(Font.font(fontName, fontSize));
        displayText.setFill(fontColor);

        return registerNode(displayText);
    }


    public static Itemable addCircle(double centerX, double centerY, double radius) {
        initialize();
        Circle circle = new Circle(centerX, centerY, radius, fill);
        circle.setStroke(stroke);
        circle.setStrokeWidth(strokeWidth);

        return registerNode(circle);
    }


    public static Itemable addRectangle(double leftX, double topY, double width, double height) {
        initialize();
        Rectangle rectangle = new Rectangle(leftX, topY, width, height);
        rectangle.setFill(fill);
        rectangle.setStroke(stroke);
        rectangle.setStrokeWidth(strokeWidth);

        return registerNode(rectangle);
    }

    public static Itemable addImage(String filename) {
        return addImage(filename,0,0);
    }



    public static Itemable addImage(String filename, double leftX, double topY) {
        initialize();

        ImageView imageView = new ImageView(new Image(filename));
        imageView.setLayoutX(leftX);
        imageView.setLayoutY(topY);

        return registerNode(imageView);
    }

    public static Itemable addImage(String filename, double leftX, double topY, double width) {
        initialize();

        ImageView imageView = new ImageView(new Image(filename));

        imageView.setPreserveRatio(true);
        imageView.setFitWidth(width);
        imageView.setLayoutX(leftX);
        imageView.setLayoutY(topY);

        return registerNode(imageView);
    }

    public static Itemable addImage(String filename, double leftX, double topY, double width, double height) {
        initialize();

        ImageView imageView = new ImageView(new Image(filename));

        imageView.setPreserveRatio(false);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setLayoutX(leftX);
        imageView.setLayoutY(topY);

        return registerNode(imageView);
    }

    public static Itemable id(String id) {
        if (!idMap.containsKey(id)) {
            Output.error("Identifier not found: " + id);
            return new NullItem();
        }

        return idMap.get(id);
    }

    public static Itemable all() {
        return all;
    }

    public static Itemable circles() {
        return circles;
    }

    public static Itemable rectangles() {
        System.out.println(rectangles.size());
        return rectangles;
    }

    public static Itemable images() {
        return images;
    }

    public static Itemable texts() {
        return texts;
    }

    private static boolean remove(String id) {

        if (idMap.containsKey(id)) {
            anchorPane.getChildren().remove(idMap.get(id).getNode());
            idMap.remove(id);
            return true;
        }

        return false;
    }

    static boolean remove(Item item) {
        if (item.id() != null) return remove(item.id());

        return anchorPane.getChildren().remove(item.getNode());
    }

    public static void clear() {
        while (anchorPane.getChildren().size() > 0) {
            Node node = anchorPane.getChildren().get(anchorPane.getChildren().size()-1);
            Item item = (Item)node.getUserData();

            remove(item);
        }
    }

    public static void onLeftKey(EventHandler<KeyEvent> handler) {
        leftKeyHander = handler;
    }

    public static void onRightKey(EventHandler<KeyEvent> handler) {
        rightKeyHander = handler;
    }

    public static void onDownKey(EventHandler<KeyEvent> handler) {
        downKeyHander = handler;
    }

    public static void onUpKey(EventHandler<KeyEvent> handler) {
        upKeyHander = handler;
    }

    public static void onSpaceKey(EventHandler<KeyEvent> handler) {
        spaceKeyHander = handler;
    }

    public static void onLetterKey(EventHandler<KeyEvent> handler) {
        letterKeyHander = handler;
    }

    public static void background(Color color) {
        scene.setFill(color);
    }

    static Bounds edges() {
        return anchorPane.getLayoutBounds();
    }

    static void assignId(Item item, String id) {
        if (id != null) {
            if (idMap.containsKey(id)) {
                return;
            }
            item.getNode().setId(id);
            idMap.put(id, item);
        }
    }
}