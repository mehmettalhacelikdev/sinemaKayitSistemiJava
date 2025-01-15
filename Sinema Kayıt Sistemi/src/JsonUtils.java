package src;

import interfaces.IKayit;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils<T> implements IKayit<T> {

    @Override
    public void kaydet(String dosyaAdi, List<T> veriler) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dosyaAdi), "UTF-8"))) {
            writer.write("[\n");
            for (int i = 0; i < veriler.size(); i++) {
                writer.write("  " + veriler.get(i).toString());
                if (i < veriler.size() - 1) {
                    writer.write(",\n");
                }
            }
            writer.write("\n]");
            System.out.println(dosyaAdi + " dosyasına veriler kaydedildi.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> oku(String dosyaAdi, Class<T> cls) {
        List<T> veriler = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(dosyaAdi), "UTF-8"))) {
            String line;
            System.out.println(cls.getSimpleName() + " Verileri:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(dosyaAdi + " bulunamadı, lütfen önce veri kaydedin.");
        }
        return veriler;
    }
}
