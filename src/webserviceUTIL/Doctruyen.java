package webserviceUTIL;

import android.media.AudioManager;
import android.media.MediaPlayer;

public class Doctruyen implements Runnable{
	private String storyName;
	private String sotryContent;
	private String language;
	
	
	public Doctruyen(){		
		
	}
	
	public Doctruyen(String input){
		String[] ss = input.split("_");
		storyName = ss[0];
		sotryContent = ss[1] + "Hết";
		language = ss[2];
		System.out.println("sotryContent1: " + sotryContent);
	}
	
	public void doc(){
		new Thread(this).start();
		System.out.println("OK");
	}
	

	@Override
	public void run() {
		System.out.println("sotryContent2: " + sotryContent);
		doccau(language,"Câu chuyện " + storyName);
		String[] s1 = sotryContent.split("\\.");
		System.out.println("s1.length: " + s1.length);
		for (int i = 0; i < s1.length; i++){
			String[] s2 = s1[i].split(",");
			for (int j = 0; j < s2.length; j++){
				System.out.println("s2.length: " + s2.length);
				doccau(language,s2[j]);
			}
		}
		System.out.println("END");
		
	}
	
	public void doccau(String lang, String content){
		try {
			 //http://translate.google.com/translate_tts?tl=vi&q=h%E1%BB%8Dc%20vi%E1%BB%87n%20c%C3%B4ng%20ngh%E1%BB%87%20b%C6%B0u%20ch%C3%ADnh%20vi%E1%BB%85n%20th%C3%B4ng
	        String text = content;

	        text=text.replace(" ", "%20"); 
	        String oLanguage = lang;

	        MediaPlayer player = new MediaPlayer();
	        player.setAudioStreamType(AudioManager.STREAM_MUSIC);    
	        String input = "http://translate.google.com/translate_tts?ie=UTF-8&total=2&idx=1&tl="+oLanguage+"&q="+ text;
	       
	        player.setDataSource(input);

	        player.prepare();
	        player.start();

        } catch (Exception e) { 
            System.out.print(e.toString());
        }
		
		
		
	}

}
