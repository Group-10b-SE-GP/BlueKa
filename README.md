# BlueKa - Android Application
This Android Application allows users to connect to nearby smartphones using the Bluetooth Low Energy (BLE) technology and thereby perform an action in unison. This action involves playing the \Merdeka!" sound snippet in coordination.

## Project Description
The idea of this project is that, as the user moves around, their phone will connect to other phones nearby that have the same app installed. Under certain circumstances an agreement will be reached, and the phones will perform an action together. In this case, the action is to play a sound snippet simultaneously. For example, given that a user has the app installed on their phone, and has it configured to connect to a minimum of four other phones within the range of their bluetooth radio. Once the network of five phones is established, the phones will negotiate a time within a few seconds from the connection and play the Merdeka! chime simultaneously at full volume.

## Aims and Objectives
* Creating an Android App that implements Bluetooth Low Energy teachnology as well as Sound Synchronization feature.
* Developing the mobile application in such a way that it runs without major user intervention. This indicates that the application should primarily run in background.
* Implementation of scan filter that allows a device to detect other smartphones which have the Android application installed.
* Configuration and connection of nearby smartphones which have active Bluetooth.
* Leveraging a technology that allows smartphones within a certain location to band together and perform an action synchronously.
* Handling audio outputs in order to play the sound snippet at maximum volume and reset it back to the original volume.

## User Manual
**Pre-requisite : Android Studio**

### Installation
1. Clone this repository and import into Android Studio.
2. Before running the application on a device, USB debugging must be enabled. On the device, open Settings page, select Developer Options, and then enable USB debugging.
3. Build and run the application on Android Studio.

### Using BlueKa
1. Once the application is launched on the device, the user shall be requested to enable Bluetooth.

2. The user shall then be able to set the number of devices that can participate in the concert.

3. This is followed by pressing on the connect button. If location permission is switched off, then the user shall be requested to enable location.

4. Once the device successfully connects based on the set conditions, the snippet shall be heard and a toast message shall be seen. This operation does not necessarily require the application to be open. This is because once the user presses the connect button,  the device can either scan or advertise, and form a network to play the snippet even when the application is running in background.

5. The user shall also be able to access the settings page. On Settings page, the user shall be able to control the permissions that the application requires as well as gain more information as to why each permission is required..

6. The user can further switch between light and dark mode for the application.

## Developers
