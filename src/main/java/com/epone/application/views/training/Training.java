package com.epone.application.views.training;

import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Training For Helpers")
@Route(value = "training maids", layout = MainLayout.class)
public class Training extends VerticalLayout {
    String infantHeader = "<span style=\"color:green\">Infant Care Training<span>";
    String infantBody = """
            Caring for your new-borns and children while balancing work is a challenge many parents face \
            in today’s world. To address this, parents can hire a helper to ensure their children are well taken \
            care of while they focus on their work.
            <br>
            <br>
            If you have a new-born, young child, or toddler, hiring a maid can assist with your daily chores \
            such as feeding, cleaning, and childcare. We offer reliable domestic helpers who are specially \
            trained in childcare. They are good in feeding infants, changing diapers, and managing \
            household responsibilities. Some are even capable of preparing meals for new mothers.
                """;

    String elderHeader = "<span style=\"color:green\">Elder Care Training<span>";
    String elderBody = """
            We are committed to provide our helper with high standard of elder care. We promise skilled \
            maids who establish trustworthy relationships and instil confidence within your household. Our \
            stringent recruitment processes ensure that only the most capable and compassionate individuals \
            join our team. At EP One Manpower, our objective is to ensure families and their elderly loved \
            ones receive top-notch care.
            <br>
            <br>
            In Singapore, we understand the challenges of balancing daily work life while caring for their\
            elderly family members. EP One Manpower equips our maids with specialized training for senior\
            care.
            <br>
            <br>
            For more information about our helpers trained in elder care, please contact us. Our professional \
            consultants will promptly respond to your inquiry.
                """;

    String houseHeader = "<span style=\"color:green\">Housekeeping Training<span>";
    String houseBody = """
            Balancing a demanding work schedule can make managing household responsibilities \
            challenging. At EP One Employment Agency, we understand the need for an extra set of helping \
            hands to assist you. Our reliable and experienced helpers are able to support you with cooking \
            and daily household chores so you have more time for yourself.
            <br>
            <br>
            Our training in this area includes maintaining a hygienic standard in the bathrooms, kitchens \
            (both dry and wet areas), living rooms and bedrooms to ensure a safe and clean living space.
                """;

    public Training() {
        Image infantImage = new Image("images/infantcare.png", "infant image");
        infantImage.setHeight("300px");
        infantImage.setWidth("300px");

        Image elderImage = new Image("images/elderycare.png", "elder image");
        elderImage.setHeight("300px");
        elderImage.setWidth("300px");

        Image housekeeping = new Image("images/housekeeping.png", "housekeeping image");
        housekeeping.setHeight("300px");
        housekeeping.setWidth("300px");

        addAndExpand(new HorizontalLayout(infantImage, getHeaderBodyCard(infantHeader, infantBody)),
                new HorizontalLayout(getHeaderBodyCard(elderHeader, elderBody), elderImage),
                new HorizontalLayout(housekeeping, getHeaderBodyCard(houseHeader, houseBody)));
    }

    private VerticalLayout getHeaderBodyCard(String header, String body) {
        Paragraph bodypara = new Paragraph(body);
        bodypara.getElement().setProperty("innerHTML", body);

        VerticalLayout vl = new VerticalLayout(getHeading(header), bodypara);
        vl.setPadding(true);
        vl.getThemeList().add("spacing-l");
        vl.getStyle().set("padding-left", "5%").set("padding-right", "5%");
        return vl;
    }

    private H2 getHeading(String html) {
        H2 heading = new H2();
        heading.getElement().setProperty("innerHTML", html);
        heading.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        return heading;
    }
}
