1. Dil Değişim Fonksiyonelliği Testi
Senaryo: Kullanıcı site dillerini değiştirebilmeli
Given Kullanıcı Baykartech sitesini ziyaret eder
When Kullanıcı site dili seçeneklerini görüntüler
And Kullanıcı mevcut dillerden birini seçer
Then Seçilen dil aktif olarak görüntülenmelidir

2. Dil Değişiminde Sayfa Elementlerinin Doğru Güncellenmesi Testi
Senaryo: Dil değiştirildiğinde sayfa içeriği güncellenmelidir
Given Kullanıcı Baykartech sitesinde belirli bir dilde bulunmaktadır
When Kullanıcı site dilini farklı bir dile değiştirir
Then Sayfa başlıkları, menü öğeleri ve içerik yeni dile uygun şekilde güncellenmelidir

3. Statik Dil Listesi Doğrulama Testi
Senaryo: Sağlanan diller statik olarak doğrulanmalıdır
Given Site tarafından sağlanan dillerin listesi biliniyor
When Kullanıcı dil değiştirme menüsünü açar
Then Görüntülenen dil seçenekleri beklenen listeyle eşleşmelidir

Bu üç test, gereksinimi kapsamlı şekilde karşılar. Eğer daha fazla detaylandırma istenirse, mobil uyumluluk, çerezler veya tarayıcı desteği gibi ek senaryolar da eklenebilir. 🚀