# Angular Blog Management Projesi

Bu proje, Angular kullanarak geliştirdiğim bir blog yönetim uygulamasıdır. Uygulama, kullanıcı listesi, yorum listesi, gönderi listesi ve kategori listesi olmak üzere toplam 4 sayfadan oluşmaktadır. CategoryList haricindeki her sayfada filtreleme özelliği bulunmaktadır. Ayrıca her sayfada sayfa numaralandırması (pagination) vardır. Bu bir blog yönetim sistemi olduğundan ötürü, buradaki kullanıcının (yani adminin) veriler üzerinde tam kontrolü
olması gerektiğini düşündüm. Bu yüzden her bir veriyi düzenlenebilir yaptım.

## Özellikler

Proje aşağıdaki özelliklere sahiptir:

- Kullanıcı Listesi: Tüm kullanıcıları görüntüler ve kullanıcıları düzenlemenize veya silmenize olanak tanır.
- Yorum Listesi: Tüm yorumları görüntüler ve yorumları düzenlemenize veya silmenize olanak tanır.
- Gönderi Listesi: Tüm gönderileri görüntüler ve gönderileri düzenlemenize veya silmenize olanak tanır.
- Kategori Listesi: Tüm kategorileri görüntüler ve kategorileri düzenlemenize veya silmenize olanak tanır.
- Filtreleme: Kullanıcı Listesi, Yorum Listesi ve Gönderi Listesi sayfalarında farklı filtreleme seçenekleri bulunmaktadır.
- Sayfalama: Tüm listeler sayfa numaralandırması (pagination) ile gösterilir.
- Yeni Eleman Ekleme: Tüm listelere yeni kullanıcı, yorum, gönderi veya kategori ekleyebilirsiniz.
- Local Storage kullanılarak oluşturulmuştur. Tüm veriler kullanıcın tarayıcısında saklanır böylece sayfa yenilendiğinde veriler kaybolmaz.
- Yeni kategori eklerken veya var olan bir kategoriyi düzenlerken kategorinin eşsiz olmasının kontrolü yapılmıştır.
- Yeni kullanıcı eklerken veya var olan bir kullanıcıyı düzenlerken kullanıcının eşsiz olmasının kontrolü yapılmıştır.

## Local Storage Hakkında

Local storage bazı verileri kullanıcın bilgisayarında depolamamızı sağlar. Local storage içerisinde beş adet fonksiyon bulundurur.

- `setItem()`: `localStorage`'a key ve value olarak değer eklemenizi sağlar. Not : Local storage sadece string depolayabilir o yüzden başka türde bir veri depolayacaksınız eğer bunu string bir değere dönüştürmeniz lazım. Örneğin;

``` javascript
const userArray = ["Obaseki",25]
localStorage.setItem('user', JSON.stringify(userArray));
```

- `getItem()`: `localStorage`'dan değerleri almamızı sağlar. Argüman olarak key değerini vermeniz gerekir. Not: Gelecek olan değer string şeklinde geleceği için bu değeri ayrıştırmak isteyebilirsiniz. Örnek;

``` javascript
const userData = JSON.parse(localStorage.getItem('user'));
console.log(userData);
```

- `key()`: `localStorage`'dan verilen index'deki key'i getirmemizi sağlar. Örnek;

``` javascript
localStorage.key(index);
```

- `clear()`: `localStorage`'da var olan verileri temizlemenizi sağlar. Örnek;

``` javascript
localStorage.clear();
```

- `remove()`: `localStorage`'da verilen key'li veriyi silmenizi sağlar. Örnek;

``` javascript
localStorage.removeItem('name');
```

## Önem Verilen Konular

Proje geliştirilirken önem verilen bazı konular şunlardır:

- Bileşenlerin Tekrar Kullanılabilirliği: Kod tekrarını önlemek ve bileşenleri tekrar kullanmak için bileşenler düzenli bir şekilde oluşturulmuştur.
- Input-Output Kullanımı: Bileşenler arasında veri iletişimi için @Input ve @Output dekoratörleri kullanılmıştır.
- Servislerin Oluşturulması ve Enjekte Edilmesi: Verilerin yönetimi ve işlemleri için servisler oluşturulmuş ve bu servisler bileşenlere enjekte edilmiştir.
- Binding Kullanımı: ngIf, ngFor gibi direktifler kullanılarak dinamik içerikler oluşturulmuştur.
- Pipe Kullanımı: Sayfalarda istenen verileri düzenlemek için pipe'lar kullanılmıştır.
- Array Fonksiyonları: map, filter, find gibi array fonksiyonları kullanılarak veri manipülasyonu yapılmıştır.

## Nasıl Başlatılır

1. Projeyi klonlayın veya zip olarak indirin.
2. Angular CLI yüklü değilse, yüklemek için aşağıdaki komutu çalıştırın:

```terminal
npm install -g @angular/cli
```

3. Proje dizinine gidin ve bağımlılıkları yüklemek için aşağıdaki komutu çalıştırın:

``` terminal
npm install
```

4. Geliştirme sunucusunu başlatmak için aşağıdaki komutu çalıştırın:

``` terminal
ng serve
```

5. Tarayıcınızda `http://localhost:4200/` adresine giderek uygulamayı görebilirsiniz.

## Katkı

Her türlü katkıya açığım. Büyük değişiklikler için önce bir konu (issue) açmanızı öneririm, böylece tartışabiliriz.
