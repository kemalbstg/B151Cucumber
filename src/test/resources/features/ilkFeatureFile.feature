Feature: US001_Neredekal_Filtre_Testi
  Scenario: TC01_En_Uygundan_En_Pahalıya_Sıralama
    Given kullanıcı neredekal sayfasına gider
    Then üyelik altından üye ol a tıklanır
    And form doldurulur
    Then kullanıcının giriş yaptığı doğrulanır
