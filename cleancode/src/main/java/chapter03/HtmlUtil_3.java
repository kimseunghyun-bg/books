package chapter03;

/**
 * @author Seunghyun Kim
 * @since 2019-11-22
 */
public class HtmlUtil_3 {
    public static String renderPageWithSetupAndTearDowns(
            PageData pageData, boolean isSuite ) throws Exception {
        if (isTestPage(pageData)) {
            includeSetupAndTeardownPages(pageData, isSuite);
        }
        return pageData.getHtml();
    }

    public static boolean isTestPage(PageData pageData) {
        return true;
    }

    public static void includeSetupAndTeardownPages(PageData pageData, boolean isSuite) {
    }
}
