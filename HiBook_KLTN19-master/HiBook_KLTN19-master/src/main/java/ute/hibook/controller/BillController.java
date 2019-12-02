package ute.hibook.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.BillDTO;
import ute.hibook.dto.BookDTO;
import ute.hibook.dto.CartDTO;
import ute.hibook.dto.DetailbillDTO;
import ute.hibook.dto.OrderstatusDTO;
import ute.hibook.dto.PaymentDTO;
import ute.hibook.dto.TransportDTO;
import ute.hibook.dto.UserDTO;
import ute.hibook.entity.History;
import ute.hibook.service.impl.BillServiceImpl;
import ute.hibook.service.impl.CartServiceImpl;
import ute.hibook.service.impl.DetailbillServiceImpl;
import ute.hibook.service.impl.HistoryServiceImpl;
import ute.hibook.service.impl.OrderstatusServiceImpl;
import ute.hibook.service.impl.UserServiceImpl;
@Configuration
@EnableScheduling
@RestController
@RequestMapping(value = "/api/v1")
public class BillController {
	
	private static final String SMTP_SERVER = "smtp server ";
	private static final String USERNAME = "nguyenvietthanh1197@gmail.com";
	private static final String PASSWORD = "nguyenvietthanh321";

	private static final String EMAIL_FROM = "hibook.2019@gmail.com";
	private static final String EMAIL_TO = "daothimy46@gmail.com";
	//private static final String EMAIL_TO_CC = "";

	private static final String EMAIL_SUBJECT = "[HiBook] THONG TIN HOA DON";
	//private static final String EMAIL_TEXT = "<h1>Hello Java Mail \n ABC123</h1>";
	String filename = "D:\\myfile.pdf";
	@Autowired
	BillServiceImpl billSer;
	@Autowired
	UserServiceImpl userSer;
	@Autowired
	CartServiceImpl cartSer;
	@Autowired
	DetailbillServiceImpl detailbillSer;
	@Autowired
	OrderstatusServiceImpl statusSer;
	@Autowired
	HistoryServiceImpl historyServiceImpl;
	@GetMapping(value="/bills")
	public ResponseEntity<List<BillDTO>> getallBill(){
		List<BillDTO> bills= billSer.getAllBill();
		if(bills.isEmpty()) {
			return new ResponseEntity<List<BillDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<BillDTO>>(bills,HttpStatus.OK);
	}
	
	@GetMapping(value="/bills/{idBill}")
	public ResponseEntity<BillDTO> getBillById(@PathVariable int idBill){
		BillDTO billDTO= billSer.getBillById(idBill);
		if(billDTO == null) {
			return new ResponseEntity<BillDTO>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<BillDTO>(billDTO,HttpStatus.OK);
	}
	
	@GetMapping(value = "/users/{idUser}/bills")
	public ResponseEntity<?> getBillByIdUser(@PathVariable int idUser){
		List<BillDTO> bills= billSer.getBillsByIdUser(idUser);
		if(bills.isEmpty()) {
			return new ResponseEntity<List<BillDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<BillDTO>>(bills,HttpStatus.OK);
	}
	
	@PostMapping(value="/bills")
	public ResponseEntity<?> addBill(@RequestParam String nameReceiver, @RequestParam String numberphone,
			 @RequestParam String deliveryAdress, @RequestParam String dateCreate,
			 @RequestParam int total, @RequestParam int idUser,
			 @RequestParam String email){
		BillDTO billDTO=new BillDTO();
		billDTO.setNameReceiver(nameReceiver);
		billDTO.setNumberphone(numberphone);
		billDTO.setDeliveryAdress(deliveryAdress);
		billDTO.setDateCreate(dateCreate);
		billDTO.setTotal(total);
		UserDTO user=new UserDTO();
		user.setIdUser(idUser);
		String emailclient = userSer.getUserById(idUser).getEmail();
		billDTO.setUser(user);		
		List<OrderstatusDTO> lstStatus = statusSer.getAllOrderstatus();
		OrderstatusDTO status = lstStatus.get(0);
		billDTO.setOrderstatus(status);
		
		//add bill
		int idBillCurrent = billSer.addBill(billDTO);
		billDTO.setIdBill(idBillCurrent);
		//
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
						msg.setFrom(new InternetAddress(EMAIL_FROM));

						msg.setRecipients(Message.RecipientType.TO,
								InternetAddress.parse(emailclient, false));

						msg.setSubject(EMAIL_SUBJECT);
						//msg.setDataHandler(new DataHandler(new HTMLDataSource(email)));
						//Transport.send(msg);
						
						MimeBodyPart textPart = new MimeBodyPart();
						textPart.setContent(email, "text/html; charset=utf-8");
				Multipart multipart = new MimeMultipart("mixed");
						multipart.addBodyPart(textPart);
					msg.setContent(multipart);
						Transport.send(msg);
						System.out.println("doneeeeee--------");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		//mess
		//getIdUserHis từ idBook
		List<History> listHis=new ArrayList<History>();
		//đổ dữ liệu cart sang detailBill
		List<CartDTO> carts=cartSer.getAllCartOfUser(idUser);
		for (CartDTO cart : carts) {
			DetailbillDTO detailBill=new DetailbillDTO();
			
			BookDTO book =new BookDTO();
			History his=historyServiceImpl.getidUserHistoryByidBook(cart.getBook().getIdBook());
			System.out.println(his);
			
			book.setIdBook(cart.getBook().getIdBook());
			
			detailBill.setBook(book);
			detailBill.setBill(billDTO);
			detailBill.setPrice(cart.getPrice());
			detailBill.setQuantityBuy(cart.getQuantity());
			
			detailbillSer.addDetailbill(detailBill);
			cartSer.deleteCart(cart.getIdCart());
			System.out.println("Đặt hàng thành công!");
		}
		
		return new ResponseEntity<Integer>(idBillCurrent,HttpStatus.OK);
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
	/*======================Update Status Bill ================= */
	@PutMapping(value="/bills/{idBill}/status/{idStatus}")
	public ResponseEntity<?> updateRoleUser(@PathVariable int idBill, @PathVariable int idStatus){
		boolean update=billSer.updateStatusBill(idBill, idStatus);
		if(!update){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}