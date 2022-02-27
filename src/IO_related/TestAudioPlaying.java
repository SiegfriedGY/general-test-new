package IO_related;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

/**
 * @author Siegfried GENG
 * @date 2019/9/2 - 22:50
 */
public class TestAudioPlaying {


    public static void main(String[] args) {
        play01();

    }

    /// 好像只能播放wav格式
    private static void play01(){
        //选择播放文件
        File file = new File("D:"+File.separator+"temp"+File.separator+"123.mp3");
        System.out.println("文件是否存在？"+file.exists());
        //创建audioclip对象
        AudioClip audioClip = null;
        //将file转换为url
        try {
            audioClip = Applet.newAudioClip(file.toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //循环播放	播放一次可以使用audioClip.play
        audioClip.play();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void plar02(){
//        File file=new  File("D:"+File.separator+"temp"+File.separator+"123.mp3");
//        Player player=Manager.createPlayer(file.toURL());
//        player.start();//开始播放
    }
}
