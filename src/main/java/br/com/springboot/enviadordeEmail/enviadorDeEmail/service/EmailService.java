package br.com.springboot.enviadordeEmail.enviadorDeEmail.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	public void enviar(String nome, String endereco) {
		try {
			SimpleEmail email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("email", "password"));
			email.setSSLOnConnect(true);

			email.setFrom("emailautomatico@orsegups.com.br");
			email.setSubject("Cadastrado uma nova despesa");
			email.setMsg("Sr(a)" + nome + " acaba de cadastrar uma nova despesa");
			email.addTo(endereco);
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

}
