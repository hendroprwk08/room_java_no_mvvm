# Room Database Java Application (No MVVM)

Aplikasi Android yang mendemonstrasikan penggunaan Room Database untuk local data persistence tanpa menggunakan MVVM architecture pattern.

## 📱 Deskripsi Proyek

Proyek ini adalah implementasi aplikasi Android yang menggunakan **Room Database** untuk menyimpan dan mengelola data secara lokal. Aplikasi ini dikembangkan dengan pendekatan tradisional tanpa mengikuti MVVM (Model-View-ViewModel) architecture, sehingga lebih fokus pada demonstrasi penggunaan Room Database dalam konteks yang sederhana dan mudah dipahami.

### Fitur Utama

- ✅ **Room Database Integration** - Menggunakan Room persistence library untuk CRUD operations
- ✅ **Local Data Storage** - Menyimpan data secara lokal di device
- ✅ **Database Operations** - Create, Read, Update, Delete (CRUD) data
- ✅ **Simple Architecture** - Implementasi tanpa MVVM untuk pembelajaran yang lebih mudah
- ✅ **User Interface** - Interface yang intuitif untuk interaksi dengan database

## 🛠️ Teknologi & Tools

| Komponen | Deskripsi |
|----------|-----------|
| **Language** | Java |
| **Database** | Room Database |
| **Platform** | Android |
| **Architecture** | Traditional MVC (No MVVM) |

## 📋 Prasyarat

Sebelum menjalankan aplikasi ini, pastikan Anda memiliki:

- Android Studio (versi terbaru)
- Java Development Kit (JDK 8 atau lebih tinggi)
- Android SDK minimum level 21
- Gradle build tools

## 🚀 Cara Menggunakan

### 1. Clone Repository

```bash
git clone https://github.com/hendroprwk08/room_java_no_mvvm.git
cd room_java_no_mvvm
```

### 2. Buka di Android Studio

- Buka Android Studio
- Pilih **File → Open** dan navigasi ke folder proyek
- Tunggu gradle sync selesai

### 3. Jalankan Aplikasi

- Hubungkan device Android atau gunakan emulator
- Klik tombol **Run** atau tekan `Shift + F10`

## 📁 Struktur Proyek

```
room_java_no_mvvm/
├── app/
│   ├── src/main/
│   │   ├── java/
│   │   │   ├── database/
│   │   │   │   ├── AppDatabase.java
│   │   │   │   └── Dao*.java
│   │   │   ├── entities/
│   │   │   │   └── Entity*.java
│   │   │   └── activities/
│   │   │       └── MainActivity.java
│   │   └── res/
│   │       ├── layout/
│   │       ├── values/
│   │       └── drawable/
│   └── build.gradle
├── build.gradle
└── settings.gradle
```

## 💾 Database Schema

Aplikasi ini menggunakan Room Database dengan struktur entitas yang dapat disesuaikan sesuai kebutuhan:

- **Entity Classes** - Mendefinisikan struktur tabel database
- **DAO (Data Access Object)** - Interface untuk CRUD operations
- **AppDatabase** - Abstrak database class

## 🎯 Fitur Utama Aplikasi

1. **Add Data** - Tambah data baru ke database
2. **View Data** - Tampilkan semua data yang tersimpan
3. **Update Data** - Edit data yang sudah ada
4. **Delete Data** - Hapus data dari database
5. **Search Data** - Cari data berdasarkan kriteria tertentu

## 📸 Screenshots

Aplikasi menampilkan interface user-friendly dengan berbagai halaman:
- Halaman utama dengan daftar data
- Form untuk menambah/mengedit data
- Detail view untuk melihat data secara lengkap
- Opsi delete dan update untuk setiap item

## 🔧 Dependencies

Dependencies utama yang digunakan dalam proyek ini:

```gradle
// Room Database
implementation 'androidx.room:room-runtime:2.x.x'
annotationProcessor 'androidx.room:room-compiler:2.x.x'

// AndroidX
implementation 'androidx.appcompat:appcompat:1.x.x'
implementation 'androidx.constraintlayout:constraintlayout:2.x.x'
```

## 📝 Catatan Penting

- Aplikasi ini menggunakan **Local Database** di device
- **Tidak ada koneksi internet** yang diperlukan setelah instalasi
- Data disimpan secara **persistent** sampai dihapus secara manual
- Architecture **tanpa MVVM** untuk kesederhanaan pembelajaran

## 🐛 Troubleshooting

| Masalah | Solusi |
|---------|--------|
| Gradle sync gagal | Pastikan Android SDK dan Build Tools sudah terinstall dengan benar |
| App crash saat launch | Bersihkan build dengan `Build → Clean Project` |
| Database tidak terupdate | Pastikan permission yang diperlukan sudah diberikan |

## 💡 Tips & Best Practices

1. **Backup Data** - Sebelum uninstall aplikasi, backup data penting
2. **Testing** - Gunakan emulator dengan level API yang berbeda untuk testing
3. **Optimization** - Pantau penggunaan memory saat menjalankan query
4. **Error Handling** - Tambahkan try-catch untuk database operations

## 📚 Referensi & Resources

- [Android Room Documentation](https://developer.android.com/training/data-storage/room)
- [Android Developer Guide](https://developer.android.com/guide)
- [SQLite Documentation](https://www.sqlite.org/docs.html)

## 🤝 Kontribusi

Jika Anda ingin berkontribusi pada proyek ini:

1. Fork repository
2. Buat branch feature (`git checkout -b feature/AmazingFeature`)
3. Commit perubahan (`git commit -m 'Add some AmazingFeature'`)
4. Push ke branch (`git push origin feature/AmazingFeature`)
5. Buat Pull Request

## 📄 Lisensi

Proyek ini tersedia tanpa lisensi khusus. Silakan gunakan dan modifikasi sesuai kebutuhan Anda.

## 👤 Author

**hendroprwk08**

- GitHub: [@hendroprwk08](https://github.com/hendroprwk08)
- Repository: [room_java_no_mvvm](https://github.com/hendroprwk08/room_java_no_mvvm)

---

## 📞 Dukungan

Jika Anda mengalami masalah atau memiliki pertanyaan:

1. Cek Issues di repository
2. Buat Issue baru dengan deskripsi yang jelas
3. Lampirkan error log atau screenshot jika diperlukan

---

**Happy Coding! 🚀**

Selamat menggunakan Room Database untuk project Android Anda!
