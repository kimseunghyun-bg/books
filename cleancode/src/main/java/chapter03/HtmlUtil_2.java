package chapter03;

/**
 * @author Seunghyun Kim
 * @since 2019-11-22
 */
public class HtmlUtil_2 {
    public static String renderPageWithSetupAndTearDowns(
            PageData pageData, boolean isSuite
    ) throws Exception {
        boolean isTestPage = pageData.hasAttribute("Test");
        if (isTestPage) {
            WikiPage testPage = pageData.getWikiPage();
            StringBuffer newPageContent = new StringBuffer();
            includeSetupPages(testPage, newPageContent, isSuite);
            newPageContent.append(pageData.getContent());
            includeTeardownPages(testPage, newPageContent, isSuite);
            pageData.setContent(newPageContent.toString());
        }
        return pageData.getHtml();
    }

    public static void includeSetupPages(WikiPage wikiPage, StringBuffer stringBuffer, boolean isSuite) {
    }

    public static void includeTeardownPages(WikiPage wikiPage, StringBuffer stringBuffer, boolean isSuite) {
    }
}
