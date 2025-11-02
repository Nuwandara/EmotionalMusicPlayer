




````markdown
# 🎧 AI Mood-Based Music Player (Architectural Simulation)

This project is a **Java architecture simulation** of an AI-driven Music Player that detects emotions and plays songs matching the user’s mood.  
It demonstrates how advanced **software architecture** can be achieved using **Design Patterns** — even without actual hardware or API integrations.

---

## 🧠 Core Concept

The system simulates how an AI music player would behave:
1. **AI Detector** identifies the user's mood (Happy, Sad, Angry, or Calm).  
2. **Mood Strategy Handler** selects the correct playlist based on the mood.  
3. **Music Player Facade** handles playback controls — play, pause, resume, and stop.  
4. **Adapters** manage different audio file formats (MP3, WAV).  
5. **Observers** keep UI and system components in sync during updates.

---

## 🧱 System Architecture

Although playback and mood detection are simulated, the **architecture is fully modular and realistic**, designed like a real AI music system.

| Layer | Description |
|-------|--------------|
| 🎭 **AI Layer** | Detects the mood (via `FacialMoodDetector`) |
| 🧩 **Strategy Layer** | Chooses mood-based playlists using `MoodStrategyHandler` |
| 🎶 **Playback Layer** | Handles playing, pausing, resuming, and stopping songs |
| 🔁 **Observer Layer** | Updates all components when state changes occur |
| 🎚️ **Adapter Layer** | Integrates multiple audio formats (MP3 / WAV) |
| 🏗️ **Facade Layer** | Simplifies control through a unified interface (`PlayerFacade`) |
| 🔒 **Singleton Layer** | Ensures one instance of `MusicPlayer` is active |

> ✅ The design allows easy integration of **real AI APIs (like OpenCV or DeepLearning4J)** or **sound engines** in the future without altering the core architecture.

---

## 🧩 Design Patterns Used

| Pattern | Purpose |
|----------|----------|
| **Strategy Pattern** | Selects playlist logic based on detected mood |
| **Adapter Pattern** | Converts multiple file types into a unified playback format |
| **Observer Pattern** | Updates UI and system states dynamically |
| **Facade Pattern** | Provides a simple unified interface for the entire player |
| **Singleton Pattern** | Controls the creation of a single global `MusicPlayer` instance |

---

## 🧪 Simulation Example

```text
 ===================SIMULATE MOOD DETECTION=======================

AI detected mood : HAPPYMOOD
-------------------------------------
 File format: Happy [MP3]
Now playing ......................... Happy
[MP3Adapter] Decoding MP3 stream...
[MP3Adapter] Playing MP3 audio: happy.mp3
------------------------------
````

---

## 🎮 Playback Controls

The system simulates real playback behavior:

* ▶️ **Play** – Starts a song
* ⏸️ **Pause** – Temporarily stops playback
* 🔁 **Resume** – Continues the song
* ⏹️ **Stop** – Ends playback and resets player

---

## 🧰 Tech Stack

* **Language:** Java SE
* **IDE:** NetBeans / IntelliJ IDEA
* **Architecture:** Modular Object-Oriented Design
* **Design Patterns:** Strategy, Adapter, Observer, Facade, Singleton

---

## 🧑‍💻 Author

**Nuwandara Abeykoon**
🎓 Java Institute | Software Engineering Student
📍 Sri Lanka

---

## ⭐ GitHub Tagline

> *A simulation of smart music emotion recognition — powered by clean architecture and strong design principles.*

```


