package com.epone.application.views.training;

import com.epone.application.EponePage;
import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Training For Helpers")
@Route(value = "training maids", layout = MainLayout.class)
public class Training extends EponePage {
    private final String infantHeader = "<span style=\"color:green\">Infant Care Training<span>";
    private final String infantBody = """
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

    private final String elderHeader = "<span style=\"color:green\">Elder Care Training<span>";
    private final String elderBody = """
            We are committed to provide our helper with high standard of elder care. We promise skilled \
            maids who establish trustworthy relationships and instil confidence within your household. Our \
            stringent recruitment processes ensure that only the most capable and compassionate individuals \
            join our team. At EP One Manpower, our objective is to ensure families and their elderly loved \
            ones receive top-notch care.
            <br>
            <br>
            In Singapore, we understand the challenges of balancing daily work life while caring for their \
            elderly family members. EP One Manpower equips our maids with specialized training for senior \
            care.
            <br>
            <br>
            For more information about our helpers trained in elder care, please contact us. Our professional \
            consultants will promptly respond to your inquiry.
                """;

    private final String houseHeader = "<span style=\"color:green\">Housekeeping Training<span>";
    private final String houseBody = """
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
        Image infantImage = GetImage("images/infantcare.png", "infant image");

        Image elderImage = GetImage("images/elderycare.png", "elder image");

        Image housekeeping = GetImage("images/housekeeping.png", "housekeeping image");

        addAndExpand(
                createCard(new HorizontalLayout(
                        infantImage,
                        GetHeaderBodyCardWithSpacing(GetH2Heading(infantHeader), GetParagraph(infantBody)))),
                createCard(new HorizontalLayout(
                        GetHeaderBodyCardWithSpacing(GetH2Heading(elderHeader), GetParagraph(elderBody)),
                        elderImage)),
                createCard(new HorizontalLayout(
                        housekeeping,
                        GetHeaderBodyCardWithSpacing(GetH2Heading(houseHeader), GetParagraph(houseBody)))));
    }
}
