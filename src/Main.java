public class Main {
    public static void main(String[] args) { // w main'e mamy glowne parametry gry
        int width = 10;
        int height = 10;
        int iterations = 10;
        GameOfLife game = new GameOfLife(width, height, iterations);
       game.startGame();
    }
}
