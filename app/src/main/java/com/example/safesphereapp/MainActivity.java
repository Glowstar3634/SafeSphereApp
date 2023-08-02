package com.example.safesphereapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;



import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton;
    private String[] badWords = {"2g1c","fck", "dck", "2 girls 1 cup","acrotomophilia","alabama hot pocket","alaskan pipeline","anal","anilingus","anus","apeshit","arsehole","DISABLEDass","asshole","assmunch","auto erotic","autoerotic","babeland","baby batter","baby juice","ball gag","ball gravy","ball kicking","ball licking","ball sack","ball sucking","bangbros","bareback","barely legal","barenaked","bastard","bastardo","bastinado","beaner","beaners","beaver cleaver","beaver lips","bestiality","big black","big breasts","big knockers","big tits","bimbos","birdlock","bitches","black cock","blonde action","blonde on blonde action","blowjob","blow job","blow your load","blue waffle","blumpkin","bollocks","bondage","boner","boob","boobs","booty call","brown showers","brunette action","bukkake","bulldyke","bullet vibe","bullshit","bung hole","bunghole","busty","buttcheeks","butthole","camel toe","camgirl","camslut","camwhore","carpet muncher","carpetmuncher","chocolate rosebuds","circlejerk","cleveland steamer","clitoris","clover clamps","clusterfuck","cock","cocks","coprolagnia","coprophilia","cornhole","coon","coons","creampie","cumming","cunnilingus","cunt","cuck","darkie","date rape","daterape","deep throat","deepthroat","dendrophilia","dildo","dingleberry","dingleberries","dirty pillows","dirty sanchez","doggie style","doggiestyle","doggy style","doggystyle","dog style","dolcett","dominatrix","dommes","donkey punch","double dong","double penetration","dp action","dry hump","eat my ass","ecchi","ejaculation","erotic","erotism","escort","eunuch","faggot","fecal","fellatio","feltch","female squirting","femdom","figging","fingerbang","fingering","fisting","foot fetish","footjob","frotting","fuck","fuck buttons","fuckin","fucking","fucktards","fudge packer","fudgepacker","futanari","gang bang","gay sex","genitals","giant cock","girl on top","girls gone wild","goatcx","goatse","god damn","gokkun","golden shower","goodpoop","goo girl","goregasm","grope","group sex","g-spot","hand job","handjob","hard core","hardcore","hentai","homoerotic","honkey","hooker","hot carl","hot chick","how to kill","how to murder","huge fat","humping","incest","intercourse","jack off","jail bait","jailbait","jelly donut","jerk off","jigaboo","jiggaboo","jiggerboo","jizz","juggs","kike","kinbaku","kinkster","kinky","knobbing","leather restraint","leather straight jacket","lemon party","lolita","lovemaking","make me come","male squirting","masturbate","menage a trois","milf","missionary position","motherfucker","mound of venus","mr hands","muff diver","muffdiving","nambla","nawashi","negro","neonazi","nigga","nigger","nig nog","nimphomania","nipple","nipples","nsfw images","nude","nudity","nympho","nymphomania","octopussy","omorashi","one cup two girls","one guy one jar","orgasm","orgy","paedophile","paki","panties","panty","pedobear","pedophile","pegging","penis","phone sex","piece of shit","pissing","piss pig","pisspig","playboy","pleasure chest","pole smoker","ponyplay","poontang","punany","poop chute","poopchute","porn","porno","pornography","prince albert piercing","pubes","pussy","queaf","queef","quim","raghead","raging boner","raping","rapist","rectum","reverse cowgirl","rimjob","rimming","rosy palm","rosy palm and her 5 sisters","rusty trombone","sadism","santorum","schlong","scissoring","semen","shaved beaver","shaved pussy","shemale","shibari","shit","shitblimp","shitty","shota","shrimping","skeet","slanteye","slut","s&m","smut","snatch","snowballing","sodomize","sodomy","splooge","splooge moose","spooge","spread legs","spunk","strap on","strapon","strappado","strip club","style doggy","suck","sucks","suicide girls","sultry women","swastika","swinger","tainted love","taste my","tea bagging","threesome","throating","tied up","tight white","tits","titties","titty","tongue in a","topless","tosser","towelhead","tranny","tribadism","tub girl","tubgirl","tushy","twat","twink","twinkie","two girls one cup","undressing","upskirt","urethra play","urophilia","vagina","venus mound","vibrator","violet wand","vorarephilia","voyeur","vulva","wank","wetback","wet dream","white power","wrapping men","wrinkled starfish","yaoi","yellow showers","yiffy","zoophilia"};


    TextView signUpButton;
    TextView forgotYourPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.usernameID);
        password = findViewById(R.id.passwordID);
        loginButton = findViewById(R.id.loginButton);
        signUpButton = findViewById(R.id.signUpButton);
        forgotYourPassword = findViewById(R.id.forgotYourPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("user") && password.getText().toString().equals("1234")) {
                    Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpSwitch = new Intent(MainActivity.this, SignUpActivity.class);
                MainActivity.this.startActivity(signUpSwitch);
            }
        });

        forgotYourPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgotYourPasswordSwitch = new Intent(MainActivity.this, forgotYourPassword.class);
                MainActivity.this.startActivity(forgotYourPasswordSwitch);
            }
        });
    }

    public void loggingIn (View view) {
        TextView usernameInput = findViewById(R.id.usernameID);
        TextView enteredPass = findViewById(R.id.passwordID);
        String pass = enteredPass.getText().toString();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");
        ref.child(usernameInput.getText().toString()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()){
                    if(task.getResult().exists()){
                        DataSnapshot snap = task.getResult();
                        String retrievedPass = String.valueOf(snap.child("password").getValue());
                        if(pass.equals(retrievedPass)){
                            String un = String.valueOf(snap.child("username").getValue());
                            loggedIn(un);
                        }
                        else{
                            findViewById(R.id.passwordID).setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.button01));
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Account does not exist.",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this,"Login Failed, try again later.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void loggedIn(String account){
        Intent switchActivity = new Intent(MainActivity.this, SignUpActivity.class);
        //Change 'SignUpActivity' to name of home screen activity
        switchActivity.putExtra("account", account);
        MainActivity.this.startActivity(switchActivity);
    }


}
