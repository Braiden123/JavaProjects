/*
I declare that this assignment is my own work and that all material previously written or published
in any source by any other person has been duly acknowledged in the assignment.
I have not submitted this work, or a significant part thereof, previously as part of any academic program.
In submitting this assignment I give permission to copy it for assessment purposes only.

Author: Braiden Little
Date: December 26, 2022
Assignment 4

Acknowledgement: This code was based on the code example from
https://www.tutorialspoint.com/javamail_api/javamail_api_checking_emails.htm ,
the response by Kariem at:
https://stackoverflow.com/questions/67556270/javax-net-ssl-sslhandshakeexception-no-appropriate-protocol-protocol-is-disabl
and, the response by Mohsen at:
https://stackoverflow.com/questions/53724265/javamail-authenticationfailedexception-eof-on-socket

Purpose: To create an email program that will either list the emails in the inbox
of the specified email address, or print the contents of a specified email.

Instructions(CLI):
The JavaMail and JavaBeans Activation Framework must be installed on your system, and
included in your classpath before compiling and running the program.
To compile this program enter the command into the command line:
javac GetEmail.java
To run this program in the command line enter:
java GetEmail {host} {user} {password} {# of the desired email}
With the # of the desired email being optional. The program will print the list of emails in the inbox
if the final argument is not provided.

Test Plan:

Good Data:

Test 1: java GetMail pop.gmail.com braidentest1@gmail.com {app password}

Expected Output:
A list of 23 emails currently in the inbox to be printed out to the terminal.

Actual Output:
As expected.

Test 2: java GetMail pop.gmail.com braidentest1@gmail.com {app password} 1

Expected Output:
The contents of the email from Google for finishing setting up the Google account.



Actual Output:
As expected.
Email Number: 1
Subject: Braiden, finish setting up your new Google Account
From: Google Community Team <googlecommunityteam-noreply@google.com>
Body: javax.mail.internet.MimeMultipart@79ad8b2f


Test 3: java GetMail pop.gmail.com braidentest1@gmail.com {app password} 23

Expected Output:
The test email that was included in the testemail.txt file for testing the second program,
along with a MimeMultipart attachment in the body.

Actual Output:
As expected.

Email Number: 23
Subject: test email
From: braidentest1@gmail.com
Body: javax.mail.internet.MimeMultipart@79ad8b2f

Test 4: java GetMail pop.gmail.com braidentest1@gmail.com {app password} 8

Expected Output:
The test email that was included in the testemail.txt file for testing the first program.

Actual Output:
As expected.

Email Number: 8
Subject: test email
From: braidentest1@gmail.com
Body: This is a test email,
Sincerely,
Braiden

Bad Input:

Test 1: java GetMail dne.gmail.com braidentest1@gmail.com {app password}

Expected Output:
A NoSuchProviderException erro to be thrown along with the message:
Error: Please ensure that the host and email provided are correct.

Actual Output:
As expected.

Test 2: java GetMail pop.gmail.com braidentest1@dne1904.fake{app password}

Expected Output:
AuthenticationFailedException error thrown.

Actual Output:
As expected.

Test 3: java GetMail pop.gmail.com braidentest1@gmail.com wrongpass

Expected Output:
AuthenticationFailedException error thrown.

Actual Output:
As expected.

Test 4: java GetMail pop.gmail.com braidentest1@gmail.com {app password} -1

Expected Output:
Message: Desired email number is invalid.

Actual Output:
As expected.


Test 5: java GetMail pop.gmail.com braidentest1@gmail.com {app password} 1000

Expected Output:
Message: Desired email number is invalid.

Actual Output:
As expected.
 */
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class GetMail{
    public static void printMailList(String host, String storeType, String user, String password) {
        try {
            //create properties field.
            Properties properties = new Properties();

            properties.put("mail.pop3s.host", host);
            properties.put("mail.pop3s.port", "995");
            properties.put("mail.pop3s.starttls.enable", "true");
            properties.put("mail.pop3s.ssl.protocols", "TLSv1.2"); //Use TLSv1.2
            properties.put("mail.store.protocol", "pop3s");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the pop3s store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");
            store.connect(host, user, password);

            //Create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            //retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("Number of messages: " + messages.length);

            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                System.out.println((i + 1) + ". " + message.getSubject() + " (" + message.getFrom()[0] + ")");
            }

            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException ex) {
            System.out.println("Error: Please ensure that host and email provided are correct.");
            ex.printStackTrace();
        } catch (MessagingException ex) {
            System.out.println("Error receiving messages.");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Unknown error receiving messages.");
            ex.printStackTrace();
        }
    }

    public static void printEmail(String host, String storeType, String user, String password, int emailNum) {
        try {
            //create properties field.
            Properties properties = new Properties();

            properties.put("mail.pop3s.host", host);
            properties.put("mail.pop3s.port", "995");
            properties.put("mail.pop3s.starttls.enable", "true");
            properties.put("mail.pop3s.ssl.protocols", "TLSv1.2"); //Use TLSv1.2
            properties.put("mail.store.protocol", "pop3s");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the pop3s store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");
            store.connect(host, user, password);

            //Create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            //retrieve the desired message and print it.
            Message[] messages = emailFolder.getMessages();
            try {
                Message message = messages[emailNum - 1];
                System.out.println("\nEmail Number: " + (emailNum));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Body: " + message.getContent().toString());
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Desired email number is invalid.");
            }
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException ex) {
            System.out.println("Error: Please ensure that host and email provided are correct.");
            ex.printStackTrace();
        } catch (MessagingException ex) {
            System.out.println("Error receiving message.");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Unknown error receiving message.");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
            try {
                String host = args[0];
                String user = args[1];
                String password = args[2];
                if (args.length < 4) {
                    printMailList(host, "pop3s", user, password);
                } else {
                    try {
                        printEmail(host, "pop3s", user, password, Integer.parseInt(args[3]));
                    } catch (NumberFormatException ex) {
                        System.out.println("Desired Email must be a positive integer.");
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Usage: java GetMail {host} {user} {password} {desiredEmail}");
            }
    }
}