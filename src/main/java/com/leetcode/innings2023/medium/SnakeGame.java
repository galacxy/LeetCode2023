package com.leetcode.innings2023.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Objects.isNull;

public class SnakeGame {

    private final Queue<Position> food;
    private final Deque<Position> snake;
    private int score;
    private final int width;
    private final int height;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.score = 0;
        this.food = setupFood(food);
        this.snake = new ArrayDeque<>();
        this.snake.add(new Position(0,0));
    }

    private Queue<Position> setupFood(int[][] food){
        Queue<Position> foodQueue = new LinkedList<>();
        Arrays.stream(food).forEach(f -> foodQueue.offer(new Position(f[0], f[1])));
        System.out.println(foodQueue);
        return foodQueue;
    }

    public int move(String direction) {
        Position nextPosition = getNextPosition(direction);
        if (isNull(nextPosition)){
            System.out.println("Hit the wall");
            return -1;
        }
        if(snake.contains(nextPosition)) {
            System.out.println("Hit the self");
            return -1;
        }
        if (nextPosition.equals(food.peek())){
            food.poll();
            this.score++;
        } else {
            snake.removeLast();
        }
        snake.addFirst(nextPosition);

        return this.score;
    }

    private Position getNextPosition(String direction){
        if (this.snake.isEmpty()){
            return null;
        }
        int currentR = snake.peek().r;
        int currentC = snake.peek().c;
        return switch (direction) {
            case "L" -> currentC > 0 ? new Position(currentR, currentC - 1) : null;
            case "R" -> currentC < width - 1 ? new Position(currentR, currentC +1) : null;
            case "D" -> currentR < height - 1 ? new Position(currentR+1, currentC) : null;
            case "U" -> currentR > 0 ? new Position(currentR-1, currentC) : null;
            default -> throw new IllegalArgumentException();
        };
    }

    private static class Position{
        final int r;
        final int c;

        public Position(int x, int y){
            this.r = x;
            this.c = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj){
                return true;
            }
            if (isNull(obj) || !(obj instanceof Position other)){
                return false;
            }
            return other.r == this.r && other.c == this.c;
        }

        @Override
        public String toString(){
            return "[" + this.r + ", " + this.c + "]";
        }
    }

    private static class Display{
        final String move;
        final Position currentHead;
        final int score;
        final Deque<Position> snake;

        public Display(String move, Position currentHead, int score, Deque<Position> snake) {
            this.move = move;
            this.currentHead = currentHead;
            this.score = score;
            this.snake = new ArrayDeque<>(snake);
        }

        @Override
        public String toString() {
            return "Display{" +
                    "move='" + move + '\'' +
                    ", currentHead=" + currentHead +
                    ", score=" + score +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[][] food = {{2,0},{0,0},{0,2},{2,2}};
        SnakeGame snakeGame = new SnakeGame(3, 3, food);
        String[] moves = {"D","D","R","U","U","L","D","R","R","U","L","D"};
        List<Display> displays = new ArrayList<>();
        displays.add(new Display("O", new Position(0,0), 0, snakeGame.snake));
        for(String move : moves){
            int score = snakeGame.move(move);
            displays.add(new Display(move, snakeGame.snake.peek(), score, snakeGame.snake));
        }

        displays.forEach(d -> System.out.println(d.move + " " + d.currentHead + " " + d.score + " " + d.snake));
    }
}
