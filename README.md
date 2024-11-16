# QuickAccess Settings App

An Android application designed to provide quick access to system settings using a modern architecture with **NavGraph** and **Fragments** for seamless navigation.

## Features

- **Radio Info**: View detailed device radio information.
- **Enable Developer Mode**: Quickly enable developer options.
- **Manage Application Settings**: Access and manage installed applications.
- **Accessibility Settings**: Modify accessibility features for enhanced usability.
- **Add Account**: Manage user accounts with ease.
- **Search Settings**: Find settings quickly via the built-in search.
- **Device Info**: Access detailed information about the device.
- **User Dictionary**: Manage custom words and shortcuts.

## Architecture

This app utilizes the **Navigation Component** for managing navigation between fragments with a **NavGraph**. The architecture ensures:
- **Single Activity Pattern**: A single `MainActivity` hosts multiple fragments.
- **Navigation Component**: Handles navigation actions and transitions.

## Navigation Flow

1. **HomeFragment**: The starting point displaying a list of available settings.
3. **AboutFragment**: Information about the app, including tips and usage guides.

## Screenshots

### Home Screen
![Home Screen](screenshots/home_screen.png)

### Settings Details
![Settings Details](screenshots/settings_details.png)

*(Ensure your screenshots are stored in a `screenshots` folder in the root directory.)*

## Tech Stack

- **Language**: Java
- **Android SDK**: Minimum API Level 21 (Lollipop)
- **Libraries**:
  - **Navigation Component**: For fragment navigation.
  - **Material Components**: For modern UI design.

## NavGraph Setup

The app uses a NavGraph (`res/navigation/nav_graph.xml`) to define navigation paths between fragments:
- `HomeFragment` (startDestination)
- `AboutFragment`

```xml
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/nav_graph"
    app:startDestination="@id/homeFragment">

    <fragment
        android:id="@+id/homeFragment"
        android:name="com.example.quickaccess.HomeFragment"
        android:label="Home" >
        <action
            android:id="@+id/action_homeFragment_to_homeFragment"
            app:destination="@id/homeFragment" />
    </fragment>

    <fragment
        android:id="@+id/aboutFragment"
        android:name="com.example.quickaccess.AboutFragment"
        android:label="About" />
</navigation>
