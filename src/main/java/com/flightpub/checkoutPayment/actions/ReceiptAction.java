package com.flightpub.checkoutPayment.actions;

import com.flightpub.base.hibernate.listener.HibernateListener;
import com.flightpub.base.model.Flights;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.smtp.SMTPTransport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SessionFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.*;

public class ReceiptAction extends ActionSupport implements SessionAware {

    /* GMail account (I think this only works with Gmail at the moment) */
    private static String USER_NAME = "flightpubreceipt";
    private static String PASSWORD = "flight2018!";
    /* Make sure that the account is on Google has IMAP access */


    private String name;
    private String email;
    private List<Flights> cart;
    private Map<String, Object> userSession;

    public String execute() {
        System.out.println("Sending the receipt");

        SessionFactory sessionFactory =
                (SessionFactory) ServletActionContext.getServletContext()
                        .getAttribute(HibernateListener.KEY_NAME);

        if (userSession.containsKey("CART")) {
            cart = (ArrayList<Flights>) userSession.get("CART");
        } else {
            cart = new ArrayList<Flights>();
        }

//        /* Access all the flights. (How to access flights in the cart) */
//        for (Flights f : cart) {
//            System.out.println(f.getDepartureTime());
//            System.out.println(f.getAirlineCode());
//        }

        String from = USER_NAME;
        String pass = PASSWORD;
        String subject = "JavaMail";
        String to = "xolopx@gmail.com";
        String body = "Hello tom! this is being sent from Nathan's Java Program!";

        /* Send the email */
//        sendFromGMail(from, pass, toEmails, subject, body);
        try {
            Send(from, pass, to, "", subject, body);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    public static void Send(final String username, final String password, String recipientEmail, String ccEmail, String title, String message) throws AddressException, MessagingException {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        // Get a Properties object
        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.setProperty("mail.smtps.auth", "true");

    /*
    If set to false, the QUIT command is sent and the connection is immediately closed. If set
    to true (the default), causes the transport to wait for the response to the QUIT command.

    ref :   http://java.sun.com/products/javamail/javadocs/com/sun/mail/smtp/package-summary.html
            http://forum.java.sun.com/thread.jspa?threadID=5205249
            smtpsend.java - demo program from javamail
    */
        props.put("mail.smtps.quitwait", "false");

        Session session = Session.getInstance(props, null);

        // -- Create a new message --
        final MimeMessage msg = new MimeMessage(session);

        // -- Set the FROM and TO fields --
        msg.setFrom(new InternetAddress(username + "@gmail.com"));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail, false));

        if (ccEmail.length() > 0) {
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail, false));
        }

        msg.setSubject(title);
        msg.setText(message, "utf-8");
        msg.setSentDate(new Date());

        SMTPTransport t = (SMTPTransport)session.getTransport("smtps");

        t.connect("smtp.gmail.com", username, password);
        t.sendMessage(msg, msg.getAllRecipients());
        t.close();
    }


    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Flights> getCart() {
        return cart;
    }

    public void setCart(List<Flights> cart) {
        this.cart = cart;
    }

    public Map<String, Object> getUserSession() {
        return userSession;
    }

    public void setUserSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }
}
