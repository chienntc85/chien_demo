package ute.hibook.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import ute.hibook.dto.ConvertPromotionDTO;
import ute.hibook.dto.UserDTO;
import ute.hibook.service.impl.PromotionServiceImpl;
import ute.hibook.service.impl.UserServiceImpl;

@Configuration
@EnableScheduling
public class SpringConfig {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	UserServiceImpl userById;
	@Autowired
	PromotionServiceImpl promotion;

	private static final String SMTP_SERVER = "smtp server ";
	private static final String USERNAME = "hibook.2019@gmail.com";
	private static final String PASSWORD = "Hibook@123";

	private static final String EMAIL_FROM = "hibook.2019@gmail.com";
	private static final String EMAIL_TO = "daothimy46@gmail.com";
	private static final String EMAIL_TO_CC = "";

	private static final String EMAIL_SUBJECT = "Test Send Email via SMTP (HTML)";
	private static final String EMAIL_TEXT = "<h1>Hello Java Mail \n ABC123</h1>";

	//@Scheduled(cron = "*/10 * * * * *")
	@Scheduled(cron = "0 0 0 25 07 ?") 
	public void ScheduledWeekEnd() throws ParseException {
		// test
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Date date = new Date();
		String dateNow = dateFormat.format(date);
		Date dt = new SimpleDateFormat("yyyy-MM-dd 00:00:00").parse(dateNow);
		//
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		Long dateNow1 = dt.getTime();
		int dateNow2 = dateNow1.intValue();
		System.out.println("------------------------------------");
		System.out.println(c.getTime());
		System.out.println(c.getTime().getTime());
		System.out.println("----------hihihih-----------");
		//
		// test
		List<ConvertPromotionDTO> listPro = promotion.getAllPromotion();

		//
		List<UserDTO> listUser = userById.getAllUser();
		List<UserDTO> listUserbyId = new ArrayList<UserDTO>();
		for (UserDTO user : listUser) {
			// RoleDTO role=new
			// RoleDTO(user.getRole().getIdRole(),user.getRole().getNameRole()) ;
			if (user.getRole().getIdRole() == 1) {
				UserDTO userDTO = new UserDTO();
				userDTO.setEmail(user.getEmail());
				System.out.println(userDTO.getEmail());
				listUserbyId.add(userDTO);
			}
		}

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USERNAME, PASSWORD);
			}
		});
		Message msg = new MimeMessage(session);

		try {
			for (UserDTO userToMail : listUserbyId) {
				for (ConvertPromotionDTO pro : listPro) {
					String dateStart = pro.getTimeStart();
					String dateEnd = pro.getTimeEnd();
					Date dtStart = new SimpleDateFormat("yyyy-MM-dd").parse(dateStart);
					Date dtEnd = new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd);
					Long Sdate = dtStart.getTime();
					Long Eend = dtEnd.getTime();
					int startDate = Sdate.intValue();
					int endDate = Eend.intValue();
					if (dateNow2>=startDate && dateNow2 < endDate) {
						System.out.println("-----" + dtStart.getTime() + "------");

						msg.setFrom(new InternetAddress(EMAIL_FROM));

						msg.setRecipients(Message.RecipientType.TO,
								InternetAddress.parse(userToMail.getEmail(), false));

						msg.setSubject(pro.getTitlePromotion());
						//msg.setDataHandler(new DataHandler(new HTMLDataSource(pro.getContentPromotion())));
						//Transport.send(msg);
						MimeBodyPart textPart = new MimeBodyPart();
						textPart.setContent(pro.getContentPromotion(), "text/html; charset=utf-8");
						Multipart multipart = new MimeMultipart("mixed");
						multipart.addBodyPart(textPart);
						msg.setContent(multipart);
						Transport.send(msg);
						
						System.out.println("doneeeeee--------");

					}
				}
			}

			// t.close();

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	static class HTMLDataSource implements DataSource {

		private String html;

		public HTMLDataSource(String htmlString) {
			html = htmlString;
		}

		public InputStream getInputStream() throws IOException {
			if (html == null)
				throw new IOException("html message is null!");
			return new ByteArrayInputStream(html.getBytes());
		}

		public OutputStream getOutputStream() throws IOException {
			throw new IOException("This DataHandler cannot write HTML");
		}

		public String getContentType() {
			return "text/html";
		}

		public String getName() {
			return "HTMLDataSource";
		}
	}

}
