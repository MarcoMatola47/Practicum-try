# MyApplicationTry

Welcome to MyApplicationTry, an Android application designed to help users track and manage their screen time activities. This README provides instructions on how to set up, use, and understand the functionality of the application.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
  - [MainActivity](#mainactivity)
  - [MainActivity2](#mainactivity2)
  - [MainActivity3](#mainactivity3)
- [Contributing](#contributing)
- [License](#license)

## Introduction

MyApplicationTry is a simple Android application that allows users to log and view their daily screen time activities. The purpose of the app is to help users keep track of how much time they spend on their devices each day, split into morning and afternoon sessions. Users can also add notes for each day to provide context or additional details about their screen time usage.

## Features

- **MainActivity**: A welcome screen with navigation to the screen time logging screen.
- **MainActivity2**: Input fields for date, morning screen time, afternoon screen time, and notes with options to save or clear inputs.
- **MainActivity3**: Displays the saved screen time details.

## Installation

To set up MyApplicationTry on your local machine:

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/MyApplicationTry.git
   ```

2. Open the project in Android Studio.

3. Build the project and run it on an Android emulator or a physical device.

## Usage

### MainActivity

The main entry point of the application, which displays a welcome screen.

- **UI Elements**:
  - `TextView`: Displays a welcome message.
  - `Button`: Navigates to `MainActivity2`.
  - `ImageView`: Displays an image (can be customized).

### MainActivity2

Allows users to input their daily screen time details, including date, morning screen time, afternoon screen time, and notes.

- **UI Elements**:
  - `EditText`: Input fields for date, morning screen time, afternoon screen time, and notes.
  - `Button`: Save the input, clear the input fields, and navigate to `MainActivity3`.
  - `TextView`: Displays messages to the user.

#### Explanation:

1. **UI Elements Initialization**:
   ```kotlin
   eDate = findViewById(R.id.eDate)
   eMorning = findViewById(R.id.eMorning)
   eAfternoon = findViewById(R.id.eAfternoon)
   eNotes = findViewById(R.id.eNotes)
   saveButton = findViewById(R.id.saveButton)
   cleanButton = findViewById(R.id.cleanButton)
   nextButton = findViewById(R.id.nextButton)
   tvMessage = findViewById(R.id.tvMessage)
   ```
   Initializes the UI elements by finding them in the layout.

2. **Clear Button**:
   ```kotlin
   cleanButton.setOnClickListener {
       eDate.setText("")
       eMorning.setText("")
       eAfternoon.setText("")
       eNotes.setText("")
   }
   ```
   Clears all input fields when the "Clean" button is clicked.

3. **Save Button**:
   ```kotlin
   saveButton.setOnClickListener {
       val screenTimeDate = eDate.text.toString()
       val screenTimeMorning = eMorning.text.toString()
       val screenTimeAfternoon = eAfternoon.text.toString()
       val screenTimeNote = eNotes.text.toString()

       if (screenTimeDate.isNotEmpty() && screenTimeMorning.isNotEmpty() && screenTimeAfternoon.isNotEmpty()) {
           try {
               dateArray.add(screenTimeDate)
               morningArrayTime.add(screenTimeMorning.toFloat())
               afternoonArrayTime.add(screenTimeAfternoon.toFloat())
               notesArray.add(screenTimeNote)
               eDate.text.clear()
               eMorning.text.clear()
               eAfternoon.text.clear()
               eNotes.text.clear()
               tvMessage.text = "Data saved successfully"
           } catch (e: NumberFormatException) {
               tvMessage.text = "Please enter a valid number"
           }
       } else {
           tvMessage.text = "Input cannot be empty"
       }
   }
   ```
   Saves the input data into corresponding lists if the fields are not empty and the numbers are valid.

4. **Next Button**:
   ```kotlin
   nextButton.setOnClickListener {
       val intent = Intent(this, MainActivity3::class.java)
       intent.putExtra("dateArray", dateArray.toTypedArray())
       intent.putExtra("morningArrayTime", morningArrayTime.toFloatArray())
       intent.putExtra("afternoonArrayTime", afternoonArrayTime.toFloatArray())
       intent.putExtra("notesArray", notesArray.toTypedArray())
       startActivity(intent)
   }
   ```
   Navigates to `MainActivity3` and passes the collected data through the intent.

### MainActivity3

Displays the saved screen time details.

- **UI Elements**:
  - `TextView`: Displays the saved dates, morning screen time, afternoon screen time, and notes.
  - `Button`: Returns to the previous screen.

#### Explanation:

1. **UI Elements Initialization**:
   ```kotlin
   textView2 = findViewById(R.id.textView2)
   textView3 = findViewById(R.id.textView3)
   textView4 = findViewById(R.id.textView4)
   textView5 = findViewById(R.id.textView5)
   button3 = findViewById(R.id.button3)
   ```
   Initializes the UI elements by finding them in the layout.

2. **Retrieve Data from Intent**:
   ```kotlin
   val dateArray = intent.getStringArrayExtra("dateArray")?.toList() ?: emptyList()
   val morningArrayTime = intent.getFloatArrayExtra("morningArrayTime")?.toList() ?: emptyList()
   val afternoonArrayTime = intent.getFloatArrayExtra("afternoonArrayTime")?.toList() ?: emptyList()
   val noteArray = intent.getStringArrayExtra("notesArray")?.toList() ?: emptyList()
   ```
   Retrieves the data passed from `MainActivity2` through the intent.

3. **Display Data**:
   ```kotlin
   val dated = StringBuilder()
   for ((index, date) in dateArray.withIndex()) {
       dated.append("Day $index: $date \n")
   }
   val hoursAM = StringBuilder()
   for ((index, time) in morningArrayTime.withIndex()) {
       hoursAM.append("Morning $index: $time \n")
   }
   val hoursPM = StringBuilder()
   for ((index, time) in afternoonArrayTime.withIndex()) {
       hoursPM.append("Afternoon $index: $time \n")
   }
   val noted = StringBuilder()
   for ((index, note) in noteArray.withIndex()) {
       noted.append("Note $index: $note \n")
   }

   textView2.text = dated.toString()
   textView3.text = hoursAM.toString()
   textView4.text = hoursPM.toString()
   textView5.text = noted.toString()
   ```
   Formats and displays the data in the text views.

4. **Finish Button**:
   ```kotlin
   button3.setOnClickListener {
       finish()
   }
   ```
   Finishes the activity and returns to the previous screen when the "Finish" button is clicked.

## Contributing

We welcome contributions to MyApplicationTry! To contribute:

1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Make your changes.
4. Submit a pull request with a detailed description of your changes.

For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

Enjoy using MyApplicationTry! If you have any questions or feedback, feel free to reach out.
