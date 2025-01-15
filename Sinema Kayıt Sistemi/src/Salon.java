package src;

import java.util.ArrayList;
import java.util.List;

public class Salon extends BaseEntity {
    private String ad;
    private Film film; // Bu salonda gösterilen film
    private List<Musteri> musteriler; // Bu salonda müşteriler listesi

    public Salon(int id, String ad) {
        super(id);
        this.ad = ad;
        this.musteriler = new ArrayList<>();
    }

    public String getAd() {
        return ad;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Film getFilm() {
        return film;
    }

    public void addMusteri(Musteri musteri) {
        musteriler.add(musteri);
    }

    public List<Musteri> getMusteriler() {
        return musteriler;
    }

    @Override
    public void BilgiGoster() {
        System.out.println("Salon: " + ad);
        if (film != null) {
            System.out.println("Gösterimdeki Film: " + film.getAd());
        }
        System.out.println("Kayıtlı Müşteriler:");
        for (Musteri musteri : musteriler) {
            musteri.BilgiGoster();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        builder.append("\"Salon ID\": ").append(getId()).append(", ");
        builder.append("\"Ad\": \"").append(ad).append("\"");

        if (film != null) {
            builder.append(", \"Film\": ").append(film.toString());
        }

        if (!musteriler.isEmpty()) {
            builder.append(", \"Musteriler\": [");
            for (int i = 0; i < musteriler.size(); i++) {
                builder.append(musteriler.get(i).toString());
                if (i < musteriler.size() - 1) {
                    builder.append(", ");
                }
            }
            builder.append("]");
        }

        builder.append(" }");
        return builder.toString();
    }
}
