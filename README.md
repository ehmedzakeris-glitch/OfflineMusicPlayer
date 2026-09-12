# Offline Music Player - Android App

YouTube-dan musiqi endirmə (MP3 128K) və oflayn oxutma üçün Android tətbiqəsi.

## Xüsusiyyətlər 🎵

✅ **YouTube Musiqi Endirmə** - YouTube linkinə görə musiqi endir
✅ **MP3 128K Keyfiyyəti** - Optimal faylsaziə
✅ **Oflayn Oxutma** - İnternet olmadan musiqi oxut
✅ **Verilənlər Bazası** - Endirilmiş mahnılar üçün Room Database
✅ **Modern UI** - Jetpack Compose ilə arayüz
✅ **ExoPlayer** - Professional musiqi oynatıcısı

## Texnologiyalar 🛠️

- **Kotlin** - Proqramlaşdırma dili
- **Jetpack Compose** - UI framework
- **Room Database** - Lokal verilənlər bazası
- **ExoPlayer** - Media player
- **yt-dlp** - YouTube downloader
- **Coroutines** - Async operations

## Quraşdırma 📱

### Tələblər:
- Android Studio 4.1+
- Android SDK 24+
- Kotlin 1.9+

### Addımlar:

1. Repository klonlayın:
```bash
git clone https://github.com/ehmedzakeris-glitch/OfflineMusicPlayer.git
cd OfflineMusicPlayer
```

2. Android Studio-da açın

3. Gradle sync edin

4. Emulator və ya cihazda çalışdırın

## APK Yaratma 📦

### Release APK:
```bash
./gradlew clean build
# APK faylı: app/build/outputs/apk/release/app-release.apk
```

### Debug APK:
```bash
./gradlew installDebug
```

## İstifadə 🎶

1. Tətbiqi açın
2. YouTube linkini yapışdırın
3. "Endir" düyməsinə basın
4. Musiqi MP3 128K formatında endirilir
5. Oflayn oxutma siyahısından seçin

## Fayl Strukturu 📂

```
app/
├── src/
│   └── main/
│       ├── java/com/musicplayer/offline/
│       │   ├── database/
│       │   │   ├── MusicDatabase.kt
│       │   │   └── MusicDao.kt
│       │   ├── model/
│       │   │   └── Music.kt
│       │   ├── service/
│       │   │   ├── MusicDownloadService.kt
│       │   │   └── MusicPlayerService.kt
│       │   ├── ui/
│       │   │   ├── MusicItem.kt
│       │   │   ├── NowPlayingScreen.kt
│       │   │   └── theme/
│       │   │       └── Theme.kt
│       │   └── MainActivity.kt
│       └── AndroidManifest.xml
└── build.gradle
```

## Lisenziya 📄

MIT License - Azad istifadə

## Müəllif 👨‍💻

ehmedzakeris-glitch

---

**Hər hansı sualınız üçün issue açın!** 💬