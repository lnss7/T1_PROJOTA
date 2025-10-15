public class Main {
    public static void main(String[] args) {
        // Exemplo simples usando LCS recursivo por força bruta
        String a = "AGGTXAB"; // exemplo
        String b = "AXTXABY"; // exemplo

        System.out.println("Entrada A: " + a);
        System.out.println("Entrada B: " + b);

        //String seq = LCS.forcaBruta(a, b);

        //System.out.println("LCS (força bruta): " + seq);
        //System.out.println("Iterações (chamadas recursivas): " + LCS.iterations);
        //System.out.printf("Tempo decorrido: %.3f ms\n", LCS.lastTimeNs / 1_000_000.0);

        // Exemplo simples usando LCS com programação dinâmica
        String seqDyn = LCS.dynamic(a, b);
        System.out.println("LCS (programação dinâmica): " + seqDyn);
        System.out.println("Tamanho da LCS: " + seqDyn.length());
        System.out.println("Iterações (programação dinâmica): " + LCS.iterationsDynamic);
        System.out.printf("Tempo decorrido: %.3f ms\n", LCS.lastTimeNsDynamic / 1_000_000.0);

    }
}