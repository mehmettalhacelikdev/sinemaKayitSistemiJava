package src;

public class Musteri extends BaseEntity {
    private String ad;
    private String soyad;

    public Musteri(int id, String ad, String soyad) {
        super(id);
        this.ad = ad;
        this.soyad = soyad;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    @Override
    public void BilgiGoster() {
        System.out.println("Müşteri ID: " + getId() + ", Ad: " + ad + ", Soyad: " + soyad);
    }

    @Override
    public String toString() {
        return "Müşteri ID: " + getId() + ", Ad: " + ad + ", Soyad: " + soyad;
    }
}
