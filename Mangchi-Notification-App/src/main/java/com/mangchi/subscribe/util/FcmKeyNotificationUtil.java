package com.mangchi.subscribe.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
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
import com.mangchi.subscribe.model.NotificationCheckRequest;

@Service
public class FcmKeyNotificationUtil {

	private NotificationDao dao;
	private static final String FIREBASE_CONFIG_PATH="donataboard-mangchi-project-firebase-adminsdk-4juy6-3c783cb128.json";

	
	@Autowired
	private SqlSessionTemplate template;

	
	public void sendFcm(NotificationCheckRequest noticeRequest) {


		try {

			FirebaseOptions options=new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(new ClassPathResource(FIREBASE_CONFIG_PATH).getInputStream()))
					.setDatabaseUrl("https://donataboard-mangchi-project.firebaseio.com")
					.build();

			//firebase 처음 호출시에만 초기화
			if(FirebaseApp.getApps().isEmpty()) {
				FirebaseApp.initializeApp(options);
			}

			dao=template.getMapper(NotificationDao.class);

			//로그인 한 사람 토큰이 데이터베이스에 있는지 체크
			int beCount=dao.countTrue(noticeRequest.getMemberNick());

			if(beCount<1) {

				throw new Exception("구독 중인 멤버가 아닙니다.");

			} else {

				//글쓴 사람이 올린 제목과 데이터베이스의 키워드 비교
				String keyTitle=noticeRequest.getTitle();
				List<String> keyword=dao.selectKeyword(noticeRequest.getMemberNick());
				for(int i=0; i<keyword.size(); i++) {
					if(!keyTitle.contains((CharSequence) keyword.get(i))) {
						throw new Exception("키워드가 일치하지 않습니다.");

					} else {

						//기기의 토큰 입력
						String registrationToken= noticeRequest.getToken();

						//제목 생성
						String title= "동네에서 대여하기 :: MANGCHI! 나눔게시판";

						//내용 생성
						String content= "키워드 새 글 : "+keyTitle;

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
				}


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