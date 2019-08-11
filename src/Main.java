import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int W = scanner.nextInt();
        int n = scanner.nextInt();

        int[]weights = new int[n + 1];
        for (int i = 1; i <= n; i++){
            weights[i] = scanner.nextInt();
        }

        System.out.println(KnapSackWithoutRepsBU(W, weights, n));
    }

    public static int KnapSackWithoutRepsBU(int W, int[]weights,int n){
        int[][]D = new int[W + 1][n + 1];

        for (int i = 1; i <= n; i++){
            for (int w = 1; w <= W; w++){
                D[w][i] = D[w][i - 1];

                if (weights[i] <= w){
                    D[w][i] = max(D[w][i], D[w - weights[i]][i - 1] + weights[i]);
                }
            }
        }

        return D[W][n];
    }

    public static int max(int a, int b){
        return a >= b ? a : b;
    }
}
