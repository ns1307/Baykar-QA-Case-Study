# Baykar QA Case Study

## 📋 Genel Bakış
Bu proje, Baykar Web Yazılım Test Uzmanı pozisyonu için istenen Yazılım Test ve Otomasyonu projesidir. Bu projede şunlar bulunmaktadır:
- Manuel Testler
- Yük Testleri
- Otomasyon Testleri


## 📝 Manuel Testler
Baykar Kariyer (https://kariyer.baykartech.com/) web sitesi için kapsamlı test senaryoları hazırlanmış ve dökümante edilmiştir. Toplamda 84 test case oluşturulmuş olup testlerin tümü başarılıdır.

## ⚙️ Yük Testleri
Locust ve JMeter kullanılarak Baykar Kariyer (https://kariyer.baykartech.com/) web sitesi için yük ve performans testleri yazılmıştır. Locust ve JMeter ile çok fazla sayıda kullanbıcının siteye erişmeye çalıştığında, sitenin bu isteklere cevap verebilirliği ölçülmüştür.

## ⚡ Otomasyon Testleri
Projede istenen 3 özellik BDD yaklaşımıyla senaryolandırılarak otomasyon testleri oluşturulmuştur. Testler oluşturulurken POM, DRY, SOLID, OOP yaklaşımlarına uyulmuştur. 


## 🔧 Teknolojiler
- ☕ Java
- 🌐 Selenium WebDriver
- 🥒 Cucumber Framework
- 🧪 JUnit
- 🍲 JSoup
- 📦 Maven
- 🚗 WebDriverManager 5.6.2

## 📁 Proje Yapısı
```
Baykar-QA-Case-Study/
├───Baykar Manuel Test Cases
│     └── Baykar Manuel Test Cases.xlsx    #Manuel Testler
│
├─── BaykarTestAutomation
│      ├── src/
│      │   └── test/
│      │       ├── java/
│      │       │   ├── pages/           # Sayfa Nesneleri ve Komponentler
│      │       │   ├── runner/          # Test Koşturucuları
│      │       │   ├── stepdefinitions/ # Adım Tanımlamaları
│      │       │   └── utilities/       # Yardımcı Sınıflar
│      │       └── resources/
│      │           └── features/        # Cucumber Özellik Dosyaları
│      │           
│      │          
│      ├── target/   # Sadece lokalde bulunur
│      │   └── reports/                 # Test Raporları
│      │   │    ├── overview-failure.html/          # Hata Raporu
│      │   │    ├── overview-features.html/         # Test edilen özelliklere göre  koşum raporu
│      │   │    ├── overview-steps.html/            # Test adımlarına göre koşum raporu
│      │   │    └── overview-tags.html/             # Taglere göre koşum raporu
│      │   │    
│      │   └── Screenshots/             # Başarısız olan testlerden sonra alınan ekran görüntüleri
│      │       
│      ├── pom.xml                      # Maven Bağımlılıkları
│      └── configuration.properties
│
│
└── Baykar Load Tests                   # Yük ve Performans Testleri     
       │
       ├── Locust
       └── JMeter
```

## 🎯 Test Senaryoları
Proje şu anda aşağıdaki test senaryolarını içermektedir:

1. 🌎 Dil Değiştirme Fonksiyonelliği
   - Sitenin dilinin değiştirilebilmesi
   - Sitenin içeriğinin dilinin değişmiş olması
   - Sitenin desteklemesi gereken tüm dilleri destekliyor olması

2. 🧭 Navbar Fonksiyonelliği
   - Tüm Navbar butonlarının doğru çalışması

3. 👨🏼‍💼 Açık Pozisyonların Filtrelenmesi
   - Birim seçilerek ve arama yapılarak filtreleme yapılması

