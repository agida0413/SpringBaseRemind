package com.sist.provider;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmailProvider {

	private final JavaMailSender javamailsender;
	private final String SUBJECT="[ SHABBY ] 인증메일입니다";
	
	public boolean sendCertificationMail(String email,String certificationNumber) {
		
		
		try {
			MimeMessage message= javamailsender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(message,true);
			
			String htmlContent= getCertificationMessage(certificationNumber);
			
			mimeMessageHelper.setSubject(SUBJECT);
			mimeMessageHelper.setText(htmlContent,true);
			
			
			javamailsender.send(message);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
	
	
	private String getCertificationMessage(String certificationNumber) {
		String certificationMessage="";
		certificationMessage+="<h1 style='text-align:center;'>[임대주택 가격 서비스] 인증메일 </h1>";
		certificationMessage+="<h3 style='text-align:center;'>인증코드:<strong style='font-size:32px; letter-spacing:8px;'> "
				+certificationMessage+"</strong></h3>";
		return certificationMessage;
	}
}
