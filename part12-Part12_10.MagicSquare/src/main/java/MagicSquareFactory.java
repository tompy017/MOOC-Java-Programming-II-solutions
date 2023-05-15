
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {
        
        // Siamese method only works with odd squares
        if (size % 2 == 0) {
            throw new RuntimeException("Only odd sizes available");
        }

        MagicSquare square = new MagicSquare(size);
        
        int[][] matrix = new int[size][size];

        int row = 0;
        int col = size / 2;

        for (int i = 1; i <= size * size; i++) {
            matrix[row][col] = i;

            // Move diagonally up and to the right
            int newRow = (row - 1 + size) % size;
            int newCol = (col + 1) % size;

            // If the current position is already filled, move down one row
            if (matrix[newRow][newCol] != 0) {
                newRow = (row + 1) % size;
                newCol = col;
            }

            row = newRow;
            col = newCol;
        }

        square.setSquare(matrix);

        return square;
    }
        
}   
        
        
        
        /*
        boolean isMagicSquare = false;

        while (!isMagicSquare) {
            square = new MagicSquare(size);

            int n = size * size;
            int[][] matrix = new int[size][size];

            int row = 0;
            int col = size / 2;

            for (int i = 1; i <= n; i++) {
                matrix[row][col] = i;

                // Move diagonally up and to the right
                row--;
                col++;

                // If row becomes less than 0, wrap around to the last row
                if (row < 0) {
                    row = size - 1;
                }

                // If col becomes greater than or equal to size, wrap around to the first column
                if (col >= size) {
                    col = 0;
                }

                // If the current position is already filled, move down one row
                if (matrix[row][col] != 0) {
                    row++;
                    // If row becomes greater than or equal to size, wrap around to the first row
                    if (row >= size) {
                        row = 0;
                    }
                    // Move one column to the left
                    col--;
                }
            }

            square.setSquare(matrix);

            if (square.isMagicSquare()) {
                isMagicSquare = true;
            }
        }

        return square;
    }
}
        
        
/*
        // implement the creation of a magic square with the Siamese method algorithm here
        fillSquare(square);
        
        while (true) {
            if (square.isMagicSquare()) {
                
                break;
            }
            MagicSquare magicSquare = new MagicSquare(size);
            fillSquare(magicSquare);
            square = magicSquare;
        }
                
        return square;
    }
    
    
    public void fillSquare(MagicSquare square) {
        
        int value = 1;
        int rowIndex = 0;
        int columnIndex = square.getWidth() / 2;
        
        square.placeValue(rowIndex, columnIndex, value);
        
        while (value <= square.getHeight() * square.getWidth()) {

            rowIndex -= 1;

            if (rowIndex < 0) {
                rowIndex = square.getHeight() - 1;
            }

            columnIndex += 1;
            if (columnIndex >= square.getWidth()) {
                columnIndex = 0;
            }

            if (square.readValue(rowIndex, columnIndex) != 0) {
                columnIndex -= 1;
            } 
            square.placeValue(rowIndex, columnIndex, value);

            value ++;

        }

    }

}
*/