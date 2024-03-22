import java.util.Arrays;
// Zrobil Ivan Savenko
// Miesci silnik gry
abstract class GameEngine {
    protected int width;
    protected int height;
    protected boolean[][] grid; // w tablice pszechowuje boolean
    protected boolean[][] nextGrid; // tablica dla nastepnej generacji

    public GameEngine(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new boolean[width][height];
        this.nextGrid = new boolean[width][height];
    }
    abstract void startGame(); // musi miescic vizualizacje gry
    public void nextGeneration() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int aliveNeighbors = countAliveNeighbors(i, j);
                // ustawiam dla pozycji [i][j] wartosc false, potem sprawdzam ilosc zywych siasiadow odzielnie
                // dla zywych(warunek aliveNeighbors == 2 lub 3) i nie zywych (gdy sa 3 zywych siasiada)
                nextGrid[i][j] = false;
                if (grid[i][j]) {
                    if (aliveNeighbors == 2 || aliveNeighbors == 3) {
                        nextGrid[i][j] = true;
                    }
                } else {
                    if (aliveNeighbors == 3) {
                        nextGrid[i][j] = true;
                    }
                }
            }
        }
        // kopiowanie nowej generacji do starej tablicy
        for (int i = 0; i < width; i++) {
            grid[i] = Arrays.copyOf(nextGrid[i], height);
        }
    }

    private int countAliveNeighbors(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue; // pominanie centralnej komorki dla ktorej sprawdzamy ilosc zywych siasiadow
                int checkX = x + i;
                int checkY = y + j;
                if (checkX >= 0 && checkX < width && checkY >= 0 && checkY < height) { // nie sprawdzamy sasiadow poza zakresem gry
                    if (grid[checkX][checkY]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
