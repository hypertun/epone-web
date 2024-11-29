package com.epone.application.utilities;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class HTMLUnorderedList {
    private List<String> listElements = new ArrayList<>();

    public void addListItem(String... listItems) {
        for (String item : listItems) {
            listElements.add("<li>" + item + "</li>");
        }
    }

    public String getHtml(String classNames) {
        String openingTag = "<ul>";
        if (StringUtils.isNotEmpty(classNames)) {
            openingTag = String.format("<ul class=\"%s\">", classNames);
        }
        return openingTag + StringUtils.join(listElements, "") + "</ul>";
    }
}