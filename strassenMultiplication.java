public class strassenMultiplication {
    public static void main(String[] args) {
        int[][] A = { { 1, 2 }, { 3, 4 } };
        int[][] B = { { 5, 6 }, { 7, 8 } };
        int[][] C = strassen(A, B);
        printMatrix(C);
    }

    private static void printMatrix(int[][] c) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] strassen(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];

            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];

            split(A, A11, 0, 0);
            split(A, A12, 0, n / 2);
            split(A, A21, n / 2, 0);
            split(A, A22, n / 2, n / 2);

            split(B, B11, 0, 0);
            split(B, B12, 0, n / 2);
            split(B, B21, n / 2, 0);
            split(B, B22, n / 2, n / 2);

            int[][] M1 = strassen(add(A11, A22), add(B11, B22));
            int[][] M2 = strassen(add(A21, A22), B11);
            int[][] M3 = strassen(A11, sub(B12, B22));
            int[][] M4 = strassen(A22, sub(B21, B11));
            int[][] M5 = strassen(add(A11, A12), B22);
            int[][] M6 = strassen(sub(A21, A11), add(B11, B12));
            int[][] M7 = strassen(sub(A12, A22), add(B21, B22));

            int[][] C11 = add(sub(add(M1, M4), M5), M7);
            int[][] C12 = add(M3, M5);
            int[][] C21 = add(M2, M4);
            int[][] C22 = add(sub(add(M1, M3), M2), M6);
            
            join(C11, C, 0, 0);
            join(C12, C, 0, n / 2);
            join(C21, C, n / 2, 0);
            join(C22, C, n / 2, n / 2);
        }
        return C;
    }

    private static void split(int[][] b, int[][] b22, int i, int j) {
        for (int x = 0; x < b22.length; x++) {
            for (int y = 0; y < b22.length; y++) {
                b22[x][y] = b[x + i][y + j];
            }
        }
    }

    private static int[][] add(int[][] m1, int[][] m4) {
        int n = m1.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = m1[i][j] + m4[i][j];
            }
        }
        return C;
    }

    private static int[][] sub(int[][] b21, int[][] b11) {
        int n = b21.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = b21[i][j] - b11[i][j];
            }
        }
        return C;
    }

    private static void join(int[][] c12, int[][] c, int i, int j) {
        for (int x = 0; x < c12.length; x++) {
            for (int y = 0; y < c12.length; y++) {
                c[i + x][j + y] = c12[x][y];
            }
        }
    }

    
    
}
