package com.conti.markdownblog.core.markdown;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.List;

public class MdToHtmlRenderer {

    public static String renderHtml(List<String> markdownLines) {
        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();

        StringBuilder sb = new StringBuilder();
        for (String markdownLine : markdownLines) {
            Node document = parser.parse(markdownLine);
            sb.append(renderer.render(document));
        }

        return sb.toString();
    }
}
