package id.ac.univ.regismaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import id.ac.univ.regismaba.dao.UserMapper;
import id.ac.univ.regismaba.model.UserModel;

@Service
public class UserServiceImplement implements UserService{

        private MailSender mailSender;
        private SimpleMailMessage templateMsg;
        
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	RoleService roleDAO;
	
	@Autowired
	TingkatRoleService tingkatRoleDAO;
	
	@Override
	public UserModel selectUser(String username) {
		// TODO Auto-generated method stub
		return userMapper.selectUser(username);
	}

	@Override
	public UserModel selectUserStafbyNIP(String nip) {
		// TODO Auto-generated method stub
		UserModel staf = userMapper.selectUserStafbyNIP(nip);
		
		staf.setRole(roleDAO.selectRole(staf.getId_role()));
		staf.setTingkat_role(tingkatRoleDAO.selectTRM(staf.getRole().getTingkat_role_id()));
		
		return staf;
	}
	
	@Override
	public void setMailSender(MailSender mailSender) {
	    this.mailSender = mailSender;
	}
	
	@Override
	public void setTemplateMsg(SimpleMailMessage templateMsg) {
	   this.templateMsg = templateMsg; 
	}
	
	@Override
	public void placeOrder(UserModel user) {
	    SimpleMailMessage msg = new SimpleMailMessage(this.templateMsg);
	    msg.setTo (user.getEmail ());
	    msg.setText ("thank you");
	    
	    try {
	        this.mailSender.send (msg);
	    }

            catch (MailException exc) {
                System.err.println (exc.getMessage ());
            }
	}
}
