package com.example.safesphereapp;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AccountCreation extends AppCompatActivity {

    boolean nameReady;
    boolean emailReady;
    boolean phoneReady;
    boolean usernameReady;
    boolean passwordReady;
    boolean confirmed;
    private String[] badWords = {"2g1c","fck", "dck", "2 girls 1 cup","acrotomophilia","alabama hot pocket","alaskan pipeline","anal","anilingus","anus","apeshit","arsehole","DISABLEDass","asshole","assmunch","auto erotic","autoerotic","babeland","baby batter","baby juice","ball gag","ball gravy","ball kicking","ball licking","ball sack","ball sucking","bangbros","bareback","barely legal","barenaked","bastard","bastardo","bastinado","beaner","beaners","beaver cleaver","beaver lips","bestiality","big black","big breasts","big knockers","big tits","bimbos","birdlock","bitches","black cock","blonde action","blonde on blonde action","blowjob","blow job","blow your load","blue waffle","blumpkin","bollocks","bondage","boner","boob","boobs","booty call","brown showers","brunette action","bukkake","bulldyke","bullet vibe","bullshit","bung hole","bunghole","busty","buttcheeks","butthole","camel toe","camgirl","camslut","camwhore","carpet muncher","carpetmuncher","chocolate rosebuds","circlejerk","cleveland steamer","clitoris","clover clamps","clusterfuck","cock","cocks","coprolagnia","coprophilia","cornhole","coon","coons","creampie","cumming","cunnilingus","cunt","cuck","darkie","date rape","daterape","deep throat","deepthroat","dendrophilia","dildo","dingleberry","dingleberries","dirty pillows","dirty sanchez","doggie style","doggiestyle","doggy style","doggystyle","dog style","dolcett","dominatrix","dommes","donkey punch","double dong","double penetration","dp action","dry hump","eat my ass","ecchi","ejaculation","erotic","erotism","escort","eunuch","faggot","fecal","fellatio","feltch","female squirting","femdom","figging","fingerbang","fingering","fisting","foot fetish","footjob","frotting","fuck","fuck buttons","fuckin","fucking","fucktards","fudge packer","fudgepacker","futanari","gang bang","gay sex","genitals","giant cock","girl on top","girls gone wild","goatcx","goatse","god damn","gokkun","golden shower","goodpoop","goo girl","goregasm","grope","group sex","g-spot","hand job","handjob","hard core","hardcore","hentai","homoerotic","honkey","hooker","hot carl","hot chick","how to kill","how to murder","huge fat","humping","incest","intercourse","jack off","jail bait","jailbait","jelly donut","jerk off","jigaboo","jiggaboo","jiggerboo","jizz","juggs","kike","kinbaku","kinkster","kinky","knobbing","leather restraint","leather straight jacket","lemon party","lolita","lovemaking","make me come","male squirting","masturbate","menage a trois","milf","missionary position","motherfucker","mound of venus","mr hands","muff diver","muffdiving","nambla","nawashi","negro","neonazi","nigga","nigger","nig nog","nimphomania","nipple","nipples","nsfw images","nude","nudity","nympho","nymphomania","octopussy","omorashi","one cup two girls","one guy one jar","orgasm","orgy","paedophile","paki","panties","panty","pedobear","pedophile","pegging","penis","phone sex","piece of shit","pissing","piss pig","pisspig","playboy","pleasure chest","pole smoker","ponyplay","poontang","punany","poop chute","poopchute","porn","porno","pornography","prince albert piercing","pubes","pussy","queaf","queef","quim","raghead","raging boner","raping","rapist","rectum","reverse cowgirl","rimjob","rimming","rosy palm","rosy palm and her 5 sisters","rusty trombone","sadism","santorum","schlong","scissoring","semen","shaved beaver","shaved pussy","shemale","shibari","shit","shitblimp","shitty","shota","shrimping","skeet","slanteye","slut","s&m","smut","snatch","snowballing","sodomize","sodomy","splooge","splooge moose","spooge","spread legs","spunk","strap on","strapon","strappado","strip club","style doggy","suck","sucks","suicide girls","sultry women","swastika","swinger","tainted love","taste my","tea bagging","threesome","throating","tied up","tight white","tits","titties","titty","tongue in a","topless","tosser","towelhead","tranny","tribadism","tub girl","tubgirl","tushy","twat","twink","twinkie","two girls one cup","undressing","upskirt","urethra play","urophilia","vagina","venus mound","vibrator","violet wand","vorarephilia","voyeur","vulva","wank","wetback","wet dream","white power","wrapping men","wrinkled starfish","yaoi","yellow showers","yiffy","zoophilia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);
        EditText fullName = findViewById(R.id.name);
        EditText email = findViewById(R.id.email);
        EditText phone = findViewById(R.id.phoneNumber);
        EditText username = findViewById(R.id.usernameID);
        EditText password = findViewById(R.id.passwordID);
        EditText confirm = findViewById(R.id.confirmPasswordID);
        Button create = findViewById(R.id.createAccount);

        nameReady = false;
        emailReady = false;
        phoneReady = false;
        usernameReady = false;
        passwordReady = false;
        confirmed = false;

        fullName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    if(fullName.getText().toString().split(" ").length == 2&&badWordChecker(fullName.getText().toString())&&nameCheck(fullName.getText().toString())){
                        nameReady = true;
                    }
                    else{
                        nameReady = false;
                    }
                }
                if (nameReady && emailReady && phoneReady && usernameReady && passwordReady && confirmed){
                    create.setBackgroundColor(getResources().getColor(R.color.primBlue));
                    create.setClickable(true);
                }
                else{
                    create.setBackgroundColor(getResources().getColor(androidx.cardview.R.color.cardview_dark_background));
                    create.setClickable(false);
                }
            }
        });
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    int checks = 0;
                    char[] emailArray = email.getText().toString().toCharArray();
                    int a = 0;
                    int b = 0;
                    for(char i: emailArray){
                        if (i == '@'){
                            a++;
                        }
                    }
                    for(char i: emailArray){
                        if (i == '.'){
                            b++;
                        }
                    }
                    if(a ==1&&b==1){
                        checks++;
                    }
                    if(email.getText().toString().indexOf('@')<email.getText().toString().indexOf('.')){
                        checks++;
                    }

                    String custom = email.getText().toString().split("@")[0];
                    String domain = email.getText().toString().split("@")[1];
                    domain = domain.split("\\.")[0];
                    String dot = email.getText().toString().split("\\.")[1];
                    if(dot.equals("com")||dot.equals("org")||dot.equals("net")||dot.equals("gov")){
                        checks++;
                    }
                    if (!custom.isEmpty()&&!domain.isEmpty()&&checks==3){
                        emailReady = true;
                    }
                    else{
                        emailReady = false;
                    }
                }
                if (nameReady && emailReady && phoneReady && usernameReady && passwordReady && confirmed){
                    create.setBackgroundColor(getResources().getColor(R.color.primBlue));
                    create.setClickable(true);
                }
                else{
                    create.setBackgroundColor(getResources().getColor(androidx.cardview.R.color.cardview_dark_background));
                    create.setClickable(false);
                }
            }
        });
        phone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    int checks = 0;
                    if(phone.getText().toString().split("-").length == 3){
                        phoneReady = true;
                    }
                    else {
                        phoneReady = false;
                    }

                }
                if (nameReady && emailReady && phoneReady && usernameReady && passwordReady && confirmed){
                    create.setBackgroundColor(getResources().getColor(R.color.primBlue));
                    create.setClickable(true);
                }
                else{
                    create.setBackgroundColor(getResources().getColor(androidx.cardview.R.color.cardview_dark_background));
                    create.setClickable(false);
                }
            }
        });
        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    if(usernameCheck(username.getText().toString())&&badWordChecker(username.getText().toString())){
                        usernameReady = true;
                    }
                    else{
                        usernameReady = false;
                    }
                }
                if (nameReady && emailReady && phoneReady && usernameReady && passwordReady && confirmed){
                    create.setBackgroundColor(getResources().getColor(R.color.primBlue));
                    create.setClickable(true);
                }
                else{
                    create.setBackgroundColor(getResources().getColor(androidx.cardview.R.color.cardview_dark_background));
                    create.setClickable(false);
                }
            }
        });
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    if(passwordCheck(password.getText().toString())&&badWordChecker(password.getText().toString())){
                        passwordReady = true;
                    }
                    else{
                        passwordReady = false;
                    }
                }
                if (nameReady && emailReady && phoneReady && usernameReady && passwordReady && confirmed){
                    create.setBackgroundColor(getResources().getColor(R.color.primBlue));
                    create.setClickable(true);
                }
                else{
                    create.setBackgroundColor(getResources().getColor(androidx.cardview.R.color.cardview_dark_background));
                    create.setClickable(false);
                }
            }
        });
        confirm.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    if(password.getText().toString().equals(confirm.getText().toString())){
                        confirmed = true;
                    }
                    else{
                        confirmed = false;
                    }
                }
                if (nameReady && emailReady && phoneReady && usernameReady && passwordReady && confirmed){
                    create.setBackgroundColor(getResources().getColor(R.color.primBlue));
                    create.setClickable(true);
                }
                else{
                    create.setBackgroundColor(getResources().getColor(androidx.cardview.R.color.cardview_dark_background));
                    create.setClickable(false);
                }
            }
        });
    }
    public boolean usernameCheck(String txt){
        for (char letter: txt.toCharArray()){
            int n = (int)letter;
            if (!((n>=65&&n<=90)||(n>=97&&n<=122)||(n>=48&&n<=57)||(n==95))) {
                return false;
            }
        }
        return true;
    }
    public boolean passwordCheck(String txt){
        for (char letter: txt.toCharArray()){
            int n = (int)letter;
            if (!((n>=65&&n<=90)||(n>=97&&n<=122)||(n>=33&&n<=57)||(n>=91&&n<=96))) {
                return false;
            }
        }
        return true;
    }
    public boolean nameCheck(String txt){
        for (char letter: txt.toCharArray()){
            int n = (int)letter;
            if (!((n==32)||(n>=65&&n<=90)||(n>=97&&n<=122))) {
                return false;
            }
        }
        return true;
    }
    public boolean badWordChecker(String txt){
        txt = txt.replace("4","a");
        txt = txt.replace("3","e");
        txt = txt.replace("0","o");
        txt = txt.replace("4","a");
        txt = txt.replace("5","s");
        txt = txt.replace("7","t");
        txt = txt.replace("8","b");
        for(String word: badWords){
            if (txt.replace("1","l").toLowerCase().contains(word)){
                return false;
            }
            if (txt.replace("1","i").toLowerCase().contains(word)){
                return false;
            }
        }
        return true;
    }
    public void create(View view){

    }

}