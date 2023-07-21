package Util;

import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.DataHandler;


public class Email {
	// password: edunwbziglabsvrk
	//email: dinhvanhuytest@gmail.com
	// Anhhuyditu00.
	static final String from = "dinhvanhuytest@gmail.com";
	static final String password = "edunwbziglabsvrk";
	
	public boolean sentEmail(String to,String title, String content) {
		//properties
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");// khai báo server nào để gửi email
				props.put("mail.smtp.port", "587");// TLS 587, SSL 465
				props.put("mail.smtp.auth", "true");// phải đăng nhập trước khi sử dụng hay không
				props.put("mail.smtp.starttls.enable", "true"); // định nghĩa giao thức sử dụng
				
				
				//create Authenticator
				Authenticator auth = new Authenticator() {

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication(from, password);
					}
			
				};
				
				//phiên làm việc
				Session session = Session.getInstance(props, auth);
				
				
				
				// Tạo một tin nhắn
				MimeMessage msg = new MimeMessage(session);
				
				try {
					//người gửi
					msg.addHeader("Content-type", "text/HTML;charset=UTF-8");
					msg.setFrom(from);
					
					//người nhận
					msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
					
					//Tiêu đề
					msg.setSubject("Thử tý vậy,");
					
					//quy định ngày gửi
					msg.setSentDate(new Date());
					
					//quy định email nhận phải hồi
					//msg.setReplyTo(InternetAddress.parse(from,false));
					
					String contentBase="<!DOCTYPE html>\r\n"
							+ "<html>\r\n"
							+ "\r\n"
							+ "<head>\r\n"
							+ "</head>\r\n"
							+ "\r\n"
							+ "<body>\r\n"
							+ content
							+ "	</body>\r\n"
							+ "</html>";
					
					//Nội dung
					msg.setContent(content,"text/html");
					
					//gửi email
					Transport.send(msg);
					System.out.println("Gửi thành công");
					return true;
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					System.out.println("Gửi không thành công");
					e.printStackTrace();
					return false;
					
				}
	}
	
	
	public static void main(String[] args) {
		Email email= new Email();
		String content = "<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "	<h1>Ngựa ngựa</h1>\r\n"
				+ "	<h2>Họ và tên: </h2> Đinh Văn Huy <br>\r\n"
				+ "	<img src=\"https://scontent.fhan2-3.fna.fbcdn.net/v/t39.30808-1/359066383_1733051017137530_8844598768540994314_n.jpg?stp=dst-jpg_p240x240&_nc_cat=101&ccb=1-7&_nc_sid=7206a8&_nc_ohc=Mw8HpWxPjT4AX9kf1MR&_nc_ht=scontent.fhan2-3.fna&oh=00_AfDbtDFzm-gApVFCLSv8cwfkpngncpY5YhTIhBR0DMEHFg&oe=64B9283E\">\r\n"
				+ "</body>\r\n"
				+ "</html>";
		email.sentEmail("dinhvanhuy1908202@gmail.com","", content);
		
	}
}
