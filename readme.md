# B\* Algoritması

## B\* Algoritmasının Amacı nedir ve Ne İçin Kullanılır?

B* algoritması, Graf arama problemlerini çözmek için kullanılan bir algoritmadır.
Bunun dışında yapay zeka, robotik ve oyun programlaması gibi alanlarda kullanılabilmektedir.
B* algoritması, A* algoritmasına benzer bir çalışma prensibine sahiptir ve A* algoritmasındaki gibi heuristik bir arama algoritmasıdır. Bununla birlikte B*, A* algoritmasının bazı dezavantajlarını gidermek için tasarlanmıştır.

B* algoritması sadece en uygun yolu değil, aynı zamanda ikinci en uygun yolu da arar. Bu, arama sırasında daha az düğüm genişletilmesine neden olur ve böylece daha hızlı çalışır. Kısacası B* algoritmasının iki önemli adımı vardır.

1. En iyi yolun maliyetinin belirlenmesi
2. İkinci en iyi yolun aranması

## B\* Algoritmasının Çalışma Mantığı

B\* algoritmasının çalışma şekli, bir öncül düğüm ve bir hedef düğüm belirleyerek başlar. Algoritma, öncül düğümden hedef düğüme doğru olası yolları aramaya başlar ve her bir yolun maliyetini hesaplar. Bu maliyetler daha sonra bir öncelik sırasına göre sıralanır ve algoritma, sıralamada üst sırada olan yolları genişletir. Bu genişletme işlemi, öncül düğümden hedef düğüme doğru yol üzerindeki düğümleri keşfetmek için kullanılır. Bu işlem, hedef düğüme ulaşana kadar devam eder.

<img src="https://github.com/pelinustunel/AlgoritmaKs1-2-B-Algorithm/blob/main/B_algorithm.jpeg" alt="B* algoritması mantığı" width="500">

## B\* Algoritmasının Çalışma Zamanı

B\* algoritmasının çalışma zamanı analizi, genişletilen düğümlerin sayısına bağlıdır.

**En kötü durumda**, B\* algoritması, grafın tüm düğümlerini genişletebilir ve en kötü zaman karmaşıklığı `O(b^d)` olur. Bu durum algoritmanın tüm yolları denemek zorunda kaldığı durumda gerçekleşir. Burda b genişleme faktörüne, d ise gereken maksimum derinliği belirtir.

**Ortalama durumda**, zaman karmaşıklığı `O(b^d)`, burada b, genişleme faktörü ve d, öncül düğümden hedef düğüme olan en kısa yolun uzunluğudur(gereken maksimum derinlik). Bu durum, aranan yolu bulmak için genellikle çok sayıda düğüm genişletmesi gerektiği durumlarda geçerlidir. Algoritma, genişlemelerini yapmak için çok sayıda alternatif yol arar ve bu nedenle ortalama karmaşıklığı artar.

**En iyi durumda**, başlangıç düğümü ve hedef düğümü arasındaki en kısa yol doğrudan bir kenardan geçerse, algoritma sadece bir kez çalışır ve zaman karmaşıklığı `O(d)` olur.
**Uygulamada Kullanılamamasının Nedeni**
Yapılan alice_in_wonderland.txt dosyasının içinde \*“upon, Dormouse, sigh, jury-box, swim”\_ kelimelerinin kaç kez tekrar ettiği uygulamasında B\* algoritması kullanılamamasının
sebebi:

1. Graf arama problemlerinin çözümlerinden kullanılan bir algoritmadır. Bu nedenle, doğrudan bir metin içinde kelime araması yapmak için uygun bir algoritma değildir. Bundan dolayı B\* algoritması bu uygulamada kullanılamamıştır.
