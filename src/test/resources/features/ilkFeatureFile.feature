Feature: US001_Neredekal_Filtre_Testi
  Scenario: TC01_En_Uygundan_En_Pahalıya_Sıralama
    Given kullanıcı neredekal sayfasına gider
    Then üyelik altından üye ol a tıklanır
    And form doldurulur
    Then üyelik işlemi doğrulanır
    And giriş yapılır
    Then giriş doğrulanır
    And arama kısmına bodrum otelleri yazılır
    Then tarih olarak bugün ve sonraki gün seçilir
    And filtreleme alanında fiyat önce en düşük seçilir
    Then fiyatların düşükten yüksege olarak sıralandığı doğrulanır
    And sayfa kapatilir

