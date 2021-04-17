package de.ur.mi.android.demos.courseguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int maxCourseWeek;
    private String[] lessonTitles;
    private String[] dateOfStreams;
    private String[] tutorialTitle;
    private String[] dateOfFirstTutorial;
    private int displayedCourseWeekIndex;

    private TextView currentWeekIndex;
    private TextView currentLessonTitle;
    private TextView currentTutorialTitle;
    private TextView currentDateOfStream;
    private TextView currentDateOfTutorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadResources();
        initUI();
        renderCourseWeek(1);
    }

    private void loadResources() {
        lessonTitles = getResources().getStringArray(R.array.lesson_titles);
        dateOfStreams = getResources().getStringArray(R.array.date_of_stream);
        tutorialTitle = getResources().getStringArray(R.array.tutorial_titles);
        dateOfFirstTutorial = getResources().getStringArray(R.array.date_of_first_tutorial);
        /**
         * Streams und Übungen finden nur dann statt, wenn es auch Vorlesungsinhalte gibt. Die Anzahl
         * der Vorlesungstitel definiert sich, wie viele Kurswochen maximal zu berücksichtigen sind.
         */
        maxCourseWeek = lessonTitles.length;
    }

    private void initUI() {
        currentWeekIndex = findViewById(R.id.currentWeekText);
        currentWeekIndex = findViewById(R.id.currentWeekText);
        currentLessonTitle = findViewById(R.id.currentLessonTitleText);
        currentTutorialTitle = findViewById(R.id.titleOfTutorialForCurrentLessonText);
        currentDateOfStream = findViewById(R.id.currentDateOfStreamText);
        currentDateOfTutorial = findViewById(R.id.dateOfFirstTutorialForCurrentLessonText);
        Button selectPreviousCourseWeek = findViewById(R.id.selectPreviousWeekButton);
        Button selectNextCourseWeek = findViewById(R.id.selectNextWeekButton);
        selectPreviousCourseWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPreviousCourseWeek();
            }
        });
        selectNextCourseWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectNextCourseWeek();
            }
        });
    }

    private void selectNextCourseWeek() {
        if (displayedCourseWeekIndex == maxCourseWeek) {
            return;
        }
        renderCourseWeek(displayedCourseWeekIndex + 1);
    }

    private void selectPreviousCourseWeek() {
        if (displayedCourseWeekIndex == 1) {
            return;
        }
        renderCourseWeek(displayedCourseWeekIndex - 1);
    }

    private void renderCourseWeek(int weekIndex) {
        int arrayIndex = weekIndex-1;
        String currentLessonTitleValue = lessonTitles[arrayIndex];
        String currentStreamDateValue = dateOfStreams.length > weekIndex ? dateOfStreams[arrayIndex] : "";
        String currentTutorialTitleValue = tutorialTitle.length > weekIndex ? tutorialTitle[arrayIndex] : "";
        String currentTutorialDateValue = dateOfFirstTutorial.length > weekIndex ? dateOfFirstTutorial[arrayIndex] : "";
        currentWeekIndex.setText(String.valueOf(weekIndex));
        currentLessonTitle.setText(currentLessonTitleValue);
        currentTutorialTitle.setText(currentTutorialTitleValue);
        currentDateOfStream.setText(currentStreamDateValue);
        currentDateOfTutorial.setText(currentTutorialDateValue);
        displayedCourseWeekIndex = weekIndex;
    }


}