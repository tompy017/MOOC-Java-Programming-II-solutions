package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {
    
    public static int WIDTH = 300;
    public static int HEIGHT = 200;


    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        
        // Points
        Text text = new Text(10, 20, "Points: 0");
        pane.getChildren().add(text);
        
        AtomicInteger points = new AtomicInteger();
        
        
        //Create ship and asteroids
        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);
        
        List<Asteroid> asteroids = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            Asteroid newAsteroid = new Asteroid(random.nextInt(WIDTH / 3), random.nextInt(HEIGHT));
            asteroids.add(newAsteroid);
        }
        
        List<Projectile> projectiles = new ArrayList<>();
       
        
        
        //add the ship and asteroids to the pane
        pane.getChildren().add(ship.getCharacter());       
        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));
        
        Scene scene = new Scene(pane);
        stage.setTitle("Asteroids!");
        stage.setScene(scene);


        //ROTATE AND MOVE THE SHIP
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
        
        // to rotate smoothly
        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });
        
        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });
        
        
        
        //ANIMATION
        new AnimationTimer() {   
            @Override
            public void handle(long now) {        //60 times per second aprox
                
                // SHIP MOVEMENTS
                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }
                
                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }
                
                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }
                
                // SHOOT
                if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                    Projectile projectile = new Projectile(
                        (int) ship.getCharacter().getTranslateX(), 
                        (int) ship.getCharacter().getTranslateY());
                    
                    projectile.getCharacter()
                        .setRotate(projectile.getCharacter().getRotate());
                    
                    projectiles.add(projectile);
                    
                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));
                    
                    //add projectile to the view
                    pane.getChildren().add(projectile.getCharacter());
                }
                
                
                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());
                
                // Stop animation if there's a collition
                asteroids.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                    }
                });
                
                
                // Projectiles shooting asteroids
                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if (projectile.collide(asteroid)) {
                            projectile.setAlive(false);
                            asteroid.setAlive(false);
                            text.setText("Points: " + points.addAndGet(1000));
                        }
                    });
                });
                
                projectiles.stream()
                    .filter(projectile -> !projectile.isAlive())
                    .forEach(projectile -> pane.getChildren().remove(projectile.getCharacter()));
                
                projectiles.removeAll(projectiles.stream()
                    .filter(projectile -> !projectile.isAlive())
                    .collect(Collectors.toList()));

                asteroids.stream()
                    .filter(asteroid -> !asteroid.isAlive())
                    .forEach(asteroid -> pane.getChildren().remove(asteroid.getCharacter()));
                
                asteroids.removeAll(asteroids.stream()
                    .filter(asteroid -> !asteroid.isAlive())
                    .collect(Collectors.toList()));
                
                /*
                projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .forEach(projectile -> {
                            pane.getChildren().remove(projectile.getCharacter());
                            projectiles.remove(projectile);
                        
                        });
                
                asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .forEach(asteroid -> {
                            pane.getChildren().remove(asteroid.getCharacter());
                            asteroids.remove(asteroid);
                        });

                */
            


            // adding asteroids
            if (Math.random() < 0.005) {
                Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                if (!asteroid.collide(ship)) {
                    asteroids.add(asteroid);
                    pane.getChildren().add(asteroid.getCharacter());
                }
            }
            }
            
            
            
        }.start();



        stage.show();
    }

    
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
