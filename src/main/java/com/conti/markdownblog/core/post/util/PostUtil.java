package com.conti.markdownblog.core.post.util;

import org.jsoup.Jsoup;

import java.util.List;
import java.util.Optional;

import static com.conti.markdownblog.core.markdown.MdToHtmlRenderer.renderHtml;

public class PostUtil {

    public static String getHtmlContentFromMdLines(List<String> mdLines) {
        Optional<List<String>> mdLineOpt = Optional.ofNullable(mdLines);
        return mdLineOpt.isEmpty() ? "" : renderHtml(mdLineOpt.get());
    }

    public static String getSynopsisFromHtmlContent(String htmlContent) {
        String content = Jsoup.parse(htmlContent).text();
        return content.length() <= 150 ? content : content.substring(0, 149);
    }
}
