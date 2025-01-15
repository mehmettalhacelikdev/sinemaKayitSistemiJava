package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JsonUtils<Musteri> musteriJson = new JsonUtils<>();
        JsonUtils<Film> filmJson = new JsonUtils<>();
        JsonUtils<Salon> salonJson = new JsonUtils<>();

        List<Musteri> musteriler = new ArrayList<>();
        List<Film> filmler = new ArrayList<>();
        List<Salon> salonlar = new ArrayList<>();

        while (true) {
            System.out.println("1. Yeni Müşteri Ekle");
            System.out.println("2. Yeni Film Ekle");
            System.out.println("3. Yeni Salon Ekle");
            System.out.println("4. Filmleri Listele");
            System.out.println("5. Bir Salonun Müşterilerini Listele");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); // Satır sonunu temizle

            switch (secim) {
                case 1:
                    System.out.print("Müşteri ID: ");
                    int musteriId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Müşteri Adı: ");
                    String musteriAd = scanner.nextLine();
                    System.out.print("Müşteri Soyadı: ");
                    String musteriSoyad = scanner.nextLine();

                    // Kullanıcıdan hangi filme gideceği bilgisi alınır
                    System.out.println("Hangi filme gitmek istiyor?");
                    filmJson.oku("resources/Film.json", Film.class); // Filmleri listeler
                    System.out.print("Film Adı: ");
                    String filmAd = scanner.nextLine();

                    // Salonu bul ve müşteriyi salona ekle
                    Salon hedefSalon = salonlar.stream()
                            .filter(salon -> salon.getFilm() != null && salon.getFilm().getAd().equalsIgnoreCase(filmAd))
                            .findFirst()
                            .orElse(null);

                    if (hedefSalon == null) {
                        System.out.println("Bu film için uygun salon bulunamadı!");
                        break;
                    }

                    // Müşteri oluşturulur ve hem genel listeye hem de salona eklenir
                    Musteri yeniMusteri = new Musteri(musteriId, musteriAd, musteriSoyad);
                    musteriler.add(yeniMusteri);
                    hedefSalon.addMusteri(yeniMusteri);

                    // Dosyalar güncellenir
                    musteriJson.kaydet("resources/Musteri.json", musteriler);
                    salonJson.kaydet("resources/Salon.json", salonlar);
                    System.out.println("Müşteri başarıyla eklendi ve salona kaydedildi!");
                    break;

                case 2:
                    System.out.print("Film Adı: ");
                    String yeniFilmAd = scanner.nextLine();
                    System.out.print("Film Süresi: ");
                    int filmSure = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Film Türü: ");
                    String filmTur = scanner.nextLine();
                    filmler.add(new Film(yeniFilmAd, filmSure, filmTur));
                    filmJson.kaydet("resources/Film.json", filmler);
                    break;

                case 3:
                    System.out.print("Salon ID: ");
                    int salonId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Salon Adı: ");
                    String salonAd = scanner.nextLine();
                    System.out.print("Hangi Film Oynatılıyor? ");
                    String oynatilanFilm = scanner.nextLine();
                    Salon yeniSalon = new Salon(salonId, salonAd);
                    filmler.stream()
                            .filter(f -> f.getAd().equalsIgnoreCase(oynatilanFilm))
                            .findFirst()
                            .ifPresent(yeniSalon::setFilm);
                    salonlar.add(yeniSalon);
                    salonJson.kaydet("resources/Salon.json", salonlar);
                    break;

                case 4:
                    System.out.println("Filmleri Listeleme:");
                    filmJson.oku("resources/Film.json", Film.class);
                    break;

                case 5:
                    System.out.println("Salonları Listeleme:");
                    salonJson.oku("resources/Salon.json", Salon.class);
                    break;

                case 6:
                    System.out.println("Çıkış yapılıyor...");
                    return;

                default:
                    System.out.println("Geçersiz seçim.");
            }
        }
    }
}
