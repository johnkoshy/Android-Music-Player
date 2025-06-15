# Android Music Player

A simple Android music player built with Jetpack Compose. Features Play, Pause, and Stop controls to play piano.mp3 from the res/raw/ directory using MediaPlayer.

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)

## Table of Contents
- [Features](#features)
- [Screenshots](#screenshots)
- [Requirements](#requirements)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Features
- **Jetpack Compose UI**: Modern, declarative UI with Play, Pause, and Stop buttons.
- **Media Playback**: Plays piano.mp3 using MediaPlayer.
- **Basic Controls**: Simple Play, Pause, and Stop functionality.

## Screenshots
| Music Player UI |
|-------------|
| ![Music Player UI](screenshots/music_player_ui.png) |

## Requirements
- Android Studio (Meerkat Feature Drop | 2024.3.2 or later)
- Android emulator or device (API 25 or higher)
- Kotlin and Jetpack Compose dependencies configured

## Setup
1. Clone the repository:
   ```bash 
   git clone https://github.com/johnkoshy/Android-Music-Player.git`
2. Open the project in Android Studio.
3. Sync the project with Gradle to install dependencies.
4. Run the app on an emulator or device (API 25+).

## Usage

1. Launch the app on your Android emulator or device.
2. Tap **Play** to start piano.mp3.
3. Tap **Pause** to pause playback.
4. Tap **Stop** to stop playback.

## Project Structure
- **app/src/main/java/**: Contains Kotlin files for the app logic.
- **app/src/main/res/raw/piano.mp3**: Audio file for playback.
- **app/src/main/res/layout/**: Jetpack Compose UI definitions.
- **build.gradle**: Configures dependencies, including Jetpack Compose and MediaPlayer.
- **screenshots/**: Stores app screenshots.

## Contributing
Contributions are welcome! Please submit a pull request or open an issue on GitHub for suggestions or bug reports.

## License
This project is licensed under the [MIT License](LICENSE).