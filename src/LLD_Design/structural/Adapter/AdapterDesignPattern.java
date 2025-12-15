package LLD_Design.structural.Adapter;

public class AdapterDesignPattern {


   /* This pattern allows two incompatible interfaces to work together by creating a bridge between them.
    It acts as a translator between two different interfaces and allows them to communicate with each other.*/

    public static void main(String[] args) {

        MediaAdapter mediaAdapter = new MediaAdapter();
        mediaAdapter.play("hello.txt");

    }
}


//existing interface
interface MediaPlayer{
    void play(String file);
}


//Incompatible Class
class AdvancedPlayer{
    void playMp4(String file) { System.out.println("Playing mp4: " + file); }
}

//Adapter
class MediaAdapter implements MediaPlayer{

    AdvancedPlayer advancedPlayer= new AdvancedPlayer();

    @Override
    public void play(String file) {
         advancedPlayer.playMp4(file);
    }
}
