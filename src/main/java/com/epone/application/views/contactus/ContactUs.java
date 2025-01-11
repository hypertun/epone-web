package com.epone.application.views.contactus;

import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@PageTitle("Contact Us")
@Route(value = "contact", layout = MainLayout.class)
public class ContactUs extends VerticalLayout {

    private static final String contactUsHeader = "<span>Contact Us!</span> <span style=\"color:green\"> We Want To Help!</span>";
    public static final String Office1HTML = "<span>170, Upper Bukit Timah Road, #03-09<br>Bukit Timah Shopping Centre<br>Singapore 588179</span>";
    public static final String Office2HTML = "<span>21, Hougang Street 51, #02-25<br>Hougang Green Shopping Mall<br>Singapore 538719</span>";
    public static final String Office3HTML = "<span>Apt Blk 23, Sin Ming Road #01-19<br>Sin Ming Ville<br>Singapore 570023</span>";
    private static final String office2PhoneHTML = "<span>Hougang(6463 5478 / 6343 6474)<br>Ms Eve (83715665) / Ms Alice (9271 5103) / Mr Terence (80822646) </span>";
    private static final String office2EmailHTML = "<span>hg25@epone.com.sg</span>";
    private static final String office1PhoneHTML = "<span>Bukit Timah(6343 6473 / 6343 6474)<br>Ms Laura (87216855) / Ms Edna (88172718) / Mr Sean (85339131) </span>";
    private static final String office1EmailHTML = "<span>bt39@epone.com.sg</span>";
    private static final String office3PhoneHTML = "<span>Sin Ming(6019 0548 / 6019 0549)<br>Ms Melinda Leong (91269010)";
    private static final String office3EmailHTML = "<span>sm19@epone.com.sg</span>";

    private static final String YOUR_EMAIL = "ivanyeom03@gmail.com"; // Replace with your email address
    private static final String YOUR_PASSWORD = "cnae nvyt qzhl cjuq"; // Replace with your email password
    private static final String requiredMsg = "This field is required.";
    private static final String requiredEmailOrMobile = "Email or Mobile number is required.";

    public ContactUs() {
        VerticalLayout formSendLayout = new VerticalLayout();
        formSendLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        formSendLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        H2 header = new H2();
        header.getElement().setProperty("innerHTML", contactUsHeader);
        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);

        HorizontalLayout informationLayout = getInformationLayout();

        Paragraph description = new Paragraph("Have any questions or feedback? We'd love to hear from you.");

        FormLayout formLayout = new FormLayout();
        TextField nameField = new TextField("Name");
        nameField.setRequired(true);
        nameField.setErrorMessage(requiredMsg);

        EmailField emailField = new EmailField("Email");
        TextField mobileField = new TextField("Mobile Number");

        CheckboxGroup<String> skillSetGroup = new CheckboxGroup<>("Preferred Skill Set");
        skillSetGroup.setItems("Childcare", "Eldercare", "Housekeeping");
        skillSetGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        skillSetGroup.setRequired(true);
        skillSetGroup.setErrorMessage(requiredMsg);

        CheckboxGroup<String> nationalityBox = new CheckboxGroup<>("Nationality");
        nationalityBox.setItems("Indonesian", "Filipino", "Myanmar", "Indian");
        nationalityBox.setRequired(true);
        nationalityBox.setErrorMessage(requiredMsg);

        TextArea messageField = new TextArea("Message");
        messageField.setHeight("150px");

        Button sendButton = new Button("Send Inquiry");

        sendButton.addClickListener(event -> {
            if (isValidInput(nameField, emailField, mobileField, nationalityBox, skillSetGroup)) {
                try {
                    sendEmail(nameField.getValue(), emailField.getValue(), mobileField.getValue(),
                            nationalityBox.getValue().toString(), skillSetGroup.getValue().toString(),
                            messageField.getValue());
                    clearFormFields(nameField, emailField, mobileField, nationalityBox, skillSetGroup, messageField);
                    Notification.show("Your inquiry has been sent successfully!").open();
                } catch (EmailException e) {
                    Notification
                            .show("An error occurred while sending the email. Please try again later." + e.getMessage())
                            .open();
                    e.printStackTrace();
                }
            }
        });

        formLayout.add(nameField, mobileField, emailField, nationalityBox, skillSetGroup, messageField);
        formLayout.setColspan(messageField, 2);
        formSendLayout.add(header, informationLayout, description, formLayout, sendButton);
        add(formSendLayout);
        getStyle().set("padding-left", "5%").set("padding-right", "5%");
    }

    private boolean isValidInput(TextField nameField, EmailField emailField, TextField mobileField,
            CheckboxGroup<String> nationalityBox, CheckboxGroup<String> skillSetGroup) {
        if (emailField.isEmpty() && mobileField.isEmpty()) {
            Notification.show(requiredEmailOrMobile).open();
            return false;
        }

        if (nameField.isEmpty() || nationalityBox.isEmpty() || skillSetGroup.isEmpty()) {
            Notification.show("Please fill in all the required fields.").open();
            return false;
        }

        return true;
    }

    private void clearFormFields(TextField nameField, EmailField emailField, TextField mobileField,
            CheckboxGroup<String> nationalityField, CheckboxGroup<String> skillSetField,
            TextArea messageField) {
        nameField.clear();
        emailField.clear();
        mobileField.clear();
        messageField.clear();
        nationalityField.clear();
        skillSetField.clear();
    }

    private void sendEmail(String name, String email, String mobile, String nationality, String skillSet,
            String message) throws EmailException {
        Email simpleEmail = new SimpleEmail();
        simpleEmail.setHostName("smtp.gmail.com"); // For Gmail, use "smtp.gmail.com"
        simpleEmail.setSmtpPort(587); // For Gmail, use port 587
        simpleEmail.setAuthenticator(new DefaultAuthenticator(YOUR_EMAIL, YOUR_PASSWORD));
        simpleEmail.setSSLOnConnect(true); // Enable SSL/TLS
        simpleEmail.setFrom(YOUR_EMAIL);
        simpleEmail.setSubject("New Inquiry from " + name);
        simpleEmail.setMsg("Name: " + name + "\n" + "Email: " + email + "\n" + "Mobile: " + mobile + "\n"
                + "Nationality: " + nationality + "\n" + "Skill Set: " + skillSet + "\n"
                + "\n\n"
                + "Message:\n" + message);
        simpleEmail.addTo("sm19@epone.com.sg","bt39@epone.com.sg","hg25@epone.com.sg");
        simpleEmail.send();
    }

    private HorizontalLayout getInformationLayout() {
        HorizontalLayout informationLayout = new HorizontalLayout();

        HorizontalLayout office1 = getPin("", Office1HTML);
        HorizontalLayout office2 = getPin("", Office2HTML);
        HorizontalLayout office3 = getPin("", Office3HTML);

        HorizontalLayout office1Phone = getPin("phone", office1PhoneHTML);
        HorizontalLayout office2Phone = getPin("phone", office2PhoneHTML);
        HorizontalLayout office3Phone = getPin("phone", office3PhoneHTML);

        HorizontalLayout office1Email = getPin("email", office1EmailHTML);
        HorizontalLayout office2Email = getPin("email", office2EmailHTML);
        HorizontalLayout office3Email = getPin("email", office3EmailHTML);

        VerticalLayout pinLayout1 = new VerticalLayout(office1,office2,office3);
        VerticalLayout pinLayout2 = new VerticalLayout(office1Phone, office2Phone, office3Phone);
        VerticalLayout pinLayout3 = new VerticalLayout(office1Email, office2Email, office3Email);
        pinLayout1.setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);
        pinLayout2.setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);
        pinLayout3.setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY);

        informationLayout.add(pinLayout1, pinLayout2, pinLayout3);
        informationLayout.setWidth("100");
        return informationLayout;
    }

    private HorizontalLayout getPin(String type, String html) {
        HorizontalLayout pinLayout = new HorizontalLayout();

        Image pinLogo = new Image("images/location-mark.png", "locationMark");
        if (type == "phone") {
            pinLogo = new Image("images/phone-call.png", "phoneMark");
        } else if (type == "email") {
            pinLogo = new Image("images/mail-inbox.png", "mailIndox");
        }
        pinLogo.setHeight("20px");

        Paragraph htmlString = new Paragraph();
        htmlString.getElement().setProperty("innerHTML", html);

        pinLayout.add(pinLogo, htmlString);
        pinLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        return pinLayout;
    }
}