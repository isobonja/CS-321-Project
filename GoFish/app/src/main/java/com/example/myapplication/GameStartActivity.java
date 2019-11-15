package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.lang.Thread;

public class GameStartActivity extends AppCompatActivity {


    protected String userInput;
    protected int themeVal;
    private Game g;
    ImageView userCardImage1;
    ImageView userCardImage2;
    ImageView userCardImage3;
    ImageView userCardImage4;
    ImageView userCardImage5;
    ImageView userCardImage6;
    ImageView userCardImage7;
    ImageView userCardImage8;
    ImageView userCardImage9;
    ImageView userCardImage10;
    ImageView userCardImage11;
    ImageView userCardImage12;
    ImageView userCardImage13;
    ImageView computerCardImage1;
    ImageView computerCardImage2;
    ImageView computerCardImage3;
    ImageView computerCardImage4;
    ImageView computerCardImage5;
    ImageView computerCardImage6;
    ImageView computerCardImage7;
    ImageView computerCardImage8;
    ImageView computerCardImage9;
    ImageView computerCardImage10;
    ImageView computerCardImage11;
    ImageView computerCardImage12;
    ImageView computerCardImage13;
    TextView userScore;
    TextView cpScore;
    TextView centerMessage;
    TextToSpeech voice;
    TextToSpeech voice2;

    private ArrayList<ImageView> handImageUser;
    private ArrayList<ImageView> handImageCp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);

        int mUIFlag = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(mUIFlag);
        g = new Game(themeVal);

        voice = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    voice.setLanguage(Locale.US);
                    voice.setSpeechRate((float) 0.7);
                    voice.setPitch((float) 1.5);
                }
            }
        });

        voice2 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    voice2.setLanguage(Locale.US);
                    voice2.setSpeechRate((float) 0.7);
                    voice2.setPitch((float) 0.2);
                }
            }
        });

        handImageUser = new ArrayList<ImageView>();
        handImageCp = new ArrayList<ImageView>();
        userCardImage1 = (ImageView) findViewById(R.id.userCardImage1);
        userCardImage2 = (ImageView) findViewById(R.id.userCardImage2);
        userCardImage3 = (ImageView) findViewById(R.id.userCardImage3);
        userCardImage4 = (ImageView) findViewById(R.id.userCardImage4);
        userCardImage5 = (ImageView) findViewById(R.id.userCardImage5);
        userCardImage6 = (ImageView) findViewById(R.id.userCardImage6);
        userCardImage7 = (ImageView) findViewById(R.id.userCardImage7);
        userCardImage8 = (ImageView) findViewById(R.id.userCardImage8);
        userCardImage9 = (ImageView) findViewById(R.id.userCardImage9);
        userCardImage10 = (ImageView) findViewById(R.id.userCardImage10);
        userCardImage11 = (ImageView) findViewById(R.id.userCardImage11);
        userCardImage12 = (ImageView) findViewById(R.id.userCardImage12);
        userCardImage13 = (ImageView) findViewById(R.id.userCardImage13);
        handImageUser.add(userCardImage1);
        handImageUser.add(userCardImage2);
        handImageUser.add(userCardImage3);
        handImageUser.add(userCardImage4);
        handImageUser.add(userCardImage5);
        handImageUser.add(userCardImage6);
        handImageUser.add(userCardImage7);
        handImageUser.add(userCardImage8);
        handImageUser.add(userCardImage9);
        handImageUser.add(userCardImage10);
        handImageUser.add(userCardImage11);
        handImageUser.add(userCardImage12);
        handImageUser.add(userCardImage13);
        computerCardImage1 = (ImageView) findViewById(R.id.computerCardImage1);
        computerCardImage2 = (ImageView) findViewById(R.id.computerCardImage2);
        computerCardImage3 = (ImageView) findViewById(R.id.computerCardImage3);
        computerCardImage4 = (ImageView) findViewById(R.id.computerCardImage4);
        computerCardImage5 = (ImageView) findViewById(R.id.computerCardImage5);
        computerCardImage6 = (ImageView) findViewById(R.id.computerCardImage6);
        computerCardImage7 = (ImageView) findViewById(R.id.computerCardImage7);
        computerCardImage8 = (ImageView) findViewById(R.id.computerCardImage8);
        computerCardImage9 = (ImageView) findViewById(R.id.computerCardImage9);
        computerCardImage10 = (ImageView) findViewById(R.id.computerCardImage10);
        computerCardImage11 = (ImageView) findViewById(R.id.computerCardImage11);
        computerCardImage12 = (ImageView) findViewById(R.id.computerCardImage12);
        computerCardImage13 = (ImageView) findViewById(R.id.computerCardImage13);
        handImageCp.add(computerCardImage1);
        handImageCp.add(computerCardImage2);
        handImageCp.add(computerCardImage3);
        handImageCp.add(computerCardImage4);
        handImageCp.add(computerCardImage5);
        handImageCp.add(computerCardImage6);
        handImageCp.add(computerCardImage7);
        handImageCp.add(computerCardImage8);
        handImageCp.add(computerCardImage9);
        handImageCp.add(computerCardImage10);
        handImageCp.add(computerCardImage11);
        handImageCp.add(computerCardImage12);
        handImageCp.add(computerCardImage13);
        userScore = (TextView) findViewById(R.id.userScore);
        cpScore = (TextView) findViewById(R.id.cpScore);
        centerMessage = (TextView) findViewById(R.id.centerMessage);
        centerMessage.setText("Turn!");

        Intent intent = getIntent();
        int theme = intent.getIntExtra(StartPageController.THEME, 0);

        this.themeVal = theme;
        //this.themeVal = Integer.parseInt(theme);

        setHandImage(themeVal);
        g.getUser().checkPairs();
        g.getCp().checkPairs();
        setHandImage(themeVal);
        System.out.println("themeVal: " + themeVal);
    }

    public void full_screen(View view) {
        int mUIFlag = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(mUIFlag);
    }

    public void setHandImage(int themeVal) {
        System.out.println("INSIDE SETHANDIMAGE");
        for (int i = 0; i < handImageCp.size(); i++) {
            handImageCp.get(i).setVisibility(View.INVISIBLE);
        }

        for (int i = 0; i < g.getCpHand().size(); i++) {
            handImageCp.get(i).setVisibility(View.VISIBLE);
        }

        for (int i = 0; i < handImageUser.size(); i++) {
            handImageUser.get(i).setVisibility(View.INVISIBLE);
        }
        int val;
        if (themeVal == 0) {
            for (int i = 0; i < g.getUserHand().size(); i++) {
                handImageUser.get(i).setVisibility(View.VISIBLE);
                val = g.getUserHand().get(i);
                if (val == 1) {
                    handImageUser.get(i).setImageResource(R.drawable.playing_card_1);
                } else if (val == 2) {
                    handImageUser.get(i).setImageResource(R.drawable.playing_card_2);
                } else if (val == 3) {
                    handImageUser.get(i).setImageResource(R.drawable.playing_card_3);
                } else if (val == 4) {
                    handImageUser.get(i).setImageResource(R.drawable.playing_card_4);
                } else if (val == 5) {
                    handImageUser.get(i).setImageResource(R.drawable.playing_card_5);
                } else if (val == 6) {
                    handImageUser.get(i).setImageResource(R.drawable.playing_card_6);
                } else if (val == 7) {
                    handImageUser.get(i).setImageResource(R.drawable.playing_card_7);
                } else if (val == 8) {
                    handImageUser.get(i).setImageResource(R.drawable.playing_card_8);
                } else if (val == 9) {
                    handImageUser.get(i).setImageResource(R.drawable.playing_card_9);
                } else if (val == 10) {
                    handImageUser.get(i).setImageResource(R.drawable.playing_card_10);
                } else if (val == 11) {
                    handImageUser.get(i).setImageResource(R.drawable.playing_card_11);
                } else if (val == 12) {
                    handImageUser.get(i).setImageResource(R.drawable.playing_card_12);
                } else if (val == 13) {
                    handImageUser.get(i).setImageResource(R.drawable.playing_card_13);
                }
            }
        }
        if (themeVal == 2) {
            for (int i = 0; i < g.getUserHand().size(); i++) {
                handImageUser.get(i).setVisibility(View.VISIBLE);
                val = g.getUserHand().get(i);
                if (val == 1) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_1);
                } else if (val == 2) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_2);
                } else if (val == 3) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_3);
                } else if (val == 4) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_4);
                } else if (val == 5) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_5);
                } else if (val == 6) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_6);
                } else if (val == 7) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_7);
                } else if (val == 8) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_8);
                } else if (val == 9) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_9);
                } else if (val == 10) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_10);
                } else if (val == 11) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_11);
                } else if (val == 12) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_12);
                } else if (val == 13) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_13);
                }
            }
        }

        userScore.setText("" + g.getUser().

                getScore());
        cpScore.setText("" + g.getCp().

                getScore());

    }

    public static Integer validColor(String userInput) {
        Integer value = 0;
        if (userInput.contains("red")) {
            return 1;
        } else if (userInput.contains("orange")) {
            return 2;
        } else if (userInput.contains("yellow")) {
            return 3;
        } else if (userInput.contains("green")) {
            return 4;
        } else if (userInput.contains("blue")) {
            return 5;
        } else if (userInput.contains("purple") || userInput.contains("violet")) {
            return 6;
        } else if (userInput.contains("pink")) {
            return 7;
        } else if (userInput.contains("black")) {
            return 8;
        } else if (userInput.contains("white")) {
            return 9;
        } else if (userInput.contains("gray") || userInput.contains("grey")) {
            return 10;
        } else if (userInput.contains("brown")) {
            return 11;
        } else if (userInput.contains("rainbow")) {
            return 12;
        } else if (userInput.contains("beige") || userInput.contains("tan")) {
            return 13;
        } else {
            return 0;
        }
    }

    public static Integer validOriginal(String userInput) {
        Integer value = 0;
        if (userInput.contains("ace")) {
            return 1;
        } else if (userInput.contains("2") || userInput.contains("two")) {
            return 2;
        } else if (userInput.contains("3") || userInput.contains("three")) {
            return 3;
        } else if (userInput.contains("4") || userInput.contains("four")) {
            return 4;
        } else if (userInput.contains("5") || userInput.contains("five")) {
            return 5;
        } else if (userInput.contains("6") || userInput.contains("six")) {
            return 6;
        } else if (userInput.contains("7") || userInput.contains("seven")) {
            return 7;
        } else if (userInput.contains("8") || userInput.contains("eight")) {
            return 8;
        } else if (userInput.contains("9") || userInput.contains("nine")) {
            return 9;
        } else if (userInput.contains("10") || userInput.contains("ten")) {
            return 10;
        } else if (userInput.contains("jack")) {
            return 11;
        } else if (userInput.contains("queen")) {
            return 12;
        } else if (userInput.contains("king")) {
            return 13;
        } else {
            return value;
        }
    }

    public boolean checkIfUserHasCard(Integer value) {
        if (g.getUserHand().contains(value) == false) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkIfGameOver() {
        if (this.g.getUser().getSizeHand() == 0 || this.g.getCp().getSizeHand() == 0 || this.g.getDeck().size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void getSpeechInputInGame(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            if (themeVal == 0) {
                startActivityForResult(intent, 13);
            }
            if (themeVal == 1) {
                startActivityForResult(intent, 14);
            }
            if (themeVal == 2) {
                startActivityForResult(intent, 15);
            }
            if (themeVal == 3) {
                startActivityForResult(intent, 16);

            }
        } else {
            Toast.makeText(this, "Your Device Doesn't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 13:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    userInput = result.get(0);
                    userInput = userInput.toLowerCase();

                    if (userInput.contains("exit")) {
                        this.finish();
                    } else if (userInput.contains("do you have")) {

                        int value = validOriginal(userInput);
                        System.out.println("value: " + value);
                        boolean hasCard = checkIfUserHasCard(value);
                        if (value == 0) {
                            Toast.makeText(this, "Please ask in the following format: 'Do you have a nine?'", Toast.LENGTH_LONG).show();
                        } else if (hasCard == false) {
                            Toast.makeText(this, "Please only ask for cards in your hand!'", Toast.LENGTH_LONG).show();
                        } else {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            this.g.getUser().getCard(this.g, this.g.getCp(), value);
                            if (g.getUser().getGoFish()) {
                                voice.speak("GO FISH!", TextToSpeech.QUEUE_FLUSH, null);
                            } else {
                                voice.speak("I have it", TextToSpeech.QUEUE_FLUSH, null);

                            }
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            setHandImage(themeVal);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            this.g.getUser().checkPairs();
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            setHandImage(themeVal);
                            //handImageUser.get(g.getUserHand().size()-1).setVisibility(View.VISIBLE);
                            System.out.println("hand size user: " + this.g.getUser().getSizeHand() + "\n hand size cp: " + this.g.getCp().getSizeHand() +
                                    "\n user score: " + this.g.getUser().getScore() + "\n cp score: " + this.g.getCp().getScore());

                            if (checkIfGameOver()) {
                                //FIXME
                            }
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            while (g.getTurn() == false) {
                                voice.speak("My turn", TextToSpeech.QUEUE_FLUSH, null);
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                int c = this.g.getCp().getCard(this.g, this.g.getUser());
                                voice.speak("I asked for a " + c, TextToSpeech.QUEUE_FLUSH, null);
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                if (g.getCp().getGoFish()) {
                                    voice2.speak("GO FISH!", TextToSpeech.QUEUE_FLUSH, null);
                                }
                                this.g.getCp().checkPairs();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                setHandImage(themeVal);
                            }
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            if (checkIfGameOver()) {
                                //FIXME
                            }
                        }
                    } else {
                        Toast.makeText(this, "Please ask for a card you have or say 'Exit' to exit the game", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case 15:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    userInput = result.get(0);
                    userInput = userInput.toLowerCase();

                    if (userInput.contains("exit")) {
                        this.finish();
                    } else if (userInput.contains("do you have")) {
                        int value = validColor(userInput);
                        System.out.println("value: " + value);
                        boolean hasCard = checkIfUserHasCard(value);
                        if (value == 0) {
                            Toast.makeText(this, "Please ask in the following format: 'Do you have a red?'", Toast.LENGTH_LONG).show();
                        } else if (hasCard == false) {
                            Toast.makeText(this, "Please only ask for cards in your hand!'", Toast.LENGTH_LONG).show();
                        } else {
                            System.out.println("hand size user: " + this.g.getUser().getSizeHand() + "\n hand size cp: " + this.g.getCp().getSizeHand() +
                                    "\n user score: " + this.g.getUser().getScore() + "\n cp score: " + this.g.getCp().getScore());
                            this.g.getUser().getCard(this.g, this.g.getCp(), value);
                            this.g.getUser().checkPairs();
                            setHandImage(themeVal);
                            System.out.println("hand size user: " + this.g.getUser().getSizeHand() + "\n hand size cp: " + this.g.getCp().getSizeHand() +
                                    "\n user score: " + this.g.getUser().getScore() + "\n cp score: " + this.g.getCp().getScore());

                            if (checkIfGameOver()) {
                                //FIXME
                            }

                            if (g.getTurn() == false) {
                                centerMessage.setText("Computer Turn");

                                this.g.getCp().getCard(this.g, this.g.getUser());
                                this.g.getCp().checkPairs();

                                setHandImage(themeVal);
                            }
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            centerMessage.setText("Your Turn");

                            if (checkIfGameOver()) {
                                //FIXME
                            }
                        }
                    } else {
                        Toast.makeText(this, "Please ask for a card you have or say 'Exit' to exit the game", Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    private void originalConversion() {

    }

    private void animalsConversion() {

    }

    private void colorsConversion() {

    }

    private void fruitsConversion() {

    }

}