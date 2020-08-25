package com.mangchi.subscribe.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.WebpushConfig;
import com.google.firebase.messaging.WebpushNotification;
import com.mangchi.subscribe.dao.NotificationDao;
import com.mangchi.subscribe.model.SubscribeCheckRequest;

@Service
public class FcmSubscribeUtil {

	private NotificationDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public void sendFcm(SubscribeCheckRequest subRequest) {

		FileInputStream oauthKey;

		try {
			oauthKey = new FileInputStream("C:\\Users\\maior\\Documents\\GitHub\\Mangchi_Final\\Mangchi-DonateBoard-App\\src\\main\\webapp\\resources\\donataboard-mangchi-project-firebase-adminsdk-4juy6-3c783cb128.json");
			System.out.println("FCM oauthKey : "+oauthKey);
			FirebaseOptions options=new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(oauthKey))
					.setDatabaseUrl("https://donataboard-mangchi-project.firebaseio.com")
					.build();

			//firebase 처음 호출시에만 초기화
			if(FirebaseApp.getApps().isEmpty()) {
				FirebaseApp.initializeApp(options);
			}

			System.out.println("비공개키 초기화 : "+options);

			dao=template.getMapper(NotificationDao.class);

			//로그인 한 사람 토큰이 데이터베이스에 있는지 점검
			int beCount=dao.countTrue(subRequest.getMemberNick());

			if(beCount<1) {
				throw new Exception("구독 중인 멤버가 아닙니다.");

			} else {

				//데이터베이스에서 확인 된 기기의 토큰 입력
				String registrationToken= subRequest.getToken();

				//제목 생성
				String title= "동네에서 대여하기 :: MANGCHI! 나눔게시판";

				//내용 생성
				String content= "새 글 : "+subRequest.getTitle();

				System.out.println("구독자의 토큰 : "+registrationToken);
				System.out.println("구독자에게 가는 알림 제목 : "+title);
				System.out.println("구독자에게 가는 알림 내용 : "+content);

				//메시지 작성
				Message message = Message.builder()
						.setToken(registrationToken)
						.setWebpushConfig(WebpushConfig.builder()
								.putHeader("ttl", "300")
								.setNotification(new WebpushNotification(title,	content))
								.build())
						.build();

				String response = FirebaseMessaging.getInstance().sendAsync(message).get();

				System.out.println("메시지 전송 성공 : " +response);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FirebaseMessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
