Sinema Müşteri Kayıt Sistemi
Proje Açıklaması
Bu proje, bir sinema müşteri kayıt sistemi olup, JSON tabanlı bir veri yönetimi yapısını kullanır. Sistem, müşteri, film ve salon bilgilerini yönetir. Kullanıcı, konsol üzerinden müşteri ekleme, film ekleme, salon ekleme, filmleri listeleme ve bir salonun müşterilerini listeleme gibi işlemleri gerçekleştirebilir.

Projenin Özellikleri
Müşteri Yönetimi: Yeni müşteri eklenebilir ve müşteriler JSON dosyasına kaydedilir.
Film Yönetimi: Yeni filmler eklenebilir ve filmler JSON dosyasına kaydedilir.
Salon Yönetimi: Yeni salonlar oluşturulabilir ve salonlara oynatılacak filmler atanabilir.
Müşteri ve Film İlişkisi: Müşteriler, seçilen filme göre ilgili salonlara atanır.
JSON Dosya Kullanımı: Tüm veriler Musteri.json, Film.json ve Salon.json dosyalarında saklanır.
Listeleme İşlemleri:
Tüm filmler listelenebilir.
Bir salonun müşterileri ve gösterimdeki filmi listelenebilir.
Dosya Yapısı

src/
├── BaseEntity.java     // Tüm sınıflar için temel özellikler
├── Film.java           // Film sınıfı, film bilgilerini yönetir
├── JsonUtils.java      // JSON dosya okuma ve yazma işlemleri
├── Main.java           // Ana dosya, konsol arayüzü
├── Musteri.java        // Müşteri sınıfı, müşteri bilgilerini yönetir
└── Salon.java          // Salon sınıfı, salon ve film bilgilerini yönetir
resources/
├── Musteri.json        // Müşteri verilerinin kaydedildiği dosya
├── Film.json           // Film verilerinin kaydedildiği dosya
└── Salon.json          // Salon ve müşteri ilişkilerinin kaydedildiği dosya
Kullanım Talimatları
Projeyi Çalıştırmak İçin:

Main.java dosyasını çalıştırarak konsol üzerinden uygulamayı başlatabilirsiniz.
Fonksiyonlar:

Yeni Müşteri Ekle: Müşteri bilgileri alınır ve hangi filme gideceği seçilir. Müşteri, ilgili filmi oynatan salona atanır.
Yeni Film Ekle: Film adı, süresi ve türü girilerek yeni bir film oluşturulur.
Yeni Salon Ekle: Salon adı ve ID bilgisi alınır. Salonda oynatılacak film seçilir.
Filmleri Listele: Tüm filmleri görüntüler.
Bir Salonun Müşterilerini Listele: Seçilen bir salonun müşterilerini ve gösterimdeki filmi görüntüler.
JSON Dosyalarının Güncellenmesi:

Müşteriler, Musteri.json dosyasına kaydedilir.
Filmler, Film.json dosyasına kaydedilir.
Salon ve müşteri ilişkileri, Salon.json dosyasına kaydedilir.
