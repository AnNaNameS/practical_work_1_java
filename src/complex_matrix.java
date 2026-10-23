class complex_matrix {
    complex_number[][] matrix;

    complex_matrix(int n) {
        matrix = new complex_number[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new complex_number(0, 0);
            }
        }
    }

    public complex_matrix add(complex_matrix other) {
        int n = matrix.length;
        complex_matrix res = new complex_matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res.matrix[i][j] = this.matrix[i][j].add(other.matrix[i][j]);
            }
        }
        return res;
    }

    public complex_matrix multiply(complex_matrix other) {
        if (this.matrix.length != other.matrix.length) {
            throw new IllegalArgumentException("Нельзя умножить матрицы разных размеров");
         }
        int n = matrix.length;
        complex_matrix res = new complex_matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                complex_number sum = new complex_number(0, 0);
                for (int k = 0; k < n; k++) {
                    sum = sum.add(this.matrix[i][k].multiply(other.matrix[k][j]));
                }
                res.matrix[i][j] = sum;
            }
        }
        return res;
    }

    public complex_matrix transp() {
        int n = matrix.length;
        complex_matrix res = new complex_matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res.matrix[i][j] = this.matrix[j][i];
            }
        }
        return res;
    }

    public complex_number determinant() {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        complex_number det = new complex_number(0, 0);
        for (int j = 0; j < n; j++) {
            complex_matrix res = minor(0, j);
            complex_number contr = matrix[0][j].multiply(res.determinant());
            if (j % 2 == 0) {
                det = det.add(contr);
            } else {
                det = det.subtract(contr);
            }
        }
        return det;
    }

    public complex_matrix minor(int row, int col) {
        int n = matrix.length;
        complex_matrix res = new complex_matrix(n - 1);
        int ri = 0;
        for (int i = 0; i < n; i++) {
            if (i == row) {
                continue;
            }
            int ci = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) {
                    continue;
                }
                res.matrix[ri][ci] = matrix[i][j];
                ci++;
            }
            ri++;
        }
        return res;
    }

    public complex_matrix det_1() {
        int n = matrix.length;
        complex_matrix res = new complex_matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                complex_matrix m = minor(i, j);
                complex_number value = m.determinant();
                if ((i + j) % 2 != 0) {
                    value = new complex_number(0, 0).subtract(value);
                }
                res.matrix[i][j] = value;
            }
        }
        return res;
    }

    public complex_matrix inverse() {
        int n = matrix.length;
        complex_matrix res = new complex_matrix(n);
        complex_matrix adj = det_1().transp();
        complex_number det = this.determinant();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res.matrix[i][j] = adj.matrix[i][j].divide(det);
            }
        }
        return res;
    }

    public complex_matrix divide(complex_matrix other) {
        complex_matrix oth_inv = other.inverse();
        return this.multiply(oth_inv);
    }

    public void print() {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }
}



