package de.ur.mi.android.demos.courseguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private int maxCourseWeek;
    private String[] lessonTitles;
    private String[] dateOfStreams;
    private String[] tutorialTitle;
    private String[] dateOfFirstTutorial;
    private int displayedCourseWeekIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadResources();
    }

    private void loadResources() {
        lessonTitles = getResources().getStringArray(R.array.lesson_titles);
        dateOfStreams = getResources().getStringArray(R.array.lesson_titles);
        tutorialTitle = getResources().getStringArray(R.array.lesson_titles);
        dateOfFirstTutorial = getResources().getStringArray(R.array.lesson_titles);
        /**
         * Streams und Übungen finden nur dann statt, wenn es auch Vorlesungsinhalte gibt. Die Anzahl
         * der Vorlesungstitel definiert sich, wie viele Kurswochen maximal zu berücksichtigen sind.
         */
        maxCourseWeek = lessonTitles.length;
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
        String currentLessonTitle = lessonTitles[weekIndex];
        String currentStreamDate = dateOfStreams.length > weekIndex ? dateOfStreams[weekIndex] : "";
        String currentTutorialTitle = tutorialTitle.length > weekIndex ? tutorialTitle[weekIndex] : "";
        String currentTutorialDate = dateOfFirstTutorial.length > weekIndex ? dateOfFirstTutorial[weekIndex] : "";
        // @TODO UI mit ausgelesenen Informationen aus dem Array aktualisieren
        displayedCourseWeekIndex = weekIndex;
    }


}