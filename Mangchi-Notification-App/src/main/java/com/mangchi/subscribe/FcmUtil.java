package com.mangchi.subscribe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.WebpushConfig;
import com.google.firebase.messaging.WebpushNotification;

@Component
public class FcmUtil {
	
	public void sendFcm(String tokenId, String title, String content) {
		
		FileInputStream refreshToken;
		
		try {
			refreshToken = new FileInputStream("C:\\Users\\maior\\Documents\\GitHub\\Mangchi_Final\\Mangchi-DonateBoard-App\\src\\main\\webapp\\resources\\donataboard-mangchi-project-firebase-adminsdk-4juy6-3c783cb128.json");
		
		FirebaseOptions options=new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(refreshToken))
				.setDatabaseUrl("https://donataboard-mangchi-project.firebaseio.com")
				.build();
		
		//firebase 처음 호출시에만 초기화
		if(FirebaseApp.getApps().isEmpty()) {
			FirebaseApp.initializeApp(options);
		}
		
		//기기의 토큰 입력
		String registrationToken=tokenId;
		
		//메시지 작성
		Message msg=Message.builder()
				.setWebpushConfig(WebpushConfig.builder()
					.setNotification(WebpushNotification.builder()
							.setTitle(title)
							.setBody(content)
							.build())
					.build())
				.setToken(registrationToken)
				.build();
		
		//메시지를 firebase messaging에 보내기
		String response=FirebaseMessaging.getInstance().send(msg);
		
		System.out.println("메시지 전송 성공 : " +response);
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FirebaseMessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
