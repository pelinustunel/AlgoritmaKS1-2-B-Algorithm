import java.util.*;

public class BStar {
    private Map<Integer, Map<Integer, Integer>> graph;

    // graph adında bir HashMap nesnesi oluşturuluyor.
    public BStar() {
        graph = new HashMap<>();
    }

    // Bu metod, başlangıç düğümünden bitiş düğümüne doğru yönlü ağırlıklı bir kenar eklemek için kullanılır.
    public void kenarEkle(int u, int v, int agirlik) {
        graph.putIfAbsent(u, new HashMap<>());
        graph.get(u).put(v, agirlik);
    }

    // Bu metod, başlangıç düğümünden bitiş düğümüne en kısa yolu bulmak için kullanılır.
    public List<Integer> enKisaYol(int start, int end) {

        // dist değişkeni,her düğüme olan mesafeyi tutmak için kullanılır.
        Map<Integer, Integer> dist = new HashMap<>();
        // parent değişkeni, her düğümün ebeveyn düğümünü tutmak için kullanılır.
        Map<Integer, Integer> parent = new HashMap<>();
        // Burada öncelik kuyruğu, mesafelerin artan sırayla saklanmasını sağlayacak şekilde ayarlanmıştır.
        PriorityQueue<Integer> oncelikKuyrugu = new PriorityQueue<>((a, b) -> dist.getOrDefault(a, Integer.MAX_VALUE) - dist.getOrDefault(b, Integer.MAX_VALUE));
        dist.put(start, 0);
        oncelikKuyrugu.offer(start);

        //Öncelik kuyruğundan düğümler çıkarılırken, bu düğümlerin komşuları ile ilgili işlemler yapılır.
        while (!oncelikKuyrugu.isEmpty()) {
            int u = oncelikKuyrugu.poll();
            if (u == end) {
                break;
            }
            if (graph.containsKey(u)) {
                for (Map.Entry<Integer, Integer> neighbor : graph.get(u).entrySet()) {
                    int v = neighbor.getKey();
                    int weight = neighbor.getValue();
                    int newDist = dist.getOrDefault(u, Integer.MAX_VALUE) + weight;
                    if (newDist < dist.getOrDefault(v, Integer.MAX_VALUE)) {
                        dist.put(v, newDist);
                        parent.put(v, u);
                        oncelikKuyrugu.offer(v);
                    }
                }
            }
        }

        // Bu kısımda, start ve end noktaları arasındaki en kısa yolu bulduktan sonra, bu yolun listesini oluşturuyor.
        List<Integer> path = new ArrayList<>();
        int u = end;
        while (parent.containsKey(u)) {
            path.add(0, u);
            u = parent.get(u);
        }
        path.add(0, u);
        return path;
    }

    // Örnek bir graf oluşturulması
    public static void main(String[] args) {
        BStar graf = new BStar();
        graf.kenarEkle(1, 2, 8);
        graf.kenarEkle(1, 3, 5);
        graf.kenarEkle(2, 4, 6);
        graf.kenarEkle(3, 4, 2);
        graf.kenarEkle(3, 5, 7);
        graf.kenarEkle(4, 5, 3);

        List<Integer> path = graf.enKisaYol(1, 5);
        System.out.println(path);
    }
}
