package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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

    public static final String USER_SCORE = "com.example.myapplication.USER_SCORE";
    public static final String CP_SCORE = "com.example.myapplication.CP_SCORE";

    protected String userInput;
    protected int themeVal;
    protected Game g;
    private Handler h;
    private Handler h2;
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
    //TextToSpeech voice;
    //TextToSpeech voice2;

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

        /*voice = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
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
        });*/

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

        Intent intent = getIntent();
        int theme = intent.getIntExtra(StartPageController.THEME, 0);

        this.themeVal = theme;
        //this.themeVal = Integer.parseInt(theme);

        setHandImage(themeVal);
        centerMessage.setText("Checking for initial pairs...");
        this.h = new Handler(Looper.getMainLooper());
        this.h2 = new Handler(Looper.getMainLooper());
        Runnable r = new Runnable() {
            @Override
            public void run() {
                g.getUser().checkPairs();
                g.getCp().checkPairs();
                setHandImage(themeVal);
                centerMessage.setText("Your turn");
            }
        };
        h.postDelayed(r, 3000);
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
//            if (themeVal == 0) { //original
                startActivityForResult(intent, 13);
//            }
//            if (themeVal == 1) { //animals
//                startActivityForResult(intent, 14);
//            }
//            if (themeVal == 2) { //colors
//                startActivityForResult(intent, 15);
//            }
//            if (themeVal == 3) { //fruits
//                startActivityForResult(intent, 16);
//
//            }
        } else {
            Toast.makeText(this, "Your Device Doesn't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            //original
            case 13:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    this.onActivity(result);
                }
                break;

            //animals
//            case 14:
//                if (resultCode == RESULT_OK && data != null) {
//                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
//                    this.onActivityAnimal(result);
//                }
//                break;
//
//            //colors
//            case 15:
//                if (resultCode == RESULT_OK && data != null) {
//                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
//                    this.onActivityColor(result);
//                }
//                break;
//
//            //fruits
//            case 16:
//                if (resultCode == RESULT_OK && data != null) {
//                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
//                    this.onActivityFruit(result);
//                }
//                break;
        }
    }

    public void onActivity(ArrayList<String> result) {
        userInput = result.get(0);
        userInput = userInput.toLowerCase();

        System.out.println("Beginning: " + this.g.getUserHand().size() + "   " + this.g.getCpHand().size() + "   " + this.g.getDeck().size());

        if (userInput.contains("exit")) {
            this.finish();
        } else if (userInput.contains("do you have")) {
            int value = 0;
            if(themeVal == 0) {
                value = validOriginal(userInput);
            }else if(themeVal == 1){
                value = validAnimal(userInput);
            }else if(themeVal == 2){
                value = validColor(userInput);
            }else if(themeVal == 3){
                value = validFruit(userInput);
            }

            System.out.println("value: " + value);
            boolean hasCard = checkIfUserHasCard(value);
            if (hasCard == false || value == 0) {
                Toast.makeText(this, "Please only ask for cards in your hand!'", Toast.LENGTH_LONG).show();
            } else {
                final User tmpUser = this.g.getUser();
                final Game tmpG = this.g;
                final Computer tmpCp = this.g.getCp();
                final int finalValue = value;
                //if (this.g.getTurn() == true) {

                Runnable r5 = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Before getCard, turn is " + g.getTurn());
                        tmpUser.getCard(g, tmpCp, finalValue);
                        System.out.println("After getCard, turn is " + g.getTurn());

                        setHandImage(themeVal);
                        if (g.getUser().getGoFish()) {
                            centerMessage.setText("GO FISH! You drew a " + textConvert(g.getUserHand().get(g.getUserHand().size() - 1)));
                            //setTurn(false);
                        } else {
                            centerMessage.setText("I have the card! Your turn again!");
                        }
                    }
                };
                System.out.println("Outside of the runnable, turn is " + g.getTurn());
                h.postDelayed(r5, 2000);


                Runnable rUserGoFish = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("rUserGoFish");
                        setHandImage(themeVal);
                    }
                };

                h.postDelayed(rUserGoFish, 1000);

                Runnable r6 = new Runnable() {
                    @Override
                    public void run() {
                        g.getUser().checkPairs();
                        setHandImage(themeVal);
                        //centerMessage.setText("Your Turn");
                        System.out.println("INSIDE: " + tmpG.getUserHand().size() + "   " + tmpG.getCpHand().size() + "   " + tmpG.getDeck().size());
                        if (checkIfGameOver()) {
                            Intent gameOverIntent = new Intent(GameStartActivity.this, GameOverActivity.class);
                            gameOverIntent.putExtra(USER_SCORE, tmpUser.getScore());
                            gameOverIntent.putExtra(CP_SCORE, tmpCp.getScore());
                            startActivity(gameOverIntent);
                        }
                        System.out.println("TURN = " + g.getTurn());
                        System.out.println("r6");
                    }
                };
                h.postDelayed(r6, 2000);
                //handImageUser.get(g.getUserHand().size()-1).setVisibility(View.VISIBLE);
//                            System.out.println("hand size user: " + this.g.getUser().getSizeHand() + "\n hand size cp: " + this.g.getCp().getSizeHand() +
//                                    "\n user score: " + this.g.getUser().getScore() + "\n cp score: " + this.g.getCp().getScore());

                System.out.println(this.g.getUserHand().size() + "   " + this.g.getCpHand().size() + "   " + this.g.getDeck().size());

                //centerMessage.setText("Your Turn");
                System.out.println("TURN IS " + g.getTurn());
                //}

//                if(!this.g.getTurn()){
//                    centerMessage.setText("Computer's Turn");
//                }i

                //COMPUTER'S TURN
                Runnable CP = new Runnable() {
                    @Override
                    public void run() {


                        new Thread() {
                            @Override
                            public void run() {


                                int i = 0;
                                while (g.getTurn() == false) {
                                    System.out.println("INSIDE COMPUTER WHILE LOOP");
                                    if (checkIfGameOver()) {
                                        Intent gameOverIntent = new Intent(GameStartActivity.this, GameOverActivity.class);
                                        gameOverIntent.putExtra(USER_SCORE, tmpG.getUser().getScore());
                                        gameOverIntent.putExtra(CP_SCORE, tmpG.getCp().getScore());
                                        startActivity(gameOverIntent);
                                    }
                                    //centerMessage.setText("Computer's turn");
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    try {
                                        final int c = tmpG.getCp().getCard(tmpG, tmpG.getUser());


                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                System.out.println("r2");
                                                centerMessage.setText("Computer's Turn!\nI asked for a " + textConvert(c));
                                                //setHandImage(themeVal);
                                            }
                                        });
                                        //h2.postDelayed(r2, 3000 + i * 2000);
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    //voice.speak("My turn", TextToSpeech.QUEUE_FLUSH, null);

                                    try {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                System.out.println("r3");
                                                tmpG.getCp().checkPairs();
                                                if (!(tmpG.getCp().getGoFish())) {
                                                    setHandImage(themeVal);
                                                }
                                            }
                                        });

                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    //voice.speak("I asked for a " + c, TextToSpeech.QUEUE_FLUSH, null);

                                    if (g.getCp().getGoFish()) {
                                        try {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    centerMessage.setText("Computer GO FISH!");
                                                    tmpG.getCp().checkPairs();
                                                    System.out.println("r4");
                                                    setHandImage(themeVal);
                                                }
                                            });

                                            Thread.sleep(3000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        try {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    centerMessage.setText("Your turn");
                                                }
                                            });

                                            Thread.sleep(3000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }

                                    System.out.println("In cp: " + tmpG.getUserHand().size() + "   " + tmpG.getCpHand().size() + "   " + tmpG.getDeck().size());

                                    if (checkIfGameOver()) {
                                        Intent gameOverIntent = new Intent(GameStartActivity.this, GameOverActivity.class);
                                        gameOverIntent.putExtra(USER_SCORE, tmpG.getUser().getScore());
                                        gameOverIntent.putExtra(CP_SCORE, tmpG.getCp().getScore());
                                        startActivity(gameOverIntent);
                                    }
                                    i++;
                                }
                            }
                        }.start();
                    }
                };
                h2.postDelayed(CP, 3000);

            }
        } else {
            Toast.makeText(this, "Please ask for a card you have in the following format: 'Do you have a nine?' or say 'Exit' to exit the game", Toast.LENGTH_LONG).show();
        }
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
        //ORIGINAL
        if (themeVal == 0) {
            for (int i = 0; i < g.getUserHand().size(); i++) {
                handImageUser.get(i).setVisibility(View.VISIBLE);
                val = g.getUserHand().get(i);
                if (val == 1) {
                    handImageUser.get(i).setImageResource(R.drawable.playing_card_1); //ace
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
                    handImageUser.get(i).setImageResource(R.drawable.playing_card_11); //jack
                } else if (val == 12) {
                    handImageUser.get(i).setImageResource(R.drawable.playing_card_12); //queen
                } else if (val == 13) {
                    handImageUser.get(i).setImageResource(R.drawable.playing_card_13); //king
                }
            }
        }
        //ANIMALS
        if (themeVal == 1) {
            for (int i = 0; i < g.getUserHand().size(); i++) {
                handImageUser.get(i).setVisibility(View.VISIBLE);
                val = g.getUserHand().get(i);
                if (val == 1) {
                    handImageUser.get(i).setImageResource(R.drawable.animal_card_1); //cat
                } else if (val == 2) {
                    handImageUser.get(i).setImageResource(R.drawable.animal_card_2); //dog
                } else if (val == 3) {
                    handImageUser.get(i).setImageResource(R.drawable.animal_card_3); //snake
                } else if (val == 4) {
                    handImageUser.get(i).setImageResource(R.drawable.animal_card_4); //monkey
                } else if (val == 5) {
                    handImageUser.get(i).setImageResource(R.drawable.animal_card_5); //pig
                } else if (val == 6) {
                    handImageUser.get(i).setImageResource(R.drawable.animal_card_6); //bear
                } else if (val == 7) {
                    handImageUser.get(i).setImageResource(R.drawable.animal_card_7); //shark
                } else if (val == 8) {
                    handImageUser.get(i).setImageResource(R.drawable.animal_card_8); //bird
                } else if (val == 9) {
                    handImageUser.get(i).setImageResource(R.drawable.animal_card_9); //duck
                } else if (val == 10) {
                    handImageUser.get(i).setImageResource(R.drawable.animal_card_10); //spider
                } else if (val == 11) {
                    handImageUser.get(i).setImageResource(R.drawable.animal_card_11); //sheep
                } else if (val == 12) {
                    handImageUser.get(i).setImageResource(R.drawable.animal_card_12); //lizard
                } else if (val == 13) {
                    handImageUser.get(i).setImageResource(R.drawable.animal_card_13); //bee
                }
            }
        }
        //COLORS
        if (themeVal == 2) {
            for (int i = 0; i < g.getUserHand().size(); i++) {
                handImageUser.get(i).setVisibility(View.VISIBLE);
                val = g.getUserHand().get(i);
                if (val == 1) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_1); //red
                } else if (val == 2) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_2); //orange
                } else if (val == 3) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_3); //yellow
                } else if (val == 4) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_4); //green
                } else if (val == 5) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_5); //blue
                } else if (val == 6) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_6); //purple
                } else if (val == 7) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_7); //pink
                } else if (val == 8) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_8); //black
                } else if (val == 9) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_9); //white
                } else if (val == 10) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_10); //gray
                } else if (val == 11) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_11); //brown
                } else if (val == 12) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_12); //rainbow
                } else if (val == 13) {
                    handImageUser.get(i).setImageResource(R.drawable.color_card_13); //tan/beige
                }
            }
        }
        //FRUITS
        if (themeVal == 3) {
            for (int i = 0; i < g.getUserHand().size(); i++) {
                handImageUser.get(i).setVisibility(View.VISIBLE);
                val = g.getUserHand().get(i);
                if (val == 1) {
                    handImageUser.get(i).setImageResource(R.drawable.fruit_card_1); //apple
                } else if (val == 2) {
                    handImageUser.get(i).setImageResource(R.drawable.fruit_card_2); //banana
                } else if (val == 3) {
                    handImageUser.get(i).setImageResource(R.drawable.fruit_card_3); //orange
                } else if (val == 4) {
                    handImageUser.get(i).setImageResource(R.drawable.fruit_card_4); //pear
                } else if (val == 5) {
                    handImageUser.get(i).setImageResource(R.drawable.fruit_card_5); //watermelon
                } else if (val == 6) {
                    handImageUser.get(i).setImageResource(R.drawable.fruit_card_6); //raspberry
                } else if (val == 7) {
                    handImageUser.get(i).setImageResource(R.drawable.fruit_card_7); //blueberry
                } else if (val == 8) {
                    handImageUser.get(i).setImageResource(R.drawable.fruit_card_8); //coconut
                } else if (val == 9) {
                    handImageUser.get(i).setImageResource(R.drawable.fruit_card_9); //pomegranate
                } else if (val == 10) {
                    handImageUser.get(i).setImageResource(R.drawable.fruit_card_10); //pineapple
                } else if (val == 11) {
                    handImageUser.get(i).setImageResource(R.drawable.fruit_card_11); //strawberry
                } else if (val == 12) {
                    handImageUser.get(i).setImageResource(R.drawable.fruit_card_12); //kiwi
                } else if (val == 13) {
                    handImageUser.get(i).setImageResource(R.drawable.fruit_card_13); //cherry
                }
            }
        }

        userScore.setText("" + g.getUser().

                getScore());
        cpScore.setText("" + g.getCp().

                getScore());
    }

    public static Integer validOriginal(String userInput) {
        Integer value = 0;
        if (userInput.equalsIgnoreCase("do you have an ace") || userInput.equalsIgnoreCase("do you have a ace")) {
            return 1;
        } else if (userInput.equalsIgnoreCase("do you have a 2") || userInput.equalsIgnoreCase("do you have a two")) {
            return 2;
        } else if (userInput.equalsIgnoreCase("do you have a 3") || userInput.equalsIgnoreCase("do you have a three")) {
            return 3;
        } else if (userInput.equalsIgnoreCase("do you have a 4") || userInput.equalsIgnoreCase("do you have a four")) {
            return 4;
        } else if (userInput.equalsIgnoreCase("do you have a 5") || userInput.equalsIgnoreCase("do you have a five")) {
            return 5;
        } else if (userInput.equalsIgnoreCase("do you have a 6") || userInput.equalsIgnoreCase("do you have a six")) {
            return 6;
        } else if (userInput.equalsIgnoreCase("do you have a 7") || userInput.equalsIgnoreCase("do you have a seven")) {
            return 7;
        } else if (userInput.equalsIgnoreCase("do you have a 8") || userInput.equalsIgnoreCase("do you have a eight") ||
                userInput.equalsIgnoreCase("do you have an eight") || userInput.equalsIgnoreCase("do you have an 8")) {
            return 8;
        } else if (userInput.equalsIgnoreCase("do you have a 9") || userInput.equalsIgnoreCase("do you have a nine")) {
            return 9;
        } else if (userInput.equalsIgnoreCase("do you have a 10") || userInput.equalsIgnoreCase("do you have a ten")) {
            return 10;
        } else if (userInput.equalsIgnoreCase("do you have a jack") || userInput.equalsIgnoreCase("do you have a j")) {
            return 11;
        } else if (userInput.equalsIgnoreCase("do you have a queen") || userInput.equalsIgnoreCase("do you have a q")) {
            return 12;
        } else if (userInput.equalsIgnoreCase("do you have a king") || userInput.equalsIgnoreCase("do you have a k")) {
            return 13;
        } else {
            return value;
        }
    }

    public static Integer validAnimal(String userInput) {
        Integer value = 0;
        if (userInput.contains("cat")) {
            return 1;
        } else if (userInput.contains("dog")) {
            return 2;
        } else if (userInput.contains("snake")) {
            return 3;
        } else if (userInput.contains("monkey")) {
            return 4;
        } else if (userInput.contains("pig")) {
            return 5;
        } else if (userInput.contains("bear") || userInput.contains("bare")) {
            return 6;
        } else if (userInput.contains("shark")) {
            return 7;
        } else if (userInput.contains("bird")) {
            return 8;
        } else if (userInput.contains("duck")) {
            return 9;
        } else if (userInput.contains("spider")) {
            return 10;
        } else if (userInput.contains("sheep")) {
            return 11;
        } else if (userInput.contains("lizard")) {
            return 12;
        } else if (userInput.contains("b") || userInput.contains("be") || userInput.contains("bee")) {
            return 13;
        } else {
            return 0;
        }
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

    public static Integer validFruit(String userInput) {
        Integer value = 0;
        if (userInput.contains("apple")) {
            return 1;
        } else if (userInput.contains("banana")) {
            return 2;
        } else if (userInput.contains("orange")) {
            return 3;
        } else if (userInput.contains("pear")) {
            return 4;
        } else if (userInput.contains("watermelon")) {
            return 5;
        } else if (userInput.contains("raspberry") || userInput.contains("raspberries")) {
            return 6;
        } else if (userInput.contains("blueberry") || userInput.contains("blueberries")) {
            return 7;
        } else if (userInput.contains("coconut")) {
            return 8;
        } else if (userInput.contains("pomegranate")) {
            return 9;
        } else if (userInput.contains("pineapple")) {
            return 10;
        } else if (userInput.contains("strawberry") || userInput.contains("strawberries")) {
            return 11;
        } else if (userInput.contains("kiwi")) {
            return 12;
        } else if (userInput.contains("cherry") || userInput.contains("cherries")) {
            return 13;
        } else {
            return 0;
        }
    }

    public String textConvert(int v){
        if(themeVal == 0) {
            if (v == 1) {
                return "ace";
            } else if (v == 11) {
                return "jack";
            } else if (v == 12) {
                return "queen";
            } else if (v == 13) {
                return "king";
            } else {
                return Integer.toString(v);
            }
        }else if(themeVal == 1){
            if (v == 1) {
                return "cat";
            } else if (v == 2) {
                return "dog";
            } else if (v == 3) {
                return "snake";
            } else if (v == 4) {
                return "monkey";
            } else if (v == 5) {
                return "pig";
            } else if (v == 6) {
                return "bear";
            } else if (v == 7) {
                return "shark";
            } else if (v == 8) {
                return "bird";
            } else if (v == 9) {
                return "duck";
            } else if (v == 10) {
                return "spider";
            } else if (v == 11) {
                return "sheep";
            } else if (v == 12) {
                return "lizard";
            } else if (v == 13) {
                return "bee";
            }
        }else if(themeVal == 2){
            if (v == 1) {
                return "red";
            } else if (v == 2) {
                return "orange";
            } else if (v == 3) {
                return "yellow";
            } else if (v == 4) {
                return "green";
            } else if (v == 5) {
                return "blue";
            } else if (v == 6) {
                return "purple";
            } else if (v == 7) {
                return "pink";
            } else if (v == 8) {
                return "black";
            } else if (v == 9) {
                return "white";
            } else if (v == 10) {
                return "gray";
            } else if (v == 11) {
                return "brown";
            } else if (v == 12) {
                return "rainbow";
            } else if (v == 13) {
                return "tan";
            }
        }else if(themeVal == 3){
            if (v == 1) {
                return "apple";
            } else if (v == 2) {
                return "banana";
            } else if (v == 3) {
                return "orange";
            } else if (v == 4) {
                return "pear";
            } else if (v == 5) {
                return "watermelon";
            } else if (v == 6) {
                return "raspberry";
            } else if (v == 7) {
                return "blueberry";
            } else if (v == 8) {
                return "coconut";
            } else if (v == 9) {
                return "pomegranate";
            } else if (v == 10) {
                return "pineapple";
            } else if (v == 11) {
                return "strawberry";
            } else if (v == 12) {
                return "kiwi";
            } else if (v == 13) {
                return "cherry";
            }
        }
        return "####";
    }


    public void setTurn(boolean b) {
        this.g.setTurn(b);
    }
}