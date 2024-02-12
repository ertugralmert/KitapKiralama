  
    Description:
    -> Database olmadığından dolayı ve projenin testinin sağlıklı yapılabilmesi için Runner Class'ında
        GUI oluşturuldu bu sayede çıkış yapmadığınız sürece GUI de gösterilen işlemleri yapabilir ve test edebilirsiniz
    -> Polimorphism yapabilmek adına Inheritance kurallarına pek uyulmadı, ancak düzeltilebilir.
    -> Encapsulation, static, final, interface kavramları kullanıldı.
    -> interface, extends yapabilmek adına nesne tanımlaması yapabilmek için farklı class'larda <T entity> kavramı öğrenildi
    -> Kendim test sırasında Runner kısmında hata aldığımda bunu sürekli döngüde tutmak adına try catch konusu araştırıldı
    -> scanner.next() -> bir sonraki satıra geçiş öğrenildi
    -> String Builder ile alınan listeyi String'e dönüştürme yapıldı
    -> return sırasında tenary kullanıldı
    ->
    -> Bilgilendirme: Kiralama Hakkında
    ->> Kasiyer Id'si olmadan kiralama yapamazsınız
    ->> Kasiyer mevcut ancak durumu PASIF ise kiralama işlemine geçilemez!
    ->> Kiralama sırasında müşterinin mevcutluğu TC NO ile kontrol edilir.
            tc numarasına sahip müşteri varsa kiralama otomatik olarak yapılır.
            yoksa o sırada yeni bir müşteri eklemesi yapılır ve kiralaam işlemine geçilir.
    ->> Kiralama yapabilmek için Kitap Listesinde kitap olmalıdır.
    ->> Kiralanan kitabı İade edebilmek için kiralanan kitabın ID'sini kullanmak gerekir.
    ->> Iade edilen kitap tekrardan kiralanabilir.

     
