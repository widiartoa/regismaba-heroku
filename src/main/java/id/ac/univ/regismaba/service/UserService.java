package id.ac.univ.regismaba.service;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import id.ac.univ.regismaba.model.UserModel;

public interface UserService {
	UserModel selectUser(String username);
	
	UserModel selectUserStafbyNIP(String nip);
	
	void setMailSender(MailSender mailSender);
	
	void setTemplateMsg(SimpleMailMessage templateMsg);
	
	void placeOrder(UserModel user);
	
}
