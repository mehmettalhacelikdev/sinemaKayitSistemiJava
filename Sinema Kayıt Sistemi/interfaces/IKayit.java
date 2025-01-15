package interfaces;

import java.util.List;

public interface IKayit<T> {
    void kaydet(String dosyaAdi, List<T> veriler);
    List<T> oku(String dosyaAdi, Class<T> cls);
}
