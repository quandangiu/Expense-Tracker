# 💰 ExpenseTracker

A modern, offline-first Personal Expense Tracker Android app built with Kotlin, Jetpack Compose, and Room database. The app follows the MVVM architecture pattern and features a premium Material3 design with smooth animations, category-based filtering, and visual spending summaries.

![Uploading Screenshot 2026-04-01 110817.png…]()

## ✨ Features

| Feature | Description |
|---------|-------------|
| ➕ **Add Expense** | Quick expense entry with amount, category, title, note, and date |
| 📋 **Expense List** | View all expenses grouped by date with "Today"/"Yesterday" headers |
| 🏷️ **Category Filter** | Filter expenses by 7 categories using scrollable chips |
| 📊 **Summary Dashboard** | Visual spending breakdown with animated bar charts |
| 🗑️ **Swipe to Delete** | Swipe left on any expense card to delete it |
| 🌙 **Dark Mode** | Full dark mode support following system theme |
| 💾 **Offline Storage** | All data stored locally with Room database |
| 🎨 **Premium UI** | Gradient cards, smooth transitions, and micro-animations |

## 🛠️ Tech Stack

| Technology | Purpose |
|-----------|---------|
| **Kotlin** | Primary programming language |
| **Jetpack Compose** | Modern declarative UI toolkit |
| **Material3** | Design system with dynamic theming |
| **Room** | Local SQLite database with type-safe queries |
| **ViewModel + StateFlow** | Reactive state management |
| **Coroutines** | Asynchronous programming |
| **Navigation Compose** | Screen-to-screen navigation with transitions |
| **KSP** | Kotlin Symbol Processing for Room code generation |

## 🏗️ Architecture Overview (MVVM)

```
┌─────────────────────────────────────────────────┐
│                    UI Layer                      │
│  ┌───────────┐ ┌──────────────┐ ┌─────────────┐│
│  │HomeScreen │ │AddExpense    │ │SummaryScreen││
│  │           │ │Screen        │ │             ││
│  └─────┬─────┘ └──────┬───────┘ └──────┬──────┘│
│        │               │                │       │
│        └───────────────┼────────────────┘       │
│                        ▼                        │
│              ┌─────────────────┐                │
│              │ ExpenseViewModel│                │
│              │  (StateFlow)    │                │
│              └────────┬────────┘                │
├───────────────────────┼─────────────────────────┤
│                Data Layer                       │
│              ┌────────▼────────┐                │
│              │ExpenseRepository│                │
│              └────────┬────────┘                │
│              ┌────────▼────────┐                │
│              │  ExpenseDao     │                │
│              │  (Room)         │                │
│              └────────┬────────┘                │
│              ┌────────▼────────┐                │
│              │ ExpenseDatabase │                │
│              │ (SQLite)        │                │
│              └─────────────────┘                │
└─────────────────────────────────────────────────┘
```

## 📦 Data Model

### Expense Entity

| Field | Type | Description |
|-------|------|-------------|
| `id` | `Int` | Primary key, auto-generated |
| `title` | `String` | Expense description |
| `amount` | `Double` | Amount spent |
| `category` | `String` | Category name (FOOD, TRANSPORT, etc.) |
| `note` | `String` | Optional note (default: "") |
| `date` | `Long` | Timestamp in milliseconds |

### Category Enum

| Category | Display Name | Color |
|----------|-------------|-------|
| FOOD | Food 🍜 | #FF6B6B |
| TRANSPORT | Transport 🚗 | #4ECDC4 |
| SHOPPING | Shopping 🛍 | #FFD93D |
| ENTERTAINMENT | Entertainment 🎮 | #A78BFA |
| HEALTH | Health 💊 | #F472B6 |
| EDUCATION | Education 📚 | #60A5FA |
| OTHER | Other 📦 | #9CA3AF |

## 🔌 API Design (Internal — Room DAO)

| Method | Return Type | Description |
|--------|-------------|-------------|
| `insertExpense(expense)` | `suspend` | Insert or replace an expense |
| `deleteExpense(expense)` | `suspend` | Delete an expense |
| `updateExpense(expense)` | `suspend` | Update an existing expense |
| `getAllExpenses()` | `Flow<List<Expense>>` | Get all expenses, sorted by date DESC |
| `getExpensesByCategory(cat)` | `Flow<List<Expense>>` | Filter expenses by category |
| `getTotalAmount()` | `Flow<Double?>` | Sum of all expense amounts |
| `getCategorySummary()` | `Flow<List<CategorySummary>>` | Grouped totals per category |

## 🚀 How to Run

### ✅ Prerequisites

| Requirement | Version | Download |
|-------------|---------|----------|
| Android Studio | Ladybug 2024.2.1 or later | [Download](https://developer.android.com/studio) |
| JDK | 11 or higher | Bundled with Android Studio |
| Android SDK | API 36 (Android 16.0 "Baklava") | Install via SDK Manager |
| Android Emulator or Device | API 36+ | Setup below |

---

### 📥 Step 1 — Get the Source Code

**Option A: Clone with Git**
```bash
git clone <repository-url>
cd ExpenseTracker
```

**Option B: Download ZIP**
- Download the ZIP from the repository
- Extract to any folder
- Remember the folder path

---

### 📂 Step 2 — Open in Android Studio

1. Launch **Android Studio**
2. On the Welcome screen, click **"Open"**
   (or go to **File → Open...** if already inside a project)
3. Navigate to the **ExpenseTracker** folder
4. Click **"OK"** / **"Open"**
5. Wait for the project to index (bottom status bar shows progress)

---

### 🔧 Step 3 — Sync Gradle

1. Android Studio will show a banner:
   **"Gradle files have changed since last project sync"**
2. Click **"Sync Now"** (top right of banner)
3. Wait for sync to complete — check the **Build** tab at the bottom
4. ✅ Success: "BUILD SUCCESSFUL" message
5. ❌ If sync fails: Go to **File → Invalidate Caches → Invalidate and Restart**

---

### 📱 Step 4A — Run on Emulator (Recommended)

1. Go to **Device Manager** (right sidebar icon or **View → Tool Windows → Device Manager**)
2. Click **"+"** → **"Create Virtual Device"**
3. Choose a phone (e.g. **Pixel 8**) → click Next
4. Select system image: **"Baklava" (API 36)** → Download if needed → Next
5. Click **Finish**
6. Click ▶️ **Play** button next to your new emulator to start it
7. Once emulator boots, click the green ▶️ **Run** button in Android Studio toolbar
   (or press **Shift + F10** on Windows / **Control + R** on Mac)
8. Select your emulator → OK
9. App will install and launch automatically

---

### 📲 Step 4B — Run on Physical Device

1. On your Android phone, go to **Settings → About Phone**
2. Tap **"Build Number"** 7 times to enable Developer Options
3. Go to **Settings → Developer Options**
4. Enable **"USB Debugging"**
5. Connect phone to computer via USB cable
6. On phone: tap **"Allow"** when asked to trust this computer
7. In Android Studio, select your device from the device dropdown (top toolbar)
8. Click ▶️ **Run** (or **Shift + F10** / **Control + R**)
9. App installs and launches on your phone

> ⚠️ Note: Physical device must run Android 16 (API 36) or higher due to minSdk=36

---

### 📦 Step 5 — Build APK (Optional)

To generate a standalone APK file:

**Option A: Via Android Studio**
1. Go to **Build → Build Bundle(s) / APK(s) → Build APK(s)**
2. Wait for build to complete
3. Click **"locate"** in the notification to find the APK

**Option B: Via Terminal**
```bash
./gradlew assembleDebug
```

APK location: `app/build/outputs/apk/debug/app-debug.apk`

---

### ❓ Troubleshooting

| Problem | Solution |
|---------|----------|
| Gradle sync fails | File → Invalidate Caches → Restart |
| SDK not found | Open SDK Manager, install API 36 |
| Emulator won't start | Increase RAM in AVD config, enable hardware acceleration |
| App crashes on launch | Check Logcat tab for errors |
| "minSdk" device error | Use device/emulator with Android 16 (API 36+) |

## 📸 Screenshots

| Home Screen | Add Expense | Summary |
|:-----------:|:-----------:|:-------:|
| *Gradient header with total spent, category filters, expense list* | *Amount hero display, category grid, form fields* | *Overview cards, bar chart, category breakdown* |

## 📁 Project Structure

```
app/src/main/java/com/example/expensetracker/
├── MainActivity.kt
├── data/
│   ├── model/
│   │   ├── Expense.kt          # Room entity
│   │   └── Category.kt         # Category enum
│   ├── local/
│   │   ├── ExpenseDao.kt       # Data Access Object
│   │   └── ExpenseDatabase.kt  # Room database
│   └── repository/
│       └── ExpenseRepository.kt
├── ui/
│   ├── screen/
│   │   ├── HomeScreen.kt       # Main expense list
│   │   ├── AddExpenseScreen.kt # Add new expense
│   │   └── SummaryScreen.kt    # Spending summary
│   ├── viewmodel/
│   │   ├── ExpenseViewModel.kt
│   │   └── ExpenseViewModelFactory.kt
│   └── theme/
│       ├── Color.kt
│       ├── Type.kt
│       └── Theme.kt
├── navigation/
│   ├── Screen.kt
│   └── ExpenseNavGraph.kt
└── util/
    └── FormatUtils.kt
```

## 📄 License

This project is for educational purposes as part of a Mobile Development course assignment.
