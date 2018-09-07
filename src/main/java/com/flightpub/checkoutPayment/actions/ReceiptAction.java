package com.flightpub.checkoutPayment.actions;

import com.flightpub.base.model.Flights;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.smtp.SMTPTransport;
import org.apache.struts2.interceptor.SessionAware;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.*;

public class ReceiptAction extends ActionSupport implements SessionAware {

    /* GMail account (I think this only works with Gmail at the moment) */
    /* Make sure that the account is on Google has IMAP access */
    private static String PASSWORD = "flight2018!";
    private static String USER_NAME = "flightpubreceipt";

    /* Variables from the form */
    private String name;
    private String email;

    private List<Flights> cart;
    private Map<String, Object> userSession;

    public String execute() {
        if (userSession.containsKey("CART")) {
            cart = (ArrayList<Flights>) userSession.get("CART");
        } else {
            cart = new ArrayList<Flights>();
        }

        /* Send the email */
        String from = USER_NAME;
        String pass = PASSWORD;
        String subject = "Receipt";

        /* Generate message content */
        StringBuilder sb = new StringBuilder();
        sb.append("Thank you for your purchase ").append(name).append("!\n\n");
        sb.append("Your flights: \n");

        /* Initialize variables for loop */
        int i = 1;
        double total = 0.0;

        for (Flights f : cart) {
            sb.append(i++).append(".\n");
            sb.append("Date: ").append(f.getDepartureTime()).append("\n");
            sb.append("Flight number: ").append(f.getFlightNumber()).append("\n");
            sb.append("Departure: ").append(f.getDepartureTime()).append(" ").append(f.getDeparture()).append("\n");
            if (f.getArrivalTimeStopOver()!=null) {
                sb.append("Stopover time: ").append(f.getArrivalTimeStopOver()).append(" ").append(f.getStopOverCode()).append("\n");
            }
            sb.append("Arrival: ").append(f.getArrivalTime()).append(" ").append(f.getDestination()).append("\n");
            sb.append("Price: $").append(f.getTotalPrice()).append("\n\n"); // You have to getPrice twice to access the actual price
            total += f.getTotalPrice();
        }

        sb.append("Total: $").append(String.format("%.2f", total)).append("\n"); // Displaying total with 2 decimal places

        String body = sb.toString();

//        System.out.println(body);

        try {
            Send(from, pass, email , "", subject, body);
            userSession.remove("CART");
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
