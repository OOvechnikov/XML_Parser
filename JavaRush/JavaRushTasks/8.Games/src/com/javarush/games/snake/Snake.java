package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private List<GameObject> snakeParts = new ArrayList<>();
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject((x + 1), y));
        snakeParts.add(new GameObject((x + 2), y));
    }
    public void draw(Game game) {
        for (int i = 0; i < snakeParts.size(); i++) {
            GameObject snakePart = snakeParts.get(i);
            if (isAlive) {
                if (i == 0) {
                    game.setCellValueEx(snakePart.x, snakePart.y, Color.NONE, HEAD_SIGN, Color.BLACK, 75);
                    continue;
                }
                game.setCellValueEx(snakePart.x, snakePart.y, Color.NONE, BODY_SIGN, Color.BLACK, 75);
            } else {
                if (i == 0) {
                    game.setCellValueEx(snakePart.x, snakePart.y, Color.NONE, HEAD_SIGN, Color.RED, 75);
                    continue;
                }
                game.setCellValueEx(snakePart.x, snakePart.y, Color.NONE, BODY_SIGN, Color.RED, 75);
            }
        }
    }

    public void setDirection(Direction direction) {

        if (direction == Direction.LEFT && this.direction == Direction.RIGHT) {
        } else if (direction == Direction.RIGHT && this.direction == Direction.LEFT) {
        } else if (direction == Direction.UP && this.direction == Direction.DOWN) {
        } else if (direction == Direction.DOWN && this.direction == Direction.UP) {
        } else if (this.direction == Direction.LEFT && snakeParts.get(0).x == snakeParts.get(1).x) {
        } else if (this.direction == Direction.RIGHT && snakeParts.get(0).x == snakeParts.get(1).x) {
        } else if (this.direction == Direction.UP && snakeParts.get(0).y == snakeParts.get(1).y) {
        } else if (this.direction == Direction.DOWN && snakeParts.get(0).y == snakeParts.get(1).y) {
        } else {
            this.direction = direction;
        }
    }

    public void move(Apple apple) {
        GameObject newHead = createNewHead();
        if ((newHead.x >= SnakeGame.WIDTH || newHead.x < 0) || (newHead.y >= SnakeGame.HEIGHT || newHead.y < 0)) {
            isAlive = false;
            return;
        }
        if (checkCollision(newHead)) {
            isAlive = false;
            return;
        }
        if (newHead.x == apple.x && newHead.y == apple.y) {
            apple.isAlive = false;
            snakeParts.add(0, newHead);
            return;
        }
        snakeParts.add(0, newHead);
        removeTail();
    }

    public GameObject createNewHead() {
        GameObject newHead = null;
        GameObject head = snakeParts.get(0);
        switch (direction) {
            case UP: {
                newHead = new GameObject(head.x, head.y - 1);
                break;
            }
            case DOWN: {
                newHead = new GameObject(head.x, head.y + 1);
                break;
            }
            case LEFT: {
                newHead = new GameObject(head.x - 1, head.y);
                break;
            }
            case RIGHT: {
                newHead = new GameObject(head.x + 1, head.y);
                break;
            }
        }
//        if (direction.equals(Direction.LEFT)) {
//            newHead = new GameObject(head.x - 1, head.y);
//        } else if (direction.equals(Direction.RIGHT)) {
//            newHead = new GameObject(head.x + 1, head.y);
//        } else if (direction.equals(Direction.UP)) {
//            newHead = new GameObject(head.x, head.y - 1);
//        } else if (direction.equals(Direction.DOWN)) {
//            newHead = new GameObject(head.x, head.y + 1);
//        }

        return  newHead;
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public boolean checkCollision(GameObject gameObject) {
        for (GameObject object : snakeParts) {
            if (gameObject.x == object.x && gameObject.y == object.y) {
                return true;
            }
        }
        return false;
    }

    public int getLength() {
        return snakeParts.size();
    }

}
