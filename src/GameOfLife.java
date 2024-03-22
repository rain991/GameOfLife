// Zrobil Ivan Savenko
// To jest KONSOLOWA wersja gry w zycie
public class GameOfLife extends GameEngine {  // klasyczne podejscie do realizacji dziedziczenia w Javie. Klasa ktora tworzy obiekt dziedziczy po klasie abstract (tworzenie "abstract layer")
    public int iterations;
    public GameOfLife(int width, int height, int iterations) {
        super(width, height);
        this.iterations=  iterations;
    }

    @Override
    void startGame() { // startGame mozna traktowac jak Visualize lub View
        initializeRandom();
        for (int i = 0; i < iterations; i++) {
            printGrid();
            nextGeneration();
        }
    }

    public void printGrid() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(grid[i][j] ? "O " : "- ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void initializeRandom() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = Math.random() < 0.5;
            }
        }
    }
}