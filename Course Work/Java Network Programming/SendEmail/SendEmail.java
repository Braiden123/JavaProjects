/*
I declare that this assignment is my own work and that all material previously written or published
in any source by any other person has been duly acknowledged in the assignment.
I have not submitted this work, or a significant part thereof, previously as part of any academic program.
In submitting this assignment I give permission to copy it for assessment purposes only.

Author: Braiden Little
Date: December 23, 2022
Assignment 4

Acknowledgement: This code was based on the code example from
https://www.javatpoint.com/example-of-sending-email-using-java-mail-api-through-gmail-server and
the response by Kariem at:
https://stackoverflow.com/questions/67556270/javax-net-ssl-sslhandshakeexception-no-appropriate-protocol-protocol-is-disabl

Purpose: To create a simple email program using the JavaMail API to connect to a preferred email server,
email the primary recipient, secondary recipients (cc), and tertiary recipients (bcc). All
metadata for the email will be stored and read from a file such as thisfile.txt.

Instructions(CLI):
The JavaMail and JavaBeans Activation Framework must be installed on your system, and
included in your classpath before compiling and running the program.
To compile this program enter the command into the command line:
javac SendEmail.java
To run this program in the command line enter:
java SendEmail {email file name}

The email file should be in the following format:
Server: email server
User: email account (also used as the From: in the email)
Password: email account password
To: primary recipient
CC: comma separated list of secondary recipients
BCC: comma separated list of tertiary recipients
Subject: Email subject
Body: multiple lies of text representing the body of the email

Test Plan:

Good Data:

Test 1: java SendEmail testemail.txt
testemail.txt contents:

Server: smtp.gmail.com
User: braidentest1@gmail.com
Password: {app password}
To: braidentest22@gmail.com
CC: braidentest1@gmail.com, braidentest22@gmail.com, braidentest3@gmail.com
BCC: braidentest3@gmail.com, braidentest4@gmail.com, braidentest5@gmail.com
Subject: test email
Body: This is a test email,
Sincerely,
Braiden

Expected Output:
Message sent successfully. With the email appearing in the inboxes of the emails in the To:, CC, and BCC fields.

Actual Output:
As expected.

Test 2: java SendEmail testemail2.txt
testemail2.txt contents:

Server: smtp.gmail.com
User: braidentest1@gmail.com
Password: {app password}
To: braidentest22@gmail.com
CC: braidentest3@gmail.com
BCC: braidentest4@gmail.com
Subject: test email
Body: This is a test email,
Sincerely,
Braiden

Expected Output:
Message sent successfully. With the email appearing in the inboxes of the emails in the To:, CC, and BCC fields.

Actual Output:
As expected.

Test 3: java SendEmail testemail3.txt
testemail3.txt contents:

Server: smtp.gmail.com
User: braidentest1@gmail.com
Password: {app password}
To: braidentest22@gmail.com
CC:
BCC:
Subject: test email
Body: This is a test email,
Sincerely,
Braiden

Expected Output:
Message sent successfully. With the email appearing in the inboxes of the emails in the To:, CC, and BCC fields.

Actual Output:
As expected.

Bad Input:

Test 1: java SendEmail bademail.txt
bademail.txt contents:

Server: smtp.dne.com
User: braidentest1@gmail.com
Password: {app password}
To: braidentest22@gmail.com
CC:
BCC:
Subject: test email
Body: This is a test email,
Sincerely,
Braiden

Expected Output:
Ensure that the email file is in the format as indicated in the documentation, and that the data is correct.

Actual Output:
As expected.

Test 2: java SendEmail bademail2.txt
bademail2.txt contents:

Server: smtp.dne.com
User: braidentest1@qwzx.com
Password: {app password}
To: braidentest22@gmail.com
CC:
BCC:
Subject: test email
Body: This is a test email,
Sincerely,
Braiden

Expected Output:
Ensure that the email file is in the format as indicated in the documentation, and that the data is correct.

Actual Output:
As expected.

Test 3: java SendEmail bademail3.txt
bademail3.txt contents:

Server: smtp.gmail.com
User: braidentest1@gmail.com
Password: wrongpass
To: braidentest22@gmail.com
CC:
BCC:
Subject: test email
Body: This is a test email,
Sincerely,
Braiden

Expected Output:
Ensure that the email file is in the format as indicated in the documentation, and that the data is correct.

Actual Output:
As expected.

Test 4: java SendEmail bademail4.txt
bademail4.txt contents:

Server: smtp.gmail.com
User: braidentest1@gmail.com
Password: {app password}
To: braidentest22@qwzx.com
CC:
BCC:
Subject: test email
Body: This is a test email,
Sincerely,
Braiden

Expected Output:
Message not being sent to the domain since it does not exist.

Actual Output:
As expected.

Test 5: java SendEmail bademail.txt
bademail.txt contents:

Server: smtp.dne.com
User: braidentest1@gmail.com
Password: {app password}
To: braidentest22@gmail.com
CC:braiden1@qwzx.com
BCC:braiden2@qwzx.com
Subject: test email
Body: This is a test email,
Sincerely,
Braiden

Expected Output:
Message sent successfully.

Actual Output:
As expected.

Test 6: java SendEmail bademail6.txt
bademail6.txt contents:

Server: smtp.gmail.com
User: braidentest1@gmail.com
Password: {app password}
To:
CC:
BCC:
Subject: test email
Body: This is a test email,
Sincerely,
Braiden

Expected Output:
Ensure that the email file is in the format as indicated in the documentation, and that the data is correct.

Actual Output:
As expected.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.*;

class Mailer{
    private String server, from, password, to, sub, body;
    private String[] ccList, bccList;

    public void read(String fileName) {
        try {
            File emailFile = new File(fileName);
            Scanner reader = new Scanner(emailFile);
            while (reader.hasNextLine()) {
                String nextLine = reader.nextLine();
                if (nextLine.startsWith("Server:")) {
                    try { //In case no space is left in front of the :
                        server = nextLine.replace("Server: ", "");
                    } catch (Exception ex) {
                        server = nextLine.replace("Server:", "");
                    }
                } else if (nextLine.startsWith("User:")) {
                    try {//In case no space is left in front of the :
                        from = nextLine.replace("User: ", "");
                    } catch (Exception ex) {
                        from = nextLine.replace("User:", "");
                    }
                } else if (nextLine.startsWith("Password:")) {
                    try {//In case no space is left in front of the :
                        password = nextLine.replace("Password: ", "");
                    } catch (Exception ex) {
                        password = nextLine.replace("Password:", "");
                    }
                } else if (nextLine.startsWith("To:")) {
                    try {//In case no space is left in front of the :
                        to = nextLine.replace("To: ", "");
                    } catch (Exception ex) {
                        to = nextLine.replace("To:", "");
                    }
                } else if (nextLine.startsWith("CC:")) {
                    try {//In case no space is left in front of the :
                        nextLine = nextLine.replace("CC: ", "");
                    } catch (Exception ex) {
                        nextLine = nextLine.replace("CC:", "");
                    }
                    ccList = nextLine.split(", ");
                } else if (nextLine.startsWith("BCC:")) {
                    try {//In case no space is left in front of the :
                        nextLine = nextLine.replace("BCC: ", "");
                    } catch (Exception ex) {
                        nextLine = nextLine.replace("BCC:", "");
                    }
                    bccList = nextLine.split(", ");
                } else if (nextLine.startsWith("Subject:")) {
                    try {//In case no space is left in front of the :
                        sub = nextLine.replace("Subject: ", "");
                    } catch (Exception ex) {
                        sub = nextLine.replace("Subject:", "");
                    }
                } else if (nextLine.startsWith("Body:")) {
                    try {//In case no space is left in front of the :
                        body = nextLine.replace("Body: ", "");
                    } catch (Exception ex) {
                        body = nextLine.replace("Body:", "");
                    }
                } else {
                    body += "\n" + nextLine;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Invalid File");
            ex.printStackTrace();
        }
    }
    public void send() {
        //Get properties object.
        Properties props = new Properties();
        props.put("mail.smtp.host",this.server);
        props.put("mail.smtp.socketFactory.port","587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.starttls.required", "true"); //Ensure tls is required.
        props.put("mail.smtp.ssl.protocols", "TLSv1.2"); //Use TLSv1.2
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        //get Session
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });
        //compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            try {
                for (String s : ccList) { //Iterate through the cc list.
                    message.addRecipient(Message.RecipientType.CC, new InternetAddress(s)); //Add email to cc.
                }
            } catch (AddressException ex) {} //No CC, do nothing.
            try {
                for (String s : bccList) { //Iterate through the bcc list.
                    message.addRecipient(Message.RecipientType.BCC, new InternetAddress(s)); //Add email to bcc.
                }
            } catch (AddressException ex) {} //No BCC, do nothing.
            message.setSubject(this.sub); //Add subject to email.
            message.setText(this.body); //Add body to email.
            //send message
            Transport.send(message);
            System.out.println("Message sent successfully");
        } catch (MessagingException e) {
            System.err.println("Ensure that the email file is in the format as indicated" +
                    " in the documentation, and that the data is correct.");
        }
    }
}

public class SendEmail{
    public static void main(String[] args) {
        Mailer mailer = new Mailer();
        mailer.read(args[0]); //Read the email file.
        mailer.send(); //Send email.
    }
}